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

import java.util.Date
import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Defi)
class DefiSpec extends Specification {
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

	def "intitule and description not blank"() {
		setup:
		mockDomain(Defi)
		mockDomain(Categorie)

		when:
		def defi=new Defi(intitule:intitule, description:"toto")
		def defi2=new Defi(intitule:"toto", description:description, categorie: new Categorie(nomCategorie:"lol") , dateCreation:new Date(), dateLimite:new Date())
		defi.validate()
		defi2.validate()

		then:
		defi.errors.hasFieldErrors("intitule")
		defi2.errors.hasFieldErrors("description")

		where:
		intitule=""
		description=""
	}

	@Unroll("test defi all constraints #field is #error using #val")
	def "test defi all constraints"() {
		setup:
		mockForConstraintsTests(Defi, [new Defi(intitule:'toto')])

		when:
		def defi=new Defi("$field": val)		

		then:
		validateConstraints(defi, field, error)

		where:
		error	|field			|val
		'blank'	|'intitule'		|''
		'unique'|'intitule'		|'toto'
		'valid'	|'intitule'		|'to'
		'blank'	|'description'	|''
	}
}