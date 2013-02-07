package ivvq_saveursdicietdailleurs

import org.springframework.dao.DataIntegrityViolationException

class DefiController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
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
