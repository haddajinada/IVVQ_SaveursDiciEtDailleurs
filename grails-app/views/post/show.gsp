<<<<<<< HEAD

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
			
				<g:if test="${postInstance?.photo}">
				<li class="fieldcontain">
					<span id="photo-label" class="property-label"><g:message code="post.photo.label" default="Photo" /></span>
					
						<span class="property-value" aria-labelledby="photo-label"><g:link controller="photo" action="show" id="${postInstance?.photo?.id}">${postInstance?.photo?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${postInstance?.video}">
				<li class="fieldcontain">
					<span id="video-label" class="property-label"><g:message code="post.video.label" default="Video" /></span>
					
						<span class="property-value" aria-labelledby="video-label"><g:link controller="video" action="show" id="${postInstance?.video?.id}">${postInstance?.video?.encodeAsHTML()}</g:link></span>
					
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
=======
<!--
Saveurs d’ici et d’ailleurs allows foodies to share recipes and cooking tips from around the globe.
Copyright (C) 2012 Anna CEJALVO - Nada HADDAJI KFITA - Ahou Melaine KOFFI - Marième TOURE

Saveurs d’ici et d’ailleurs is free software: you can redistribute it and/or modify it under the terms of the GNU Affero General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

Saveurs d’ici et d’ailleurs is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License along with this program. If not, see ww.gnu.org/licenses/agpl-3.0.html.
-->
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
>>>>>>> 4bd57838cae24008542bf85621cd5fc46af25236
