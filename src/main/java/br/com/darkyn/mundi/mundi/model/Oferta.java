package br.com.darkyn.mundi.mundi.model;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private BigDecimal Valor;

    private LocalDate DataDaEntrega;

    private String comentario;

    @ManyToOne(fetch = FetchType.LAZY)
    private Pedido pedido;

}
