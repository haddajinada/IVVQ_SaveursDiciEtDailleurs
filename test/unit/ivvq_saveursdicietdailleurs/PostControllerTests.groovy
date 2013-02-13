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

import grails.test.mixin.*

@TestFor(PostController)
@Mock(Post)
class PostControllerTests {
	def populateValidParams(params) {
		assert params != null

		params["intitule"] = "post"
		params["message"] = "trop cool ce post"
		params["auteurPost"] = "Bah moi"
		params["commentaires"] = ["com1", "com2"]
	}

	void testIndex() {
		controller.index()
		assert "/post/list" == response.redirectedUrl
	}

	void testList() {
		def model = controller.list()

		assert model.postInstanceList.size() == 0
		assert model.postInstanceTotal == 0
	}

	void testCreate() {
		def model = controller.create()

		assert model.postInstance != null
	}
/*
	void testSave() {
		controller.save()

		assert model.postInstance != null
		assert view == '/post/create'

		response.reset()

		populateValidParams(params)
		controller.save()

		assert response.redirectedUrl == '/post/show/1'
		assert controller.flash.message != null
		assert Post.count() == 1
	}

	void testShow() {
		controller.show()

		assert flash.message != null
		assert response.redirectedUrl == '/post/list'

		populateValidParams(params)
		def post = new Post(params)

		assert post.save() != null

		params.id = post.id

		def model = controller.show()

		assert model.postInstance == post
	}

	void testEdit() {
		controller.edit()

		assert flash.message != null
		assert response.redirectedUrl == '/post/list'

		populateValidParams(params)
		def post = new Post(params)

		assert post.save() != null

		params.id = post.id

		def model = controller.edit()

		assert model.postInstance == post
	}

	void testUpdate() {
		controller.update()

		assert flash.message != null
		assert response.redirectedUrl == '/post/list'

		response.reset()

		populateValidParams(params)
		def post = new Post(params)

		assert post.save() != null

		// test invalid parameters in update
		params.id = post.id
		//invalid values to params object
		params.intitule = ""

		controller.update()

		assert view == "/post/edit"
		assert model.postInstance != null

		post.clearErrors()

		populateValidParams(params)
		controller.update()

		assert response.redirectedUrl == "/post/show/$post.id"
		assert flash.message != null

		//test outdated version number
		response.reset()
		post.clearErrors()

		populateValidParams(params)
		params.id = post.id
		params.version = -1
		controller.update()

		assert view == "/post/edit"
		assert model.postInstance != null
		assert model.postInstance.errors.getFieldError('version')
		assert flash.message != null
	}

	void testDelete() {
		controller.delete()
		assert flash.message != null
		assert response.redirectedUrl == '/post/list'

		response.reset()

		populateValidParams(params)
		def post = new Post(params)

		assert post.save() != null
		assert Post.count() == 1

		params.id = post.id

		controller.delete()

		assert Post.count() == 0
		assert Post.get(post.id) == null
		assert response.redirectedUrl == '/post/list'
	}*/
}
