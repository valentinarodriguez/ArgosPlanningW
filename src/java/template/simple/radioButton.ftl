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

<#assign radioSuffix = 'Radio' />

<#if parameters.id??>
	<#assign radioId = parameters.idHidden.toString() + radioSuffix />
<#else>
	<#assign radioId = '' />
</#if>

<@s.hidden id="${parameters.idHidden?html}" name="${parameters.name?default('')}" />
<input type="radio" id="${radioId?html}" class="radioButton"
	<@s.if test="${parameters.name?default('')}">checked="checked"</@s.if>
/>

<label for="${radioId?html}" class="radioButton"> 
	<@s.text name="${parameters.key?default('')}"></@s.text>:
</label>

<script type="text/javascript">
	dojo.addOnLoad(function(e) {
		var radioWdg = dojo.byId('${parameters.idHidden?default('')}' + presentia.radioButton.radioWidgetSuffix); 
		var radioHidden = dojo.byId('${parameters.idHidden?default('')}');
		
		dojo.connect(radioWdg,'onclick',function(e) {
			radioHidden.value = '' + radioWdg.checked;
		});
	});
</script>
	    