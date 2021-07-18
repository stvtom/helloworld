package database.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IController {

    @RequestMapping(value = {"/","index"})
    @ResponseBody
    public String hello(){
        return "兄弟，找我干啥子";
    }

}
