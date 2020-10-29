package pe.edu.upc.medicenter.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.medicenter.models.entities.Receta;
import pe.edu.upc.medicenter.repositories.RecetaRepository;
import pe.edu.upc.medicenter.services.RecetaService;
@Service
public class RecetaServiceImpl implements Serializable, RecetaService {

	private static final long serialVersionUID = 1L;
	@Autowired
	private RecetaRepository recetaRepository;
	
	@Transactional
	@Override
	public Receta save(Receta entity) throws Exception {
		// TODO Auto-generated method stub
		return recetaRepository.save(entity);
	}
	@Transactional
	@Override
	public Receta update(Receta entity) throws Exception {
		// TODO Auto-generated method stub
		return recetaRepository.save(entity);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		recetaRepository.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Receta> findAll() throws Exception {
		// TODO Auto-generated method stub
		return recetaRepository.findAll();
	}
	@Transactional(readOnly = true)
	@Override
	public Optional<Receta> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return recetaRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Receta> findByHistorial(Integer idH_Clinico) throws Exception {
		// TODO Auto-generated method stub
		return recetaRepository.findByHistorial(idH_Clinico);
	}

}
