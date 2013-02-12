package ivvq_saveursdicietdailleurs

import grails.plugin.spock.IntegrationSpec

class CommentaireServiceSpec extends IntegrationSpec {

	def comService  
	def "commentaire creation"() {
		expect:    
		CommentaireService.createCommentaire(corps, post).hasErrors() == creationFailed    
		
		where:    corps     | post   | creationFailed    
		          null      | null   |  true    
				  "bill"    | null   |  false
	}
	
	def "commentaire modification"() {
		expect:
		CommentaireService.updateCorpsCommentaire(1, corps)
		
		where:    corps = "com1"
	}
}