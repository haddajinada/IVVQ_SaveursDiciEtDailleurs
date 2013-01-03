/*******************************************************************************
 * SaveurDiciEtDailleurs est une application grails qui consiste à gérer des défis culinaires.
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

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Commentaire)
class CommentaireSpec extends Specification {
	
	def setup() {
		System.out.println("debut de test");
	}

	def cleanup() {
		System.out.println("fin de test");
	}

	void "test attributs Commentaire"() {
		expect:
			 new Commentaire(idCommentaire : idCom, corpsCommentaire : corpsCom, postCommentaire : postCom)
		where:
		idCom | corpsCom | postCom
		2     | "test"   | new Post(idPost : 1, intitule : "titré", message : "post1", auteurPost : new Membre(idMembre : "1", pseudo : "toto", mdp : "123456", prenom : "nada", nom : "kfita", adresse_mail : "kjnjn@jhhk.fr"))
	}
}
