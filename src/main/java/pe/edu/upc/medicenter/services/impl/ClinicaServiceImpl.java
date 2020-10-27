package pe.edu.upc.medicenter.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.medicenter.models.entities.Clinica;
import pe.edu.upc.medicenter.repositories.ClinicaRepository;
import pe.edu.upc.medicenter.services.ClinicaService;


@Service
public class ClinicaServiceImpl implements ClinicaService,Serializable{
	
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private ClinicaRepository clinicaRepository;

	@Transactional
	@Override
	public Clinica save(Clinica entity) throws Exception {
		// TODO Auto-generated method stub
		return clinicaRepository.save(entity);
	}

	@Transactional
	@Override
	public Clinica update(Clinica entity) throws Exception {
		// TODO Auto-generated method stub
		return clinicaRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		clinicaRepository.deleteById(id);
	}
	@Transactional(readOnly = true)
	@Override
	public List<Clinica> findAll() throws Exception {
		// TODO Auto-generated method stub
		return clinicaRepository.findAll();
	}
	@Transactional(readOnly = true)
	@Override 
	public List<Clinica> findByNombre(String nombres) throws Exception {
		// TODO Auto-generated method stub
		return clinicaRepository.findByNombreContaining(nombres);
	}
	@Transactional(readOnly = true)
	@Override
	public List<Clinica> findByUbicacion(String ubicacion) throws Exception {
		// TODO Auto-generated method stub
		return clinicaRepository.findByUbicacionContaining(ubicacion);
	}
	@Transactional(readOnly = true)
	@Override
	public Optional<Clinica> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return clinicaRepository.findById(id);
	}
}
