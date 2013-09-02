<div class="fup">
	<div class="fup-content">
		<div class="fup-header">
			<h4 class="fup-title">File Uploader</h4>
		</div>
		<div class="fup-body">
			<div ng-show="dupeNames.length" class="alert alert-warning" style="display:none">
				Could not add file because a file with same name has already been added.<br/><br/>
				
				Duplicate names:
				<b ng-repeat="name in dupeNames">{{name}}{{{true: '', false: ', '}[$last]}}</b>
			</div>
			<div ng-show="errors" class="alert alert-warning">
				Sorry, some errors occurred.<br/>
				We could not upload the following files:
				<b ng-repeat="(key, value) in errors">{{value}}{{{true: '', false: ', '}[$last]}}</b>
				<br/><br/>
				Please try uploading those files again.
			</div>
			
			<div class="form-wrp">
				<button type="button" class="upload-btn btn btn-primary" data-dismiss="modal">
					<i class="plus"></i><span>Add Files</span>
				</button>
				<input class="qry-fup-inp fup-inp-main" type="file" multiple="multiple" />
			</div>
	
			<table ng-show="fileWrappers.length" class="ftable">
				<tr>
					<th>File</th>
					<th>Status</th>
					<th>Remove</th>
				</tr>
				<tr ng-repeat="wrap in fileWrappers" ng-hide="wrap.kbSize == null">
					<td class="c1">{{wrap.file.name}} <span class="size">({{wrap.kbSize}}KB)</span></td>
					<td class="c2">{{wrap.status}}</td>
					<td class="c2">
						<a ng-show="wrap.status != 'success'" href="javascript:;" ng-click="remove(wrap.id)">Remove</a>
						<span ng-show="wrap.status == 'success'" class="disabled">Remove</span>
					</td>
				</tr>
			</table>			
			
			<div ng-show="!fileWrappers.length">
				Click "Add" buttons to add files.
			</div>
			
			
			<input name="fup-inp-dlg" class="qry-fup-inp-more" type="file" multiple="multiple" />
		</div>
		<div class="fup-footer">
			<div class="progress progress-striped active">
				<div class="progress-bar"  role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: {{percentDone}}%">
					<span class="sr-only">{{percentDone}}% Complete</span>
				</div>
			</div>
			<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			<button ng-class="{disabled: allUploadsSuccessful}" type="button" class="qry-fup-upBtn btn btn-primary">Upload</button>
		</div>
	</div><!-- fup-content -->
</div><!-- End of file-uploader directive -->
