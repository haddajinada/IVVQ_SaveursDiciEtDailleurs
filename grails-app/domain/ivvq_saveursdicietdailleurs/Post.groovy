/*******************************************************************************
 * Saveurs d’ici et d’ailleurs allows foodies to share recipes and cooking tips from around the globe.
 * Copyright (C) 2012 Anna CEJALVO - Nada HADDAJI KFITA - Ahou Melaine KOFFI - Marième TOURE
 * 
 * Saveurs d’ici et d’ailleurs is free software: you can redistribute it and/or modify it under the terms of the GNU Affero General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * 
 * Saveurs d’ici et d’ailleurs is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License along with this program. If not, see ww.gnu.org/licenses/agpl-3.0.html.
 ******************************************************************************/
package ivvq_saveursdicietdailleurs

/**
* Post est la classe représentant une recette de cuisine.
* 
* Un Post est caractérisé par les informations suivantes :
* 
* Un "intitule" intitulé de la recette.
* Un "message" le contenu de la recette.
* Un "auteurPost" qui doit être un membre.
* Un "tof" qui correspond à une photo de la recette, suceptible d'être null.
* Un "video" qui correspond à une video de la recette, suceptible d'être null.
* Des "commentaires" des visiteurs sur la recette.
* 
* 
*
* @author nada
* @version 1.0
*/
class Post {
	/**
	* L'intitulé du Post.
	*
	*/
	String intitule
	/**
	* La description du Post.
	*
	*/
	String message
	/**
	* L'auteur du Post.
	*
	*/
	Membre auteurPost
	/**
	* La photo du Post.
	*
	* @see Photo
	*/
	Photo tof
	/**
	* La video associé au Post.
	*
	* @see Video
	*/
	Video video
	/**
	* Les commentaire associés au Post.
	*
	*/
	static hasMany = [commentaires : Commentaire]
	/**
	* Les contraintes à respecter pour créer un Post : 
	* tous les attributs de Post doivent être precisés sauf la photo et la video.
	*
	*/
	static constraints = {
		intitule blank : false, nullable : false
		message blank : false, nullable : false
		tof blank : true, nullable : true
		video blank : true, nullable : true
	}
	
	/**
	 * @return l'intitulé de la recette
	 */
	String toString(){
		return " $intitule"//$idPost $message
	}
}
