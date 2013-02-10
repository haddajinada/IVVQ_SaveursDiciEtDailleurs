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

@TestFor(VideoController)
@Mock(Video)
class VideoControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      params["titreRecette"] = "recette de nada"
	  params["keyVideoYoutube"] = "xnT2HR0RQnA"
	  params["recette"] = "une bonne recette"
    }

    void testIndex() {
        controller.index()
        assert "/video/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.videoInstanceList.size() == 0
        assert model.videoInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.videoInstance != null
    }

    void testSave() {
        controller.save()

        assert model.videoInstance != null
        assert view == '/video/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/video/show/1'
        assert controller.flash.message != null
        assert Video.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/video/list'


        populateValidParams(params)
        def video = new Video(params)

        assert video.save() != null

        params.id = video.id

        def model = controller.show()

        assert model.videoInstance == video
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/video/list'


        populateValidParams(params)
        def video = new Video(params)

        assert video.save() != null

        params.id = video.id

        def model = controller.edit()

        assert model.videoInstance == video
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/video/list'

        response.reset()


        populateValidParams(params)
        def video = new Video(params)

        assert video.save() != null

        // test invalid parameters in update
        params.id = video.id
        //TODO: add invalid values to params object
		params.titreRecette = ""
		
        controller.update()

        assert view == "/video/edit"
        assert model.videoInstance != null

        video.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/video/show/$video.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        video.clearErrors()

        populateValidParams(params)
        params.id = video.id
        params.version = -1
        controller.update()

        assert view == "/video/edit"
        assert model.videoInstance != null
        assert model.videoInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/video/list'

        response.reset()

        populateValidParams(params)
        def video = new Video(params)

        assert video.save() != null
        assert Video.count() == 1

        params.id = video.id

        controller.delete()

        assert Video.count() == 0
        assert Video.get(video.id) == null
        assert response.redirectedUrl == '/video/list'
    }
}
