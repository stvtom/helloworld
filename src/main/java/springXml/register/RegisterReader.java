package springXml.register;

import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionCustomizer;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AutowireCandidateQualifier;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.context.annotation.*;
import org.springframework.lang.Nullable;

import java.lang.annotation.Annotation;
import java.util.function.Supplier;

public class RegisterReader {

    public void register(Class... annotatedClasses) {
        Class[] var2 = annotatedClasses;
        int var3 = annotatedClasses.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Class<?> annotatedClass = var2[var4];
            this.registerBean(annotatedClass);
        }
    }

    public void registerBean(Class<?> annotatedClass) {
        this.doRegisterBean(annotatedClass, (Supplier)null, (String)null, (Class[])null);
    }

    <T> void doRegisterBean(Class<T> annotatedClass, @Nullable Supplier<T> instanceSupplier, @Nullable String name, @Nullable Class<? extends Annotation>[] qualifiers, BeanDefinitionCustomizer... definitionCustomizers) {
        AnnotatedGenericBeanDefinition abd = new AnnotatedGenericBeanDefinition(annotatedClass);


    }
}
