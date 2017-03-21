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
 * If you are using SBT, Maven or Gradle, add the following dependency to the _dependencies_ section of your
 * project descriptor to access the Vert.x Core API and enable the Scala support:
 *
 * * SBT (in your `build.sbt` file):
 *
 * [source,scala,subs="+attributes"]
 * ----
 * libraryDependencies += "io.vertx" %% "vertx-lang-scala" % "${maven.version}"
 * ----
 *
 * * Maven (in your `pom.xml`):
 *
 * [source,xml,subs="+attributes"]
 * ----
 * <dependency>
 *   <groupId>${maven.groupId}</groupId>
 *   <artifactId>${maven.artifactId}</artifactId>
 *   <version>${maven.version}</version>
 * </dependency>
 * ----
 *
 * * Gradle (in your `build.gradle` file):
 *
 * [source,groovy,subs="+attributes"]
 * ----
 * compile "${maven.groupId}:${maven.artifactId}:${maven.version}"
 * ----
 */
@Document(fileName = "override/dependencies.adoc")
package docoverride.dependencies;

/*-
 * #%L
 * Vert.x Scala Language Support
 * %%
 * Copyright (C) 2016 vert.x
 * %%
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 * #L%
 */

import io.vertx.docgen.Document;
