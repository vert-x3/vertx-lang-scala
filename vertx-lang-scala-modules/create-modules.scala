import java.io.*
import scala.io.Source
import scala.util.Using

@main def run(path: String, version: String = "4.3.8-SNAPSHOT"): Unit =
  val modulesParentPath = File(path)
  val existingModules = modulesParentPath
    .listFiles
    .filter(_.isDirectory)
    .map(_.getName)
    .filter(isWantedModule(_))
  val modulesToCreate = modulesWanted diff existingModules
  printf("Modules that exist: %3d%n", existingModules.size)
  printf("Modules to create:  %3d%n", modulesToCreate.size)
  modulesToCreate
    .zipWithIndex
    .foreach { case (moduleName, i) =>
      printf(s"Creating module %3d/%d\r", i, modulesToCreate.size)
      val dir = File(s"$path${File.separator}$moduleName")
      dir.mkdir()
      val pom = File(dir, "pom.xml")
      Using(BufferedWriter(FileWriter(pom))) { writer =>
        writer.append(
          s"""
             |<?xml version="1.0" encoding="UTF-8"?>
             |<project xmlns="http://maven.apache.org/POM/4.0.0"
             |         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             |         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
             |  <modelVersion>4.0.0</modelVersion>
             |  <parent>
             |    <groupId>io.vertx</groupId>
             |    <artifactId>vertx-lang-scala-modules</artifactId>
             |    <version>$vertxVersion</version>
             |  </parent>
             |
             |  <artifactId>$moduleName</artifactId>
             |
             |  <properties>
             |    <gen.src.gid>io.vertx</gen.src.gid>
             |    <gen.src.aid>${sourceModuleName(moduleName)}</gen.src.aid>
             |    <gen.src.unpacked.dir>$${project.build.directory}/sources/java</gen.src.unpacked.dir>
             |    <gen.src.generated.dir>$${project.build.directory}/generated-sources</gen.src.generated.dir>
             |  </properties>
             |
             |  <dependencies>
             |    <dependency>
             |      <groupId>org.scala-lang</groupId>
             |      <artifactId>scala3-library_3</artifactId>
             |    </dependency>
             |
             |    <!-- Code generation source -->
             |    <dependency>
             |      <groupId>$${gen.src.gid}</groupId>
             |      <artifactId>$${gen.src.aid}</artifactId>
             |      <version>$${stack.version}</version>
             |    </dependency>
             |
             |    <!-- Code generator -->
             |    <dependency>
             |      <groupId>io.vertx</groupId>
             |      <artifactId>vertx-lang-scala-codegen</artifactId>
             |      <version>$${stack.version}</version>
             |    </dependency>
             |    <!-- Extra dependencies -->
             |  </dependencies>
             |
             |  <build>
             |    <plugins>
             |      <plugin>
             |        <groupId>org.apache.maven.plugins</groupId>
             |        <artifactId>maven-dependency-plugin</artifactId>
             |        <configuration>
             |          <includeGroupIds>$${gen.src.gid}</includeGroupIds>
             |          <includeArtifactIds>$${gen.src.aid}</includeArtifactIds>
             |          <classifier>sources</classifier>
             |          <includeTypes>jar</includeTypes>
             |          <outputDirectory>$${gen.src.unpacked.dir}</outputDirectory>
             |        </configuration>
             |        <executions>
             |          <execution>
             |            <id>unpack-$${gen.src.aid}-sources</id>
             |            <phase>generate-sources</phase>
             |            <goals>
             |              <goal>unpack-dependencies</goal>
             |            </goals>
             |            <configuration>
             |              <includes>io/vertx/**/*.java</includes>
             |              <excludes>**/impl/**/*.java,io/vertx/core/logging/**/*.java</excludes>
             |            </configuration>
             |          </execution>
             |        </executions>
             |      </plugin>
             |      <plugin>
             |        <groupId>org.bsc.maven</groupId>
             |        <artifactId>maven-processor-plugin</artifactId>
             |        <configuration>
             |          <systemProperties>
             |            <java.util.logging.SimpleFormatter.format>%4$$s: %3$$s - %5$$s %6$$s%n
             |            </java.util.logging.SimpleFormatter.format>
             |            <mvel2.disable.jit>true</mvel2.disable.jit>
             |          </systemProperties>
             |          <defaultOutputDirectory>$${gen.src.generated.dir}</defaultOutputDirectory>
             |        </configuration>
             |        <executions>
             |          <execution>
             |            <id>generate-$${gen.src.aid}-sources</id>
             |            <goals>
             |              <goal>process</goal>
             |            </goals>
             |            <phase>generate-sources</phase>
             |            <configuration>
             |              <sourceDirectory>$${gen.src.unpacked.dir}</sourceDirectory>
             |              <processors>
             |                <processor>io.vertx.codegen.CodeGenProcessor</processor>
             |              </processors>
             |              <optionMap>
             |                <codegen.generators>scala</codegen.generators>
             |                <codegen.output>$${gen.src.generated.dir}</codegen.output>
             |              </optionMap>
             |            </configuration>
             |          </execution>
             |        </executions>
             |      </plugin>
             |      <plugin>
             |        <groupId>net.alchim31.maven</groupId>
             |        <artifactId>scala-maven-plugin</artifactId>
             |        <executions>
             |          <execution>
             |            <id>compile-generated-$${gen.src.aid}-sources</id>
             |            <goals>
             |              <goal>compile</goal>
             |            </goals>
             |          </execution>
             |        </executions>
             |      </plugin>
             |    </plugins>
             |  </build>
             |
             |</project>
             |""".stripMargin)
        writer.close()
      }
    }
  val parentPom = File(s"$path${File.separator}pom.xml")
  println(s"Adding %d modules to $parentPom")
  val linesUntilModulesSection = Source.fromFile(parentPom).getLines.takeWhile(line => !line.matches(".*<modules>.*"))
  val linesAfterModulesSection = Source.fromFile(parentPom).getLines.dropWhile(line => !line.matches(".*</modules>.*"))
  val parentPomContent =
    linesUntilModulesSection.mkString(System.lineSeparator) +
      "  <modules>" + System.lineSeparator +
      modulesWanted.map(moduleName => s"    <module>$moduleName</module>").mkString(System.lineSeparator) +
      linesAfterModulesSection.mkString(System.lineSeparator)
  Using(BufferedWriter(FileWriter(parentPom))) { writer => writer.write(parentPomContent) }
  println("Done")

def isWantedModule(moduleName: String): Boolean = modulesWanted contains moduleName
def modulesWanted: Seq[String] = moduleMap.keys.toSeq
def sourceModuleName(targetModuleName: String): String = moduleMap(targetModuleName)

val moduleMap = Map(
  "vertx-lang-scala-core" -> "vertx-core",
  "vertx-lang-scala-mail-client" -> "vertx-mail-client",
  "vertx-lang-scala-bridge-common" -> "vertx-bridge-common",
  "vertx-lang-scala-web-common" -> "vertx-web-common",
  "vertx-lang-scala-web" -> "vertx-web",
  "vertx-lang-scala-web-client" -> "vertx-web-client",
  "vertx-lang-scala-mongo-client" -> "vertx-mongo-client",
  "vertx-lang-scala-redis-client" -> "vertx-redis-client",
  "vertx-lang-scala-cassandra-client" -> "vertx-cassandra-client",
  "vertx-lang-scala-consul-client" -> "vertx-consul-client",
  "vertx-lang-scala-kafka-client" -> "vertx-kafka-client",
  "vertx-lang-scala-amqp-client" -> "vertx-amqp-client",
  "vertx-lang-scala-rabbitmq-client" -> "vertx-rabbitmq-client",
  "vertx-lang-scala-sql-client" -> "vertx-sql-client",
  "vertx-lang-scala-db2-client" -> "vertx-db2-client",
  "vertx-lang-scala-pg-client" -> "vertx-pg-client",
  "vertx-lang-scala-mssql-client" -> "vertx-mssql-client",
  "vertx-lang-scala-mysql-client" -> "vertx-mysql-client",
  "vertx-lang-scala-oracle-client" -> "vertx-oracle-client",
  "vertx-lang-scala-mqtt" -> "vertx-mqtt",
  "vertx-lang-scala-auth-common" -> "vertx-auth-common",
  "vertx-lang-scala-auth-jwt" -> "vertx-auth-jwt",
  "vertx-lang-scala-auth-oauth2" -> "vertx-auth-oauth2",
  "vertx-lang-scala-auth-otp" -> "vertx-auth-otp",
  "vertx-lang-scala-auth-htdigest" -> "vertx-auth-htdigest",
  "vertx-lang-scala-auth-htpasswd" -> "vertx-auth-htpasswd",
  "vertx-lang-scala-auth-mongo" -> "vertx-auth-mongo",
  "vertx-lang-scala-auth-shiro" -> "vertx-auth-shiro",
  "vertx-lang-scala-auth-webauthn" -> "vertx-auth-webauthn",
  "vertx-lang-scala-auth-properties" -> "vertx-auth-properties",
  "vertx-lang-scala-auth-ldap" -> "vertx-auth-ldap",
  "vertx-lang-scala-auth-jdbc" -> "vertx-auth-jdbc",
  "vertx-lang-scala-auth-sql-client" -> "vertx-auth-sql-client",
  "vertx-lang-scala-health-checks" -> "vertx-health-check",
  "vertx-lang-scala-jdbc-client" -> "vertx-jdbc-client",
  "vertx-lang-scala-json-schema" -> "vertx-json-schema",
  "vertx-lang-scala-web-validation" -> "vertx-web-validation",
  "vertx-lang-scala-web-openapi" -> "vertx-web-openapi",
  "vertx-lang-scala-web-api-service" -> "vertx-web-api-service",
  "vertx-lang-scala-web-templ-freemarker" -> "vertx-web-templ-freemarker",
  "vertx-lang-scala-web-templ-handlebars" -> "vertx-web-templ-handlebars",
  "vertx-lang-scala-web-templ-jade" -> "vertx-web-templ-jade",
  "vertx-lang-scala-web-templ-mvel" -> "vertx-web-templ-mvel",
  "vertx-lang-scala-web-templ-pebble" -> "vertx-web-templ-pebble",
  "vertx-lang-scala-web-templ-rocker" -> "vertx-web-templ-rocker",
  "vertx-lang-scala-web-templ-thymeleaf" -> "vertx-web-templ-thymeleaf",
  "vertx-lang-scala-web-sstore-cookie" -> "vertx-web-sstore-cookie",
  "vertx-lang-scala-web-sstore-infinispan" -> "vertx-web-sstore-infinispan",
  "vertx-lang-scala-web-sstore-redis" -> "vertx-web-sstore-redis",
  "vertx-lang-scala-web-graphql" -> "vertx-web-graphql",
  "vertx-lang-scala-circuit-breaker" -> "vertx-circuit-breaker",
  "vertx-lang-scala-stomp" -> "vertx-stomp",
  "vertx-lang-scala-config" -> "vertx-config",
  "vertx-lang-scala-sql-client-templates" -> "vertx-sql-client-templates",
  "vertx-lang-scala-shell" -> "vertx-shell",
  "vertx-lang-scala-micrometer-metrics" -> "vertx-micrometer-metrics",
  "vertx-lang-scala-tcp-eventbus-bridge" -> "vertx-tcp-eventbus-bridge",
  "vertx-lang-scala-service-discovery" -> "vertx-service-discovery",
  "vertx-lang-scala-service-discovery-backend-consul" -> "vertx-service-discovery-backend-consul",
  "vertx-lang-scala-service-discovery-backend-redis" -> "vertx-service-discovery-backend-redis",
  "vertx-lang-scala-service-discovery-backend-zookeeper" -> "vertx-service-discovery-backend-zookeeper",
  "vertx-lang-scala-service-discovery-bridge-consul" -> "vertx-service-discovery-bridge-consul",
  "vertx-lang-scala-service-discovery-bridge-docker" -> "vertx-service-discovery-bridge-docker",
  "vertx-lang-scala-service-discovery-bridge-docker-links" -> "vertx-service-discovery-bridge-docker-links",
  "vertx-lang-scala-service-discovery-bridge-kubernetes" -> "vertx-service-discovery-bridge-kubernetes",
  "vertx-lang-scala-service-discovery-bridge-zookeeper" -> "vertx-service-discovery-bridge-zookeeper",
  "vertx-lang-scala-uri-template" -> "vertx-uri-template",
  "vertx-lang-scala-http-proxy" -> "vertx-http-proxy",
)
