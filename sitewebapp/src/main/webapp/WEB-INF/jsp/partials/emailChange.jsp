<table id="info" class="info" cellspacing="0" cellpadding="0">
	<tr>
		<td class="col1"><label>Email:</label></td>
		<td class="col2"><input ng-model="editAccount.emailId" class="form-control readonly" readonly/></td>
	</tr>
	<tr>
		<td class="col1"><label>New email:</label></td>
		<td class="col2"><input ng-model="editAccount.newEmailId" class="form-control" /></td>
	</tr>
	<tr>
		<td class="col1"><label>Confirm new email:</label></td>
		<td class="col2"><input ng-model="editAccount.confirmNewEmailId" class="form-control" /></td>
	</tr>
	<tr>
		<td colspan="2">
			<hr class="sep"/>
		</td>
	</tr>
	<tr>
		<td class="col1"><label>Current Password:</label></td>
		<td class="col2"><input ng-model="editAccount.password" class="form-control" type="password"/></td>
	</tr>
	<tr>
		<td colspan="2" class="actns">
			<div class="sub-cncl">
				<input  type="submit" class="btn lg" value="Submit"/>
				<a ng-click="reset()" class="cncl lg" href="javascript:;">Cancel</a>
			</div>
		</td>
	</tr>
	
</table>


