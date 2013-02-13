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

@TestFor(PhotoController)
@Mock(Photo)
class PhotoControllerTests {
	def populateValidParams(params) {
		assert params != null

		params["recette"] = "photo"
		params["image"] = new Byte[3]
	}

	void testIndex() {
		controller.index()
		assert "/photo/list" == response.redirectedUrl
	}

	void testList() {
		def model = controller.list()

		assert model.photoInstanceList.size() == 0
		assert model.photoInstanceTotal == 0
	}

	void testCreate() {
		def model = controller.create()

		assert model.photoInstance != null
	}

	void testSave() {
	/*	controller.save()

		assert model.photoInstance != null
		assert view == '/photo/create'

		response.reset()

		populateValidParams(params)
		controller.save()

		assert response.redirectedUrl == '/photo/show/1'
		assert controller.flash.message != null
		assert Photo.count() == 1*/
	}

	void testShow() {
		/*controller.show()

		assert flash.message != null
		assert response.redirectedUrl == '/photo/list'

		populateValidParams(params)
		def photo = new Photo(params)

		assert photo.save() != null

		params.id = photo.id

		def model = controller.show()

		assert model.photoInstance == photo*/
	}

	void testEdit() {
		/*controller.edit()

		assert flash.message != null
		assert response.redirectedUrl == '/photo/list'

		populateValidParams(params)
		def photo = new Photo(params)

		assert photo.save() != null

		params.id = photo.id

		def model = controller.edit()

		assert model.photoInstance == photo*/
	}

	void testUpdate() {
		/*controller.update()

		assert flash.message != null
		assert response.redirectedUrl == '/photo/list'

		response.reset()

		populateValidParams(params)
		def photo = new Photo(params)

		assert photo.save() != null

		// test invalid parameters in update
		params.id = photo.id
		//invalid values to params object
		params.recette = 2

		controller.update()

		assert view == "/photo/edit"
		assert model.photoInstance != null

		photo.clearErrors()

		populateValidParams(params)
		controller.update()

		assert response.redirectedUrl == "/photo/show/$photo.id"
		assert flash.message != null

		//test outdated version number
		response.reset()
		photo.clearErrors()

		populateValidParams(params)
		params.id = photo.id
		params.version = -1
		controller.update()

		assert view == "/photo/edit"
		assert model.photoInstance != null
		assert model.photoInstance.errors.getFieldError('version')
		assert flash.message != null*/
	}

	void testDelete() {
		/*controller.delete()
		assert flash.message != null
		assert response.redirectedUrl == '/photo/list'

		response.reset()

		populateValidParams(params)
		def photo = new Photo(params)

		assert photo.save() != null
		assert Photo.count() == 1

		params.id = photo.id

		controller.delete()

		assert Photo.count() == 0
		assert Photo.get(photo.id) == null
		assert response.redirectedUrl == '/photo/list'*/
	}
}
