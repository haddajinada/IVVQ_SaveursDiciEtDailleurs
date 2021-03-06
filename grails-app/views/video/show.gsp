<!--
Saveurs d’ici et d’ailleurs allows foodies to share recipes and cooking tips from around the globe.
Copyright (C) 2012 Anna CEJALVO - Nada HADDAJI KFITA - Ahou Melaine KOFFI - Marième TOURE

Saveurs d’ici et d’ailleurs is free software: you can redistribute it and/or modify it under the terms of the GNU Affero General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

Saveurs d’ici et d’ailleurs is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License along with this program. If not, see ww.gnu.org/licenses/agpl-3.0.html.
-->
<%@ page import="ivvq_saveursdicietdailleurs.Video" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'video.label', default: 'Video')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-video" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-video" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list video">
				
				<g:if test="${videoInstance?.titreRecette}">
				<li class="fieldcontain">
					<span id="titreRecette-label" class="property-label"><g:message code="video.titreRecette.label" default="Titre Recette" /></span>
					
						<span class="property-value" aria-labelledby="titreRecette-label"><g:fieldValue bean="${videoInstance}" field="titreRecette"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${videoInstance?.keyVideoYoutube}">
				<li class="fieldcontain">
					<span id="keyVideoYoutube-label" class="property-label"><g:message code="video.keyVideoYoutube.label" default="" /></span>
					
						<g:video videoKey="${videoInstance?.keyVideoYoutube}" />
				</li>
				</g:if>
			
				<g:if test="${videoInstance?.recette}">
				<li class="fieldcontain">
					<span id="recette-label" class="property-label"><g:message code="video.recette.label" default="Recette" /></span>
					
						<span class="property-value" aria-labelledby="recette-label"><g:fieldValue bean="${videoInstance}" field="recette"/></span>
					
				</li>
				</g:if>
							
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${videoInstance?.id}" />
					<g:link class="edit" action="edit" id="${videoInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
