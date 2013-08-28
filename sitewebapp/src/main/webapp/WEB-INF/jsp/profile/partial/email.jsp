<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<table class="info" cellspacing="0" cellpadding="0">
	<tr>
		<td class="col1"><label>Email:</label></td>
		<td class="col2"><input ng-model="changeEmailRequest.oldEmailId" class="form-control readonly" readonly/></td>
	</tr>
	<tr class="fldWrp">
		<td class="col1"><label>New email:</label></td>
		<td class="col2">
			<input ng-model="changeEmailRequest.newEmail" class="form-control"/>
			<div error field="newEmail" cname="com.vendertool.sharedtypes.rnr.ChangeEmailRequest"></div>
		</td>
	</tr>
	<tr class="fldWrp">
		<td class="col1"><label>Confirm new email:</label></td>
		<td class="col2">
			<input ng-model="changeEmailRequest.confirmEmail" class="form-control"/>
			<div error field="confirmEmail" cname="com.vendertool.sharedtypes.rnr.ChangeEmailRequest"></div>
		</td>
	</tr>

	<tr>
		<td colspan="2">
			<hr class="sep"/>
		</td>
	</tr>
	<tr>
		<td class="col1"><label>Current Password:</label></td>
		<td class="col2">
			<input ng-model="changeEmailRequest.password" class="form-control" type="password"/>
			<div error field="password" cname="com.vendertool.sharedtypes.rnr.ChangeEmailRequest"></div>
		</td>
	</tr>
	<tr>
		<td colspan="2" class="actns">
			<div class="sub-cncl">
				<input ng-click="saveEmail()" type="submit" class="btn lg" value="Submit"/>
				<a ng-click="resetEmail()" class="cncl lg" href="javascript:;">Cancel</a>
			</div>
		</td>
	</tr>
	
</table>


