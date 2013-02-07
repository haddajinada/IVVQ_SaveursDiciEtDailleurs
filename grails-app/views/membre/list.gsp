<<<<<<< HEAD
<!--
SaveurDiciEtDailleurs est une application grails qui consiste à gérer des défis culinaires.

Copyright (C) 2012  by - KFITA Nada, CEJALVO Anna, TOURE Mariame, KOFFI Aho Melaine

SaveurDiciEtDailleurs is free software: you can redistribute it and/or modify it under the terms of the GNU Affero General Public License as
published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

SaveurDiciEtDailleurs  is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the  GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License along with this program.  If not, see http://www.gnu.org/licenses/agpl-3.0.html.
--!>
#-------------------------------------------------------------------------------
# Saveurs d’ici et d’ailleurs allows foodies to share recipes and cooking tips from around the globe.
# Copyright (C) 2012 Anna CEJALVO - Nada HADDAJI KFITA - Ahou Melaine KOFFI - Marième TOURE
# 
# Saveurs d’ici et d’ailleurs is free software: you can redistribute it and/or modify it under the terms of the GNU Affero General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
# 
# Saveurs d’ici et d’ailleurs is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public License for more details.
# 
# You should have received a copy of the GNU Affero General Public License along with this program. If not, see ww.gnu.org/licenses/agpl-3.0.htm
#-------------------------------------------------------------------------------
<%@ page import="ivvq_saveursdicietdailleurs.Membre" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'membre.label', default: 'Membre')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-membre" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-membre" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="pseudo" title="${message(code: 'membre.pseudo.label', default: 'Pseudo')}" />
					
						<g:sortableColumn property="mdp" title="${message(code: 'membre.mdp.label', default: 'Mdp')}" />
					
						<g:sortableColumn property="adresse_mail" title="${message(code: 'membre.adresse_mail.label', default: 'Adressemail')}" />
					
						<g:sortableColumn property="idMembre" title="${message(code: 'membre.idMembre.label', default: 'Id Membre')}" />
					
						<g:sortableColumn property="nom" title="${message(code: 'membre.nom.label', default: 'Nom')}" />
					
						<g:sortableColumn property="prenom" title="${message(code: 'membre.prenom.label', default: 'Prenom')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${membreInstanceList}" status="i" var="membreInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${membreInstance.id}">${fieldValue(bean: membreInstance, field: "pseudo")}</g:link></td>
					
						<td>${fieldValue(bean: membreInstance, field: "mdp")}</td>
					
						<td>${fieldValue(bean: membreInstance, field: "adresse_mail")}</td>
					
						<td>${fieldValue(bean: membreInstance, field: "idMembre")}</td>
					
						<td>${fieldValue(bean: membreInstance, field: "nom")}</td>
					
						<td>${fieldValue(bean: membreInstance, field: "prenom")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${membreInstanceTotal}" />
			</div>
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
<%@ page import="ivvq_saveursdicietdailleurs.Membre" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'membre.label', default: 'Membre')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-membre" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-membre" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="pseudo" title="${message(code: 'membre.pseudo.label', default: 'Pseudo')}" />
					
						<g:sortableColumn property="mdp" title="${message(code: 'membre.mdp.label', default: 'Mdp')}" />
					
						<g:sortableColumn property="adresse_mail" title="${message(code: 'membre.adresse_mail.label', default: 'Adressemail')}" />
					
						<g:sortableColumn property="idMembre" title="${message(code: 'membre.idMembre.label', default: 'Id Membre')}" />
					
						<g:sortableColumn property="nom" title="${message(code: 'membre.nom.label', default: 'Nom')}" />
					
						<g:sortableColumn property="prenom" title="${message(code: 'membre.prenom.label', default: 'Prenom')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${membreInstanceList}" status="i" var="membreInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${membreInstance.id}">${fieldValue(bean: membreInstance, field: "pseudo")}</g:link></td>
					
						<td>${fieldValue(bean: membreInstance, field: "mdp")}</td>
					
						<td>${fieldValue(bean: membreInstance, field: "adresse_mail")}</td>
					
						<td>${fieldValue(bean: membreInstance, field: "idMembre")}</td>
					
						<td>${fieldValue(bean: membreInstance, field: "nom")}</td>
					
						<td>${fieldValue(bean: membreInstance, field: "prenom")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${membreInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
>>>>>>> 4bd57838cae24008542bf85621cd5fc46af25236
