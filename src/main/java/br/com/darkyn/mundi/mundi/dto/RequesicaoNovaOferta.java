package br.com.darkyn.mundi.mundi.dto;

import br.com.darkyn.mundi.mundi.model.Oferta;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class RequesicaoNovaOferta {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Long PedidoId;

    private String Valor;

    private String DataDaEntrega;

    private String comentario;


    public Oferta toOferta() {
        Oferta oferta = new Oferta();
        oferta.setComentario(this.comentario);
        oferta.setDataDaEntrega(LocalDate.parse(this.getDataDaEntrega(), formatter));
        oferta.setValor(new BigDecimal(this.Valor));
        return oferta;
    }
}
