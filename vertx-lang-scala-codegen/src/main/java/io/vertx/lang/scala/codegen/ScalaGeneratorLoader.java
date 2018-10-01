package io.vertx.lang.scala.codegen;

import io.vertx.codegen.Generator;
import io.vertx.codegen.GeneratorLoader;

import javax.annotation.processing.ProcessingEnvironment;
import java.util.HashSet;
import java.util.stream.Stream;

public class ScalaGeneratorLoader implements GeneratorLoader {
  @Override
  public Stream<Generator<?>> loadGenerators(ProcessingEnvironment processingEnv) {
    HashSet<Generator<?>> generators = new HashSet<>();

//    MvelCodeGenerator datatObjectGen = new MvelCodeGenerator();
//    HashSet dataObjectKinds = new HashSet();
//    dataObjectKinds.add("dataObject");
//    datatObjectGen.name = "Scala";
//    datatObjectGen.kinds = dataObjectKinds;
//    datatObjectGen.incremental = false;
//    datatObjectGen.filename = "if(type.name != 'io.vertx.ext.web.handler.sockjs.PermittedOptions'){'scala/' + module.translateQualifiedName(fqn, 'scala').replace('.', '/') + '.scala'}";
//    datatObjectGen.templateFilename = "vertx-scala/template/dataobject.templ";
//    generators.add(datatObjectGen);


    DataObjectCodeGenerator datatObjectGen = new DataObjectCodeGenerator();
    HashSet dataObjectKinds = new HashSet();
    dataObjectKinds.add("dataObject");
    datatObjectGen.name = "Scala";
    datatObjectGen.kinds = dataObjectKinds;
    datatObjectGen.incremental = false;
    datatObjectGen.filename = "if(type.name != 'io.vertx.ext.web.handler.sockjs.PermittedOptions'){'scala/' + module.translateQualifiedName(fqn, 'scala').replace('.', '/') + '.scala'}";
    datatObjectGen.templateFilename = "vertx-scala/template/dataobject.templ";
    generators.add(datatObjectGen);

    ClassCodeGenerator classGen = new ClassCodeGenerator();
    HashSet classKinds = new HashSet();
    classKinds.add("class");
    classGen.name = "Scala";
    classGen.kinds = classKinds;
    classGen.incremental = false;
    classGen.filename = "if(type.name != 'io.vertx.core.buffer.Buffer'){'scala/' + module.translateQualifiedName(fqn, 'scala').replace('.', '/') + '.scala'}";
    classGen.templateFilename = "vertx-scala/template/class.templ";
    generators.add(classGen);


    return generators.stream();
  }
}
