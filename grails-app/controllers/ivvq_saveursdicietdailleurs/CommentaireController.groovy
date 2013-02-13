package ivvq_saveursdicietdailleurs

import org.springframework.dao.DataIntegrityViolationException

class CommentaireController {

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
