<!--
Saveurs d’ici et d’ailleurs allows foodies to share recipes and cooking tips from around the globe.
Copyright (C) 2012 Anna CEJALVO - Nada HADDAJI KFITA - Ahou Melaine KOFFI - Marième TOURE
Saveurs d’ici et d’ailleurs is free software: you can redistribute it and/or modify it under the terms of the GNU Affero General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
Saveurs d’ici et d’ailleurs is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public License for more details.
You should have received a copy of the GNU Affero General Public License along with this program. If not, see ww.gnu.org/licenses/agpl-3.0.html.
-->

<%@ page import="ivvq_saveursdicietdailleurs.Categorie" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'categorie.label', default: 'Categorie')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
		<style type="text/css" media="screen">
		#someText {
		font-size:large;
		}
		
		</style>
	</head>
	<body>
		<a href="#show-categorie" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<%--<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			--%>
			</ul>
		</div>
		<div id="show-categorie" class="content scaffold-show" role="main">
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list categorie">
			<g:form>
				<fieldset class="buttons">
					<g:link action="showRecettes" id="1">Recettes</g:link>
					<g:link action="showPhotos" id="2">Photos</g:link>
					<g:link action="showVideos" id="3">Videos</g:link>
                    <g:link action="showConcours" id="4">Jeux Concours</g:link>
                    <g:link action="showOutils" id="5">Outils</g:link>
                </fieldset>
			</g:form>
			<h1><g:message code="${categorieInstance?.nomCategorie}" /></h1>
			<div id="someText">
				<p>
				<br>
					Un peu de bla-bla sur la cuisine locale et quelques photos
				</p>
			</div>
				<g:if test="${categorieInstance?.nomCategorie}">
				<li class="fieldcontain">
					<span id="nomCategorie-label" class="property-label"><g:message code="Pays"/></span>
						<span class="property-value" aria-labelledby="nomCategorie-label"><g:fieldValue bean="${categorieInstance}" field="nomCategorie"/></span>
				</li>
				</g:if>
			</ol>
			<%--<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${categorieInstance?.id}" />
					<g:link class="edit" action="edit" id="${categorieInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		--%>
		</div>
	</body>
</html>
