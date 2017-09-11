package br.com.cea.transporte.batch.reader;

import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cea.transporte.batch.rwms.model.DistribuicaoContinua;
import br.com.cea.transporte.batch.rwms.service.DistribuicaoContinuaService;
import br.com.cea.transporte.batch.sercdc.model.PalletsModel;
import br.com.cea.transporte.batch.sercdc.service.PalletsService;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class IntegrationDistributedItemReader implements ItemReader<PalletsModel> {

	@Autowired
	private PalletsService service;

	@Autowired
	private DistribuicaoContinuaService services;

	private boolean batchJobState = false;

	@Override
	public PalletsModel read() throws Exception {
		if (!batchJobState) {
			List<DistribuicaoContinua> listaContinua = this.services.consultar();
			if (listaContinua.size() == 0) {
				log.info("Não exitem dados para serem processados");
				return null;
			}

//			this.service.alterarRegistros(id);
			this.service.alterarRegistros(listaContinua);
			batchJobState = true;
			return new PalletsModel();
		}
		return null;
	}

}
