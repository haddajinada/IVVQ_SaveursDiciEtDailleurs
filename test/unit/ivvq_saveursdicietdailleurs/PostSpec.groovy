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

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Post)
class PostSpec extends Specification {

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
	
	def "index action"() {
		setup:
		mockLogging(PostController, true)
		
		when:
		controller.index()
		
		then:
		response.redirectedUrl == "/post/list"
	}
	
	def "intitule and message not blank"() {
		setup:
		mockDomain(Membre)
		mockDomain(Post)
		
		when:
		Membre membre = new Membre(idMembre:"id", pseudo:"pseudo", mdp:"mdp", prenom:"nada", nom:"jojjo", adresse_mail:"dfdfdsf@dfdsf.fr").save()
		Post post = new Post(intitule:intitule, message:"test de post", auteurPost:membre).save()
		post.validate()
		
		then:
		post.errors.hasFieldErrors("intitule")

		
		where:
		intitule=""
	}

@Unroll("test post all constraints #field is #error using #val")
def "test post all constraints"() {
		setup:
		mockForConstraintsTests(Post, [new Post(intitule:'toto')])
		
		when:
		def post=new Post("$field": val)		
		
		then:
		validateConstraints(post, field, error)
		
		where:
		error	  |field		|val
		'blank'	  |'intitule'	|''
		'nullable'|'intitule'	|null
		'blank'	  |'message'	|''
		'nullable'|'message'	|null
		'blank'	  |'auteurPost'	|''
		'nullable'|'auteurPost'	|null
	}
	
	def "find post by intitule"() {
		setup:
		mockDomain(Membre)
		mockDomain(Post)
		
		when:
		Membre membre = new Membre(idMembre:"id", pseudo:"pseudo", mdp:"mdp", prenom:"nada", nom:"jojjo", adresse_mail:"dfdfdsf@dfdsf.fr").save()
		Post post = new Post(intitule:"post1", message:"test de post", auteurPost:membre).save()
		
		then:
		Post.findByIntitule("post1") != null
	}

}
