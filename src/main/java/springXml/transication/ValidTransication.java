package springXml.transication;

import database.service.impl.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ValidTransication {

    @Autowired
    private CityServiceImpl cityService;

    @Autowired
    private InvalidTransication invalidTransication;


    public void addInfo(){
        invalidTransication.creat();
    }

    @Transactional
    public int creat(){
        Boolean aBoolean = cityService.updateCity(null);
        return 0;
    }

}
