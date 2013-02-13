package ivvq_saveursdicietdailleurs

import org.springframework.transaction.annotation.Transactional

class CommentaireService {

	/**   * Create a commentaire and persists him   **/
	Commentaire createCommentaire(String corpsCommentaire) {
		Commentaire com = new Commentaire(corpsCommentaire: corpsCommentaire)   
		 com.save()   
		 com
	}
	
//	@Transactional(readOnly = true)
//	def listCommentaires() {
//		Commentaire.list()
//	}
	
	void updateCorpsCommentaire(id, String com) {
		def comm = Commentaire.get(id)
		comm.corpsCommentaire = com
		if (!comm.toString().equals(comm)) {
			throw new Exception("modificaton failed", comm)
		}
	}
}