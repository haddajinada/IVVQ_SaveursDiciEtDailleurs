package ivvq_saveursdicietdailleurs



import org.junit.*
import grails.test.mixin.*

@TestFor(VisiteurController)
@Mock(Visiteur)
class VisiteurControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/visiteur/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.visiteurInstanceList.size() == 0
        assert model.visiteurInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.visiteurInstance != null
    }

    void testSave() {
        controller.save()

        assert model.visiteurInstance != null
        assert view == '/visiteur/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/visiteur/show/1'
        assert controller.flash.message != null
        assert Visiteur.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/visiteur/list'

        populateValidParams(params)
        def visiteur = new Visiteur(params)

        assert visiteur.save() != null

        params.id = visiteur.id

        def model = controller.show()

        assert model.visiteurInstance == visiteur
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/visiteur/list'

        populateValidParams(params)
        def visiteur = new Visiteur(params)

        assert visiteur.save() != null

        params.id = visiteur.id

        def model = controller.edit()

        assert model.visiteurInstance == visiteur
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/visiteur/list'

        response.reset()

        populateValidParams(params)
        def visiteur = new Visiteur(params)

        assert visiteur.save() != null

        // test invalid parameters in update
        params.id = visiteur.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/visiteur/edit"
        assert model.visiteurInstance != null

        visiteur.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/visiteur/show/$visiteur.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        visiteur.clearErrors()

        populateValidParams(params)
        params.id = visiteur.id
        params.version = -1
        controller.update()

        assert view == "/visiteur/edit"
        assert model.visiteurInstance != null
        assert model.visiteurInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/visiteur/list'

        response.reset()

        populateValidParams(params)
        def visiteur = new Visiteur(params)

        assert visiteur.save() != null
        assert Visiteur.count() == 1

        params.id = visiteur.id

        controller.delete()

        assert Visiteur.count() == 0
        assert Visiteur.get(visiteur.id) == null
        assert response.redirectedUrl == '/visiteur/list'
    }
}
