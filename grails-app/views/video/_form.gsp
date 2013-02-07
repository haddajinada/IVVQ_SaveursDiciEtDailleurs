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

