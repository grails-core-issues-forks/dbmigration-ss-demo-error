import es.virtualsw.webintegral.UsersPasswordEncoderListener
// Place your Spring DSL code here
beans = {
    usersPasswordEncoderListener(UsersPasswordEncoderListener, ref('hibernateDatastore'))
}
