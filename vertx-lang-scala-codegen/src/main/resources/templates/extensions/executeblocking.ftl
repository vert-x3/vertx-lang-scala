  /**
   * Safely execute some blocking code.
   *
   * Executes the blocking code in the handler `blockingCodeHandler` using a thread from the worker pool.
   *
   * When the code is complete the returned Future will be completed with the result.
   *
   * @param blockingFunction function containing blocking code
   * @param ordered if true then if executeBlocking is called several times on the same context, the executions for that context will be executed serially, not in parallel. if false then they will be no ordering guarantees
   * @return a Future representing the result of the blocking operation
   */
  def executeBlocking[T](blockingFunction: () => T, ordered: Boolean = true): concurrent.Future[T] = {
    val promise = concurrent.Promise[T]
    val h: Handler[io.vertx.core.Promise[T]] = {f => util.Try(blockingFunction()) match {
      case util.Success(s) => f.complete(s)
      case util.Failure(t) => f.fail(t)
    }}
    asJava.asInstanceOf[J${className}].executeBlocking[T](h, ordered, {h:AsyncResult[T] => {if (h.succeeded()) promise.success(h.result()) else promise.failure(h.cause());()} })
    promise.future
  }

