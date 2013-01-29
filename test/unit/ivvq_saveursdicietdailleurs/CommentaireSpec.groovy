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

	void validateConstraints(obj, field, error) {
		def validated = obj.validate()
		if (error && error != 'valid') {
			assert !validated
			assert obj.errors[field]
			assert error == obj.errors[field]
		} else {
			assert !obj.errors[field]
		}
	}
   
	def "corpsCommentaire not blank"() {
		setup:
		mockDomain(Commentaire)
	   
		when:
		def commentaire=new Commentaire(corpsCommentaire:corpsCommentaire)
		def commentaire2=new Commentaire(corpsCommentaire:"toto")
		commentaire.validate()
		commentaire2.validate()
	   
		then:
		commentaire.errors.hasFieldErrors("corpsCommentaire")
   
		where:
		corpsCommentaire=""
	
	}

	def "test commentaire all constraints"() {
		setup:
		mockForConstraintsTests(Commentaire, [new Commentaire(corpsCommentaire:'toto')])
	   
		when:
		def comment=new Commentaire("$field": val)
	   
		then:
		validateConstraints(comment, field, error)
	   
		where:
		error       |field                |val
		'blank'     |'corpsCommentaire'   |''
		'nullable'  |'corpsCommentaire'   |''
		'valid'     |'corpsCommentaire'   |'toto'
	

	}

}
