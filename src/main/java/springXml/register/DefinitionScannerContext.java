package springXml.register;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ScopeMetadata;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.util.Assert;

import java.util.LinkedHashSet;
import java.util.Set;

public class DefinitionScannerContext extends GenericApplicationContext {

    private final BeanDefinitionScanner scanner;

    public DefinitionScannerContext() {
        this.scanner = new BeanDefinitionScanner(this);
    }

    public DefinitionScannerContext(String... basePackages) {
        this();
        scan(basePackages);
        refresh();
    }

    public void scan(String... basePackages) {
        Assert.notEmpty(basePackages, "At least one base package must be specified");
        this.scanner.doScan(basePackages);
    }

}
