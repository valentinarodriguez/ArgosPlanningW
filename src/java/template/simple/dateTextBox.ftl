<#assign hasFieldErrors = fieldErrors?? && fieldErrors[parameters.name]?? />
<#if hasFieldErrors>
	<ul class="errorList">
		<#list fieldErrors[parameters.name] as error>
		<li>${error?html}</li>
		<#t/>
		<#lt/>
		</#list>
	</ul>
</#if>

<label for="${parameters.idDateTextBox?default('')}" >
<@s.text name="${parameters.key?default('')}" /><#t/>
<@s.if test="%{${parameters.required?default('false')}}">
 <span class="required">*</span><#t/>
</@s.if>
:
</label>

<div class="${parameters.cssClass?default('')}" style="display:inline;">
	<div dojoType="dijit.form.DateTextBox"
	
		constraints="${parameters.constraints?default('{datePattern:\'dd/MM/yyyy\'}')}"
		
  		required="${parameters.required?default('false')}"

		<@s.if test="%{${parameters.disabled?default('false')}}">
	  		disabled="disabled"
		</@s.if>
		
  		lang="${parameters.lang?default('es')}"

	    name="${parameters.name?default('')}"
	    id="${parameters.idDateTextBox?default('')}"
	    value="<@s.property value="${parameters.name?default('')}" />"
	    
	     >
	 </div>
</div>
	    