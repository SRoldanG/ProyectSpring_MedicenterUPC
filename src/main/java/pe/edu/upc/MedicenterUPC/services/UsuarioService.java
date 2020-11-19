package pe.edu.upc.MedicenterUPC.services;

import java.util.Optional;

import pe.edu.upc.MedicenterUPC.models.entities.Usuario;

public interface UsuarioService extends CrudService<Usuario, Long> {
	Optional<Usuario> findByUsername( String username ) throws Exception;
}
