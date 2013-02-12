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

class CategorieController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [categorieInstanceList: Categorie.list(params), categorieInstanceTotal: Categorie.count()]
    }

    def create() {
        [categorieInstance: new Categorie(params)]
    }

    def save() {
        def categorieInstance = new Categorie(params)
        if (!categorieInstance.save(flush: true)) {
            render(view: "create", model: [categorieInstance: categorieInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'categorie.label', default: 'Categorie'), categorieInstance.id])
        redirect(action: "show", id: categorieInstance.id)
    }

    def show(Long id) {
        def categorieInstance = Categorie.get(id)
        if (!categorieInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'categorie.label', default: 'Categorie'), id])
            redirect(action: "list")
            return
        }

        [categorieInstance: categorieInstance]
    }

    def edit(Long id) {
        def categorieInstance = Categorie.get(id)
        if (!categorieInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'categorie.label', default: 'Categorie'), id])
            redirect(action: "list")
            return
        }

        [categorieInstance: categorieInstance]
    }

    def update(Long id, Long version) {
        def categorieInstance = Categorie.get(id)
        if (!categorieInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'categorie.label', default: 'Categorie'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (categorieInstance.version > version) {
                categorieInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'categorie.label', default: 'Categorie')] as Object[],
                          "Another user has updated this Categorie while you were editing")
                render(view: "edit", model: [categorieInstance: categorieInstance])
                return
            }
        }

        categorieInstance.properties = params

        if (!categorieInstance.save(flush: true)) {
            render(view: "edit", model: [categorieInstance: categorieInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'categorie.label', default: 'Categorie'), categorieInstance.id])
        redirect(action: "show", id: categorieInstance.id)
    }

    def delete(Long id) {
        def categorieInstance = Categorie.get(id)
        if (!categorieInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'categorie.label', default: 'Categorie'), id])
            redirect(action: "list")
            return
        }

        try {
            categorieInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'categorie.label', default: 'Categorie'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'categorie.label', default: 'Categorie'), id])
            redirect(action: "show", id: id)
        }
    }
	
	def showRecettes = {
//		def user = Membre.findByPseudoAndMdp(params.pseudo, params.mdp)
//		if(!user) {
//			redirect(action: "login")
//		}
//		else {
//			redirect(action: "showRecettes")
//		}
	}
	
	def showDefis = {}
	
}
