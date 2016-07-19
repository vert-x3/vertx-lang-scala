package io.vertx.lang.scala;

import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.core.spi.logging.LogDelegate;

/**
 * A logging delegate to allow {@link Logger} to be used in Scala. The Scala-Compiler can't distinguish between
 * method(Object) and method(Object,Object..). This delegate makes the leading type more specific.
 */
public class ScalaLogger{
    private final Logger log;

    public static ScalaLogger getLogger(String name) {
        return new ScalaLogger(LoggerFactory.getLogger(name));
    }

    public ScalaLogger(Logger log) {
        this.log = log;
    }

    public boolean isInfoEnabled() {
        return log.isInfoEnabled();
    }

    public boolean isDebugEnabled() {
        return log.isDebugEnabled();
    }

    public boolean isTraceEnabled() {
        return log.isTraceEnabled();
    }

    public void fatal(String message) {
        log.fatal(message);
    }

    public void fatal(String message, Throwable t) {
        log.fatal(message, t);
    }

    public void error(String message) {
        log.error(message);
    }

    public void error(String message, Throwable t) {
        log.error(message, t);
    }

    public void error(String message, Object... objects) {
        log.error(message, objects);
    }

    public void error(String message, Throwable t, Object... objects) {
        log.error(message, t, objects);
    }

    public void warn(String message) {
        log.warn(message);
    }

    public void warn(String message, Throwable t) {
        log.warn(message, t);
    }

    public void warn(String message, Object... objects) {
        log.warn(message, objects);
    }

    public void warn(String message, Throwable t, Object... objects) {
        log.warn(message, t, objects);
    }

    public void info(String message) {
        log.info(message);
    }

    public void info(String message, Throwable t) {
        log.info(message, t);
    }

    public void info(String message, Object... objects) {
        log.info(message, objects);
    }

    public void info(String message, Throwable t, Object... objects) {
        log.info(message, t, objects);
    }

    public void debug(String message) {
        log.debug(message);
    }

    public void debug(String message, Throwable t) {
        log.debug(message, t);
    }

    public void debug(String message, Object... objects) {
        log.debug(message, objects);
    }

    public void debug(String message, Throwable t, Object... objects) {
        log.debug(message, t, objects);
    }

    public void trace(String message) {
        log.trace(message);
    }

    public void trace(String message, Throwable t) {
        log.trace(message, t);
    }

    public void trace(String message, Object... objects) {
        log.trace(message, objects);
    }

    public void trace(String message, Throwable t, Object... objects) {
        log.trace(message, t, objects);
    }
    /**
     * @return the delegate instance sending operations to the underlying logging framework
     */

    public LogDelegate getDelegate() {
        return log.getDelegate();
    }
}
