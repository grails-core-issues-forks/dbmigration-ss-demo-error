package es.virtualsw.webintegral

import grails.gorm.DetachedCriteria
import groovy.transform.ToString

import org.codehaus.groovy.util.HashCodeHelper
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@ToString(cache=true, includeNames=true, includePackage=false)
class UsersRoles implements Serializable {

	private static final long serialVersionUID = 1

	Users users
	Roles roles

	@Override
	boolean equals(other) {
		if (other instanceof UsersRoles) {
			other.usersId == users?.id && other.rolesId == roles?.id
		}
	}

    @Override
	int hashCode() {
	    int hashCode = HashCodeHelper.initHash()
        if (users) {
            hashCode = HashCodeHelper.updateHash(hashCode, users.id)
		}
		if (roles) {
		    hashCode = HashCodeHelper.updateHash(hashCode, roles.id)
		}
		hashCode
	}

	static UsersRoles get(long usersId, long rolesId) {
		criteriaFor(usersId, rolesId).get()
	}

	static boolean exists(long usersId, long rolesId) {
		criteriaFor(usersId, rolesId).count()
	}

	private static DetachedCriteria criteriaFor(long usersId, long rolesId) {
		UsersRoles.where {
			users == Users.load(usersId) &&
			roles == Roles.load(rolesId)
		}
	}

	static UsersRoles create(Users users, Roles roles, boolean flush = false) {
		def instance = new UsersRoles(users: users, roles: roles)
		instance.save(flush: flush)
		instance
	}

	static boolean remove(Users u, Roles r) {
		if (u != null && r != null) {
			UsersRoles.where { users == u && roles == r }.deleteAll()
		}
	}

	static int removeAll(Users u) {
		u == null ? 0 : UsersRoles.where { users == u }.deleteAll() as int
	}

	static int removeAll(Roles r) {
		r == null ? 0 : UsersRoles.where { roles == r }.deleteAll() as int
	}

	static constraints = {
		roles validator: { Roles r, UsersRoles ur ->
			if (ur.users?.id) {
				UsersRoles.withNewSession {
					if (UsersRoles.exists(ur.users.id, r.id)) {
						return ['userRole.exists']
					}
				}
			}
		}
	}

	static mapping = {
		id composite: ['users', 'roles']
		version false
	}
}
