package br.com.darkyn.mundi.mundi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Table(name = "ofertas")
@Entity
public class Oferta {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "idOferta_Sequence", sequenceName = "idOferta_Sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idOferta_Sequence")
    @Column(name = "ID")
    private Long id;

    private BigDecimal Valor;

    private LocalDate DataDaEntrega;

    private String comentario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Pedido pedido;

}
