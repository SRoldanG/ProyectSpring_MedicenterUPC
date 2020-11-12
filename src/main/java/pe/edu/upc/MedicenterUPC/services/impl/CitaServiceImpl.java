package pe.edu.upc.MedicenterUPC.services.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.MedicenterUPC.models.entities.Cita;
import pe.edu.upc.MedicenterUPC.repositories.CitaRepository;
import pe.edu.upc.MedicenterUPC.services.CitaService;

@Service
public class CitaServiceImpl implements Serializable, CitaService {

	private static final long serialVersionUID = 1L;
	@Autowired
	private CitaRepository citaRepository;
	
	@Transactional
	@Override
	public Cita save(Cita entity) throws Exception {
		// TODO Auto-generated method stub
		return citaRepository.save(entity);
	}
	@Transactional
	@Override
	public Cita update(Cita entity) throws Exception {
		// TODO Auto-generated method stub
		return citaRepository.save(entity);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		citaRepository.deleteById(id);
	}
	@Transactional(readOnly = true)
	@Override
	public List<Cita> findAll() throws Exception {
		// TODO Auto-generated method stub
		return citaRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	@Override
	public Optional<Cita> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return citaRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Cita> findByPacientes(Integer paciente) throws Exception {
		// TODO Auto-generated method stub
		return citaRepository.findByPacienteContaining(paciente);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Cita> findByEspecialista(Integer especialista) throws Exception {
		// TODO Auto-generated method stub
		return citaRepository.findByEspecialistaContaining(especialista);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Cita> findByFecha(Date fecha) throws Exception {
		// TODO Auto-generated method stub
		return citaRepository.findByFechaContaining(fecha);
	}
	
}
