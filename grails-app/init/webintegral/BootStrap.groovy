package webintegral

class BootStrap {

    def springSecurityService

    def init = { servletContext ->
        if (!User.count) {
            def rol = new Role(authority: 'ADMIN').save()

            def user = new User(username: 'virtual', password: '1qazxc').save()

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
