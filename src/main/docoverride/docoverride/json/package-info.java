/*
 * Copyright 2014 Red Hat, Inc.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Apache License v2.0 which accompanies this distribution.
 *
 *  The Eclipse Public License is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  The Apache License v2.0 is available at
 *  http://www.opensource.org/licenses/apache2.0.php
 *
 *  You may elect to redistribute this code under either of these licenses.
 */

/**
 * == JSON
 *
 * To manipulate JSON object, Vert.x proposes its own implementation of {@link io.vertx.core.json.JsonObject} and
 * {@link io.vertx.core.json.JsonArray}. This is because, unlike some other languages, Java does not have first class
 * support for http://json.org/[JSON].
 *
 * When developping a vert.x application with Groovy, you can rely on these two classes, or use the
 * (http://www.groovy-lang.org/json.html)[JSON support from Groovy]. This section explains how to use the Vert.x
 * classes.
 *
 * NOTE: Most vert.x methods taking a JSON object as argument in their Java version, take a map instead.
 *
 *
 * === JSON objects
 *
 * The {@link io.vertx.core.json.JsonObject} class represents JSON objects.
 *
 * A JSON object is basically just a map which has string keys and values can be of one of the JSON supported types
 * (string, number, boolean).
 *
 * JSON objects also support `null` values.
 *
 * ==== Creating JSON objects
 *
 * Empty JSON objects can be created with the default constructor.
 *
 * You can create a JSON object from a string or g-string JSON representation as follows:
 *
 * [source,groovy]
 * ----
 * def object = new JsonObject("{\"foo\":\"bar\"}")
 * def object2 = new JsonObject("""
 * {
 *  "foo": "bar"
 * }
 * """)
 * ----
 *
 * In Groovy it's also convenient to create a JSON object from a map:
 *
 * [source, groovy]
 * ----
 * def map = [ "foo" : "bar" ]
 * def json = new JsonObject(map)
 * ----
 *
 * Nested maps are transformed to nested JSON objects.
 *
 * ==== Putting entries into a JSON object
 *
 * Use the {@link io.vertx.core.json.JsonObject#put} methods to put values into the JSON object.
 *
 * The method invocations can be chained because of the fluent API:
 *
 * [source,java]
 * ----
 * def object = new JsonObject()
 * object.put("foo", "bar").put("num", 123).put("mybool", true)
 * ----
 *
 * ==== Getting values from a JSON object
 *
 * You get values from a JSON object using the {@code getXXX} methods, for example:
 *
 * [source,java]
 * ----
 * dev val1 = jsonObject.getString("some-key")
 * def val2 = jsonObject.getInteger("some-other-key")
 * ----
 *
 * ==== Encoding the JSON object to a String
 *
 * You use {@link io.vertx.core.json.JsonObject#encode} to encode the object to a String form. There is also a
 * {@link io.vertx.core.json.JsonObject#encodePrettily()} that makes the output pretty (understand multi-line and
 * indented).
 *
 * === JSON arrays
 *
 * The {@link io.vertx.core.json.JsonArray} class represents JSON arrays.
 *
 * A JSON array is a sequence of values (string, number, boolean).
 *
 * JSON arrays can also contain `null` values.
 *
 * ==== Creating JSON arrays
 *
 * Empty JSON arrays can be created with the default constructor.
 *
 * You can create a JSON array from a string JSON representation or a map as follows:
 *
 * [source,groovy]
 * ----
 * def object = new JsonObject("""{foo:["bar", "baz"}""")
 * def object2 = new JsonObject(["foo": ["bar", "baz"]])
 * ----
 *
 * ==== Adding entries into a JSON array
 *
 * You add entries to a JSON array using the {@link io.vertx.core.json.JsonArray#add} methods.
 *
 * [source,groovy]
 * ----
 * def array = new JsonArray()
 * array.add("foo").add(123).add(false)
 * ----
 *
 * ==== Getting values from a JSON array
 *
 * You get values from a JSON array using the {@code getXXX} methods, for example:
 *
 * [source,groovy]
 * ----
 * def val = array.getString(0)
 * def intVal = array.getInteger(1)
 * def boolVal = array.getBoolean(2)
 * ----
 *
 * ==== Encoding the JSON array to a String
 *
 * You use {@link io.vertx.core.json.JsonArray#encode} to encode the array to a String form. There is also a
 * {@link io.vertx.core.json.JsonObject#encodePrettily()} that makes the output pretty (understand multi-line and
 * indented).
 *
 */
@Document(fileName = "override/json.adoc")
package docoverride.json;

import io.vertx.docgen.Document;
