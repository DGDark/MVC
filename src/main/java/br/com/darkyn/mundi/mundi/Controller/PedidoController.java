package br.com.darkyn.mundi.mundi.Controller;

import br.com.darkyn.mundi.mundi.dto.RequisicaoNovoPedido;
import br.com.darkyn.mundi.mundi.model.Pedido;
import br.com.darkyn.mundi.mundi.model.User;
import br.com.darkyn.mundi.mundi.repository.PedidoRepository;
import br.com.darkyn.mundi.mundi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("formulario")
    public String formulario(RequisicaoNovoPedido requisicao){
        return "pedido/formulario";
    }

    @PostMapping("novo")
    public String novo(@Valid  RequisicaoNovoPedido requisicao, BindingResult result) {
        if(result.hasErrors()){
            return "pedido/formulario";

        }else{
            //usado para saber qual usuario esta fazendo a riquisição
            String username =SecurityContextHolder.getContext().getAuthentication().getName();
            User user =userRepository.findByUserName(username);

            Pedido pedido = requisicao.toPedido();
            pedido.setUser(user);
            pedidoRepository.save(pedido);
            return "redirect:/home";
        }
    }


}
