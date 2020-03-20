  type Vertx = io.vertx.core.Vertx

  object Vertx {
    def vertx(options: VertxOptions = null): io.vertx.core.Vertx =
      if(options == null)
        io.vertx.core.Vertx.vertx()
      else
        io.vertx.core.Vertx.vertx(options)

    def clusteredVertx(options: VertxOptions): scala.concurrent.Future[io.vertx.core.Vertx] = {
      val promise = concurrent.Promise[io.vertx.core.Vertx]()
      io.vertx.core.Vertx.clusteredVertx(options).onComplete({a:AsyncResult[io.vertx.core.Vertx] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def currentContext(): scala.Option[io.vertx.core.Context] =
      scala.Option(io.vertx.core.Vertx.currentContext())
  }

