
    import io.vertx.lang.scala.ScalaVerticle

    /**
      * Deploy a verticle instance that you have created yourself.
      * <p>
      * Vert.x will assign the verticle a context and start the verticle.
      * <p>
      * The actual deploy happens asynchronously and may not complete until after the call has returned.
      *
      * @param  verticle the verticle instance to deploy.
      */
    def deployVerticle(verticle: ScalaVerticle): Unit = {
      asJava.deployVerticle(verticle.asJava())
    }

    /**
      * Like [[deployVerticle]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
      */
    def deployVerticleFuture(verticle: ScalaVerticle): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.deployVerticle(verticle.asJava(), {a:AsyncResult[String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
      * Like {@link #deployVerticle(Verticle)} but {@link io.vertx.core.DeploymentOptions} are provided to configure the
      * deployment.
      *
      * @param verticle the verticle instance to deploy
      * @param options  the deployment options.
      */
    def deployVerticle(verticle: ScalaVerticle, options: DeploymentOptions): Unit = {
      asJava.deployVerticle(verticle.asJava(), options)
    }

    /**
      * Like [[deployVerticle]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
      */
    def deployVerticleFuture(verticle: ScalaVerticle, options: DeploymentOptions): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.deployVerticle(verticle.asJava(),options , {a:AsyncResult[String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }
