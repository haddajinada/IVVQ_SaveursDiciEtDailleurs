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

class Membre {
	String idMembre
	String pseudo
	String mdp
	String prenom
	String nom
	String adresse_mail
	
	//static hasMany = [posts : Post] je mets en comm parce que pas encore cr�e post
	
    static constraints = {
		pseudo blank : false, unique : true
		mdp size : 6..12, blank : false
		adresse_mail email : true
    }
}
