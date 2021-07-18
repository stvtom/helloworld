package springXml.transication;

import org.springframework.stereotype.Service;

// Spring事务不生效的原因大解读
// https://blog.csdn.net/f641385712/article/details/80445933
@Service
public class InvalidTransication {


    public void addInfo(){

    }


    public int creat(){
        return 0;
    }

}
