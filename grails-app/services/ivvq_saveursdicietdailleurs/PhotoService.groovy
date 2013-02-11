package ivvq_saveursdicietdailleurs

class PhotoService {

  def photoService  

	def "photo creation"() {
		expect:    
		PostService.createPost(rec, image).hasErrors() == creationFailed    
		
		where:    rec     | image             | creationFailed    
		          null    | null              | true
				  "bill"  | new byte[109900]  | false
				  null    | new byte[109900]  | false
	}
	
	def "photo modification"() {
		expect:
		PostService.updateRecettePhoto(1, recette)
		
		where:    recette = "rrrrrrrr"
	}
}
