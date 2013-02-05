/*******************************************************************************
 * Saveurs d’ici et d’ailleurs allows foodies to share recipes and cooking tips from around the globe.
 * Copyright (C) 2012 Anna CEJALVO - Nada HADDAJI KFITA - Ahou Melaine KOFFI - Marième TOURE
 * 
 * Saveurs d’ici et d’ailleurs is free software: you can redistribute it and/or modify it under the terms of the GNU Affero General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * 
 * Saveurs d’ici et d’ailleurs is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License along with this program. If not, see ww.gnu.org/licenses/agpl-3.0.htm
 ******************************************************************************/
package ivvq_saveursdicietdailleurs

class Post {

	//int idPost
	String intitule
	String message
	Membre auteurPost
	Photo photo
	Video video
	static hasMany = [commentaires : Commentaire]

//	def beforeInsert() {
//		def lastIdPost = Post.list([sort: 'idPost', order:'desc', max: 1])
//		if(lastIdPost)
//			idPost = (lastIdPost.pop().getAt(idPost) as int) + 1 as int
//		else
//			idPost = '0'
//	}

	static constraints = {
		//idPost blank : false,nullable : false, unique : true
		intitule blank : false, nullable : false
		message blank : false, nullable : false
		photo blank : true, nullable : true
		video blank : true, nullable : true
	}

	String toString(){
		return " $intitule"//$idPost $message
	}
}
