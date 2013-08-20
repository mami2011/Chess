<table id="info" class="info" cellspacing="0" cellpadding="0">
	<tr>
		<td class="col1"><label>Email:</label></td>
		<td class="col2"><input ng-model="pageEdit.fieldMap.EMAIL.value" class="form-control readonly" readonly/></td>
	</tr>
	 
	<tr class="ng-class:{'err': page.fieldMap.ADDRESS_LINE_1.errors != null};">
	<%--
	<tr ng-class="{err: pageEdit.fieldMap.ADDRESS_LINE_1.errors != null}; err">
	--%>
	
		<td class="col1"><label>Address 1:</label></td>
		<td class="col2">
			<input ng-model="pageEdit.fieldMap.ADDRESS_LINE_1.value" class="form-control" />
			<div class="err-msg">
				<span ng-repeat="msg in pageEdit.fieldMap.ADDRESS_LINE_1.errorMessages">
					{{msg}}<br/>
				</span>
			</div>				
		</td>
	</tr>
	<tr>
		<td class="col1"><label>Address 2:</label></td>
		<td class="col2"><input ng-model="pageEdit.fieldMap.ADDRESS_LINE_2.value" class="form-control" /></td>
	</tr>
	<tr>
		<td class="col1"><label>City:</label></td>
		<td class="col2"><input ng-model="pageEdit.fieldMap.CITY.value" class="form-control" /></td>
	</tr>
	<tr>
		<td class="col1"><label>State:</label></td>
		<td class="col2"><input ng-model="pageEdit.fieldMap.STATE.value" class="form-control" /></td>
	</tr>
	<tr>
		<td class="col1"><label>Zip:</label></td>
		<td class="col2"><input ng-model="pageEdit.fieldMap.ZIP.value" class="form-control" /></td>
	</tr>
	<tr>
		<td class="col1"><label>Country:</label></td>
		<td class="col2"><%--
			 <select ng-model="acctFieldSetEdit.country.value" ng-options="c.value for c in acctFieldSetEdit.country.options"></select>
      		--%>
			<select class="cntryMenu" ng-model="pageEdit.fieldMap.COUNTRY.value">
				<option ng-repeat="opt in pageEdit.fieldMap.COUNTRY.options" value="{{opt.value}}">{{opt.label}}</option>
    		</select> 
		</td>
	</tr>
	<tr>
		<td class="col1"><label>Phone (work):</label></td>
		<td class="col2"><input ng-model="pageEdit.fieldMap.PHONE_WORK.value" class="form-control" /></td>
	</tr>
	<tr>
		<td class="col1"><label>Phone (mobile):</label></td>
		<td class="col2"><input ng-model="pageEdit.fieldMap.PHONE_MOBILE.value" class="form-control" /></td>
	</tr>
	<tr>
		<td class="col1"><label>Phone (home):</label></td>
		<td class="col2"><input ng-model="pageEdit.fieldMap.PHONE_HOME.value" class="form-control" /></td>
	</tr>
	<tr>
		<td colspan="2">
			<hr class="sep"/>
		</td>
	</tr>
	<tr>
		<td class="col1"><label>Current Password:</label></td>
		<td class="col2"><input ng-model="pageEdit.fieldMap.PASSWORD.value" class="form-control" type="password"/></td>
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


