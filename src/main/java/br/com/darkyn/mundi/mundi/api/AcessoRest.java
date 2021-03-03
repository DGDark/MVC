package br.com.darkyn.mundi.mundi.api;

import br.com.darkyn.mundi.mundi.interceptor.InterceptadorDeAcessos;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
;import java.util.List;

@RequestMapping("acesso")
@RestController
public class AcessoRest {

    @GetMapping
    public List<InterceptadorDeAcessos.Acesso> getAcessos(){
        return InterceptadorDeAcessos.acessos;

    }

}
