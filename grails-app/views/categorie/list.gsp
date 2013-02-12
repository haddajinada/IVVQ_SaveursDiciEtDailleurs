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
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	
	</head>
	<body>
		<a href="#list-categorie" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="Ajouter un pays" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-categorie" class="content scaffold-list" role="main">
			<h1><g:message code="Choisissez un pays" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					<%--<g:select name="nomCategorie" noSelection="${['null':'Pays...']}" from="${Categorie.list()}" optionKey="nomCategorie" optionValue="nomCategorie"></g:select>
					--%>
					</tr>
				</thead>
				<tbody>
				<g:each in="${categorieInstanceList}" status="i" var="categorieInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td><g:link action="show" id="${categorieInstance.id}">${fieldValue(bean: categorieInstance, field: "id")}</g:link></td>
						<td><g:link action="show" id="${categorieInstance.id}">${fieldValue(bean: categorieInstance, field: "nomCategorie")}</g:link></td>
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${categorieInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
