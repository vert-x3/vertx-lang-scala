package io.vertx.lang.scala

import io.vertx.codegen.`type`._
import io.vertx.codetrans.CodeTranslator
import io.vertx.codetrans.lang.groovy.GroovyLang
import io.vertx.docgen.Coordinate
import io.vertx.docgen.DocGenerator
import javax.annotation.processing.ProcessingEnvironment
import javax.lang.model.element._
import javax.lang.model.`type`.ExecutableType
import javax.lang.model.`type`.TypeMirror

import scala.collection.JavaConversions._

/**
  * @author <a href="mailto:jochen.mader@codecentric.de">Jochen Mader</a>
  */
class ScalaDocGenerator extends DocGenerator {
  private var factory: TypeMirrorFactory = _
  private var translator: CodeTranslator = _
  private var env: ProcessingEnvironment = _

  def init(processingEnv: ProcessingEnvironment) {
    factory = new TypeMirrorFactory(processingEnv.getElementUtils, processingEnv.getTypeUtils)
    translator = new CodeTranslator(processingEnv)
    env = processingEnv
  }

  def getName: String = "scala"

  def renderSource(elt: ExecutableElement, source: String): String = {
    val lang: GroovyLang = new GroovyLang
    try
      translator.translate(elt, lang)

    catch {
      case e: Exception => {
        System.out.println("Cannot generate " + elt.getEnclosingElement.getSimpleName + "#" + elt.getSimpleName + " : " + e.getMessage)
        "Code not translatable"
      }
    }
  }

  def resolveTypeLink(elt: TypeElement, coordinate: Coordinate): String = {
    var `type`: TypeInfo = null
    try
      `type` = factory.create(elt.asType)

    catch {
      case e: Exception => {
        System.out.println("Could not resolve doc link for type " + elt.getQualifiedName)
        return null
      }
    }
    if ((`type`.getKind eq ClassKind.ENUM) && `type`.asInstanceOf[EnumTypeInfo].isGen) {
      var baselink: String = null
      if (coordinate == null) baselink = "../"
      else baselink = "../../" + coordinate.getArtifactId + "/"
      return baselink + "enums.html#" + elt.getSimpleName.toString
    }
    if (`type`.getKind eq ClassKind.DATA_OBJECT) {
      var baselink: String = null
      if (coordinate == null) baselink = "../"
      else baselink = "../../" + coordinate.getArtifactId + "/"
      return baselink + "dataobjects.html#" + elt.getSimpleName.toString
    }
    if (`type`.getKind eq ClassKind.API) {
      val api: ApiTypeInfo = `type`.getRaw.asInstanceOf[ApiTypeInfo]
      return "../../groovydoc/" + api.translateName("groovy").replace('.', '/') + ".html"
    }
    null
  }

  def resolveMethodLink(elt: ExecutableElement, coordinate: Coordinate): String = {
    val typeElt: TypeElement = elt.getEnclosingElement.asInstanceOf[TypeElement]
    var link: String = resolveTypeLink(typeElt, coordinate)
    if (link != null) if (link.contains("cheatsheet")) link = link + '#' + java.beans.Introspector.decapitalize(elt.getSimpleName.toString.substring(3))
    else {
      var anchor: String = '#' + elt.getSimpleName.toString + "("
      val `type`: TypeMirror = elt.asType
      val methodType: ExecutableType = env.getTypeUtils.erasure(`type`).asInstanceOf[ExecutableType]

      methodType.getParameterTypes.zipWithIndex.foreach{
        case (v, i) => {
          if(i > 0) anchor += ",%20"
          anchor += v.toString
        }
      }

      anchor += ')'
      link = link + anchor
    }
    link
  }

  def resolveLabel(elt: Element, defaultLabel: String): String = {
    if (elt.getKind eq ElementKind.METHOD) {
      val `type`: TypeInfo = factory.create(elt.getEnclosingElement.asType)
      if (`type`.getKind eq ClassKind.DATA_OBJECT) {
        var name: String = elt.getSimpleName.toString
        if (name.startsWith("set") && name.length > 3 && Character.isUpperCase(name.charAt(3))) name = java.beans.Introspector.decapitalize(name.substring(3))
        return name
      }
    }
    defaultLabel
  }

  def resolveConstructorLink(elt: ExecutableElement, coordinate: Coordinate): String = {
    return "todo"
  }

  def resolveFieldLink(elt: VariableElement, coordinate: Coordinate): String = {
    return "todo"
  }
}
