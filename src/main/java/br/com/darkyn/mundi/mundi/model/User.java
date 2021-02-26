package br.com.darkyn.mundi.mundi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private Boolean enabled;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private List<Pedido> pedidos;

}
