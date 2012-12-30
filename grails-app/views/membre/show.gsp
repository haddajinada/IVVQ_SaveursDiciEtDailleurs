#-------------------------------------------------------------------------------
# Saveurs d’ici et d’ailleurs allows foodies to share recipes and cooking tips from around the globe.
# Copyright (C) 2012 Anna CEJALVO - Nada HADDAJI KFITA - Ahou Melaine KOFFI - Marième TOURE
# 
# Saveurs d’ici et d’ailleurs is free software: you can redistribute it and/or modify it under the terms of the GNU Affero General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
# 
# Saveurs d’ici et d’ailleurs is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public License for more details.
# 
# You should have received a copy of the GNU Affero General Public License along with this program.  If not, see ww.gnu.org/licenses/agpl-3.0.html.
#-------------------------------------------------------------------------------
<%@ page import="ivvq_saveursdicietdailleurs.Membre" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'membre.label', default: 'Membre')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-membre" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-membre" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list membre">
			
				<g:if test="${membreInstance?.pseudo}">
				<li class="fieldcontain">
					<span id="pseudo-label" class="property-label"><g:message code="membre.pseudo.label" default="Pseudo" /></span>
					
						<span class="property-value" aria-labelledby="pseudo-label"><g:fieldValue bean="${membreInstance}" field="pseudo"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${membreInstance?.mdp}">
				<li class="fieldcontain">
					<span id="mdp-label" class="property-label"><g:message code="membre.mdp.label" default="Mdp" /></span>
					
						<span class="property-value" aria-labelledby="mdp-label"><g:fieldValue bean="${membreInstance}" field="mdp"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${membreInstance?.adresse_mail}">
				<li class="fieldcontain">
					<span id="adresse_mail-label" class="property-label"><g:message code="membre.adresse_mail.label" default="Adressemail" /></span>
					
						<span class="property-value" aria-labelledby="adresse_mail-label"><g:fieldValue bean="${membreInstance}" field="adresse_mail"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${membreInstance?.idMembre}">
				<li class="fieldcontain">
					<span id="idMembre-label" class="property-label"><g:message code="membre.idMembre.label" default="Id Membre" /></span>
					
						<span class="property-value" aria-labelledby="idMembre-label"><g:fieldValue bean="${membreInstance}" field="idMembre"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${membreInstance?.nom}">
				<li class="fieldcontain">
					<span id="nom-label" class="property-label"><g:message code="membre.nom.label" default="Nom" /></span>
					
						<span class="property-value" aria-labelledby="nom-label"><g:fieldValue bean="${membreInstance}" field="nom"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${membreInstance?.prenom}">
				<li class="fieldcontain">
					<span id="prenom-label" class="property-label"><g:message code="membre.prenom.label" default="Prenom" /></span>
					
						<span class="property-value" aria-labelledby="prenom-label"><g:fieldValue bean="${membreInstance}" field="prenom"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${membreInstance?.id}" />
					<g:link class="edit" action="edit" id="${membreInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
