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


import grails.test.mixin.TestFor
import spock.lang.Unroll
import sun.security.action.GetLongAction;

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Photo)
class PhotoSpec {

@Unroll("test post all constraints #field is #error using #val")
def "test photo all constraints"() {
		setup:
		mockForConstraintsTests(Photo, [new Photo(recette:'toto', image : new byte[10000001])])
		
		when:
		def photo=new Photo("$field": val)		
		
		then:
		validateConstraints(photo, field, error)
		
		where:
		error	  |field		|val
		'size'	  |'image'	    |getLongbyte(10000001)

	}
	
}
