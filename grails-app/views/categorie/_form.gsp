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
</div>

