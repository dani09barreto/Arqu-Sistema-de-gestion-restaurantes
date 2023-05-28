package com.example.negociorestaurante.Controller;

import com.example.negociorestaurante.Services.intf.IServicePlato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/restaurante/platos")
public class ControllerPlatos {
    @Autowired
    @Qualifier("servicePlato")
    IServicePlato servicePlato;

    @PostMapping("/LlenarPlatos")
    public String LlenarPlatos() {
        try {
return "";

        } catch (Exception e) {
return "";
        }
    }


}
