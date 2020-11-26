package pe.edu.upc.MedicenterUPC.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.MedicenterUPC.models.entities.Medicamento;
import pe.edu.upc.MedicenterUPC.repositories.MedicamentoRepository;
import pe.edu.upc.MedicenterUPC.services.MedicamentosService;

@Service
public class MedicamentoServiceImpl implements MedicamentosService, Serializable{

	private static final long serialVersionUID = 1L;

	@Autowired
	private MedicamentoRepository medRepository;
	@Transactional
	@Override
	public Medicamento save(Medicamento entity) throws Exception {
		// TODO Auto-generated method stub
		return medRepository.save(entity);
	}
	@Transactional
	@Override
	public Medicamento update(Medicamento entity) throws Exception {
		// TODO Auto-generated method stub
		return medRepository.save(entity);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		medRepository.deleteById(id);
	}
    @Transactional(readOnly = true)
	@Override
	public List<Medicamento> findAll() throws Exception {
		// TODO Auto-generated method stub
		return medRepository.findAll();
	}
    @Transactional(readOnly = true)
	@Override
	public Optional<Medicamento> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return medRepository.findById(id);
	}
    
    @Transactional(readOnly = true)
	@Override
	public List<Medicamento> findByNombre(String nombre) throws Exception {
		// TODO Auto-generated method stub
		return medRepository.findByNombreStartingWith(nombre);
	}

}
