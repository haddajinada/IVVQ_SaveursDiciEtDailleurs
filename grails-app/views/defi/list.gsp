<!--
Saveurs d’ici et d’ailleurs allows foodies to share recipes and cooking tips from around the globe.
Copyright (C) 2012 Anna CEJALVO - Nada HADDAJI KFITA - Ahou Melaine KOFFI - Marième TOURE
Saveurs d’ici et d’ailleurs is free software: you can redistribute it and/or modify it under the terms of the GNU Affero General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
Saveurs d’ici et d’ailleurs is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public License for more details.
You should have received a copy of the GNU Affero General Public License along with this program. If not, see ww.gnu.org/licenses/agpl-3.0.html.
-->
<%@ page import="ivvq_saveursdicietdailleurs.Defi" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'defi.label', default: 'Defi')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-defi" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-defi" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
						<g:sortableColumn property="intitule" title="${message(code: 'defi.intitule.label', default: 'Intitule')}" />
						<g:sortableColumn property="description" title="${message(code: 'defi.description.label', default: 'Description')}" />
						<g:sortableColumn property="dateLimite" title="${message(code: 'defi.dateLimite.label', default: 'Date Limite')}" />
						<th><g:message code="defi.categorie.label" default="Categorie" /></th>
						<g:sortableColumn property="dateCreation" title="${message(code: 'defi.dateCreation.label', default: 'Date Creation')}" />
					</tr>
				</thead>
				<tbody>
				<g:each in="${defiInstanceList}" status="i" var="defiInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td><g:link action="show" id="${defiInstance.id}">${fieldValue(bean: defiInstance, field: "intitule")}</g:link></td>
						<td>${fieldValue(bean: defiInstance, field: "description")}</td>
						<td><g:formatDate date="${defiInstance.dateLimite}" /></td>
						<td>${fieldValue(bean: defiInstance, field: "categorie")}</td>
						<td><g:formatDate date="${defiInstance.dateCreation}" /></td>
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${defiInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
