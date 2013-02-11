package ivvq_saveursdicietdailleurs

import org.springframework.transaction.annotation.Transactional

class CommentaireService {

	/**   * Create a user and persists him   
	 * * @param userName   
	 * * @param name   
	 * * @param firstName   
	 * * @return the user   */  
	Commentaire createCommentaire(String corpsCommentaire, Post post = null) {
		Commentaire com = new Commentaire(corpsCommentaire: corpsCommentaire, postCommentaire: post)   
		 com.save()   
		 com
	}
	
	@Transactional(readOnly = true)
	def listCommentaires() {
		Commentaire.list()
	}
	
	void updateCorpsCommentaire(id, String com) {
		def comm = Commentaire.get(id)
		comm.corpsCommentaire = com
		if (!comm.toString().equals(comm)) {
			throw new Exception("modificaton failed", comm)
		}
	}
}