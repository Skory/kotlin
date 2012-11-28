/*
 * Copyright 2010-2012 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package org.jetbrains.jet.di;

import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.jet.lang.descriptors.ModuleDescriptor;
import org.jetbrains.jet.lang.resolve.BindingTrace;
import org.jetbrains.jet.lang.resolve.ModuleDescriptorProvider;
import org.jetbrains.jet.lang.resolve.java.*;
import org.jetbrains.jet.lang.resolve.java.resolver.*;

import javax.annotation.PreDestroy;

/* This file is generated by org.jetbrains.jet.generators.injectors.GenerateInjectors. DO NOT EDIT! */
public class InjectorForJavaDescriptorResolver {

    private final Project project;
    private final BindingTrace bindingTrace;
    private final ModuleDescriptor moduleDescriptor;
    private JavaBridgeConfiguration javaBridgeConfiguration;
    private JavaSemanticServices javaSemanticServices;
    private JavaDescriptorResolver javaDescriptorResolver;
    private PsiClassFinderImpl psiClassFinder;
    private ModuleDescriptorProvider moduleDescriptorProvider;
    private JavaTypeTransformer javaTypeTransformer;
    private JavaClassResolver javaClassResolver;
    private JavaAnnotationResolver javaAnnotationResolver;
    private JavaCompileTimeConstResolver javaCompileTimeConstResolver;
    private JavaClassObjectResolver javaClassObjectResolver;
    private JavaSupertypeResolver javaSupertypeResolver;
    private JavaNamespaceResolver javaNamespaceResolver;
    private JavaSignatureResolver javaSignatureResolver;
    private JavaConstructorResolver javaConstructorResolver;
    private JavaValueParameterResolver javaValueParameterResolver;
    private JavaFunctionResolver javaFunctionResolver;
    private JavaInnerClassResolver javaInnerClassResolver;
    private JavaPropertyResolver javaPropertyResolver;

    public InjectorForJavaDescriptorResolver(
        @NotNull Project project,
        @NotNull BindingTrace bindingTrace,
        @NotNull ModuleDescriptor moduleDescriptor
    ) {
        this.project = project;
        this.bindingTrace = bindingTrace;
        this.moduleDescriptor = moduleDescriptor;
        this.javaBridgeConfiguration = new JavaBridgeConfiguration();
        this.javaSemanticServices = new JavaSemanticServices();
        this.javaDescriptorResolver = new JavaDescriptorResolver();
        this.psiClassFinder = new PsiClassFinderImpl();
        this.moduleDescriptorProvider = org.jetbrains.jet.lang.resolve.ModuleDescriptorProviderFactory.createDefaultModuleDescriptorProvider(project);
        this.javaTypeTransformer = new JavaTypeTransformer();
        this.javaClassResolver = new JavaClassResolver();
        this.javaAnnotationResolver = new JavaAnnotationResolver();
        this.javaCompileTimeConstResolver = new JavaCompileTimeConstResolver();
        this.javaClassObjectResolver = new JavaClassObjectResolver();
        this.javaSupertypeResolver = new JavaSupertypeResolver();
        this.javaNamespaceResolver = new JavaNamespaceResolver();
        this.javaSignatureResolver = new JavaSignatureResolver();
        this.javaConstructorResolver = new JavaConstructorResolver();
        this.javaValueParameterResolver = new JavaValueParameterResolver();
        this.javaFunctionResolver = new JavaFunctionResolver();
        this.javaInnerClassResolver = new JavaInnerClassResolver();
        this.javaPropertyResolver = new JavaPropertyResolver();

        javaBridgeConfiguration.setJavaSemanticServices(javaSemanticServices);
        javaBridgeConfiguration.setProject(project);

        this.javaSemanticServices.setDescriptorResolver(javaDescriptorResolver);
        this.javaSemanticServices.setPsiClassFinder(psiClassFinder);
        this.javaSemanticServices.setTrace(bindingTrace);
        this.javaSemanticServices.setTypeTransformer(javaTypeTransformer);

        this.javaDescriptorResolver.setClassResolver(javaClassResolver);
        this.javaDescriptorResolver.setConstructorResolver(javaConstructorResolver);
        this.javaDescriptorResolver.setFunctionResolver(javaFunctionResolver);
        this.javaDescriptorResolver.setInnerClassResolver(javaInnerClassResolver);
        this.javaDescriptorResolver.setModuleDescriptorProvider(moduleDescriptorProvider);
        this.javaDescriptorResolver.setNamespaceResolver(javaNamespaceResolver);
        this.javaDescriptorResolver.setPropertiesResolver(javaPropertyResolver);

        this.psiClassFinder.setProject(project);

        javaTypeTransformer.setJavaSemanticServices(javaSemanticServices);
        javaTypeTransformer.setResolver(javaDescriptorResolver);

        javaClassResolver.setAnnotationResolver(javaAnnotationResolver);
        javaClassResolver.setClassObjectResolver(javaClassObjectResolver);
        javaClassResolver.setNamespaceResolver(javaNamespaceResolver);
        javaClassResolver.setPsiClassFinder(psiClassFinder);
        javaClassResolver.setSemanticServices(javaSemanticServices);
        javaClassResolver.setSignatureResolver(javaSignatureResolver);
        javaClassResolver.setSupertypesResolver(javaSupertypeResolver);
        javaClassResolver.setTrace(bindingTrace);

        javaAnnotationResolver.setClassResolver(javaClassResolver);
        javaAnnotationResolver.setCompileTimeConstResolver(javaCompileTimeConstResolver);

        javaCompileTimeConstResolver.setAnnotationResolver(javaAnnotationResolver);
        javaCompileTimeConstResolver.setClassResolver(javaClassResolver);

        javaClassObjectResolver.setDescriptorResolver(javaDescriptorResolver);
        javaClassObjectResolver.setSupertypesResolver(javaSupertypeResolver);
        javaClassObjectResolver.setTrace(bindingTrace);

        javaSupertypeResolver.setClassResolver(javaClassResolver);
        javaSupertypeResolver.setSemanticServices(javaSemanticServices);
        javaSupertypeResolver.setTrace(bindingTrace);
        javaSupertypeResolver.setTypeTransformer(javaTypeTransformer);

        javaNamespaceResolver.setJavaSemanticServices(javaSemanticServices);
        javaNamespaceResolver.setModuleDescriptorProvider(moduleDescriptorProvider);
        javaNamespaceResolver.setPsiClassFinder(psiClassFinder);
        javaNamespaceResolver.setTrace(bindingTrace);

        javaSignatureResolver.setJavaSemanticServices(javaSemanticServices);

        javaConstructorResolver.setTrace(bindingTrace);
        javaConstructorResolver.setTypeTransformer(javaTypeTransformer);
        javaConstructorResolver.setValueParameterResolver(javaValueParameterResolver);

        javaValueParameterResolver.setTypeTransformer(javaTypeTransformer);

        javaFunctionResolver.setAnnotationResolver(javaAnnotationResolver);
        javaFunctionResolver.setParameterResolver(javaValueParameterResolver);
        javaFunctionResolver.setSignatureResolver(javaSignatureResolver);
        javaFunctionResolver.setTrace(bindingTrace);
        javaFunctionResolver.setTypeTransformer(javaTypeTransformer);

        javaInnerClassResolver.setClassResolver(javaClassResolver);

        javaPropertyResolver.setAnnotationResolver(javaAnnotationResolver);
        javaPropertyResolver.setJavaSignatureResolver(javaSignatureResolver);
        javaPropertyResolver.setSemanticServices(javaSemanticServices);
        javaPropertyResolver.setTrace(bindingTrace);

        javaBridgeConfiguration.init();

        psiClassFinder.initialize();

    }

    @PreDestroy
    public void destroy() {
    }

    public Project getProject() {
        return this.project;
    }

    public BindingTrace getBindingTrace() {
        return this.bindingTrace;
    }

    public ModuleDescriptor getModuleDescriptor() {
        return this.moduleDescriptor;
    }

    public JavaSemanticServices getJavaSemanticServices() {
        return this.javaSemanticServices;
    }

    public JavaDescriptorResolver getJavaDescriptorResolver() {
        return this.javaDescriptorResolver;
    }

    public PsiClassFinderImpl getPsiClassFinder() {
        return this.psiClassFinder;
    }

}
