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

class MembreController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def index() {
		if (session.user != null) {
        	redirect(action: "show", params: params)
		}
		else {
			redirect(action: "login", params: params)
		}
    }
	
	def login = {}
	
	def authenticate = {
		def user = Membre.findByPseudoAndMdp(params.pseudo, params.mdp)
		if(user){
			session.user = user
			flash.message = "Hello ${user.nom}!"
			redirect(action:"login")
			
		}else{
		flash.message = "Sorry, ${params.nom}. Please try again."
		redirect(action:"login")
		}
	}
	
	def logout = {
		flash.message = "Goodbye ${session.user.nom}"
		session.user = null
		redirect(action:"login")
	}
	
	def inscription = {}

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [membreInstanceList: Membre.list(params), membreInstanceTotal: Membre.count()]
    }

    def create() {
        [membreInstance: new Membre(params)]
    }

    def save() {
        def membreInstance = new Membre(params)
        if (!membreInstance.save(flush: true)) {
            render(view: "create", model: [membreInstance: membreInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'membre.label', default: 'Membre'), membreInstance.id])
        redirect(action: "show", id: membreInstance.id)
    }

    def show(Long id) {
        def membreInstance = Membre.get(id)
        if (!membreInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'membre.label', default: 'Membre'), id])
            redirect(action: "list")
            return
        }

        [membreInstance: membreInstance]
    }

    def edit(Long id) {
        def membreInstance = Membre.get(id)
        if (!membreInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'membre.label', default: 'Membre'), id])
            redirect(action: "list")
            return
        }

        [membreInstance: membreInstance]
    }

    def update(Long id, Long version) {
        def membreInstance = Membre.get(id)
        if (!membreInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'membre.label', default: 'Membre'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (membreInstance.version > version) {
                membreInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'membre.label', default: 'Membre')] as Object[],
                          "Another user has updated this Membre while you were editing")
                render(view: "edit", model: [membreInstance: membreInstance])
                return
            }
        }

        membreInstance.properties = params

        if (!membreInstance.save(flush: true)) {
            render(view: "edit", model: [membreInstance: membreInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'membre.label', default: 'Membre'), membreInstance.id])
        redirect(action: "show", id: membreInstance.id)
    }

    def delete(Long id) {
        def membreInstance = Membre.get(id)
        if (!membreInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'membre.label', default: 'Membre'), id])
            redirect(action: "list")
            return
        }

        try {
            membreInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'membre.label', default: 'Membre'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'membre.label', default: 'Membre'), id])
            redirect(action: "show", id: id)
        }
    }
}
