/*******************************************************************************
 * SaveurDiciEtDailleurs est une application grails qui consiste � g�rer des d�fis culinaires.
 * 
 * Copyright (C) 2012  by - KFITA Nada, CEJALVO Anna, TOURE Mariame, KOFFI Aho Melaine
 * 
 * SaveurDiciEtDailleurs is free software: you can redistribute it and/or modify it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * 
 * SaveurDiciEtDailleurs  is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the  GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License along with this program.  If not, see http://www.gnu.org/licenses/agpl-3.0.html.
 ******************************************************************************/
package ivvq_saveursdicietdailleurs

class Post {

	int idPost
	String intitule
	String message
	Membre auteurPost
	static hasMany = [commentaires : Commentaire]

//	def beforeInsert() {
//		def lastIdPost = Post.list([sort: 'idPost', order:'desc', max: 1])
//		if(lastIdPost)
//			idPost = (lastIdPost.pop().getAt(idPost) as int) + 1 as int
//		else
//			idPost = '0'
//	}

	static constraints = {
		idPost blank : false,nullable : false, unique : true
		intitule blank : false, nullable : false
		message blank : false, nullable : false
	}

	String toString(){
		return " $intitule"//$idPost $message
	}
}
