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

function renderSource(elt, source) {

    // A bit twisted at the moment due to classloading issues but that works
    var type = java.lang.Thread.currentThread().getContextClassLoader().loadClass("io.vertx.codetrans.CodeTranslator");
    var type2 = java.lang.Thread.currentThread().getContextClassLoader().loadClass("io.vertx.codetrans.ScalaLang");
    var JArray = Java.type("java.lang.Object[]");
    var arr = new JArray(1);
    arr[0] = processingEnv;
    var translator = type.getConstructors()[0].newInstance(arr);
    var lang = type2.newInstance();
    try {
        var translation = translator.translate(elt, lang);
        return translation
    } catch (Err) {
        java.lang.System.out.println("Cannot generate: " + elt + ". Err: " + Err);
        return "todo";
    }
}

function isDataObject(elt) {
    var annotation = java.lang.Thread.currentThread().getContextClassLoader().loadClass("io.vertx.codegen.annotations.DataObject");
    while (elt != null) {
        var kind = elt.getKind().name();
        if (kind === "CLASS" || kind === "INTERFACE") {
            return elt.getAnnotation(annotation);
        }
        elt = elt.getEnclosingElement();
    }
    return false;
}

function toTypeLink(elt, coordinate) {
    if (isDataObject(elt)) {
        var baseLink;
        if (coordinate == null) {
            baseLink = "../";
        } else {
            baseLink = "../../" + coordinate.getArtifactId() + "/"
        }
        return baseLink + "cheatsheet/" + elt.getSimpleName().toString() + ".html";
    } else {
        if (coordinate == null) {
            baseLink = "";
        } else {
            baseLink = "../../" + coordinate.getArtifactId() + "/scala/"
        }
        return baseLink + "scaladocs/" + elt.getQualifiedName().toString().replace("io.vertx.", "io.vertx.scala.").replace(/\./g, "/") + ".html";
    }
}

function toMethodLink(elt, coordinate) {
    return toExecutableLink(elt, elt.getSimpleName().toString(), coordinate);
}

function toConstructorLink(elt, coordinate) {
    return toExecutableLink(elt, elt.getEnclosingElement().getSimpleName().toString(), coordinate);
}

function toExecutableLink(elt, name, coordinate) {
    var typeElt = elt.getEnclosingElement();
    var link = toTypeLink(typeElt, coordinate);
    if (link.indexOf("cheatsheet") != -1) {
        return link + '#' + java.beans.Introspector.decapitalize(elt.getSimpleName().toString().substring(3));
    } else {
        var anchor = '#' + name + "(";
        var type = elt.asType();
        var methodType  = typeUtils.erasure(type);
        var parameterTypes = methodType.getParameterTypes();
        for (var i = 0;i < parameterTypes.size();i++) {
            if (i > 0) {
                anchor += ',%20';
            }
            anchor += parameterTypes.get(i).toString();
        }
        anchor += ')';
        return link + anchor;
    }
}

function toFieldLink(elt) {
    return "todo";
}

function resolveLabel(elt, label) {
    if (isDataObject(elt)) {
        if (elt.getKind().name() === "METHOD") {
            return java.beans.Introspector.decapitalize(elt.getSimpleName().toString().substring(3));
        }
    }
    return label;
}
