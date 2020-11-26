package pe.edu.upc.MedicenterUPC.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.MedicenterUPC.models.entities.Especialista;
import pe.edu.upc.MedicenterUPC.repositories.EspecialistaRepository;
import pe.edu.upc.MedicenterUPC.services.EspecialistaService;

@Service
public class EspecialistaServiceImpl implements EspecialistaService,Serializable{
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private EspecialistaRepository especialistaRepository;

	@Transactional
	@Override
	public Especialista save(Especialista entity) throws Exception {
		// TODO Auto-generated method stub
		return especialistaRepository.save(entity);
	}

	@Transactional
	@Override
	public Especialista update(Especialista entity) throws Exception {
		// TODO Auto-generated method stub
		return especialistaRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		especialistaRepository.deleteById(id);
	}
	@Transactional(readOnly = true)
	@Override
	public List<Especialista> findAll() throws Exception {
		// TODO Auto-generated method stub
		return especialistaRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	@Override
	public Optional<Especialista> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return especialistaRepository.findById(id);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Especialista> findByNombres(String nombres) throws Exception {
		// TODO Auto-generated method stub
		return especialistaRepository.findByNombresContaining(nombres);
	}
}
