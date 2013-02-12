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

import grails.test.mixin.*
import spock.lang.Specification;
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Video)
class VideoSpec extends Specification {

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

	def "keyVideoYoutube not blank"() {
		setup:
		mockDomain(Video)

		when:
		Video video = new Video(titreRecette : "test", keyVideoYoutube : "3NxuoIIz8Pk", recette : "ma recette")
		video.validate()

		then:
		video.errors.hasFieldErrors("keyVideoYoutube")

		where:
		keyVideoYoutube=""
	}

	@Unroll("test video all constraints #field is #error using #val")
	def "test video all constraints"() {
		setup:
		mockForConstraintsTests(Video, [
			new Video(titreRecette:'recettttt')
		])

		when:
		def video = new Video("$field": val)

		then:
		validateConstraints(video, field, error)

		where:
		error	  |field		     |val
		'blank'	  |'titreRecette'	 |''
		'blank'   |'keyVideoYoutube' |'nada'
		'blank'	  |'recette'	     |''

	}
}
