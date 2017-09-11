package br.com.cea.transporte.batch.sercdc.service;

import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cea.transporte.batch.rwms.model.DistribuicaoContinua;
import br.com.cea.transporte.batch.sercdc.model.PalletsModel;
import br.com.cea.transporte.batch.sercdc.repository.PalletsRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class PalletsService {

	@Autowired
	private PalletsRepository repository;

	private String retorno;

	@Transactional
	public void alterarRegistros(Long id) {
		// id = 928385L;
		PalletsModel model = this.repository.findOne(id);
		if (!(model.getId() == null)) {
			log.info("Dados da base: " + model);
			try {
				this.retorno = this.repository.pallets(model.getId(),
						model.getDestino() != null ? model.getDestino() : 0,
						model.getCajas() != null ? model.getCajas() : 0,
						model.getVolumenes() != null ? model.getVolumenes() : 0,
						model.getPiezas() != null ? model.getPiezas() : 0);
				log.info("Dados de " + model.getId() + " foram inseridos/atualidos com " + retorno);
			} catch (Exception e) {
				if (retorno.trim().equals("FALHA")) {
					log.info("Falha ao inserir/atualizar tabela T_RYE_PALLETS " + e.getMessage());
				}
			}
			log.info("Passou");
		}
	}

	@Transactional
	public void alterarRegistros(List<DistribuicaoContinua> listaContinua) {
		try {
			this.repository.atualizar(listaContinua);
		} catch (SQLException e) {
			log.info("Falha ao acessar a procedure:");
		}
	}
}
