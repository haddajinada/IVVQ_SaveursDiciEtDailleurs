package ivvq_saveursdicietdailleurs

import grails.plugin.spock.IntegrationSpec

class PostServiceSpec extends IntegrationSpec {

	def postService  

	def "post creation"() {
		expect:    
		PostService.createPost(intitule, message, membre).hasErrors() == creationFailed    
		
		where:    intitule  | message   | membre  | creationFailed    
		          null      | null      | null    | true
				  "bill"    | null      | null    | false
				  null      | "hjhj"    | null    | false
	}
	
	def "post modification"() {
		expect:
		PostService.updateIntitulePost(1, intitule)
		
		where:    intitule = "jkjjkjk"
	}
}