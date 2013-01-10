package ivvq_saveursdicietdailleurs

import org.springframework.dao.DataIntegrityViolationException

class VisiteurController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [visiteurInstanceList: Visiteur.list(params), visiteurInstanceTotal: Visiteur.count()]
    }

    def create() {
        [visiteurInstance: new Visiteur(params)]
    }

    def save() {
        def visiteurInstance = new Visiteur(params)
        if (!visiteurInstance.save(flush: true)) {
            render(view: "create", model: [visiteurInstance: visiteurInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'visiteur.label', default: 'Visiteur'), visiteurInstance.id])
        redirect(action: "show", id: visiteurInstance.id)
    }

    def show(Long id) {
        def visiteurInstance = Visiteur.get(id)
        if (!visiteurInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'visiteur.label', default: 'Visiteur'), id])
            redirect(action: "list")
            return
        }

        [visiteurInstance: visiteurInstance]
    }

    def edit(Long id) {
        def visiteurInstance = Visiteur.get(id)
        if (!visiteurInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'visiteur.label', default: 'Visiteur'), id])
            redirect(action: "list")
            return
        }

        [visiteurInstance: visiteurInstance]
    }

    def update(Long id, Long version) {
        def visiteurInstance = Visiteur.get(id)
        if (!visiteurInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'visiteur.label', default: 'Visiteur'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (visiteurInstance.version > version) {
                visiteurInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'visiteur.label', default: 'Visiteur')] as Object[],
                          "Another user has updated this Visiteur while you were editing")
                render(view: "edit", model: [visiteurInstance: visiteurInstance])
                return
            }
        }

        visiteurInstance.properties = params

        if (!visiteurInstance.save(flush: true)) {
            render(view: "edit", model: [visiteurInstance: visiteurInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'visiteur.label', default: 'Visiteur'), visiteurInstance.id])
        redirect(action: "show", id: visiteurInstance.id)
    }

    def delete(Long id) {
        def visiteurInstance = Visiteur.get(id)
        if (!visiteurInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'visiteur.label', default: 'Visiteur'), id])
            redirect(action: "list")
            return
        }

        try {
            visiteurInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'visiteur.label', default: 'Visiteur'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'visiteur.label', default: 'Visiteur'), id])
            redirect(action: "show", id: id)
        }
    }
}
