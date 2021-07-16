package springXml;

import org.springframework.stereotype.Component;

@Component
public class DogService {

    public String dance(String name){
        System.err.println("DogService"+name);
        return name;
    }
}
