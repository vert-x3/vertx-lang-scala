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

class AddressResolverOptions(val asJava: io.vertx.core.dns.AddressResolverOptions) {
  def setCacheMaxTimeToLive(value:Int) = {
    asJava.setCacheMaxTimeToLive(value)
    this
  }
  def getCacheMaxTimeToLive = {
    asJava.getCacheMaxTimeToLive()
  }
  def setCacheMinTimeToLive(value:Int) = {
    asJava.setCacheMinTimeToLive(value)
    this
  }
  def getCacheMinTimeToLive = {
    asJava.getCacheMinTimeToLive()
  }
  def setCacheNegativeTimeToLive(value:Int) = {
    asJava.setCacheNegativeTimeToLive(value)
    this
  }
  def getCacheNegativeTimeToLive = {
    asJava.getCacheNegativeTimeToLive()
  }
  def setHostsPath(value:String) = {
    asJava.setHostsPath(value)
    this
  }
  def getHostsPath = {
    asJava.getHostsPath()
  }
  def setHostsValue(value:io.vertx.core.buffer.Buffer) = {
    asJava.setHostsValue(value)
    this
  }
  def getHostsValue = {
    asJava.getHostsValue()
  }
  def setMaxQueries(value:Int) = {
    asJava.setMaxQueries(value)
    this
  }
  def getMaxQueries = {
    asJava.getMaxQueries()
  }
  def setNdots(value:Int) = {
    asJava.setNdots(value)
    this
  }
  def getNdots = {
    asJava.getNdots()
  }
  def setOptResourceEnabled(value:Boolean) = {
    asJava.setOptResourceEnabled(value)
    this
  }
  def isOptResourceEnabled = {
    asJava.isOptResourceEnabled()
  }
  def setQueryTimeout(value:Long) = {
    asJava.setQueryTimeout(value)
    this
  }
  def getQueryTimeout = {
    asJava.getQueryTimeout()
  }
  def setRdFlag(value:Boolean) = {
    asJava.setRdFlag(value)
    this
  }
  def getRdFlag = {
    asJava.getRdFlag()
  }
  def addSearchDomain(value:String) = {
    asJava.addSearchDomain(value)
    this
  }
  def setSearchDomains(value:scala.collection.mutable.Buffer[String]) = {
    asJava.setSearchDomains(value)
    this
  }
  def getSearchDomains = {
    asJava.getSearchDomains()
  }
  def addServer(value:String) = {
    asJava.addServer(value)
    this
  }
  def setServers(value:scala.collection.mutable.Buffer[String]) = {
    asJava.setServers(value)
    this
  }
  def getServers = {
    asJava.getServers()
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
