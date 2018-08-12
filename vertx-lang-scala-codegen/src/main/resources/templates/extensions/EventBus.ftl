  import io.vertx.core.eventbus.MessageCodec
  
  /**
   * Register a message codec.
   * <p>
   * You can register a message codec if you want to send any non standard message across the event bus.
   * E.g. you might want to send POJOs directly across the event bus.
   * <p>
   * To use a message codec for a send, you should specify it in the delivery options.
   *
   * @param codec  the message codec to register
   * @return a reference to this, so the API can be used fluently
   */
  def registerCodec(codec: MessageCodec[_,_]): EventBus  = {
    asJava.asInstanceOf[JEventBus].registerCodec(codec)
    this
  }

  /**
   * Register a default message codec.
   * <p>
   * You can register a message codec if you want to send any non standard message across the event bus.
   * E.g. you might want to send POJOs directly across the event bus.
   * <p>
   * Default message codecs will be used to serialise any messages of the specified type on the event bus without
   * the codec having to be specified in the delivery options.
   *
   * @param clazz  the class for which to use this codec
   * @param codec  the message codec to register
   * @return a reference to this, so the API can be used fluently
   */
  def registerDefaultCodec[T](clazz:Class[T] , codec: MessageCodec[T, _]): EventBus  = {
    asJava.asInstanceOf[JEventBus].registerDefaultCodec(clazz, codec)
    this
  }

  /**
   * Unregister a default message codec.
   * <p>
   * @param clazz  the class for which the codec was registered
   * @return a reference to this, so the API can be used fluently
   */
  def unregisterDefaultCodec(clazz: Class[_]): EventBus  = {
    asJava.asInstanceOf[JEventBus].unregisterDefaultCodec(clazz)
    this
  }

  /**
   * Add an interceptor that will be called whenever a message is sent from Vert.x
   *
   * @param interceptor  the interceptor
   * @return a reference to this, so the API can be used fluently
   */
  def addInterceptor(interceptor: Handler[JSendContext[_]]): EventBus = {
    asJava.asInstanceOf[JEventBus].addInterceptor(interceptor)
    this
  }

  /**
   * Remove an interceptor
   *
   * @param interceptor  the interceptor
   * @return a reference to this, so the API can be used fluently
   */
  def removeInterceptor(interceptor: Handler[JSendContext[_]]): EventBus = {
    asJava.asInstanceOf[JEventBus].removeInterceptor(interceptor)
    this
  }

