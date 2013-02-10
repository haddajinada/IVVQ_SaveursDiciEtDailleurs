/*******************************************************************************
 * Saveurs d’ici et d’ailleurs allows foodies to share recipes and cooking tips from around the globe.
 * Copyright (C) 2012 Anna CEJALVO - Nada HADDAJI KFITA - Ahou Melaine KOFFI - Marième TOURE
 * 
 * Saveurs d’ici et d’ailleurs is free software: you can redistribute it and/or modify it under the terms of the GNU Affero General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * 
 * Saveurs d’ici et d’ailleurs is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License along with this program. If not, see ww.gnu.org/licenses/agpl-3.0.html.
 ******************************************************************************/
import ivvq_saveursdicietdailleurs.Commentaire
import ivvq_saveursdicietdailleurs.Membre
import ivvq_saveursdicietdailleurs.Photo
import ivvq_saveursdicietdailleurs.Post

class BootStrap {

 	def init = { servletContext ->

//		Membre membre1 = new Membre(idMembre : "1", pseudo : "toto", mdp : "123456", prenom : "nado", nom : "nom1", adresse_mail : "nsdkjb@ds.fr")
//		Membre membre2 = new Membre(idMembre : "2", pseudo : "tata", mdp : "123456", prenom : "nada", nom : "nom2", adresse_mail : "nsdkjb@ds.fr")
//		Membre membre3 = new Membre(idMembre : "3", pseudo : "titi", mdp : "123456", prenom : "nadi", nom : "nom3", adresse_mail : "nsdkjb@ds.fr")
//		if (!membre1.save()){
//			membre1.errors.allErrors.each{error -> println error}
//		}
//		if (!membre2.save()){
//			membre2.errors.allErrors.each{error -> println error}
//		}
//		if (!membre3.save()){
//			membre3.errors.allErrors.each{error -> println error}
//		}
//
//		Photo ph = new Photo(image : new File("C:\\Users\\nada\\Pictures\\remords.jpg").readBytes(), recette : "recette")
//		Photo ph1 = new Photo(image : new File("C:\\Users\\nada\\Pictures\\soso7.bmp").readBytes(), recette : "recette1")
//		Photo ph2 = new Photo(image : new File("C:\\Users\\nada\\Pictures\\basket.jpg").readBytes(), recette : "recette2")
//		Photo ph3 = new Photo(image : new File("C:\\Users\\nada\\Pictures\\foot.jpg").readBytes(), recette : "recette3")
//		if (!ph3.save()){
//			ph.errors.allErrors.each{error -> println error}
//		}
//		if (!ph2.save()){
//			ph.errors.allErrors.each{error -> println error}
//		}
//		if (!ph.save()){
//			ph.errors.allErrors.each{error -> println error}
//		}
//		if (!ph1.save()){
//			ph1.errors.allErrors.each{error -> println error}
//		}
//		
//
//		Post post1 = new Post(idPost : 1, intitule : "aaaaaaaaaaaaa", message : "jhkjsjgyugejrg", auteurPost : membre1)
//		Post post2 = new Post(idPost : 2, intitule : "bbbbbbbbbbbbb", message : "jhkjsjgyugejrg", auteurPost : membre1)
//		Post post3 = new Post(idPost : 3, intitule : "ccccccccccccc", message : "jhkjsjgyugejrg", auteurPost : membre2)
//		if (!post1.save()){
//			post1.errors.allErrors.each{error -> println error}
//		}
//		if (!post2.save()){
//			post2.errors.allErrors.each{error -> println error}
//		}
//		if (!post3.save()){
//			post3.errors.allErrors.each{error -> println error}
//		}
//
//
//		Commentaire com1 = new Commentaire(idCommentaire : 1, corpsCommentaire : "un commentaire 1", postCommentaire : post1)
//		Commentaire com2 = new Commentaire(idCommentaire : 2, corpsCommentaire : "un commentaire 2", postCommentaire : post1)
//		Commentaire com3 = new Commentaire(idCommentaire : 3, corpsCommentaire : "un commentaire 3", postCommentaire : post1)
//		if (!com1.save()){
//			com1.errors.allErrors.each{error -> println error}
//		}
//		if (!com2.save()){
//			com2.errors.allErrors.each{error -> println error}
//		}
//		if (!com3.save()){
//			com3.errors.allErrors.each{error -> println error}
//		}
//
//		post1
//				.addToCommentaires(com1)
//				.addToCommentaires(com2)
//				.save()
//		post2
//				.addToCommentaires(com2)
//				.addToCommentaires(com3)
//				.save()
//		post3
//				.addToCommentaires(com3)
//				.addToCommentaires(com1)
//				.save()
	}


	def destroy = {
	}
 }

