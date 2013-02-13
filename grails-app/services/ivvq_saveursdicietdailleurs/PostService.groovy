package ivvq_saveursdicietdailleurs

class PostService {

    
	/**   * Create a post and persists him
		 * @param String intitule
		 * @param String message
		 * @param Membre auteurPost   **/
	Post createPost(String intitule, String message, Membre membre = null, Photo tof = null, Video video = null) {
		 Post pp = new Post(intitule: intitule, message: message, auteurPost: membre, tof: tof, video: video)   
		 pp.save()   
		 pp
	}
	
//	@Transactional(readOnly = true)
//	def listPosts() {
//		Post.list()
//	}
	
	void updateIntitulePost(id, String intitule) {
		def post = Post.get(id)
		post.intitule = intitule
		if (post.toString().equals(null)) {
			throw new Exception("modificaton failed", post)
		}
	}
}
