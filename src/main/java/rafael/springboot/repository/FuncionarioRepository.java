package rafael.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rafael.springboot.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario , Long> {

}
