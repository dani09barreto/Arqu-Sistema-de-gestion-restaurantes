package com.example.negociogeneral.Controller;

import com.example.negociogeneral.ServiceLocator.IResponseLB;
import com.example.negociogeneral.Services.intf.IServicioPlato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/general/platos")
public class ControllerPlato {
    @Autowired
    @Qualifier("servicioPlato")
    IServicioPlato servicioPlato;

    @Autowired
    @Qualifier("responseLB")
    IResponseLB restClient;

}
