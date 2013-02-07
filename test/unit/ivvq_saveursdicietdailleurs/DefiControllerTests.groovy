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

@TestFor(DefiController)
@Mock(Defi)
class DefiControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/defi/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.defiInstanceList.size() == 0
        assert model.defiInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.defiInstance != null
    }

    void testSave() {
        controller.save()

        assert model.defiInstance != null
        assert view == '/defi/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/defi/show/1'
        assert controller.flash.message != null
        assert Defi.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/defi/list'

        populateValidParams(params)
        def defi = new Defi(params)

        assert defi.save() != null

        params.id = defi.id

        def model = controller.show()

        assert model.defiInstance == defi
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/defi/list'

        populateValidParams(params)
        def defi = new Defi(params)

        assert defi.save() != null

        params.id = defi.id

        def model = controller.edit()

        assert model.defiInstance == defi
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/defi/list'

        response.reset()

        populateValidParams(params)
        def defi = new Defi(params)

        assert defi.save() != null

        // test invalid parameters in update
        params.id = defi.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/defi/edit"
        assert model.defiInstance != null

        defi.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/defi/show/$defi.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        defi.clearErrors()

        populateValidParams(params)
        params.id = defi.id
        params.version = -1
        controller.update()

        assert view == "/defi/edit"
        assert model.defiInstance != null
        assert model.defiInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/defi/list'

        response.reset()

        populateValidParams(params)
        def defi = new Defi(params)

        assert defi.save() != null
        assert Defi.count() == 1

        params.id = defi.id

        controller.delete()

        assert Defi.count() == 0
        assert Defi.get(defi.id) == null
        assert response.redirectedUrl == '/defi/list'
    }
}
