package ivvq_saveursdicietdailleurs

import grails.plugin.spock.IntegrationSpec

class CategorieServiceSpec extends IntegrationSpec {

	def categorieService
	
	  def "categorie creation"() {
	
		expect:
		categorieService.createCategorie(nomCategorie).hasErrors() == creationFailed
	
		where:
		nomCategorie   | creationFailed
		"nomCategorie" |  false
		null           |  true
	
	
	  }
}