import es.virtualsw.webintegral.UserPasswordEncoderListener
beans = {
    // Until this issue is solved, you will need to comment out this bean definition to run any Grails command 
    // https://github.com/grails/grails-data-mapping/issues/946
    userPasswordEncoderListener(UserPasswordEncoderListener, ref('hibernateDatastore'))
}
