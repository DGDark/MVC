package br.com.darkyn.mundi.mundi.Controller;

import br.com.darkyn.mundi.mundi.model.Pedido;
import br.com.darkyn.mundi.mundi.model.StatusPedido;
import br.com.darkyn.mundi.mundi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeControlle {


    @Autowired
    PedidoRepository pedidoRepository;

    @GetMapping
    public String home(Model model, Principal principal) {

        //informa qual a ordem que vai ser ordenado os pedudis
        Sort sort = Sort.by("dataEntrega").ascending();

        // o primeiro parametro mostra o tanto de paginas e o segundo o tanto de objetos nela
        PageRequest paginacao = PageRequest.of(0,10, sort);

        List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.ENTREGUE, paginacao);
        model.addAttribute("pedidos", pedidos);
        return "home";

        //ai
    }


}


