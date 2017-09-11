package br.com.cea.transporte.batch.sercdc.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import br.com.cea.transporte.batch.sercdc.model.PalletsModel;

@Repository
public interface PalletsRepository extends JpaRepository<PalletsModel, Long>,PalletsRepositoryCustom {

	@Procedure(name = "pallets", procedureName = "sp_update_t_rye_pallets")
	String pallets(Long id, Integer sucDestino, Integer cajas, Integer unidades, Integer piezas);
	
	List<PalletsModel> findByFecEnvioIsAfter(Date fecenvio);
	

}
