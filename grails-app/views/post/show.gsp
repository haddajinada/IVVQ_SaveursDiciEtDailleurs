
<%@ page import="ivvq_saveursdicietdailleurs.Post" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'post.label', default: 'Post')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-post" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-post" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list post">
			
				<g:if test="${postInstance?.idPost}">
				<li class="fieldcontain">
					<span id="idPost-label" class="property-label"><g:message code="post.idPost.label" default="Id Post" /></span>
					
						<span class="property-value" aria-labelledby="idPost-label"><g:fieldValue bean="${postInstance}" field="idPost"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${postInstance?.intitule}">
				<li class="fieldcontain">
					<span id="intitule-label" class="property-label"><g:message code="post.intitule.label" default="Intitule" /></span>
					
						<span class="property-value" aria-labelledby="intitule-label"><g:fieldValue bean="${postInstance}" field="intitule"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${postInstance?.message}">
				<li class="fieldcontain">
					<span id="message-label" class="property-label"><g:message code="post.message.label" default="Message" /></span>
					
						<span class="property-value" aria-labelledby="message-label"><g:fieldValue bean="${postInstance}" field="message"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${postInstance?.auteurPost}">
				<li class="fieldcontain">
					<span id="auteurPost-label" class="property-label"><g:message code="post.auteurPost.label" default="Auteur Post" /></span>
					
						<span class="property-value" aria-labelledby="auteurPost-label"><g:link controller="membre" action="show" id="${postInstance?.auteurPost?.id}">${postInstance?.auteurPost?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${postInstance?.commentaires}">
				<li class="fieldcontain">
					<span id="commentaires-label" class="property-label"><g:message code="post.commentaires.label" default="Commentaires" /></span>
					
						<g:each in="${postInstance.commentaires}" var="c">
						<span class="property-value" aria-labelledby="commentaires-label"><g:link controller="commentaire" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${postInstance?.id}" />
					<g:link class="edit" action="edit" id="${postInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
