package br.com.crudteste.springcrudteste.repository;

import br.com.crudteste.springcrudteste.entity.Desenvolvedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesenvolvedorRepository extends JpaRepository<Desenvolvedor, Long> {
}
