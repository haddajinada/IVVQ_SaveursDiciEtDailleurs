<%@ page import="ivvq_saveursdicietdailleurs.Photo" %>



<div class="fieldcontain ${hasErrors(bean: photoInstance, field: 'image', 'error')} ">
	<label for="image">
		<g:message code="photo.image.label" default="Image" />
		
	</label>
	<input type="file" id="image" name="image" />
</div>

<div class="fieldcontain ${hasErrors(bean: photoInstance, field: 'recette', 'error')} ">
	<label for="recette">
		<g:message code="photo.recette.label" default="Recette" />
		
	</label>
	<g:textField name="recette" value="${photoInstance?.recette}"/>
</div>

