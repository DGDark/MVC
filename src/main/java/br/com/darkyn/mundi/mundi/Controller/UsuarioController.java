package br.com.darkyn.mundi.mundi.Controller;

import br.com.darkyn.mundi.mundi.model.Pedido;
import br.com.darkyn.mundi.mundi.model.StatusPedido;
import br.com.darkyn.mundi.mundi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("pedido")
    public String home(Model model, Principal principal) {
        List<Pedido> pedidos = pedidoRepository.findAllByUsuario(principal.getName());
        model.addAttribute("pedidos", pedidos);
        return "usuario/home";
    }

    @GetMapping("pedido/{status}")
    public String porStatus(@PathVariable("status") String status, Model model, Principal principal) {
        List<Pedido> pedidos = pedidoRepository.findByStatusUsuario(StatusPedido.valueOf(status.toUpperCase()), principal.getName());
        model.addAttribute("pedidos", pedidos);
        model.addAttribute("status", status);
        return "usuario/home";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError() {
        return "redirect:/usuario/home";
    }

}
