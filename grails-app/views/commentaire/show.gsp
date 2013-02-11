
<%@ page import="ivvq_saveursdicietdailleurs.Commentaire" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'commentaire.label', default: 'Commentaire')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-commentaire" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-commentaire" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list commentaire">
			
				<g:if test="${commentaireInstance?.corpsCommentaire}">
				<li class="fieldcontain">
					<span id="corpsCommentaire-label" class="property-label"><g:message code="commentaire.corpsCommentaire.label" default="Corps Commentaire" /></span>
					
						<span class="property-value" aria-labelledby="corpsCommentaire-label"><g:fieldValue bean="${commentaireInstance}" field="corpsCommentaire"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${commentaireInstance?.postCommentaire}">
				<li class="fieldcontain">
					<span id="postCommentaire-label" class="property-label"><g:message code="commentaire.postCommentaire.label" default="Post Commentaire" /></span>
					
						<span class="property-value" aria-labelledby="postCommentaire-label"><g:link controller="post" action="show" id="${commentaireInstance?.postCommentaire?.id}">${commentaireInstance?.postCommentaire?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${commentaireInstance?.id}" />
					<g:link class="edit" action="edit" id="${commentaireInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
