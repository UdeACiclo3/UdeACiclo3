package eq.abmodel.abomodel;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Prueba {

    @RequestMapping
    public String hola(){
        return  "Hola Mundo";
    }
}
