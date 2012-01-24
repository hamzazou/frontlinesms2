<div id='move-message'>
	<select class="dropdown extra-msg-btn" name="move-actions" id="move-actions" onchange="moveAction()">
		<option value="na" class="na">Move message to...</option>
		<g:if test="${messageSection != 'inbox'}">
			<option class="inbox" value="inbox">Inbox</option>
		</g:if>
		<g:each in="${radioShowInstanceList}" status="i" var="s">
			<g:if test="${(messageSection == 'inbox') || (s != ownerInstance)}">
				<option class="radioShow" value="${s.id}">${s.name}</option>
			</g:if>
		</g:each>
		<g:each in="${pollInstanceList}" status="i" var="p">
			<g:if test="${(messageSection == 'inbox') || (p != ownerInstance)}">
				<option class="poll" value="${p.id}">${p.title}</option>
			</g:if>
		</g:each>
		<g:each in="${announcementInstanceList}" status="i" var="a">
			<g:if test="${(messageSection == 'inbox') || (a != ownerInstance)}">
				<option class="announcement" value="${a.id}">${a.name}</option>
			</g:if>
		</g:each>
		<g:each in="${folderInstanceList}" status="i" var="f">
			<g:if test="${(messageSection == 'inbox') || (f != ownerInstance)}">
				<option class="folder" value="${f.id}">${f.name}</option>
			</g:if>
		</g:each>
	</select>
</div>