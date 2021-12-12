package springXml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;

@Service
public class PersonService {

    @Autowired
    private UserService userService;

    public String dance(String name){
        String sing = userService.sing(name);
        System.err.println("PersonService"+sing);
        return name;
    }

}
