<!--
Saveurs d’ici et d’ailleurs allows foodies to share recipes and cooking tips from around the globe.
Copyright (C) 2012 Anna CEJALVO - Nada HADDAJI KFITA - Ahou Melaine KOFFI - Marième TOURE

Saveurs d’ici et d’ailleurs is free software: you can redistribute it and/or modify it under the terms of the GNU Affero General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

Saveurs d’ici et d’ailleurs is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License along with this program. If not, see ww.gnu.org/licenses/agpl-3.0.html.
-->
<%@ page import="ivvq_saveursdicietdailleurs.Defi" %>



<div class="fieldcontain ${hasErrors(bean: defiInstance, field: 'intitule', 'error')} required">
	<label for="intitule">
		<g:message code="defi.intitule.label" default="Intitule" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="intitule" required="" value="${defiInstance?.intitule}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: defiInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="defi.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="description" cols="40" rows="5" required="" value="${defiInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: defiInstance, field: 'dateLimite', 'error')} required">
	<label for="dateLimite">
		<g:message code="defi.dateLimite.label" default="Date Limite" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dateLimite" precision="day"  value="${defiInstance?.dateLimite}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: defiInstance, field: 'categorie', 'error')} required">
	<label for="categorie">
		<g:message code="defi.categorie.label" default="Categorie" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="categorie" name="categorie.id" from="${ivvq_saveursdicietdailleurs.Categorie.list()}" optionKey="id" required="" value="${defiInstance?.categorie?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: defiInstance, field: 'dateCreation', 'error')} required">
	<label for="dateCreation">
		<g:message code="defi.dateCreation.label" default="Date Creation" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dateCreation" precision="day"  value="${defiInstance?.dateCreation}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: defiInstance, field: 'posts', 'error')} ">
	<label for="posts">
		<g:message code="defi.posts.label" default="Posts" />
		
	</label>
	<g:select name="posts" from="${ivvq_saveursdicietdailleurs.Post.list()}" multiple="multiple" optionKey="id" size="5" value="${defiInstance?.posts*.id}" class="many-to-many"/>
</div>

