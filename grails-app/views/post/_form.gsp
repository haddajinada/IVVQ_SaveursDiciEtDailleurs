<!--
Saveurs d’ici et d’ailleurs allows foodies to share recipes and cooking tips from around the globe.
Copyright (C) 2012 Anna CEJALVO - Nada HADDAJI KFITA - Ahou Melaine KOFFI - Marième TOURE

Saveurs d’ici et d’ailleurs is free software: you can redistribute it and/or modify it under the terms of the GNU Affero General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

Saveurs d’ici et d’ailleurs is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License along with this program. If not, see ww.gnu.org/licenses/agpl-3.0.html.
-->
<%@ page import="ivvq_saveursdicietdailleurs.Post" %>



<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'idPost', 'error')} required">
	<label for="idPost">
		<g:message code="post.idPost.label" default="Id Post" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="idPost" required="" value="${postInstance.idPost}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'intitule', 'error')} required">
	<label for="intitule">
		<g:message code="post.intitule.label" default="Intitule" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="intitule" required="" value="${postInstance?.intitule}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'message', 'error')} required">
	<label for="message">
		<g:message code="post.message.label" default="Message" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="message" required="" value="${postInstance?.message}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'auteurPost', 'error')} required">
	<label for="auteurPost">
		<g:message code="post.auteurPost.label" default="Auteur Post" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="auteurPost" name="auteurPost.id" from="${ivvq_saveursdicietdailleurs.Membre.list()}" optionKey="id" required="" value="${postInstance?.auteurPost?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'commentaires', 'error')} ">
	<label for="commentaires">
		<g:message code="post.commentaires.label" default="Commentaires" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${postInstance?.commentaires?}" var="c">
    <li><g:link controller="commentaire" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="commentaire" action="create" params="['post.id': postInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'commentaire.label', default: 'Commentaire')])}</g:link>
</li>
</ul>

</div>

