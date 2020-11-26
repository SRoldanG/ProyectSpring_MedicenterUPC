package pe.edu.upc.MedicenterUPC.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import pe.edu.upc.MedicenterUPC.models.entities.Especialidad;
import pe.edu.upc.MedicenterUPC.repositories.EspecialidadRepository;

import pe.edu.upc.MedicenterUPC.services.EspecialidadService;
import pe.edu.upc.MedicenterUPC.utils.Segmento;

@Service
public class EspecialidadServiceImpl implements EspecialidadService, Serializable {
	
	private static final long serialVersionUID= 1L;
	@Autowired
	private EspecialidadRepository especialidadRepository;
	
	
    @Transactional
	@Override
	public Especialidad save(Especialidad entity) throws Exception {
		// TODO Auto-generated method stub
		return especialidadRepository.save(entity) ;
	}

	@Transactional
	@Override
	public Especialidad update(Especialidad entity) throws Exception {
		// TODO Auto-generated method stub
		return especialidadRepository.save(entity);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub

		especialidadRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Especialidad> findAll() throws Exception {
		// TODO Auto-generated method stub
		return especialidadRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Especialidad> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return especialidadRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Especialidad> findByNombres(String nombres) throws Exception {
		// TODO Auto-generated method stub

		return especialidadRepository.findByNombresStartingWith(nombres);

		return especialidadRepository.findByNombreStartingWith(nombres);

	}


//	public Optional<Especialidad> findById(Segmento segmento) {
//		
//		return null;
	

}
