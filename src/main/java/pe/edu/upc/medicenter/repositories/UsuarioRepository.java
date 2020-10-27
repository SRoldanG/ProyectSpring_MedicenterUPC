package pe.edu.upc.medicenter.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.medicenter.models.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{
	List<Usuario> findByNombresContaining(String nombres) throws Exception;
	Optional<Usuario> findByDNI(String dni) throws Exception;
}
