package webintegral

class BootStrap {

    def springSecurityService

    def init = { servletContext ->
        if (!Users.count) {
            def rol = new Roles(authority: 'ADMIN').save()

            def user = new Users(username: 'virtual', password: '1qazxc').save()

            UserRole.create user, rol

            UserRole.withSession {
                it.flush()
                it.clear()
            }
        }
    }
    def destroy = {
    }
}
