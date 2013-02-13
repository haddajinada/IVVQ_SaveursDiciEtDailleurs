package ivvq_saveursdicietdailleurs

import grails.plugin.spock.IntegrationSpec

class PhotoServiceSpec extends IntegrationSpec {

	def photoService
	
		def "photo creation"() {
			expect:
			PhotoService.createPhoto(rec, image).hasErrors() == creationFailed
			
			where:    rec     | image              | creationFailed
					  "bill"  | new byte[109900]   | false
					  null    | new byte[1000000]  | false
		}
		
		def "photo modification"() {
			expect:
			PostService.updateRecettePhoto(1, recette)
			
			where:    recette = "rrrrrrrr"
		}
	
}