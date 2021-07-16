package springXml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlApplicationContextText {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName:beanDefinitionNames){
            System.err.println(beanName);
        }

        AnimalService animalService = (AnimalService) applicationContext.getBean("animalService");

        animalService.sing("张三");

        String userName = animalService.userName;

        System.err.println(userName);

        AnimalAgeService animalAge =(AnimalAgeService) applicationContext.getBean("animalAge");

        String lisi = animalAge.sing("lisi");
        System.err.println(lisi);
        System.err.println(animalAge.userName);
    }
}
