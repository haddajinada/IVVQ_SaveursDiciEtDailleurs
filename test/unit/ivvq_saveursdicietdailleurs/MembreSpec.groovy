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
import java.util.Date;

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll
import static grails.test.MockUtils.*
import ivvq_saveursdicietdailleurs.Post
import ivvq_saveursdicietdailleurs.Membre
import ivvq_saveursdicietdailleurs.MembreController

class MembreSpec extends Specification {
	
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
	
	String getEmail(Boolean valid) {
		valid ? "mel@miamipd.gov" : "melm@m"
	}
	
	def "pseudo and mdp not blank"() {
		setup:
		mockDomain(Membre)
		mockDomain(Post)
	   
		when:
		def membre1=new Membre(pseudo:pseudo, mdp:"mi0001", prenom:"mel", nom:"mel", adresse_mail:"mail@gmail.com", role:"membre") //, post: new Post(intitule:"", message:""))
		def membre2=new Membre(pseudo:"mel", mdp:mdp, prenom:"mel", nom:"mel", adresse_mail:"mail@gmail.com", role:"membre") //, post: new Post())
		membre1.validate()
		membre2.validate()
	   
		then:
		membre1.errors.hasFieldErrors("pseudo")
		membre2.errors.hasFieldErrors("mdp")
	   
		where:
		pseudo=""
		mdp=""
		prenom="moi"
		nom="moi"
		mail="moi@y.fr"
		role="Membre"
		}

	@Unroll("test membre all constraints #field is #error using #val")
	def "test membre all constraints"() {
		setup:
		mockForConstraintsTests(Membre, [new Membre(pseudo:'titi', mdp:'123456mo', adresse_mail:'mail@gmail.com', role:'Membre')]) //, post: new Post(idPost:'1', intitule:'mel', message:'miiiiiiii'))])
	   
		when:
		def membre1=new Membre("$field": val)
	   
		then:
		validateConstraints(membre1, field, error)
	   
		where:
		error      |field            |val
		'blank'    |'pseudo'         |''
		'unique'   |'pseudo'         |'titi'
		'valid'    |'pseudo'         |'to'
		'blank'    |'mdp'            |''
		'blank'    |'role'           |''
		'blank'    |'adresse_mail'   |''
		'email'    |'adresse_mail'   |getEmail(false)
	}
   
	def "find membre by pseudo"(){
		setup:
		mockDomain(Membre)
		mockDomain(Post)
	   
		when:
		new Membre(pseudo:"iiiiiiii", mdp:"meli01", prenom:"mel", nom:"mel", adresse_mail:"mail1@gmail.com", role:"Membre", post: new Post(idPost:"1", intitule:"mel", message:"miiiiiiii").save()).save()
			   
		then:
	   
		Membre.findByPseudo("iiiiiiii") != null
	}		
}