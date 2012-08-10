<h2><g:message code="subscription.group.header"/></h2>
<div class="info">
	<p><g:message code="subscription.group.description"/></p>
</div>
<div class="input">
	<g:select name="group" value="${activityInstanceToEdit?.group}" class="dropdown required"
		noSelection="${['': g.message(code:'subscription.group.none.selected')]}"
		from="${groupInstanceList}"/>
</div>

<h2><g:message code="subscription.keyword.header"/></h2>
<div class="input">
	<g:textField name="keyword" id="subscription-keyword" value="${activityInstanceToEdit?.keyword?.value}"/>
</div>


