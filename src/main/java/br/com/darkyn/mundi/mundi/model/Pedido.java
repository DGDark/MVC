package br.com.darkyn.mundi.mundi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Table(name = "pedidos")
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome_produto")
    private String nomeProduto;

    @Column(name = "valor_negociado")
    private BigDecimal valorNegociado;

    @Column(name = "data_entrega")
    private LocalDate dataEntrega;

    @Column(name = "url_produto")
    private String urlProduto;

    @Column(name = "url_img")
    private String urlImg;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "status_pedido")
    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Oferta> ofertas;

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }
}
