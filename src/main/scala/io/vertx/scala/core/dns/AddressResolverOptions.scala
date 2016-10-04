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

  /**
    * Set the cache maximum TTL value in seconds. After successful resolution IP addresses are cached with their DNS response TTL,
    * use this to set a maximum value to all responses TTL.
    */
  def setCacheMaxTimeToLive(value:Int) = {
    asJava.setCacheMaxTimeToLive(value)
    this
  }
  def getCacheMaxTimeToLive = {
    asJava.getCacheMaxTimeToLive()
  }

  /**
    * Set the cache minimum TTL value in seconds. After resolution successful IP addresses are cached with their DNS response TTL,
    * use this to set a minimum value to all responses TTL.
    */
  def setCacheMinTimeToLive(value:Int) = {
    asJava.setCacheMinTimeToLive(value)
    this
  }
  def getCacheMinTimeToLive = {
    asJava.getCacheMinTimeToLive()
  }

  /**
    * Set the negative cache TTL value in seconds. After a failed hostname resolution, DNS queries won't be retried
    * for a period of time equals to the negative TTL. This allows to reduce the response time of negative replies
    * and reduce the amount of messages to DNS servers.
    */
  def setCacheNegativeTimeToLive(value:Int) = {
    asJava.setCacheNegativeTimeToLive(value)
    this
  }
  def getCacheNegativeTimeToLive = {
    asJava.getCacheNegativeTimeToLive()
  }

  /**
    * Set the path of an alternate hosts configuration file to use instead of the one provided by the os.
    * <p/>
    * The default value is null, so the operating system hosts config is used.
    */
  def setHostsPath(value:String) = {
    asJava.setHostsPath(value)
    this
  }
  def getHostsPath = {
    asJava.getHostsPath()
  }

  /**
    * Set an alternate hosts configuration file to use instead of the one provided by the os.
    * <p/>
    * The value should contain the hosts content literaly, for instance <i>127.0.0.1 localhost</i>
    * <p/>
    * The default value is null, so the operating system hosts config is used.
    */
  def setHostsValue(value:io.vertx.core.buffer.Buffer) = {
    asJava.setHostsValue(value)
    this
  }
  def getHostsValue = {
    asJava.getHostsValue()
  }

  /**
    * Set the maximum number of queries when an hostname is resolved.
    */
  def setMaxQueries(value:Int) = {
    asJava.setMaxQueries(value)
    this
  }
  def getMaxQueries = {
    asJava.getMaxQueries()
  }

  /**
    * Set the ndots value used when resolving using search domains, the default value is `1`.
    */
  def setNdots(value:Int) = {
    asJava.setNdots(value)
    this
  }
  def getNdots = {
    asJava.getNdots()
  }

  /**
    * Set to true to enable the automatic inclusion in DNS queries of an optional record that hints
    * the remote DNS server about how much data the resolver can read per response.
    */
  def setOptResourceEnabled(value:Boolean) = {
    asJava.setOptResourceEnabled(value)
    this
  }
  def isOptResourceEnabled = {
    asJava.isOptResourceEnabled()
  }

  /**
    * Set the query timeout in milliseconds, i.e the amount of time after a query is considered to be failed.
    */
  def setQueryTimeout(value:Long) = {
    asJava.setQueryTimeout(value)
    this
  }
  def getQueryTimeout = {
    asJava.getQueryTimeout()
  }

  /**
    * Set the DNS queries <i>Recursion Desired</i> flag value.
    */
  def setRdFlag(value:Boolean) = {
    asJava.setRdFlag(value)
    this
  }
  def getRdFlag = {
    asJava.getRdFlag()
  }

  /**
    * Set the lists of DNS search domains.
    * <p/>
    * When the search domain list is null, the effective search domain list will be populated using
    * the system DNS search domains.
    */
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

  /**
    * Set the list of DNS server addresses, an address is the IP  of the dns server, followed by an optional
    * colon and a port, e.g `8.8.8.8` or {code 192.168.0.1:40000}. When the list is empty, the resolver
    * will use the list of the system DNS server addresses from the environment, if that list cannot be retrieved
    * it will use Google's public DNS servers `"8.8.8.8"` and `"8.8.4.4"`.
    */
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
  
  def apply() = {
    new AddressResolverOptions(new AddressResolverOptionsJava(io.vertx.lang.scala.json.Json.emptyObj()))
   
  }
  
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
