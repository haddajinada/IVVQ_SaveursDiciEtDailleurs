<!--
Saveurs d’ici et d’ailleurs allows foodies to share recipes and cooking tips from around the globe.
Copyright (C) 2012 Anna CEJALVO - Nada HADDAJI KFITA - Ahou Melaine KOFFI - Marième TOURE

Saveurs d’ici et d’ailleurs is free software: you can redistribute it and/or modify it under the terms of the GNU Affero General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

Saveurs d’ici et d’ailleurs is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License along with this program. If not, see ww.gnu.org/licenses/agpl-3.0.html.
-->
<%@ page import="ivvq_saveursdicietdailleurs.Categorie" %>
<!doctype html>
<html>
    <head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'categorie.label', default: 'Categorie')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
    <body>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
            </ul>
        </div>
        <div id="show-videos" class="content scaffold-show" role="main">
           <g:form>
				<fieldset class="buttons">
					<g:link action="showRecettes" id="1">Recettes</g:link>
					<g:link action="showPhotos" id="2">Photos</g:link>
					<g:link action="showVideos" id="3">Videos</g:link>
                    <g:link action="showConcours" id="4">Jeux Concours</g:link>
                    <g:link action="showOutils" id="5">Outils</g:link>
                </fieldset>
                <fieldset>
                	<h1><g:message code="${categorieInstance?.nomCategorie}" /></h1>
                	<h2><g:message code="Quelques Videos"/></h2>
                </fieldset>
			</g:form>
        </div>
    </body>
</html>