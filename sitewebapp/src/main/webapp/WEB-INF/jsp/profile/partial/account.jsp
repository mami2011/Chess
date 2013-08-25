<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 
<div class="msg">
	<div class="alert alert-danger" style="display:none;">Sorry, there's been an error.</div>
</div>--%>
<table id="info" class="info" cellspacing="0" cellpadding="0">
	<tr>
		<td class="col1"><label>Email:</label></td>
		<td class="col2"><input ng-model="accountEdit.emailId" class="form-control readonly" readonly/></td>
	</tr>
	
	<%-- 
	<tr class="ng-class:{'err': errorResp.fieldBindingErrors.firstName != null};">--%>
	
	<tr class="ng-class:{'err': errorMap.firstName != null};">
		<td class="col1"><label>First name:</label></td>
		<td class="col2">
			<input ng-model="accountEdit.contactDetails.firstName" class="form-control"/>
			<div class="err-msg">
				<div ng-repeat="error in errorMap.firstName">
					{{error.message}}
				</div>
				
			</div>
		</td>
	</tr>
	<tr>
		<td class="col1"><label>Last name:</label></td>
		<td class="col2"><input ng-model="accountEdit.contactDetails.lastName" class="form-control"/></td>
	</tr>

	 
	 <%--
	 {{errorResponse.fieldBindingErrors[0].bindingFieldMap.firstName[0]}}
	 
	 <c:if test="${errorResponse.hasFieldError(account.getContactDetails().getClass().getName(), firstnamepath)}">
						<div>
							<c:forEach
								items="${errorResponse.getFieldErrors(account.getContactDetails().getClass().getName(), firstnamepath)}"
								var="vterror">
								<span class="errorfont">
									<c:out value="${vterror.getMessage()}" />
								</span>
								<br />
							</c:forEach>
						</div>
					</c:if>
					
	 
	 
	  --%>
	  
	 
	<tr class="ng-class:{'err': profileEdit.error.NULL_ARGUMENT_PASSED != null};">
	<%--
	<tr ng-class="{err: pageEdit.fieldMap.ADDRESS_LINE_1.errors != null}; err">
	--%>
		<td class="col1"><label>Address 1:</label></td>
		<td class="col2">
			<input ng-model="accountEdit.contactDetails.address.addressLine1" class="form-control" />
			<div class="err-msg">{{profileEdit.error.NULL_ARGUMENT_PASSED.errorMessage}}</div>		
		</td>
	</tr>
	<tr>
		<td class="col1"><label>Address 2:</label></td>
		<td class="col2"><input ng-model="accountEdit.contactDetails.address.addressLine2" class="form-control" /></td>
	</tr>
	<tr class="ng-class:{'err': profileEdit.error.INTERNAL_DATABASE_DOWN != null};">
		<td class="col1"><label>City:</label></td>
		<td class="col2">
			<input ng-model="accountEdit.contactDetails.address.city" class="form-control" />
			<div class="err-msg">{{profileEdit.error.INTERNAL_DATABASE_DOWN.errorMessage}}</div>		
		</td>
	</tr>
	<tr>
		<td class="col1"><label>State:</label></td>
		<td class="col2"><input ng-model="accountEdit.contactDetails.address.state" class="form-control" /></td>
	</tr>
	<tr>
		<td class="col1"><label>Zip:</label></td>
		<td class="col2"><input ng-model="accountEdit.contactDetails.address.zip" class="form-control" /></td>
	</tr>
	<tr>
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


