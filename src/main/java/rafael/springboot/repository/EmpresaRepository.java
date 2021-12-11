package rafael.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rafael.springboot.model.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa , Long> {

}
