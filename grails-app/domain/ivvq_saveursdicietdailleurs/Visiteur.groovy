package ivvq_saveursdicietdailleurs

class Visiteur {

	String idVisiteur
	
    static constraints = {
		idVisiteur blank: false, unique: true
    }
}
