package br.com.darkyn.mundi.mundi.dto;

import br.com.darkyn.mundi.mundi.model.Pedido;
import br.com.darkyn.mundi.mundi.model.StatusPedido;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RequisicaoNovoPedido {

    @NotBlank
    private String nomeProduto;

    @NotBlank
    private String urlProduto;

    @NotBlank
    private String urlImg;


    private String descricao;


    public Pedido toPedido(){
        Pedido pedido = new Pedido();
        pedido.setDescricao(descricao);
        pedido.setNomeProduto(nomeProduto);
        pedido.setUrlImg(urlImg);
        pedido.setUrlProduto(urlProduto);
        pedido.setStatus(StatusPedido.AGUARDANDO);
        return pedido;
    }
}
