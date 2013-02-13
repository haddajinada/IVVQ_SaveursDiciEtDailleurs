<%@ page import="ivvq_saveursdicietdailleurs.Post" %>



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

<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'tof', 'error')} ">
	<label for="tof">
		<g:message code="post.tof.label" default="Tof" />
		
	</label>
	<g:select id="tof" name="tof.id" from="${ivvq_saveursdicietdailleurs.Photo.list()}" optionKey="id" value="${postInstance?.tof?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'video', 'error')} ">
	<label for="video">
		<g:message code="post.video.label" default="Video" />
		
	</label>
	<g:select id="video" name="video.id" from="${ivvq_saveursdicietdailleurs.Video.list()}" optionKey="id" value="${postInstance?.video?.id}" class="many-to-one" noSelection="['null': '']"/>
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

