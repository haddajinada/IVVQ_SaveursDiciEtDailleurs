<!--
SaveurDiciEtDailleurs est une application grails qui consiste à gérer des défis culinaires.

Copyright (C) 2012  by - KFITA Nada, CEJALVO Anna, TOURE Mariame, KOFFI Aho Melaine

SaveurDiciEtDailleurs is free software: you can redistribute it and/or modify it under the terms of the GNU Affero General Public License as
published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

SaveurDiciEtDailleurs  is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the  GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License along with this program.  If not, see http://www.gnu.org/licenses/agpl-3.0.html.
--!>
<%@ page import="ivvq_saveursdicietdailleurs.Commentaire" %>



<div class="fieldcontain ${hasErrors(bean: commentaireInstance, field: 'corpsCommentaire', 'error')} required">
	<label for="corpsCommentaire">
		<g:message code="commentaire.corpsCommentaire.label" default="Corps Commentaire" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="corpsCommentaire" required="" value="${commentaireInstance?.corpsCommentaire}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: commentaireInstance, field: 'postCommentaire', 'error')} required">
	<label for="postCommentaire">
		<g:message code="commentaire.postCommentaire.label" default="Post Commentaire" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="postCommentaire" name="postCommentaire.id" from="${ivvq_saveursdicietdailleurs.Post.list()}" optionKey="id" required="" value="${commentaireInstance?.postCommentaire?.id}" class="many-to-one"/>
</div>

