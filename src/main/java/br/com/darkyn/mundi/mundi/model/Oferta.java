package br.com.darkyn.mundi.mundi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Table(name = "oferta")
@Entity
public class Oferta {

    @Id
    @SequenceGenerator(name = "idOferta_Sequence", sequenceName = "idOferta_Sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idOferta_Sequence")
    @Column(name = "ID")
    private Long id;

    private BigDecimal Valor;

    private LocalDate DataEntrega;

    private String comentario;

    @ManyToOne(fetch = FetchType.LAZY)
    private Pedido pedido;

}
