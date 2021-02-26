package br.com.darkyn.mundi.mundi.repository;

import br.com.darkyn.mundi.mundi.model.Pedido;
import br.com.darkyn.mundi.mundi.model.StatusPedido;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Cacheable("pedidos")
    List<Pedido> findByStatus(StatusPedido aguardando, Pageable sort);

    @Query(value = "SELECT * FROM pedidos WHERE user_username = :username", nativeQuery = true)
    List<Pedido> findAllByUsuario(@Param("username") String username);

    @Query(value = "SELECT * FROM pedidos WHERE user_username = :username AND STATUS_PEDIDO = :status", nativeQuery = true)
    List<Pedido> findByStatusUsuario(@Param("status")StatusPedido status, @Param("username")String username);
}


