package webintegral

import webintegral.vistas.Cfgusu

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

        if (Cfgusu.count) {
            println("Hemos encontrado ${Cfgusu.count} registros en CfgUsu")
        } else {
            println("No hemos encontrado registros en CfgUsu")
        }
    }
    def destroy = {
    }
}
