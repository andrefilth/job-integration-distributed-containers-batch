package br.com.cea.transporte.batch.processor;

import org.springframework.batch.item.ItemProcessor;

import br.com.cea.transporte.batch.sercdc.model.PalletsModel;

public class IntegrationDistributedProcessor implements ItemProcessor<PalletsModel, PalletsModel> {

	@Override
	public PalletsModel process(PalletsModel item) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
