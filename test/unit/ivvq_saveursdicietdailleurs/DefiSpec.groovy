package ivvq_saveursdicietdailleurs

import java.util.Date;

import grails.test.mixin.TestFor
import spock.lang.Specification
import ivvq_saveursdicietdailleurs.Categorie
import ivvq_saveursdicietdailleurs.Defi

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
	
	def "intitule not blank"() {
		setup:
		mockDomain(Defi)
		mockDomain(Categorie)
		
		when:
		def defi=new Defi(intitule:intitule, description:"toto")
		def defi2=new Defi(intitule:"toto", description:description, categorie: new Categorie(idCategorie:"trop lol", nomCategorie:"lol") , dateCreation:new Date(), dateLimite:new Date())
		defi.validate()
		defi2.validate()
		
		then:
		defi.errors.hasFieldErrors("intitule")
		defi2.errors.hasFieldErrors("description")
		
		where:
		intitule=""
		description=""
	}

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
		'blank'	|'description'	|''
		'unique'|'intitule'		|'toto'
		'valid'	|'intitule'		|'to'

	}
	
	def "find defi by intitule"(){
		setup:
		mockDomain(Defi)
		mockDomain(Categorie)
		
		when:
		new Defi(intitule:"lola", description:"oulala", categorie:new Categorie(idCategorie:"id", nomCategorie:"categorie").save(), dateCreation:new Date(), dateLimite:new Date()).save()
		
		then:
		
		Categorie.findByIdCategorie("id") != null
		Defi.findByIntitule("lola") != null
	}
}
