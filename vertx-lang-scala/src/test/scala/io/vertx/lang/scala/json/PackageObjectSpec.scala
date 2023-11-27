/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.vertx.lang.scala.json

import io.vertx.core.json.{JsonArray, JsonObject}
import io.vertx.lang.scala.json.*
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers


final class PackageObjectSpec extends AnyFlatSpec, Matchers:

  "asMap extension" should "return a Map representation of some JsonObject" in :
    val jsonObject = JsonObject.of("foo", "foo text", "optional", true)
    jsonObject.asMap("foo") should equal("foo text")
    jsonObject.asMap("optional") should equal(true)


  "asList extension" should "return a List representation of some JsonArray" in :
    val jsonArray = JsonArray.of(1, 2, 3)
    jsonArray.asList should contain inOrderOnly(1, 2, 3)
