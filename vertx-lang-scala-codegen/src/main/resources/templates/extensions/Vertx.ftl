  /**
    * Deploy a verticle instance that you have created yourself.
    * <p>
    * Vert.x will assign the verticle a context and start the verticle.
    * <p>
    * The actual deploy happens asynchronously and may not complete until after the call has returned.
    *
    * @param verticle the verticle instance to deploy.
    */
  def deployVerticle(verticle: ScalaVerticle): Unit = {
    asJava.asInstanceOf[JVertx].deployVerticle(verticle.asJava)
  }

  /**
    * Like [[deployVerticle]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
    */
  def deployVerticleFuture(verticle: ScalaVerticle): scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JVertx].deployVerticle(verticle.asJava(), promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Like {@link #deployVerticle(Verticle)} but {@link io.vertx.core.DeploymentOptions} are provided to configure the
    * deployment.
    *
    * @param verticle the verticle instance to deploy
    * @param options  the deployment options.
    */
  def deployVerticle(verticle: ScalaVerticle, options: DeploymentOptions): Unit = {
    asJava.asInstanceOf[JVertx].deployVerticle(verticle.asJava, options.asJava)
  }

  /**
    * Like [[deployVerticle]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
    */
  def deployVerticleFuture(verticle: ScalaVerticle, options: DeploymentOptions): scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JVertx].deployVerticle(verticle.asJava(), options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }
