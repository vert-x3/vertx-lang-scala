/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.vertx.scala.core.dns

import io.vertx.core.json.JsonObject
import scala.collection.JavaConversions._

/**
  * Configuration options for Vert.x hostname resolver. The resolver uses the local <i>hosts</i> file and performs
  * DNS <i>A</i> and <i>AAAA</i> queries.
  */

class AddressResolverOptions(val java: io.vertx.core.dns.AddressResolverOptions) {
          def setCacheMaxTimeToLive(value:Int) = {
          java.setCacheMaxTimeToLive(value)
          this
  }
            def getCacheMaxTimeToLive = {
    java.getCacheMaxTimeToLive()
  }
            def setCacheMinTimeToLive(value:Int) = {
          java.setCacheMinTimeToLive(value)
          this
  }
            def getCacheMinTimeToLive = {
    java.getCacheMinTimeToLive()
  }
            def setCacheNegativeTimeToLive(value:Int) = {
          java.setCacheNegativeTimeToLive(value)
          this
  }
            def getCacheNegativeTimeToLive = {
    java.getCacheNegativeTimeToLive()
  }
            def setHostsPath(value:String) = {
          java.setHostsPath(value)
          this
  }
            def getHostsPath = {
    java.getHostsPath()
  }
            def setHostsValue(value:io.vertx.core.buffer.Buffer) = {
          java.setHostsValue(value)
          this
  }
            def getHostsValue = {
    java.getHostsValue()
  }
            def setMaxQueries(value:Int) = {
          java.setMaxQueries(value)
          this
  }
            def getMaxQueries = {
    java.getMaxQueries()
  }
            def setNdots(value:Int) = {
          java.setNdots(value)
          this
  }
            def getNdots = {
    java.getNdots()
  }
            def setOptResourceEnabled(value:Boolean) = {
          java.setOptResourceEnabled(value)
          this
  }
            def isOptResourceEnabled = {
    java.isOptResourceEnabled()
  }
            def setQueryTimeout(value:Long) = {
          java.setQueryTimeout(value)
          this
  }
            def getQueryTimeout = {
    java.getQueryTimeout()
  }
            def setRdFlag(value:Boolean) = {
          java.setRdFlag(value)
          this
  }
            def getRdFlag = {
    java.getRdFlag()
  }
            def addSearchDomain(value:String) = {
            java.addSearchDomain(value)
            this
    }
              def setSearchDomains(value:scala.collection.mutable.Buffer[String]) = {
          java.setSearchDomains(value)
          this
  }
            def getSearchDomains = {
    java.getSearchDomains()
  }
            def addServer(value:String) = {
            java.addServer(value)
            this
    }
              def setServers(value:scala.collection.mutable.Buffer[String]) = {
          java.setServers(value)
          this
  }
            def getServers = {
    java.getServers()
  }
  }
object AddressResolverOptions {
  type AddressResolverOptionsJava = io.vertx.core.dns.AddressResolverOptions
  
  def apply(t: AddressResolverOptionsJava) = {
    if(t != null)
      new AddressResolverOptions(t)
    else
      null
   
  }
  
  def fromJson(json: JsonObject):AddressResolverOptions = {
    if(json != null)
      new AddressResolverOptions(new AddressResolverOptionsJava(json))
    else
      null
  }
}
