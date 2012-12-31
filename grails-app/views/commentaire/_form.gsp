<%@ page import="ivvq_saveursdicietdailleurs.Commentaire" %>



<div class="fieldcontain ${hasErrors(bean: commentaireInstance, field: 'idCommentaire', 'error')} required">
	<label for="idCommentaire">
		<g:message code="commentaire.idCommentaire.label" default="Id Commentaire" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="idCommentaire" required="" value="${commentaireInstance.idCommentaire}"/>
</div>

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

