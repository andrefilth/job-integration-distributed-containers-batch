package br.com.cea.transporte.batch.sercdc.repository;

import java.sql.SQLException;
import java.util.List;

import br.com.cea.transporte.batch.rwms.model.DistribuicaoContinua;

public interface PalletsRepositoryCustom {
	
	void atualizar(List<DistribuicaoContinua> list) throws SQLException;

}
