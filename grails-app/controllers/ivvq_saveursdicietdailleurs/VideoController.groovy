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

import org.springframework.dao.DataIntegrityViolationException

class VideoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [videoInstanceList: Video.list(params), videoInstanceTotal: Video.count()]
    }

    def create() {
        [videoInstance: new Video(params)]
    }

    def save() {
        def videoInstance = new Video(params)
        if (!videoInstance.save(flush: true)) {
            render(view: "create", model: [videoInstance: videoInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'video.label', default: 'Video'), videoInstance.id])
        redirect(action: "show", id: videoInstance.id)
    }

    def show() {
        def videoInstance = Video.get(params.id)
        if (!videoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'video.label', default: 'Video'), params.id])
            redirect(action: "list")
            return
        }

        [videoInstance: videoInstance]
    }

    def edit() {
        def videoInstance = Video.get(params.id)
        if (!videoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'video.label', default: 'Video'), params.id])
            redirect(action: "list")
            return
        }

        [videoInstance: videoInstance]
    }

    def update() {
        def videoInstance = Video.get(params.id)
        if (!videoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'video.label', default: 'Video'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (videoInstance.version > version) {
                videoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'video.label', default: 'Video')] as Object[],
                          "Another user has updated this Video while you were editing")
                render(view: "edit", model: [videoInstance: videoInstance])
                return
            }
        }

        videoInstance.properties = params

        if (!videoInstance.save(flush: true)) {
            render(view: "edit", model: [videoInstance: videoInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'video.label', default: 'Video'), videoInstance.id])
        redirect(action: "show", id: videoInstance.id)
    }

    def delete() {
        def videoInstance = Video.get(params.id)
        if (!videoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'video.label', default: 'Video'), params.id])
            redirect(action: "list")
            return
        }

        try {
            videoInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'video.label', default: 'Video'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'video.label', default: 'Video'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
