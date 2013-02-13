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
package ivvq_saveursdicietdailleurs

import org.junit.*
import grails.test.mixin.*

@TestFor(MembreController)
@Mock(Membre)
class MembreControllerTests {

    def populateValidParams(params) {
        assert params != null
        // Populate valid properties like...
        params["pseudo"] = "Pseudo du membre"
		params["mdp"] = "Mot de passe"
		params["prenom"] = "prenom membre"
		params["nom"] = "nom du membre"
		params["adresse_mail"] = "mail@gmail.com"
		params["role"] = "Membre"
		params["posts"] = new Post(intitule:"Intitule du post", message:"Message post")
    }

    void testIndex() {
        controller.index()
        assert "/membre/login" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.membreInstanceList.size() == 0
        assert model.membreInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.membreInstance != null
	}
	
	void testSave() {
		params.flush = true
		
        controller.save()

        assert model.membreInstance != null
        assert view == '/membre/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/membre/show/1'
        assert controller.flash.message != null
        assert Membre.count() == 1
    }

    void testShow() {		
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/membre/list'

        populateValidParams(params)
        def membre = new Membre(params)

        assert membre.save() != null

        params.id = membre.id

        def model = controller.show()

        assert model.membreInstance == membre
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/membre/list'

        populateValidParams(params)
        def membre = new Membre(params)

        assert membre.save() != null

        params.id = membre.id

        def model = controller.edit()

        assert model.membreInstance == membre
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/membre/list'

        response.reset()

        populateValidParams(params)
        def membre = new Membre(params)

        assert membre.save() != null

        // test invalid parameters in update
        params.id = membre.id
        //add invalid values to params object
		params["pseudo"] = ""

        controller.update()

        assert view == "/membre/edit"
        assert model.membreInstance != null

        membre.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/membre/show/$membre.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        membre.clearErrors()

        populateValidParams(params)
        params.id = membre.id
        params.version = -1
        controller.update()

        assert view == "/membre/edit"
        assert model.membreInstance != null
        assert model.membreInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/membre/list'

        response.reset()

        populateValidParams(params)
        def membre = new Membre(params)

        assert membre.save() != null
        assert Membre.count() == 1

        params.id = membre.id

        controller.delete()

        assert Membre.count() == 0
        assert Membre.get(membre.id) == null
        assert response.redirectedUrl == '/membre/list'
    }
}
