<%@ page import="ivvq_saveursdicietdailleurs.Membre" %>



<div class="fieldcontain ${hasErrors(bean: membreInstance, field: 'pseudo', 'error')} required">
	<label for="pseudo">
		<g:message code="membre.pseudo.label" default="Pseudo" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="pseudo" required="" value="${membreInstance?.pseudo}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: membreInstance, field: 'mdp', 'error')} required">
	<label for="mdp">
		<g:message code="membre.mdp.label" default="Mdp" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="mdp" maxlength="12" required="" value="${membreInstance?.mdp}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: membreInstance, field: 'adresse_mail', 'error')} ">
	<label for="adresse_mail">
		<g:message code="membre.adresse_mail.label" default="Adressemail" />
		
	</label>
	<g:field type="email" name="adresse_mail" value="${membreInstance?.adresse_mail}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: membreInstance, field: 'nom', 'error')} ">
	<label for="nom">
		<g:message code="membre.nom.label" default="Nom" />
		
	</label>
	<g:textField name="nom" value="${membreInstance?.nom}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: membreInstance, field: 'posts', 'error')} ">
	<label for="posts">
		<g:message code="membre.posts.label" default="Posts" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${membreInstance?.posts?}" var="p">
    <li><g:link controller="post" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="post" action="create" params="['membre.id': membreInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'post.label', default: 'Post')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: membreInstance, field: 'prenom', 'error')} ">
	<label for="prenom">
		<g:message code="membre.prenom.label" default="Prenom" />
		
	</label>
	<g:textField name="prenom" value="${membreInstance?.prenom}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: membreInstance, field: 'role', 'error')} ">
	<label for="role">
		<g:message code="membre.role.label" default="Role" />
		
	</label>
	<g:textField name="role" value="${membreInstance?.role}"/>
</div>

