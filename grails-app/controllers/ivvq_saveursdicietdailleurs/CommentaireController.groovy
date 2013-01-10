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

class CommentaireController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [commentaireInstanceList: Commentaire.list(params), commentaireInstanceTotal: Commentaire.count()]
    }

    def create() {
        [commentaireInstance: new Commentaire(params)]
    }

    def save() {
        def commentaireInstance = new Commentaire(params)
        if (!commentaireInstance.save(flush: true)) {
            render(view: "create", model: [commentaireInstance: commentaireInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'commentaire.label', default: 'Commentaire'), commentaireInstance.id])
        redirect(action: "show", id: commentaireInstance.id)
    }

    def show() {
        def commentaireInstance = Commentaire.get(params.id)
        if (!commentaireInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'commentaire.label', default: 'Commentaire'), params.id])
            redirect(action: "list")
            return
        }

        [commentaireInstance: commentaireInstance]
    }

    def edit() {
        def commentaireInstance = Commentaire.get(params.id)
        if (!commentaireInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'commentaire.label', default: 'Commentaire'), params.id])
            redirect(action: "list")
            return
        }

        [commentaireInstance: commentaireInstance]
    }

    def update() {
        def commentaireInstance = Commentaire.get(params.id)
        if (!commentaireInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'commentaire.label', default: 'Commentaire'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (commentaireInstance.version > version) {
                commentaireInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'commentaire.label', default: 'Commentaire')] as Object[],
                          "Another user has updated this Commentaire while you were editing")
                render(view: "edit", model: [commentaireInstance: commentaireInstance])
                return
            }
        }

        commentaireInstance.properties = params

        if (!commentaireInstance.save(flush: true)) {
            render(view: "edit", model: [commentaireInstance: commentaireInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'commentaire.label', default: 'Commentaire'), commentaireInstance.id])
        redirect(action: "show", id: commentaireInstance.id)
    }

    def delete() {
        def commentaireInstance = Commentaire.get(params.id)
        if (!commentaireInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'commentaire.label', default: 'Commentaire'), params.id])
            redirect(action: "list")
            return
        }

        try {
            commentaireInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'commentaire.label', default: 'Commentaire'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'commentaire.label', default: 'Commentaire'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
