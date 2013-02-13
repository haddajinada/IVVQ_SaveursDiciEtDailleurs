package ivvq_saveursdicietdailleurs

import spock.lang.Specification;
import static grails.test.MockUtils.*
import grails.test.mixin.TestFor



class CategorieControllerSpec extends Specification {
	def mockI18N = { controller ->
		controller.metaClass.message = { Map map ->
			return "I18N message ($map)"
		}
	}
	
		
	def "index action"() {
		setup:
		mockLogging(CategorieController, true)
		
		when:
		controller.index()
		
		then:
		response.redirectedUrl == "/categorie/list"
	}
	
//	def "list action: 1 categorie"() {
//		setup:
//		mockLogging(CategorieController, true)
//		mockDomain(Categorie, [categorieInstance])
//	
//		expect:
//		controller.list() == [categorieInstanceList: [categorieInstance], categorieInstanceTotal: 1]
//	
//		where:
//		categorieInstance = new Categorie(nomCategorie: "nomCategorie")
//	  }
	
	def "create action"() {
		setup:
		mockLogging(CategorieController, true)
		mockDomain(Categorie)
		controller.params.nomCategorie = nomCategorie
		
		
		when:
		def model = controller.create()
		
		then:
		model.categorieInstance != null
		model.categorieInstance.nomCategorie == nomCategorie
		
		
		where:
		nomCategorie = "nomCategorie"

	}
	
	def "show action: existing categorie"() {
		setup:
		mockLogging(CategorieController, true)
		mockDomain(Categorie, [categorieInstance])
		mockI18N(CategorieController)
		controller.params.id = categorieInstance.id
		
		expect:
		controller.show() == [categorieInstance: categorieInstance]
		
		where:
		categorieInstance = new Categorie(nomCategorie:"nomCategorie")
	}
	
	def "edit action: existing categorie"() {
		setup:
		mockLogging(CategorieController, true)
		mockDomain(Categorie, [categorieInstance])
		mockI18N(CategorieController)
		controller.params.id = categorieInstance.id
		
		expect:
		controller.edit() == [categorieInstance: categorieInstance]
		
		where:
		categorieInstance = new Categorie(nomCategorie:"nomCategorie")
	}
	
}
