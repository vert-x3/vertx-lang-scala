import java.time.LocalDate

ThisBuild / scalaVersion := "3.3.1"
ThisBuild / resolvers += Resolver.mavenLocal
ThisBuild / version      := "4.5.4-SNAPSHOT"

lazy val currentYear = LocalDate.now().getYear()
lazy val socialLinks = Map(
  "github"  -> "https://github.com/vert-x3/vertx-lang-scala",
  "discord" -> "https://discord.com/invite/6ry7aqPWXy",
  // custom social links will re-appear in 3.4.0
  "stackoverflow" -> "https://stackoverflow.com/questions/tagged/vert.x::stackoverflow-icon-white.png::stackoverflow-icon-black.png",
  "vertx" -> "https://vertx.io/community::vertx-icon-16x16.png",
)

Compile / doc / scalacOptions ++= Seq(
  "-siteroot",
  "src/main/markdown",
  "-snippet-compiler:compile",
  "-social-links:" + socialLinks.map { case (site, link) => s"$site::$link" }.mkString(","),
  "-scastie-configuration",
  s"""
    |libraryDependencies += "io.vertx" % "vertx-web" % ${version.value},
    |libraryDependencies += "io.vertx" %% "vertx-lang-scala" % ${version.value},
  """.stripMargin.stripMargin.replace("\n", " "),
  "-Ygenerate-inkuire",
  "-project-version",
  version.value,
  "-project-logo",
  "src/main/markdown/_assets/images/vertx-logo.png",
  "-project-footer",
  s"© $currentYear Eclipse Vert.x™",
  "-project-url",
  "https://github.com/vert-x3/vertx-lang-scala",
)

lazy val root = project
  .in(file("."))
  .settings(
    name := "Vert.x for Scala",
    libraryDependencies ++= Seq(
      "io.vertx"       % "vertx-web"             % version.value,
      "io.vertx"      %% "vertx-lang-scala"      % version.value,
      "io.vertx"      %% "vertx-lang-scala-test" % version.value,
      "org.scalatest" %% "scalatest"             % "3.3.0-SNAP4",
    ),
    scalacOptions ++= Seq("-deprecation", "-feature"),
  )
