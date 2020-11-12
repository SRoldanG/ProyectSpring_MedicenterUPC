package pe.edu.upc.MedicenterUPC.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.MedicenterUPC.models.entities.MedicamentosXClinica;
import pe.edu.upc.MedicenterUPC.repositories.MedXclinicaRepository;
import pe.edu.upc.MedicenterUPC.services.MedXClinicaService;

@Service
public class MedXClinicaServiceImpl implements MedXClinicaService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private MedXclinicaRepository medRepository;
	@Transactional
	@Override
	public MedicamentosXClinica save(MedicamentosXClinica entity) throws Exception {
		// TODO Auto-generated method stub
		return medRepository.save(entity);
	}
	@Transactional(readOnly = true)
	@Override
	public MedicamentosXClinica update(MedicamentosXClinica entity) throws Exception {
		// TODO Auto-generated method stub
		return medRepository.save(entity);
	}
	@Transactional(readOnly = true)
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		medRepository.deleteById(id);
	}
	@Transactional(readOnly = true)
	@Override
	public List<MedicamentosXClinica> findAll() throws Exception {
		// TODO Auto-generated method stub
		return medRepository.findAll();
	}
	@Transactional(readOnly = true)
	@Override
	public Optional<MedicamentosXClinica> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return medRepository.findById(id);
	}
	

}
