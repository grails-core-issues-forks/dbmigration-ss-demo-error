import es.virtualsw.webintegral.UserPasswordEncoderListener
beans = {
    userPasswordEncoderListener(UserPasswordEncoderListener, ref('hibernateDatastore'))
}
