package ivvq_saveursdicietdailleurs

class CategorieService {

  Categorie createCategorie(String nomCategorie) {
    Categorie categorie = new Categorie(nomCategorie: nomCategorie)
    categorie.save()
    categorie
  }
}
