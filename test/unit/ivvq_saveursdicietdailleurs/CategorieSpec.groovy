<<<<<<< HEAD
package ivvq_saveursdicietdailleurs

=======
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

>>>>>>> origin/dev
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Categorie)
class CategorieSpec extends Specification {

<<<<<<< HEAD
	def setup() {
	}

	def cleanup() {
	}

	void "test something"() {
=======
	
	def "test nomCategorie not blank"() {
		setup:
		mockDomain(Categorie)
		
		when:
		def categorie = new Categorie(nomCategorie:nomCategorie)
		categorie.validate()
		
		then:
		categorie.errors.hasFieldErrors("nomCategorie")
		
		where:
		nomCategorie = ""
	}
	

	def "test nomCategorie not null"() {
		
		setup:
		mockDomain(Categorie)
		
		when:
		def categorie = new Categorie(nomCategorie:nomCategorie)
		categorie.validate()
		
		then:
		categorie.errors.hasFieldErrors("nomCategorie")
		
		where:
		nomCategorie = null
	}
	
	def "find categorie by nomCategorie"() {
		setup:
		mockDomain(Categorie)
		
		when:
		def categorie = new Categorie(nomCategorie:"nomCategorie").save() 
		
		then:
		Categorie.findByNomCategorie("nomCategorie") != null
>>>>>>> origin/dev
	}
}