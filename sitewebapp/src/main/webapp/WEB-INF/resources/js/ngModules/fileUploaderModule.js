angular.module('fileUploaderModule', []).directive("fileUploader", function() {
	
	_css = {
		'fileInput':		'qry-fup-inp',
		'uploadBtn':		'qry-fup-upBtn'
	};

	return {
		link: function(scope, element, attrs) {

			var uploadUrl = attrs.uploadUrl,
				allDoneUrl = attrs.allDoneUrl,
				fileInput,
				uploadBtn,
				
				/** functions **/
				initScopeVars,
				addFiles,
				addMoreFiles,
				uploadFiles,
				send,
				clearFileInput,
				findDupes,
				makeId,
				progressHandler,
				getMapSize
			;

			//
			// Find the elements
			//
			fileInput = $(element).find('.' + _css.fileInput);
			uploadBtn = $(element).find('.' + _css.uploadBtn);
			
			initScopeVars = function() {
				scope.percentDone = 0;
				scope.fileWrappers = [];
				scope.dupeNames = [];
				scope.errors = undefined; // map of fileId to fileName
				scope.allUploadsSuccessful = false;
				scope.groupId = makeGroupId();
			};
			
			//
			// If user tries to close popup, show warning if there
			// are files in the list that have not been uploaded.
			//
			$(window).bind('beforeunload', function() {
				if (!scope.allUploadsSuccessful) {
					
					var notUploadedCount = 0;
					
					for (var i=0, n=scope.fileWrappers.length; i<n; i++) {
						if (!scope.fileWrappers[i].status || scope.fileWrappers[i].status!='success') {
							notUploadedCount++;
						}
					}

					if (notUploadedCount == 1) {
						return 'A file has not been uploaded.';
					}
					else if (notUploadedCount > 1) {
						return 'Some files have not been uploaded.';
					}
				}
			});
			

			$(window).bind('unload', function() {
				// Send ajax flag to say that this group is done
				$.ajax({
					url: "http://www.amazon.com",
					context: "oooo"
				});
			});

			initialAdd = function() {

				initScopeVars();
				addFiles(this.files);
				scope.$apply();
				
				// Clear and rebind fileInput to add additional files
				clearFileInput(_css.fileInput, addMoreFiles);
			};
			
			addFiles = function(files, dupeNames) {
				var filesToAdd = [], fileWrap, dupes;
				
				// Remove files that are dupes
				if (dupeNames) {
					for (var i=0, n=files.length; i<n; i++) {
						if (dupeNames.indexOf(files[i].name) === -1) {
							filesToAdd.push(files[i]);
						}
					}
				}
				else {
					filesToAdd = files;
				}
				
				for (var i=0, n=filesToAdd.length; i<n; i++) {
					fileWrap = {};
					fileWrap.id = makeId();
					fileWrap.file = filesToAdd[i];
					fileWrap.kbSize = parseInt(filesToAdd[i].size/1024);
					scope.fileWrappers.push(fileWrap);
				}
			};
			
			addMoreFiles = function() {
				
				var dupeNames;
				scope.dupeNames = [];
				
				dupeNames = findDupes(scope.fileWrappers, this.files);
				
				if (dupeNames && dupeNames.length > 0) {
					scope.dupeNames = dupeNames;
					addFiles(this.files, dupeNames);
				}
				else {
					addFiles(this.files);
				}
				
				updateUploadStatus();
				clearFileInput(_css.fileInput, addMoreFiles);
			};
			
			uploadFiles = function() {
				
				var fileWrap, formData;
				
				// Reset the progress bar and errors
				scope.percentDone = 0;
				scope.errors = undefined;
				scope.dupeNames = [];

				if (window.FormData){
					for (var i=0, n=scope.fileWrappers.length; i<n; i++) {
						fileWrap = scope.fileWrappers[i];
						
						// Only upload if not already successfully uploaded.
						// We allow user to hit uploadBtn again to upload any
						// files that errored in a previous upload attempt.
						if (!fileWrap.status || fileWrap.status !== 'success') {
							formData = new FormData();
							formData.append(scope.groupId, fileWrap.file);
							send(formData, fileWrap);
						}
					}
				}
			};
			
			send = function(formData, fileWrap) {

				$.ajax({
					type: 'post',
					url: uploadUrl,
					data: formData,
					cache: false,
			        contentType: false,
			        processData: false,
					success: function(data, textStatus, jqXHR) {

						fileWrap.status = 'success';

						updateUploadStatus();

						//
						// If all uploads are successful, close popup.
						// There's a listener on the close event that
						// sends the the 'done' flag to backend.
						//
						if (scope.allUploadsSuccessful) {			
							window.close();
						}
					},
					error: function(jqXHR, textStatus, errorThrown) {
						
						fileWrap.status = 'error';
						if (!scope.errors) {
							scope.errors = {};
						}
						scope.errors[fileWrap.id] = fileWrap.file.name;
						
						updateUploadStatus();
					},
					xhr: function() {
						var fileId = fileWrap.id;
						
				        var myXhr = $.ajaxSettings.xhr();
				        if (myXhr.upload) {
				            myXhr.upload.addEventListener('progress', function(evt) {
				            	overallProgress(evt, fileId);
				            }, false);
				        }
				        return myXhr;
				    }
				});
			};
			
			//
			// Browser prevents altering the file input value, so we need
			// to replace the file input element with a new one instead.
			// We need a cleared file input to allow user to upload same
			// file twice in a row.
			//
			// This is because our js is triggered by the 'change' event.
			// If the value of the file input is the same, then there is
			// no 'change', thus no event.
			//
			clearFileInput = function(fileInputClass, bindAction) {
				var oldInp, newInp;
				
				oldInp = $(element).find('.' + fileInputClass);
				newInp = $(document.createElement('INPUT'));
				$.each(oldInp[0].attributes, function() {
					// this.attributes is not a plain object, but an array
					// of attribute nodes, which contain both the name and value
					if (this.specified) {
						newInp.attr(this.name, this.value);
					}
				});
				
				newInp.bind('change', bindAction);
				oldInp.replaceWith(newInp);
			};
			
			findDupes = function(fileWrappers, moreFiles) {
				var existingNames = [], dupes = [];
				
				for (var i=0, n=fileWrappers.length; i<n; i++) {
					existingNames.push(fileWrappers[i].file.name);
				}

				for (var i=0, n=moreFiles.length; i<n; i++) {
					if (existingNames.indexOf(moreFiles[i].name) > -1) {
						dupes.push(moreFiles[i].name);
					}
				}
				
				return dupes;
			};

			makeId = function() {
				var rand = Math.floor((Math.random()*100000000) + 1);
				var millis = new Date().getTime();
				return rand + millis;
			};
			
			makeGroupId = function() {
				return makeId();
			};
			
			updateUploadStatus = function() {
				var doneCount = 0;
				scope.allUploadsSuccessful = false;
				
				for (var i=0, n=scope.fileWrappers.length; i<n; i++) {
					if (scope.fileWrappers[i].status === 'success') {
						doneCount++;
					}
				}
				
				if (doneCount === scope.fileWrappers.length) {
					scope.allUploadsSuccessful = true;
				}

				scope.$apply();
			};
			
			overallProgress = function(evt, fileId) {
				console.log(fileId);
			};

			progressHandler = function(evt) {
				if (evt.lengthComputable) {
					
					scope.percentDone = parseInt(100.0 * (evt.loaded/evt.total));
					scope.$apply();
					
					if (scope.percentDone === 100) {
						//alert('done');

					}
					console.log(evt.loaded + ":" + evt.total + ":" + evt.totalSize);
					/*
					if (percent_done < 99) {
						percent_done = 'Uploading: ' + percent_done + '%';
					}
					else {
						percent_done = 'Processing File...';
					}
					//$('#your-progress-div').text(percent_done);
					console.log(percent_done);*/
				}
			};
			
			getMapSize = function(map) {
			    var count = 0, key;
			    for (key in map) {
			        if (map.hasOwnProperty(key)) {
			            count++;
			        }
			    }
			    return count;
			};
			
			scope.remove = function(fileId) {

				for (var i=0, n=scope.fileWrappers.length; i<n; i++) {
					var fw = scope.fileWrappers[i];

					if (fw.id === fileId) {
						scope.fileWrappers.splice(i, 1);
						
						// Update error object since an error file might have been removed.
						if (scope.errors) {
							delete scope.errors[fileId];
							if (getMapSize(scope.errors) === 0) {
								scope.errors = undefined;
							}
						}

						break;
					}
				}
				
				updateUploadStatus();
			};
			
			scope.closePopup = function() {
				window.close();
			};

			//
			// Bind the elements
			//
			fileInput.bind('change', initialAdd);
			uploadBtn.bind('click', uploadFiles);
		
		},
		templateUrl:'ngModules/fileUploaderModule',
		scope: true
		
	};// End of returned statement

});

