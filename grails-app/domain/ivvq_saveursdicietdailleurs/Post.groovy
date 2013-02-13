/*******************************************************************************
 * Saveurs d�ici et d�ailleurs allows foodies to share recipes and cooking tips from around the globe.
 * Copyright (C) 2012 Anna CEJALVO - Nada HADDAJI KFITA - Ahou Melaine KOFFI - Mari�me TOURE
 * 
 * Saveurs d�ici et d�ailleurs is free software: you can redistribute it and/or modify it under the terms of the GNU Affero General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * 
 * Saveurs d�ici et d�ailleurs is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License along with this program. If not, see ww.gnu.org/licenses/agpl-3.0.html.
 ******************************************************************************/
package ivvq_saveursdicietdailleurs

/**
* Post est la classe repr�sentant une recette de cuisine.
* 
* Un Post est caract�ris� par les informations suivantes :
* 
* Un "intitule" intitul� de la recette.
* Un "message" le contenu de la recette.
* Un "auteurPost" qui doit �tre un membre.
* Un "tof" qui correspond � une photo de la recette, suceptible d'�tre null.
* Un "video" qui correspond � une video de la recette, suceptible d'�tre null.
* Des "commentaires" des visiteurs sur la recette.
* 
* 
*
* @author nada
* @version 1.0
*/
class Post {
	/**
	* L'intitul� du Post.
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
	* La video associ� au Post.
	*
	* @see Video
	*/
	Video video
	/**
	* Les commentaire associ�s au Post.
	*
	*/
	static hasMany = [commentaires : Commentaire]
	/**
	* Les contraintes � respecter pour cr�er un Post : 
	* tous les attributs de Post doivent �tre precis�s sauf la photo et la video.
	*
	*/
	static constraints = {
		intitule blank : false, nullable : false
		message blank : false, nullable : false
		tof blank : true, nullable : true
		video blank : true, nullable : true
	}
	
	/**
	 * @return l'intitul� de la recette
	 */
	String toString(){
		return " $intitule"//$idPost $message
	}
}
