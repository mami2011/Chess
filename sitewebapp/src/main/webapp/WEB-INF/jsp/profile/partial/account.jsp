<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 
<script>
    var $element = $('table[ng-controller="ProfileCtrl"]');
    var scope = angular.element($element).scope();
   	alert(scope.accountOrig.emailId);
</script>
--%>

<table id="info" class="info" cellspacing="0" cellpadding="0">
	<tr>
		<td class="col1"><label>Email:</label></td>
		<td class="col2"><input ng-model="accountEdit.emailId" class="form-control readonly" readonly/></td>
	</tr>
	<tr class="ng-class:{'err': errorMap.firstName};">
		<td class="col1"><label>First name:</label></td>
		<td class="col2">
			<input ng-model="accountEdit.contactDetails.firstName" class="form-control"/>
			<div class="err-msg" ng-repeat="errorMsg in errorMap.firstName">{{errorMsg}}</div>
		</td>
	</tr>
	<tr class="ng-class:{'err': errorMap.lastName};">
		<td class="col1"><label>Last name:</label></td>
		<td class="col2">
			<input ng-model="accountEdit.contactDetails.lastName" class="form-control"/>
			<div class="err-msg" ng-repeat="errorMsg in errorMap.lastName">{{errorMsg}}</div>
		</td>
	</tr>
	<tr class="ng-class:{'err': errorMap.addressLine1};">
		<td class="col1"><label>Address 1:</label></td>
		<td class="col2">
			<input ng-model="accountEdit.contactDetails.address.addressLine1" class="form-control" />
			<div class="err-msg" ng-repeat="errorMsg in errorMap.addressLine1">{{errorMsg}}</div>
		</td>
	</tr>
	<tr class="ng-class:{'err': errorMap.addressLine2};">
		<td class="col1"><label>Address 2:</label></td>
		<td class="col2">
			<input ng-model="accountEdit.contactDetails.address.addressLine2" class="form-control" />
			<div class="err-msg" ng-repeat="errorMsg in errorMap.addressLine2">{{errorMsg}}</div>
		</td>
	</tr>
	<tr class="ng-class:{'err': errorMap.city};">
		<td class="col1"><label>City:</label></td>
		<td class="col2">
			<input ng-model="accountEdit.contactDetails.address.city" class="form-control" />
			<div class="err-msg" ng-repeat="errorMsg in errorMap.city">{{errorMsg}}</div>
		</td>
	</tr>
	<tr class="ng-class:{'err': errorMap.state};">
		<td class="col1"><label>State:</label></td>
		<td class="col2">
			<input ng-model="accountEdit.contactDetails.address.state" class="form-control" />
			<div class="err-msg" ng-repeat="errorMsg in errorMap.state">{{errorMsg}}</div>
		</td>
	</tr>
	<tr class="ng-class:{'err': errorMap.zip};">
		<td class="col1"><label>Zip:</label></td>
		<td class="col2">
			<input ng-model="accountEdit.contactDetails.address.zip" class="form-control" />
			<div class="err-msg" ng-repeat="errorMsg in errorMap.zip">{{errorMsg}}</div>
		</td>
	</tr>
	<tr class="ng-class:{'err': errorMap.country};">
		<td class="col1"><label>Country:</label></td>
		<td class="col2"><%--
			 <select ng-model="acctFieldSetEdit.country.value" ng-options="c.value for c in acctFieldSetEdit.country.options"></select>
      		--%>
      		<%--
			<select class="cntryMenu" ng-model="profileEdit.country">
				
				<option ng-repeat="opt in pageEdit.fieldMap.COUNTRY.options" value="{{opt.value}}">{{opt.label}}</option>
				
				<c:forEach var="entry" items="${countryMap}">
					<option value="${entry.key}">${entry.value}</option>
				</c:forEach>
    		</select> --%>
    		
    		<div class="err-msg" ng-repeat="errorMsg in errorMap.country">{{errorMsg}}</div>
		</td>
	</tr>
	<tr>
		<td class="col1"><label>Phone (work):</label></td>
		<td class="col2"><input ng-model="accountEdit.contactDetails.phones['WORK'].number" class="form-control" /></td>
	</tr>
	<tr>
		<td class="col1"><label>Phone (mobile):</label></td>
		<td class="col2"><input ng-model="accountEdit.contactDetails.phones['MOBILE'].number" class="form-control" /></td>
	</tr>
	<tr>
		<td class="col1"><label>Phone (home):</label></td>
		<td class="col2"><input ng-model="accountEdit.contactDetails.phones['HOME'].number" class="form-control" /></td>
	</tr>
	<tr>
		<td colspan="2">
			<hr class="sep"/>
		</td>
	</tr>
	<tr>
		<td class="col1"><label>Current Password:</label></td>
		<td class="col2"><input ng-model="profileEdit.password" class="form-control" type="password"/></td>
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


