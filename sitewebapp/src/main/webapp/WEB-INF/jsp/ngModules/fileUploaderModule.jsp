<div class="fup">
	<div class="fup-content" ng-cloak>
		<div class="fup-body">
			<div ng-show="dupeNames" class="alert alert-danger">
				<button ng-click="dupeNames = !dupeNames" type="button" class="close" aria-hidden="true">&times;</button>
				Could not add file because a file with the same name has already been added.
				(Duplicate names: <b ng-repeat="name in dupeNames">{{name}}{{{true: '', false: ', '}[$last]}}</b>)
			</div>
			<div ng-show="errors" class="alert alert-danger">
				<button ng-click="errors = !errors"  type="button" class="close" aria-hidden="true">&times;</button>
				Sorry, some errors occurred. We could not upload the following files:
				<b ng-repeat="(key, value) in errors">{{value}}{{{true: '', false: ', '}[$last]}}</b>
				<br/><br/>
				Please try uploading those files again.
			</div>
			
			<div class="fup-inp-wrp">
				<button type="button" class="upload-btn btn btn-primary" data-dismiss="modal">
					<i class="plus"></i><span>Add Files</span>
				</button>
				<input class="qry-fup-inp fup-inp-main" type="file" multiple="multiple" />
			</div>
	
			<div style="border:1px solid #ccc; min-height:150px">
				<table class="ftable">
					<tr>
						<th class="c1">File</th>
						<th class="c2">Status</th>
						<th class="c3">Remove</th>
					</tr>
					<tr ng-repeat="wrap in fileWrappers" ng-hide="wrap.kbSize == null">
						<td>{{wrap.file.name}} <span class="size">({{wrap.kbSize}}KB)</span></td>
						<td>{{wrap.status}}</td>
						<td>
							<a ng-show="wrap.status != 'success'" href="javascript:;" ng-click="remove(wrap.id)">Remove</a>
							<span ng-show="wrap.status == 'success'" class="disabled">Remove</span>
						</td>
					</tr>
				</table>
			</div>
		</div>
		<div class="fup-footer">
			<div class="progress progress-striped active">
				<div class="progress-bar"  role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: {{percentDone}}%">
					<span class="sr-only">{{percentDone}}% Complete</span>
				</div>
			</div>
			
			<button ng-click="closePopup()" type="button" class="btn btn-default">Close</button>
			<button ng-class="{disabled: allUploadsSuccessful || !fileWrappers}" type="button" class="qry-fup-upBtn btn btn-primary">Upload Files</button>
		</div>
	</div><!-- fup-content -->
</div><!-- End of file-uploader directive -->
