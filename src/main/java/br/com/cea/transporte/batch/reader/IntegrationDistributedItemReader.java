package br.com.cea.transporte.batch.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cea.transporte.batch.rwms.service.DistribuicaoContinuaService;
import br.com.cea.transporte.batch.sercdc.model.PalletsModel;
import br.com.cea.transporte.batch.sercdc.service.PalletsService;

public class IntegrationDistributedItemReader implements ItemReader<PalletsModel> {

	@Autowired
	private PalletsService service;
	
	@Autowired
	private DistribuicaoContinuaService services;
	@Autowired
//	@Qualifier("datasource")
//	private DataSource source;

	@Override
	public PalletsModel read() throws Exception {
		
		Long id = 928385L;
		this.services.consultar();
		this.service.alterarRegistros(id);
		return null;
	}

}
