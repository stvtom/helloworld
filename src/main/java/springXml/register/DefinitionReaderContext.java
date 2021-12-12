package springXml.register;

import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.util.Assert;

public class DefinitionReaderContext extends GenericApplicationContext {

    private final AnnotatedBeanDefinitionReader reader;
    private final ClassPathBeanDefinitionScanner scanner;

    public DefinitionReaderContext() {
        this.reader = new AnnotatedBeanDefinitionReader(this);
        this.scanner = new ClassPathBeanDefinitionScanner(this);
    }

    public DefinitionReaderContext(Class... annotatedClasses) {
        this();
        this.register(annotatedClasses);
        this.refresh();
    }

    public void register(Class... annotatedClasses) {
        Assert.notEmpty(annotatedClasses, "At least one annotated class must be specified");
        this.reader.register(annotatedClasses);
    }
}
