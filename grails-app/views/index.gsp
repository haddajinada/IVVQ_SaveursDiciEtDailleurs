<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Saveurs d'ici et d'ailleurs, bienvenue!</title>
		<style type="text/css" media="screen">
			#status {
				background-color: #E869AA;
				border: .2em solid #fff;
				margin: 2em 2em 1em;
				padding: 1em;
				width: 12em;
				/*height: 15em;*/
				float: left;
				-moz-box-shadow: 0px 0px 1.25em #ccc;
				-webkit-box-shadow: 0px 0px 1.25em #ccc;
				box-shadow: 0px 0px 1.25em #ccc;
				-moz-border-radius: 0.6em;
				-webkit-border-radius: 0.6em;
				border-radius: 0.6em;
			}

			.ie6 #status {
				display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
			}

			#status ul {
				font-size: 0.9em;
				list-style-type: none;
				margin-bottom: 0.6em;
				padding: 0;
			}
            
			#status li {
				line-height: 1.3;
				font-size:120%;
			}

			#status h1 {
				text-transform: uppercase;
				margin: 0 0 0.3em;
				font-size: 150%;
			}

			#page-body {
				margin: 2em 1em 1.25em 18em;
				height: 30em;
			}

			h2 {
				margin-top: 1em;
				margin-bottom: 0.3em;
				
			}

			p {
				line-height: 1.5;
				margin: 0.25em 0;
				font-size: 120%;
			}

			table {
				border:none;
			}
			
			#controller-list ul {
				list-style-position: inside;
			}

			#controller-list li {
				line-height: 1.3;
				list-style-position: inside;
				margin: 0.25em 0;
			}

			@media screen and (max-width: 480px) {
				#status {
					display: none;
				}

				#page-body {
					margin: 0 1em 1em;
				}

				#page-body h1 {
					margin-top: 0;
				}
			}
		</style>
	</head>
	<body>
		<div class="nav" role="navigation">
			<ul>
				
				<li><g:link class="${(session.user) == null ? 'login' : 'logout'}" action="${(session.user) == null ? 'login' : 'logout'}" controller="Membre">${(session.user) == null ? 'Se connecter' : 'Se déconnecter'}</g:link></li>
				<g:if test="${(session.user)}">
				<li><g:link class="show" controller="Membre" id="${(session.user.id)}" style="visibility:${(session.user) == null ? 'hidden' : 'visible'}">${(session.user.nom)}</g:link></li>
				</g:if>
			</ul>
		</div>
		<a href="#page-body" class="skip"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="status" role="complementary">
			<h2>MENU</h2>
			
			<ul>
				<g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
					<li class="controller"><g:link controller="${c.logicalPropertyName}">${c.name}</g:link></li>
				</g:each>
			</ul>

		</div>
		<div id="page-body" role="main">
			<h2>Saveurs d'ici et d'ailleurs vous souhaite la bienvenue! </br></h2>
			<p>
				Ce site permet aux passionnés de cuisine d’échanger des 
				recettes et astuces culinaires provenant des quatre coins du globe.
			</p>
			<p>	Pour accéder à l'ensemble des recettes postées il faudra vous inscrire ^^.
			</p>
			<p>
				Et pour vous donner un avant goût de ce que vous pouvez trouver ici, voici
				 les dernières recettes postées par nos membres :
			</p>
			</br>
	
			
		</div>
	</body>
</html>
