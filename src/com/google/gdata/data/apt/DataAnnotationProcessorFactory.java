package com.google.gdata.data.apt;

import com.google.gdata.data.Kind;
import com.google.gdata.data.Kind.Adaptor;
import com.google.gdata.data.Kind.Term;
import com.google.gdata.util.common.base.StringUtil;
import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.apt.AnnotationProcessorFactory;
import com.sun.mirror.apt.Filer;
import com.sun.mirror.apt.Filer.Location;
import com.sun.mirror.apt.Messager;
import com.sun.mirror.declaration.AnnotationTypeDeclaration;
import com.sun.mirror.declaration.ClassDeclaration;
import com.sun.mirror.declaration.Declaration;
import com.sun.mirror.type.ClassType;
import com.sun.mirror.type.InterfaceType;
import com.sun.mirror.type.TypeMirror;
import com.sun.mirror.util.Types;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DataAnnotationProcessorFactory implements AnnotationProcessorFactory {
    private static List<String> supportedTypes;

    private static class DataAnnotationProcessor implements AnnotationProcessor {
        private AnnotationProcessorEnvironment env;

        private DataAnnotationProcessor(AnnotationProcessorEnvironment env) {
            this.env = env;
        }

        private void handleKindTerms() {
            Messager msg = this.env.getMessager();
            Filer filer = this.env.getFiler();
            AnnotationTypeDeclaration kindDecl = (AnnotationTypeDeclaration) this.env.getTypeDeclaration(Term.class.getName());
            if (kindDecl == null) {
                msg.printError("Unable to find the Kind.Term annotation type");
                return;
            }
            Types typeUtils = this.env.getTypeUtils();
            InterfaceType declaratorType = (InterfaceType) typeUtils.getDeclaredType(this.env.getTypeDeclaration(Adaptor.class.getName()), new TypeMirror[0]);
            Map<String, List<String>> adaptorMap = new HashMap();
            for (Declaration decl : this.env.getDeclarationsAnnotatedWith(kindDecl)) {
                if (decl instanceof ClassDeclaration) {
                    ClassDeclaration classDecl = (ClassDeclaration) decl;
                    if (typeUtils.isAssignable((ClassType) typeUtils.getDeclaredType(classDecl, new TypeMirror[0]), declaratorType)) {
                        Term kindTerm = (Term) classDecl.getAnnotation(Term.class);
                        List<String> kindAdaptors = (List) adaptorMap.get(kindTerm.value());
                        if (kindAdaptors == null) {
                            kindAdaptors = new ArrayList();
                            adaptorMap.put(kindTerm.value(), kindAdaptors);
                        }
                        kindAdaptors.add(classDecl.toString());
                    } else {
                        msg.printError(classDecl.getPosition(), "Class annotated by @Kind.Term must implement Kind.Adaptor");
                    }
                } else {
                    msg.printError(decl.getPosition(), "@Kind.Term may only be used to annotate a class");
                }
            }
            for (String term : adaptorMap.keySet()) {
                File file = new File(Kind.getKindServiceName(term));
                PrintWriter pw = null;
                try {
                    pw = filer.createTextFile(Location.CLASS_TREE, StringUtil.EMPTY_STRING, file, null);
                    pw.println("# GData Kind Adaptors for " + term);
                    for (String adaptorClass : (List) adaptorMap.get(term)) {
                        pw.println(adaptorClass);
                    }
                    if (pw != null) {
                        pw.close();
                    }
                } catch (IOException ioe) {
                    msg.printError("Unable to write kind metadata:" + file);
                    ioe.printStackTrace();
                    if (pw != null) {
                        pw.close();
                    }
                } catch (Throwable th) {
                    if (pw != null) {
                        pw.close();
                    }
                }
                msg.printNotice("Wrote kind metadata for " + term + " to " + file);
            }
        }

        public void process() {
            handleKindTerms();
        }
    }

    static {
        supportedTypes = Collections.unmodifiableList(Arrays.asList(new String[]{"com.google.gdata.data.*"}));
    }

    public Collection<String> supportedOptions() {
        return Collections.emptyList();
    }

    public Collection<String> supportedAnnotationTypes() {
        return supportedTypes;
    }

    public AnnotationProcessor getProcessorFor(Set<AnnotationTypeDeclaration> set, AnnotationProcessorEnvironment env) {
        return new DataAnnotationProcessor(null);
    }
}
