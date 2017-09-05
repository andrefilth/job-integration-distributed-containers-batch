package br.com.cea.transporte.integration.distributed.repository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.cea.transporte.integration.distributed.model.PalletsModel;

@Repository
public interface PalletsRepository extends CrudRepository<PalletsModel, Long> {

//	Optional<PalletsModel> findById(Long id);
	
	@Procedure(name = "pallets", procedureName = "sp_update_t_rye_pallets")
	String pallets(Long id, Integer sucDestino, Integer cajas, Integer unidades, Integer piezas);

//	@Procedure(name = "viajes", procedureName = "SP_UPDATE_T_RYE_VIAJES")
//	VoltaModel viajes(String nome, Integer idade);

}
