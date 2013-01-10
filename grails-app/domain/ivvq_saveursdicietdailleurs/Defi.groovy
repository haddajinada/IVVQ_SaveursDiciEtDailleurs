package ivvq_saveursdicietdailleurs

class Defi {

	String intitule
	String description
	Date dateCreation
	Date dateLimite
	//Categorie categorie
	
	// relation one-to-many
	static hasMany = [posts:Post]

	static constraints = {
		intitule (blank:false)
		description (widget:'textarea', nullable:true, blank:false)
	}
}
