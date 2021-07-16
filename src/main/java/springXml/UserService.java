package springXml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    @Autowired
    private PersonService personService;

    private String name ;

    public String sing(String sing){
        System.err.println("UserService在唱歌"+sing);
        return sing;
    }

}
