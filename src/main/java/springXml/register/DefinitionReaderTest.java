package springXml.register;

import springXml.Main1;
import springXml.UserService;

public class DefinitionReaderTest {

    public static void main(String[] args) {

        DefinitionReaderContext annotationContext = new DefinitionReaderContext(Main1.class);

        UserService userService = (UserService) annotationContext.getBean("userService");

        userService.sing("张三");
    }
}
