package br.com.cea.transporte.batch.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cea.transporte.integration.distributed.service.PalletsService;

public class IntegrationDistributedItemReader implements ItemReader<Object> {

	@Autowired
	private PalletsService service;

	@Override
	public Object read() throws Exception {
		
		Long id = 928385L;
		this.service.alterarRegistros(id);
		return null;
	}

}
