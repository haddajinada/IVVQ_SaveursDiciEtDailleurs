<!--
Saveurs d’ici et d’ailleurs allows foodies to share recipes and cooking tips from around the globe.
Copyright (C) 2012 Anna CEJALVO - Nada HADDAJI KFITA - Ahou Melaine KOFFI - Marième TOURE

Saveurs d’ici et d’ailleurs is free software: you can redistribute it and/or modify it under the terms of the GNU Affero General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

Saveurs d’ici et d’ailleurs is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License along with this program. If not, see ww.gnu.org/licenses/agpl-3.0.html.
-->
<%@ page import="ivvq_saveursdicietdailleurs.Video" %>



<div class="fieldcontain ${hasErrors(bean: videoInstance, field: 'recette', 'error')} ">
	<label for="recette">
		<g:message code="video.recette.label" default="Recette" />
		
	</label>
	<g:textField name="recette" value="${videoInstance?.recette}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: videoInstance, field: 'keyVideoYoutube', 'error')} ">
	<label for="keyVideoYoutube">
		<g:message code="video.keyVideoYoutube.label" default="Key Video Youtube" />
		
	</label>
	<g:textField name="keyVideoYoutube" value="${videoInstance?.keyVideoYoutube}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: videoInstance, field: 'titreRecette', 'error')} ">
	<label for="titreRecette">
		<g:message code="video.titreRecette.label" default="Titre Recette" />
		
	</label>
	<g:textField name="titreRecette" value="${videoInstance?.titreRecette}"/>
</div>

