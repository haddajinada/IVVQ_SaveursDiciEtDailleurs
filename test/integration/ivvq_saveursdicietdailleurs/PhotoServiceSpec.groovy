package ivvq_saveursdicietdailleurs

import grails.plugin.spock.IntegrationSpec

class PhotoServiceSpec extends IntegrationSpec {

	/**   * Create a photo and persists him
	* @param String recette
	* @param byte[] image  **/
Photo createphoto(String recette, byte[] image = null) {
	photo photo = new Photo(recette: recette, image: image)
	photo.save()
	photo
}

//	@Transactional(readOnly = true)
//	def listPhotos() {
//		Photo.list()
//	}

void updateRecettePhoto(id, String recette) {
   def photo = Photo.get(id)
   photo.recette = recette
   if (photo.toString().equals(null)) {
	   throw new Exception("modificaton failed", photo)
   }
}
}