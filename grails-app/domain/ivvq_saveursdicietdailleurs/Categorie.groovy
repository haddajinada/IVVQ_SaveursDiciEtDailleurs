package ivvq_saveursdicietdailleurs

class Categorie {
	String idCategorie
	String nomCategorie

    static constraints = {
		idCategorie blank : false, unique : true
		nomCategorie blank: false, unique: true
    }
}
