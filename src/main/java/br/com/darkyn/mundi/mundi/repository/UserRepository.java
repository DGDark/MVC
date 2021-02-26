package br.com.darkyn.mundi.mundi.repository;

import br.com.darkyn.mundi.mundi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

    User findByUserName(String username);
}
