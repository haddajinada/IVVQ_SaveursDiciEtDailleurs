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

class DefiController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def beforeInterceptor = [action:this.&auth]
	
	def index() {
		redirect(action: "list", params: params)
	}
	
	def auth() {
		if(!session.user) {
			redirect(controller:"Membre", action:"login")
			return false
		}
	}
	
    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [defiInstanceList: Defi.list(params), defiInstanceTotal: Defi.count()]
    }

    def create() {
        [defiInstance: new Defi(params)]
    }

    def save() {
        def defiInstance = new Defi(params)
        if (!defiInstance.save(flush: true)) {
            render(view: "create", model: [defiInstance: defiInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'defi.label', default: 'Defi'), defiInstance.id])
        redirect(action: "show", id: defiInstance.id)
    }

    def show(Long id) {
        def defiInstance = Defi.get(id)
        if (!defiInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'defi.label', default: 'Defi'), id])
            redirect(action: "list")
            return
        }

        [defiInstance: defiInstance]
    }

    def edit(Long id) {
        def defiInstance = Defi.get(id)
        if (!defiInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'defi.label', default: 'Defi'), id])
            redirect(action: "list")
            return
        }

        [defiInstance: defiInstance]
    }

    def update(Long id, Long version) {
        def defiInstance = Defi.get(id)
        if (!defiInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'defi.label', default: 'Defi'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (defiInstance.version > version) {
                defiInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'defi.label', default: 'Defi')] as Object[],
                          "Another user has updated this Defi while you were editing")
                render(view: "edit", model: [defiInstance: defiInstance])
                return
            }
        }

        defiInstance.properties = params

        if (!defiInstance.save(flush: true)) {
            render(view: "edit", model: [defiInstance: defiInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'defi.label', default: 'Defi'), defiInstance.id])
        redirect(action: "show", id: defiInstance.id)
    }

    def delete(Long id) {
        def defiInstance = Defi.get(id)
        if (!defiInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'defi.label', default: 'Defi'), id])
            redirect(action: "list")
            return
        }

        try {
            defiInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'defi.label', default: 'Defi'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'defi.label', default: 'Defi'), id])
            redirect(action: "show", id: id)
        }
    }
}
