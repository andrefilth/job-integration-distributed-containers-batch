package br.com.cea.transporte.batch.sercdc.repository.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import br.com.cea.transporte.batch.rwms.model.DistribuicaoContinua;
import br.com.cea.transporte.batch.sercdc.repository.PalletsRepositoryCustom;
import br.com.cea.transporte.batch.sercdc.repository.QuerysRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class PalletsRepositoryImpl implements PalletsRepositoryCustom {

	@Autowired
	private JdbcTemplate template;

	@Override
	public void atualizar(List<DistribuicaoContinua> list) throws SQLException {
		Connection connection = this.template.getDataSource().getConnection();
		CallableStatement call = connection.prepareCall(QuerysRepository.PROCEDURE_PALLETS);
		list.forEach(listas -> {
			try {
				call.setInt(1, Integer.valueOf(listas.getFacilityId()));
				call.setInt(2, Integer.valueOf(listas.getDestID()));
				call.setInt(3, listas.getContQty());
				call.setInt(4, listas.getUnitQty());
				call.setInt(5, listas.getPiecesQty());
				call.addBatch();
			} catch (SQLException e) {
				log.error("Falha ao passar parametros para a procedure: " + listas);
//				throw new RuntimeException("Falha ao executar atualização de banco de dados:");
			}

		});
		call.executeBatch();
		call.close();

	}

}
