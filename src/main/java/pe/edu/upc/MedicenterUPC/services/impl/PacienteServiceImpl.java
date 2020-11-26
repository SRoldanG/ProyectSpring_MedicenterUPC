package pe.edu.upc.MedicenterUPC.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.MedicenterUPC.models.entities.Paciente;
import pe.edu.upc.MedicenterUPC.repositories.PacienteRepository;
import pe.edu.upc.MedicenterUPC.services.PacienteService;
@Service
public class PacienteServiceImpl implements PacienteService,Serializable{

	private static final long serialVersionUID = 1L;
	@Autowired
	private PacienteRepository pacienteRepository;

	@Transactional
	@Override
	public Paciente save(Paciente entity) throws Exception {
		// TODO Auto-generated method stub
		return pacienteRepository.save(entity);
	}

	@Transactional
	@Override
	public Paciente update(Paciente entity) throws Exception {
		// TODO Auto-generated method stub
		return pacienteRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		pacienteRepository.deleteById(id);
	}
	@Transactional(readOnly = true)
	@Override
	public List<Paciente> findAll() throws Exception {
		// TODO Auto-generated method stub
		return pacienteRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	@Override
	public Optional<Paciente> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return pacienteRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Paciente> findByNombresStartingWith(String nombres) throws Exception {
		// TODO Auto-generated method stub
		return pacienteRepository.findByNombresStartingWith(nombres);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Paciente> findByDni(String dni) throws Exception {
		// TODO Auto-generated method stub
		return pacienteRepository.findByDni(dni);
	}
	
	

}
