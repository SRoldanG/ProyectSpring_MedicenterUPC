package pe.edu.upc.MedicenterUPC.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.medicenter.models.entities.Historial_Clinico;
import pe.edu.upc.medicenter.repositories.His_ClinicoRepository;
import pe.edu.upc.medicenter.services.His_ClinicoService;

@Service
public class His_ClinicoImpl implements His_ClinicoService,Serializable{
	
	  private static final long serialVersionUID = 1L;

	@Autowired
	private His_ClinicoRepository His_ClinicoRepository;
	 
	@Transactional
	@Override
	public Historial_Clinico save(Historial_Clinico entity) throws Exception {
		// TODO Auto-generated method stub
		return His_ClinicoRepository.save(entity);
	}
	
	
    @Transactional
	@Override
	public Historial_Clinico update(Historial_Clinico entity) throws Exception {
		// TODO Auto-generated method stub   	
		return His_ClinicoRepository.save(entity);
	}
   
    
    @Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
        His_ClinicoRepository.deleteById(id);	
    }
    
    
    
    @Transactional(readOnly = true)
	@Override
	public List<Historial_Clinico> findAll() throws Exception {
		// TODO Auto-generated method stub
		return His_ClinicoRepository.findAll();
	}
 
	@Transactional(readOnly = true)
	@Override
	public Optional<Historial_Clinico> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return His_ClinicoRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Historial_Clinico> findByCita(Integer idCita) throws Exception {
		// TODO Auto-generated method stub
		return His_ClinicoRepository.findByCita(idCita);
	}
	  
}
