package ivvq_saveursdicietdailleurs

import grails.plugin.spock.IntegrationSpec

class CommentaireServiceSpec extends IntegrationSpec {

	def comService  
	def "commentaire creation"() {
		expect:    
		CommentaireService.createCommentaire(corps).hasErrors() == creationFailed    
		
		where:    
		corps     	    | creationFailed    
		""      	    |  true    
		"commentaire"   |  false
	}
	
//	def "commentaire modification"() {
//		expect:
//		CommentaireService.updateCorpsCommentaire(1, corps)
//		
//		where:    corps = "com1"
//	}
}