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

@TestFor(CategorieController)
@Mock(Categorie)
class CategorieControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        params["nomCategorie"] = 'nomCategorie'
    }

    void testIndex() {
        controller.index()
        assert "/categorie/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.categorieInstanceList.size() == 0
        assert model.categorieInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.categorieInstance != null
    }

    void testSave() {
        controller.save()

        assert model.categorieInstance != null
        assert view == '/categorie/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/categorie/show/1'
        assert controller.flash.message != null
        assert Categorie.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/categorie/list'

        populateValidParams(params)
        def categorie = new Categorie(params)

        assert categorie.save() != null

        params.id = categorie.id

        def model = controller.show()

        assert model.categorieInstance == categorie
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/categorie/list'

        populateValidParams(params)
        def categorie = new Categorie(params)

        assert categorie.save() != null

        params.id = categorie.id

        def model = controller.edit()

        assert model.categorieInstance == categorie
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/categorie/list'

        response.reset()

        populateValidParams(params)
        def categorie = new Categorie(params)

        assert categorie.save() != null

        // test invalid parameters in update
        params.id = categorie.id
        //TODO: add invalid values to params object
		params["nomCategorie"] = ''
		
        controller.update()

        assert view == "/categorie/edit"
        assert model.categorieInstance != null

        categorie.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/categorie/show/$categorie.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        categorie.clearErrors()

        populateValidParams(params)
        params.id = categorie.id
        params.version = -1
        controller.update()

        assert view == "/categorie/edit"
        assert model.categorieInstance != null
        assert model.categorieInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/categorie/list'

        response.reset()

        populateValidParams(params)
        def categorie = new Categorie(params)

        assert categorie.save() != null
        assert Categorie.count() == 1

        params.id = categorie.id

        controller.delete()

        assert Categorie.count() == 0
        assert Categorie.get(categorie.id) == null
        assert response.redirectedUrl == '/categorie/list'
    }
}
