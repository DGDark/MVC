package br.com.darkyn.mundi.mundi.api;

import br.com.darkyn.mundi.mundi.dto.RequesicaoNovaOferta;
import br.com.darkyn.mundi.mundi.model.Oferta;
import br.com.darkyn.mundi.mundi.model.Pedido;
import br.com.darkyn.mundi.mundi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/oferta")
public class OfertaRest {

    @Autowired
    private PedidoRepository pedidoRepository;

    @PostMapping
    public Oferta criaOferta(@Valid @RequestBody RequesicaoNovaOferta requisicao) {
        Optional<Pedido> pedidoBuscado = pedidoRepository.findById(requisicao.getPedidoId());
        if(!pedidoBuscado.isPresent()) {
            return null;
        }

        Pedido pedido = pedidoBuscado.get();

        Oferta nova = requisicao.toOferta();
        nova.setPedido(pedido);
        pedido.getOfertas().add(nova);
        pedidoRepository.save(pedido);

        return nova;
    }

}
