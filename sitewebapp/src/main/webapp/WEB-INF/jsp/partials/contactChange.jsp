<table id="info" class="info" cellspacing="0" cellpadding="0">
	<tr>
		<td class="col1"><label>Email:</label></td>
		<td class="col2"><input ng-model="accountFieldsEdit.email.value" class="form-control readonly" readonly/></td>
	</tr>
	<tr>
		<td class="col1"><label>Address 1:</label></td>
		<td class="col2"><input ng-model="accountFieldsEdit.addressLine1.value" class="form-control" /></td>
	</tr>
	<tr>
		<td class="col1"><label>Address 2:</label></td>
		<td class="col2"><input ng-model="accountFieldsEdit.addressLine2.value" class="form-control" /></td>
	</tr>
	<tr>
		<td class="col1"><label>City:</label></td>
		<td class="col2"><input ng-model="accountFieldsEdit.city.value" class="form-control" /></td>
	</tr>
	<tr>
		<td class="col1"><label>State:</label></td>
		<td class="col2"><input ng-model="accountFieldsEdit.state.value" class="form-control" /></td>
	</tr>
	<tr>
		<td class="col1"><label>Zip:</label></td>
		<td class="col2"><input ng-model="accountFieldsEdit.zip.value" class="form-control" /></td>
	</tr>
	<tr>
		<td class="col1"><label>Country:</label></td>
		<td class="col2"><input ng-model="accountFieldsEdit.country.value" class="form-control" /></td>
	</tr>
	<tr>
		<td class="col1"><label>Phone (work):</label></td>
		<td class="col2"><input ng-model="accountFieldsEdit.phoneWork.value" class="form-control" /></td>
	</tr>
	<tr>
		<td class="col1"><label>Phone (mobile):</label></td>
		<td class="col2"><input ng-model="accountFieldsEdit.phoneMobile.value" class="form-control" /></td>
	</tr>
	<tr>
		<td class="col1"><label>Phone (home):</label></td>
		<td class="col2"><input ng-model="accountFieldsEdit.phoneHome.value" class="form-control" /></td>
	</tr>
	<tr>
		<td colspan="2">
			<hr class="sep"/>
		</td>
	</tr>
	<tr>
		<td class="col1"><label>Current Password:</label></td>
		<td class="col2"><input ng-model="accountFieldsEdit.password.value" class="form-control" type="password"/></td>
	</tr>
	<tr>
		<td colspan="2" class="actns">
			<div class="sub-cncl">
				<input ng-click="save()" type="submit" class="btn lg" value="Submit"/>
				<a ng-click="reset()" class="cncl lg" href="javascript:;">Cancel</a>
			</div>
		</td>
	</tr>
	
</table>


