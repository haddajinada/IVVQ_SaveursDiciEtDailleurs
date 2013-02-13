<<<<<<< HEAD
<%@ page import="ivvq_saveursdicietdailleurs.Categorie" %>

<div class="fieldcontain ${hasErrors(bean: categorieInstance, field: 'idCategorie', 'error')} required">
	<label for="">
		<g:message code="categorie.idCategorie.label" default="Id Categorie" />
	</label>
</div>

<div class="fieldcontain ${hasErrors(bean: categorieInstance, field: 'nomCategorie', 'error')} required">
	<label for="">
		<g:message code="categorie.nomCategorie.label" default="Nom Categorie" />
	</label>
=======
<!--
Saveurs d’ici et d’ailleurs allows foodies to share recipes and cooking tips from around the globe.
Copyright (C) 2012 Anna CEJALVO - Nada HADDAJI KFITA - Ahou Melaine KOFFI - Marième TOURE
Saveurs d’ici et d’ailleurs is free software: you can redistribute it and/or modify it under the terms of the GNU Affero General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
Saveurs d’ici et d’ailleurs is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public License for more details.
You should have received a copy of the GNU Affero General Public License along with this program. If not, see ww.gnu.org/licenses/agpl-3.0.html.
-->

<%@ page import="ivvq_saveursdicietdailleurs.Categorie" %>



<div class="fieldcontain ${hasErrors(bean: categorieInstance, field: 'idCategorie', 'error')} required">
	<label for="idCategorie">
		<g:message code="categorie.idCategorie.label" default="Id Categorie" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="idCategorie" required="" value="${categorieInstance?.idCategorie}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: categorieInstance, field: 'nomCategorie', 'error')} required">
	<label for="nomCategorie">
		<g:message code="categorie.nomCategorie.label" default="Nom Categorie" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nomCategorie" required="" value="${categorieInstance?.nomCategorie}"/>
>>>>>>> origin/dev
</div>

