# dbmigration-ss-demo-error
Demo repo for error reporting to OCI when using SpringSecurity Core 3.1.2 and Database migration 3.0.0

The error happens when you run:

./grailsw dbm-generate-gorm-changelog changelog.groovy

The command ./grailsw bootRun runs ok

The error is:


----
<pre>
***************************
APPLICATION FAILED TO START
***************************

Description:

The dependencies of some of the beans in the application context form a cycle:

   authenticationUserDetailsService
      ↓
   userDetailsService
┌─────┐
|  hibernateDatastore
↑     ↓
|  usersPasswordEncoderListener
└─────┘


Context failed to load: Error creating bean with name 'authenticationUserDetailsService': Cannot resolve reference to bean 'userDetailsService' while setting constructor argument; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'userDetailsService': Initialization of bean failed; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'hibernateDatastore': Bean instantiation via constructor failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.grails.orm.hibernate.HibernateDatastore]: Constructor threw exception; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'usersPasswordEncoderListener': Cannot resolve reference to bean 'hibernateDatastore' while setting constructor argument; nested exception is org.springframework.beans.factory.BeanCurrentlyInCreationException: Error creating bean with name 'hibernateDatastore': Requested bean is currently in creation: Is there an unresolvable circular reference?
:dbmGenerateGormChangelog FAILED

FAILURE: Build failed with an exception.
</pre>

----
