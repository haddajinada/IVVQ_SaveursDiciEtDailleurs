package ivvq_saveursdicietdailleurs

import grails.plugin.spock.IntegrationSpec

class PostServiceSpec extends IntegrationSpec {

	def postService  

	def "post creation"() {
		expect:    
		PostService.createPost(intitule, message, membre, tof, video).hasErrors() == creationFailed    
		
		where:    intitule  | message   | membre  | tof     | video   | creationFailed    
		          ""        | "kh"      | null    | null    | null    | true
				  "bill"    | "jjj"     | null    | null    | null    | false
				  ""        | "hjhj"    | null    | null    | null    | false
	}
	
	def "post modification"() {
		expect:
		PostService.updateIntitulePost(1, intitule)
		
		where:    intitule = "jkjjkjk"
	}
}