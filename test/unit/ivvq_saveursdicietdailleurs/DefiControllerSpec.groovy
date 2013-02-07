package ivvq_saveursdicietdailleurs

import grails.test.mixin.TestFor
import spock.lang.Specification
import static grails.test.MockUtils.*

class DefiControllerSpec extends Specification {
	def mockI18N = { controller ->
		controller.metaClass.message = { Map map ->
			return "I18N message ($map)"
		}
	}
	
	def "index action"() {
		setup:
		mockLogging(DefiController, true)
		
		when:
		controller.index()
		
		then:
		response.redirectedUrl == "/defi/list"
	}
	
	/*def "list action: 1 defi"() {
		setup:
		mockLogging(DefiController, true)
		mockDomain(Defi, [defiInstance])
		mockDomain(Categorie)
		
		expect:
		controller.list() == [defiInstanceList: [defiInstance], defiInstanceTotal:1]
		
		where:
		defiInstance = new Defi(intitule:"toto", description:"titi", categorie: new Categorie(idCategorie:"trop lol", nomCategorie:"lol") , dateCreation:new Date(), dateLimite:new Date())
	}
	
	def "list action: 2 defis and max = 1"() {
		setup:
		mockLogging(DefiController, true)
		mockDomain(Defi, [firstDefiInstance, secondDefiInstance])
		mockDomain(Categorie)
		controller.params.max = 1
		
		expect:
		controller.list() == [defiInstanceList: [firstDefiInstance], defiInstance: 2]
		
		where:
		firstDefiInstance = new Defi(intitule:"toto", description:"titi", categorie: new Categorie(idCategorie:"trop lol", nomCategorie:"lol") , dateCreation:new Date(), dateLimite:new Date())
		secondDefiInstance = new Defi(intitule:"lala", description:"lili", categorie: new Categorie(idCategorie:"trop lol", nomCategorie:"lol") , dateCreation:new Date(), dateLimite:new Date())
	}*/
	
	def "create action"() {
		setup:
		mockLogging(DefiController, true)
		mockDomain(Defi)
		mockDomain(Categorie)
		controller.params.intitule = intitule
		controller.params.description = description
		controller.params.categorie = categorie
		controller.params.dateCreation = dateCreation
		controller.params.dateLimite = dateLimite
		
		when:
		def model = controller.create()
		
		then:
		model.defiInstance != null
		model.defiInstance.intitule == intitule
		model.defiInstance.description == description
		model.defiInstance.categorie == categorie
		model.defiInstance.dateCreation == dateCreation
		model.defiInstance.dateLimite == dateLimite
		
		where:
		intitule = "lala"
		description = "desc de lala"
		categorie = new Categorie(idCategorie:"trop lol", nomCategorie:"lol")
		dateCreation = new Date()
		dateLimite = new Date() + 10
	}
	/*
	def "save action: valid defi"() {
		setup:
		mockLogging(DefiController, true)
		mockDomain(Defi)
		mockDomain(Categorie)
		mockI18N(DefiController)
		controller.params.intitule = "titi"
		controller.params.description = "tit desc"
		controller.params.categorie = new Categorie(idCategorie:"trop lol", nomCategorie:"lol")
		controller.params.dateCreation = new Date()
		controller.params.dateLimite = new Date() + 10
		
		when:
		controller.save()
		
		then:
		response.redirectedUrl == "/defi/show"
		controller.flash.message != null
	}
	
	def "save action: invalid defi"() {
		setup:
		mockLogging(DefiController, true)
		mockDomain(Defi)
		mockForConstraintsTests(Defi)
		mockDomain(Categorie)
		mockI18N(DefiController)
		controller.params.intitule = intitule
		controller.params.description = description
		controller.params.categorie = categorie
		controller.params.dateCreation = dateCreation
		controller.params.dateLimite = dateLimite
		
		when:
		controller.save()
		
		then:
		renderArgs.view == "create"
		renderArgs.model.defiInstance.intitule == intitule
		renderArgs.model.defiInstance.description == description
		renderArgs.model.defiInstance.categorie == categorie
		renderArgs.model.defiInstance.dateCreation == dateCreation
		renderArgs.model.defiInstance.dateLimite == dateLimite
		
		where:
		intitule = "lala"
		description = ""
		categorie = new Categorie(idCategorie:"trop lol", nomCategorie:"lol")
		dateCreation = new Date()
		dateLimite = new Date() + 10
	}*/
	
	def "show action: existing defi"() {
		setup:
		mockLogging(DefiController, true)
		mockDomain(Defi, [defiInstance])
		mockDomain(Categorie)
		mockI18N(DefiController)
		controller.params.id = defiInstance.id
		
		expect:
		controller.show() == [defiInstance: defiInstance]
		
		where:
		defiInstance = new Defi(intitule:"toto", description:"titi", categorie: new Categorie(idCategorie:"trop lol", nomCategorie:"lol") , dateCreation:new Date(), dateLimite:new Date())
	}
	/*
	def "show action: not existing defi"() {
		setup:
		mockLogging(DefiController, true)
		mockDomain(Defi, [defiInstance])
		mockDomain(Categorie)
		mockI18N(DefiController)
		controller.params.id = defiInstance.id
		
		when:
		controller.show()
		
		then:
		response.redirectedUrl == "/defi/list"
		controller.flash.message != null
	}*/
	
	def "edit action: existing defi"() {
		setup:
		mockLogging(DefiController, true)
		mockDomain(Defi, [defiInstance])
		mockDomain(Categorie)
		mockI18N(DefiController)
		controller.params.id = defiInstance.id
		
		expect:
		controller.edit() == [defiInstance: defiInstance]
		
		where:
		defiInstance = new Defi(intitule:"toto", description:"titi", categorie: new Categorie(idCategorie:"trop lol", nomCategorie:"lol") , dateCreation:new Date(), dateLimite:new Date())
	}
	/*
	def "edit action: not existing defi"() {
		setup:
		mockLogging(DefiController, true)
		mockDomain(Defi, [defiInstance])
		mockI18N(DefiController)
		controller.params.id = 1L
		
		when:
		controller.edit()
		
		then:
		response.redirectedUrl == "/defi/list"
		controller.flash.message != null
	}*/
	
	def "update action: valid defi"() {
		setup:
		mockDomain(Defi, [defiInstance])
		mockLogging(DefiController, true)
		mockDomain(Categorie)
		mockI18N(DefiController)
		controller.params.intitule = "titi changed"
		controller.params.description = "tit desc changed"
		controller.params.categorie = new Categorie(idCategorie:"trop lol", nomCategorie:"lol")
		controller.params.dateCreation = new Date()
		controller.params.dateLimite = new Date() + 10
		controller.params.version = defiInstance.version
		controller.params.id = defiInstance.id
	
		when:
		controller.update()
	
		then:
		response.redirectedUrl == "/defi/show"
		controller.flash.message != null
	
		where:
		defiInstance = new Defi(intitule:"toto", description:"titi", categorie: new Categorie(idCategorie:"trop lol", nomCategorie:"lol") , dateCreation:new Date(), dateLimite:new Date(), version: 1)
	}

	def "update action: optimistic locking"() {
		setup:
		mockDomain(Defi, [defiInstance])
		mockLogging(DefiController, true)
		mockDomain(Categorie)
		mockI18N(DefiController)
		controller.params.intitule = "titi changed"
		controller.params.description = "tit desc changed"
		controller.params.categorie = new Categorie(idCategorie:"trop lol", nomCategorie:"lol")
		controller.params.dateCreation = new Date()
		controller.params.dateLimite = new Date() + 10
		//Decrease version of edited object to enforce optimistic locking validation
		controller.params.version = (currentVersionInDB -1)
		controller.params.id = defiInstance.id
	
		when:
		controller.update()
	
		then:
		renderArgs.view == "edit"
		renderArgs.model.defiInstance == defiInstance
		renderArgs.model.defiInstance.hasErrors()
		
		where:
		currentVersionInDB = 2
		defiInstance = new Defi(intitule:"toto", description:"titi", categorie: new Categorie(idCategorie:"trop lol", nomCategorie:"lol") , dateCreation:new Date(), dateLimite:new Date(), version: currentVersionInDB)
	}
	
}
