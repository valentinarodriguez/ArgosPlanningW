<#--
/*
 * $Id: optiontransferselect.ftl 720258 2008-11-24 19:05:16Z musachy $
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
-->
<#if !stack.findValue("#optiontransferselect_js_included")??><#t/>
	<script type="text/javascript" src="<@s.url value="/struts/optiontransferselect.js" encode='false' includeParams='none'/>"></script>
	<#assign temporaryVariable = stack.setValue("#optiontransferselect_js_included", "true") /><#t/>
</#if><#t/>
<table class="queryTableStretch">
<tr>
<td class="colLabel" style="text-align:left">
<#if parameters.leftTitle??><#t/>
	<label for="leftTitle">${parameters.leftTitle}:</label><br />
</#if><#t/>
</td>
<td>
</td>
<td class="colLabel" style="text-align:left">
<#if parameters.rightTitle??><#t/>
	<label for="rightTitle">${parameters.rightTitle}:</label><br />
</#if><#t/>
</td>
</tr>
<tr>
<td>
<#include "/${parameters.templateDir}/simple/select.ftl" /> 
<#if parameters.allowUpDownOnLeft?default(true)>
<input type="button" 
	onclick="moveOptionDown(document.getElementById('${parameters.id}'), 'key', <#if parameters.headerKey??>'${parameters.headerKey}'<#else>''</#if>);<#if parameters.upDownOnLeftOnclick?has_content>${parameters.upDownOnLeftOnclick};</#if>"
<#if parameters.leftDownLabel??>
	value="${parameters.leftDownLabel?html}"
</#if>
/>
<input type="button"
	onclick="moveOptionUp(document.getElementById('${parameters.id}'), 'key', <#if parameters.headerKey??>'${parameters.headerKey}'<#else>''</#if>);<#if parameters.upDownOnLeftOnclick?has_content>${parameters.upDownOnLeftOnclick};</#if>"
<#if parameters.leftUpLabel??>
	value="${parameters.leftUpLabel?html}"
</#if>
/>
</#if>
</td>
<td valign="middle" align="center" style="width:50px">
	<#if parameters.get("readonly")?default(false)>
		&nbsp;
	<#else>
		<table>
		<#if parameters.allowAddToLeft?default(true)><#t/>
		<tr><td style="padding:4px">
			<#assign addToLeftLabel = parameters.addToLeftLabel?default("<-")?html/><#t/>
			<#if parameters.doubleHeaderKey??><#t/>
				<a class="back" href="#nowhere" onclick="javascript:moveSelectedOptions(document.getElementById('${parameters.doubleId?html}'), document.getElementById('${parameters.id?html}'), false, '${parameters.doubleHeaderKey}', '');<#if parameters.addToLeftOnclick?has_content>${parameters.addToLeftOnclick};</#if>"></a><br/>
			<#else><#t/>
				<a class="back" href="#nowhere" onclick="javascript:moveSelectedOptions(document.getElementById('${parameters.doubleId?html}'), document.getElementById('${parameters.id?html}'), false, '');<#if parameters.addToLeftOnclick?has_content>${parameters.addToLeftOnclick};</#if>"></a>
			</#if><#t/>
		</td></tr>
		</#if><#t/>
		<#if parameters.allowAddToRight?default(true)><#t/>
		<tr><td style="padding:4px">
			<#assign addToRightLabel=parameters.addToRightLabel?default("->")?html /><#t/>
			<#if parameters.headerKey??><#t/>
				<a class="next" href="#nowhere" onclick="moveSelectedOptions(document.getElementById('${parameters.id?html}'), document.getElementById('${parameters.doubleId?html}'), false, '${parameters.headerKey}', '');<#if parameters.addToRightOnclick?has_content>${parameters.addToRightOnclick};</#if>"></a>
			<#else><#t/>
				<a class="next" href="#nowhere" onclick="moveSelectedOptions(document.getElementById('${parameters.id?html}'), document.getElementById('${parameters.doubleId?html}'), false, '');<#if parameters.addToRightOnclick?has_content>${parameters.addToRightOnclick};</#if>"></a>
			</#if><#t/>
		</td></tr>
		</#if><#t/>
		<#if parameters.allowAddAllToLeft?default(true)><#t/>
		<tr><td style="padding:4px">
			<#assign addAllToLeftLabel=parameters.addAllToLeftLabel?default("<<--")?html /><#t/>
			<#if parameters.doubleHeaderKey??><#t/>
				<a class="first" href="#nowhere" onclick="moveAllOptions(document.getElementById('${parameters.doubleId?html}'), document.getElementById('${parameters.id?html}'), false, '${parameters.doubleHeaderKey}', '');<#if parameters.addAllToLeftOnclick?has_content>${parameters.addAllToLeftOnclick};</#if>"></a>
			<#else><#t/>
				<a class="first" href="#nowhere" onclick="moveAllOptions(document.getElementById('${parameters.doubleId?html}'), document.getElementById('${parameters.id?html}'), false, '');<#if parameters.addAllToLeftOnclick?has_content>${parameters.addAllToLeftOnclick};</#if>"></a>
			</#if><#t/>
		</td></tr>
		</#if><#t/>
		<#if parameters.allowAddAllToRight?default(true)><#t/>
		<tr><td style="padding:4px">
			<#assign addAllToRightLabel=parameters.addAllToRightLabel?default("-->>")?html /><#t/>
			<#if parameters.headerKey??><#t/>
				<a class="last" href="#nowhere" onclick="moveAllOptions(document.getElementById('${parameters.id?html}'), document.getElementById('${parameters.doubleId?html}'), false, '${parameters.headerKey}', '');<#if parameters.addAllToRightOnclick?has_content>${parameters.addAllToRightOnclick};</#if>"></a>	
			<#else><#t/>
				<a class="last" href="#nowhere" onclick="moveAllOptions(document.getElementById('${parameters.id?html}'), document.getElementById('${parameters.doubleId?html}'), false, '');<#if parameters.addAllToRightOnclick?has_content>${parameters.addAllToRightOnclick};</#if>"></a>	
			</#if><#t/>
		</td></tr>
		</#if><#t/>
		<#if parameters.allowSelectAll?default(true)><#t/>
			<#assign selectAllLabel=parameters.selectAllLabel?default("<*>")?html /><#t/>
			<#if parameters.headerKey?? && parameters.doubleHeaderKey??><#t/>
				<input type="button" 
				<#if parameters.buttonCssClass??><#t/>
				 class="${parameters.buttonCssClass?html}" 
				</#if><#t/>
				<#if parameters.buttonCssStyle??><#t/>
				 style="${parameters.buttonCssStyle?html}"
				</#if><#t/>
				 value="${selectAllLabel}" onclick="selectAllOptionsExceptSome(document.getElementById('${parameters.id?html}'), 'key', '${parameters.headerKey}');selectAllOptionsExceptSome(document.getElementById('${parameters.doubleId?html}'), 'key', '${parameters.doubleHeaderKey}');<#if parameters.selectAllOnclick?has_content>${parameters.selectAllOnclick};</#if>" /><br /><br />
			<#elseif parameters.headerKey??><#t/>
				<input type="button" 
				<#if parameters.buttonCssClass??><#t/>
				 class="${parameters.buttonCssClass?html}" 
				</#if><#t/>
				<#if parameters.buttonCssStyle??><#t/>
				 style="${parameters.buttonCssStyle?html}"
				</#if><#t/>
				 value="${selectAllLabel}" onclick="selectAllOptionsExceptSome(document.getElementById('${parameters.id?html}'), 'key', '${parameters.headerKey}');selectAllOptions(document.getElementById('${parameters.doubleId?html}'));<#if parameters.selectAllOnclick?has_content>${parameters.selectAllOnclick};</#if>" /><br /><br />
			<#elseif parameters.doubleHeaderKey??><#t/>
				<input type="button" 
				<#if parameters.buttonCssClass??><#t/>
				 class="${parameters.buttonCssClass?html}" 
				</#if><#t/>
				<#if parameters.buttonCssStyle??><#t/>
				 style="${parameters.buttonCssStyle?html}"
				</#if><#t/>
				 value="${selectAllLabel}" onclick="selectAllOptions(document.getElementById('${parameters.id?html}'));selectAllOptionsExceptSome(document.getElementById('${parameters.doubleId?html}'), 'key', '${parameters.doubleHeaderKey}');<#if parameters.selectAllOnclick?has_content>${parameters.selectAllOnclick};</#if>" /><br /><br />
			<#else><#t/>
				<input type="button" 
				<#if parameters.buttonCssClass??><#t/>
				 class="${parameters.buttonCssClass?html}" 
				</#if><#t/>
				<#if parameters.buttonCssStyle??><#t/>
				 style="${parameters.buttonCssStyle?html}"
				</#if><#t/>
				 value="${selectAllLabel}" onclick="selectAllOptions(document.getElementById('${parameters.id?html}'));selectAllOptions(document.getElementById('${parameters.doubleId?html}'));<#if parameters.selectAllOnclick?has_content>${parameters.selectAllOnclick};</#if>" /><br /><br />
			</#if><#t/>
		</#if><#t/>
		</table>
	</#if>
</td>
<td>

<select 
	name="${parameters.doubleName?default("")?html}"
	<#if parameters.get("doubleSize")??><#t/>
	size="${parameters.get("doubleSize")?html}"		
	</#if><#t/>
	<#if parameters.doubleDisabled?default(false)><#t/>
	disabled="disabled"
	</#if><#t/>
	<#if parameters.doubleMultiple?default(false)><#t/>
	multiple="multiple"
	</#if><#t/>
	<#if parameters.doubleTabindex??><#t/>
	tabindex="${parameters.tabindex?html}"
	</#if><#t/>
	<#if parameters.doubleId??><#t/>
	id="${parameters.doubleId?html}"
	</#if><#t/>
	<#if parameters.doubleCss??><#t/>
	class="${parameters.doubleCss?html}"
	</#if><#t/>
	<#if parameters.doubleStyle??><#t/>
	style="${parameters.doubleStyle?html}"
	</#if><#t/>
    <#if parameters.doubleOnclick??><#t/>
    onclick="${parameters.doubleOnclick?html}"
    </#if><#t/>
    <#if parameters.doubleOndblclick??><#t/>
    ondblclick="${parameters.doubleOndblclick?html}"
    </#if><#t/>
    <#if parameters.doubleOnmousedown??><#t/>
    onmousedown="${parameters.doubleOnmousedown?html}"
    </#if><#t/>
    <#if parameters.doubleOnmouseup??><#t/>
    onmouseup="${parameters.doubleMnmouseup?html}"
    </#if><#t/>
    <#if parameters.doubleOnmousemove??><#t/>
    onmousemove="${parameters.doubleOnmousemove?html}"
    </#if><#t/>
    <#if parameters.doubleOnmouseout??><#t/>
    onmouseout="${parameters.doubleOnmouseout?html}"
    </#if><#t/>
    <#if parameters.doubleOnfocus??><#t/>
    onfocus="${parameters.doubleOnfocus?html}"
    </#if><#t/>
    <#if parameters.doubleOnblur??><#t/>
    onblur="${parameters.doubleOnblur?html}"
    </#if><#t/>
    <#if parameters.doubleOnkeypress??><#t/>
    onkeypress="${parameters.doubleOnkeypress?html}"
    </#if><#t/>
    <#if parameters.doubleOnKeydown??><#t/>
    onkeydown="${parameters.doubleOnkeydown?html}"
    </#if><#t/>
    <#if parameters.doubleOnkeyup??><#t/>
    onkeyup="${parameters.doubleOnkeyup?html}"
    </#if><#t/>
    <#if parameters.doubleOnselect??><#t/>
    onselect="${parameters.doubleOnselect?html}"
    </#if><#t/>
    <#if parameters.doubleOnchange??><#t/>
    onchange="${parameters.doubleOnchange?html}"
    </#if><#t/>
    <#if parameters.doubleAccesskey??><#t/>
    accesskey="${parameters.doubleAccesskey?html}"
    </#if>
>
	<#if parameters.doubleHeaderKey?? && parameters.doubleHeaderValue??><#t/>
    <option value="${parameters.doubleHeaderKey?html}">${parameters.doubleHeaderValue?html}</option>
	</#if><#t/>
	<#if parameters.doubleEmptyOption?default(false)><#t/>
    <option value=""></option>
	</#if><#t/>
	<@s.iterator value="parameters.doubleList"><#t/>
        <#if parameters.doubleListKey??><#t/>
            <#assign doubleItemKey = stack.findValue(parameters.doubleListKey) /><#t/>
        <#else><#t/>
            <#assign doubleItemKey = stack.findValue('top') /><#t/>
        </#if><#t/>
        <#assign doubleItemKeyStr = doubleItemKey.toString() /><#t/>
        <#if parameters.doubleListValue??><#t/>
            <#assign doubleItemValue = stack.findString(parameters.doubleListValue)!"" /><#t/>
        <#else><#t/>
            <#assign doubleItemValue = stack.findString('top') /><#t/>
        </#if><#t/>
    	<option value="${doubleItemKeyStr?html}"<#rt/>
        <#if tag.contains(parameters.doubleNameValue, doubleItemKey)><#t/>
 		selected="selected"<#rt/>
        </#if><#t/>
    	>${doubleItemValue?html}</option><#lt/>
	</@s.iterator><#t/>
</select>
<#if parameters.allowUpDownOnRight?default(true)>
<input type="button" 
	onclick="moveOptionDown(document.getElementById('${parameters.doubleId}'), 'key', <#if parameters.doubleHeaderKey??>'${parameters.doubleHeaderKey}'<#else>''</#if>);<#if parameters.upDownOnRightOnclick?has_content>${parameters.upDownOnRightOnclick};</#if>"
<#if parameters.rightDownLabel??>
	value="${parameters.rightDownLabel?html}"
</#if>
/>
<input type="button" 
	onclick="moveOptionUp(document.getElementById('${parameters.doubleId}'), 'key', <#if parameters.doubleHeaderKey??>'${parameters.doubleHeaderKey}'<#else>''</#if>);<#if parameters.upDownOnRightOnclick?has_content>${parameters.upDownOnRightOnclick};</#if>"
<#if parameters.rightUpLabel??>
	value="${parameters.rightUpLabel?html}"
</#if>
/>
</#if>
</td>
</tr>
</table>
