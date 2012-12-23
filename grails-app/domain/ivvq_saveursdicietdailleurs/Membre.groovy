package ivvq_saveursdicietdailleurs

class Membre {
	String idMembre
	String pseudo
	String mdp
	String prenom
	String nom
	String adresse_mail
	
	//static hasMany = [posts : Post] je mets en comm parce que pas encore crée post
	
    static constraints = {
		pseudo blank : false, unique : true
		mdp size : 6..12, blank : false
		adresse_mail email : true
    }
}
