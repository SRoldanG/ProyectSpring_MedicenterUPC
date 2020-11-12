package pe.edu.upc.MedicenterUPC.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.MedicenterUPC.models.entities.MedicamentosXClinica;
@Repository
public interface MedXclinicaRepository extends JpaRepository<MedicamentosXClinica,Integer>{

}
