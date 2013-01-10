<!--
Saveurs d’ici et d’ailleurs allows foodies to share recipes and cooking tips from around the globe.
Copyright (C) 2012 Anna CEJALVO - Nada HADDAJI KFITA - Ahou Melaine KOFFI - Marième TOURE

Saveurs d’ici et d’ailleurs is free software: you can redistribute it and/or modify it under the terms of the GNU Affero General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

Saveurs d’ici et d’ailleurs is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License along with this program. If not, see ww.gnu.org/licenses/agpl-3.0.html.
-->
<%@ page import="ivvq_saveursdicietdailleurs.Membre" %>
<!doctype html>
<html>
    <head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'membre.label', default: 'Membre')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
    <body>
        <a href="#create-membre" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create">S'inscrire</g:link></li>
            </ul>
        </div>
        <div id="create-membre" class="content scaffold-create" role="main">
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${membreInstance}">
            <ul class="errors" role="alert">
                <g:eachError bean="${membreInstance}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <h1><g:message code="Veuillez vous connecter" /></h1>
            <g:form action="authenticate" >
                <fieldset class="form">
                    <div class="fieldcontain ${hasErrors(bean: membreInstance, field: 'pseudo', 'error')} ">
                        <label for="pseudo">
                            <g:message code="membre.pseudo.label" default="Pseudo" />
                            
                        </label>
                        <g:textField name="pseudo" value="${membreInstance?.pseudo}"/>
                    </div>
                    
                    <div class="fieldcontain ${hasErrors(bean: membreInstance, field: 'motDePasse', 'error')} ">
                        <label for="motDePasse">
                            <g:message code="membre.motDePasse.label" default="Mot de passe" />
                            
                        </label>
                        <g:field type="motDePasse" name="motDePasse" value="${membreInstance?.motDePasse}"/>
                    </div>
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="login" class="save" value="Se connecter" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
