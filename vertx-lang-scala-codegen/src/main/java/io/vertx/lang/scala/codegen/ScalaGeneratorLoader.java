package io.vertx.lang.scala.codegen;

import io.vertx.codegen.Generator;
import io.vertx.codegen.GeneratorLoader;
import io.vertx.codegen.type.ClassKind;

import javax.annotation.processing.ProcessingEnvironment;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class ScalaGeneratorLoader implements GeneratorLoader {
  @Override
  public Stream<Generator<?>> loadGenerators(ProcessingEnvironment processingEnv) {
    HashSet<Generator<?>> generators = new HashSet<>();

    ClassCodeGenerator classGen = new ClassCodeGenerator();
    HashSet<String> classKinds = new HashSet<>();
    classKinds.add("dataObject");
    classGen.name = "scala";
    classGen.kinds = classKinds;
    classGen.incremental = true;
    classGen.filename = "if(type.name != 'io.vertx.core.buffer.Buffer'){var pkg = 'scala/' + type.module.translatePackageName('scala').replace('.', '/'); var splitted = pkg.split('/'); return pkg + '/package.scala';}";
    // TODO: this is wrong
    classGen.templateFilename = "vertx-scala/template/package_object.ftl";
    generators.add(classGen);

    ScalaGenerator scalaGenerator = new ScalaGenerator();
    Set<String> scalaGeneratorClassKinds = new HashSet<>();
    scalaGeneratorClassKinds.add("class");
    scalaGenerator.kinds = scalaGeneratorClassKinds;
    scalaGenerator.name = "scala";
    scalaGenerator.incremental = false;
    generators.add(scalaGenerator);

    return generators.stream();
  }
}
