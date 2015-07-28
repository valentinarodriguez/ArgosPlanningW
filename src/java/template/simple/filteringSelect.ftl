<tr>
	<td>
		<label class="label" for="${parameters.idAutocompleter?default('')}">
			<@s.if test="%{${parameters.required?default('true')}}">
			<span class="required">*</span>
			</@s.if>
			<@s.text name="${parameters.key?default('')}" />:
		 </label>
	</td>
</tr>
<tr>
	<td>
		<@s.hidden id="${parameters.idDisplayedValueAutocompleter?default('')}" name="${parameters.idDisplayedValueAutocompleter?default('')}" />
		<div style="float:left;" id="${parameters.idAutocompleterContainer?default((parameters.idAutocompleter?default(''))+'Container')}" class="${parameters.classAutocompleter?default('')}">
			<div dojoType="peaFilteringSelect"
				hasDownArrow="${parameters.hasDownArrow?default('true')}"
				ignoreCase="${parameters.ignoreCase?default('true')}"
				searchDelay="${parameters.searchDelay?default('0')}"
			    value="${parameters.value?default('')}"
			    autocomplete="${parameters.autocomplete?default('true')}"
			    searchAttr="${parameters.searchAttr?default('nombre')}"
			    labelAttr="${parameters.labelAttr?default('nombre')}"
			    intermediateChanges="${parameters.intermediateChanges?default('false')}"
			    name="${parameters.idAutocompleter?default('')}"
			    id="${parameters.idAutocompleter?default('')}"
			    required="${parameters.required?default('true')}" >
			</div>
		</div>
	</td>
</tr>
<tr>
	<td>
	   <@s.fielderror>
	        <@s.param>${parameters.idAutocompleter?default('')}</@s.param>
	   </@s.fielderror>
	</td>
</tr>


<script type="text/javascript">
	
	dojo.addOnLoad(function()
	{
		var defaultErrorMessage = '<@s.text name="error.ajaxComunicacion" />';

		agregarListenersAutoCompleter(
			'${parameters.idAutocompleter?default('')}',
			'${parameters.idDisplayedValueAutocompleter?default('')}',
			"${request.contextPath}/<@s.url namespace="${parameters.urlNamespace?default('')}" action="${parameters.urlAction?default('')}" method="${parameters.urlMethod?default('')}" includeContext='false' includeParams='none' />",
			${parameters.minSearchLength?default('3')},
			${parameters.errorMessage?default('defaultErrorMessage')}
			);
	});
	
</script>