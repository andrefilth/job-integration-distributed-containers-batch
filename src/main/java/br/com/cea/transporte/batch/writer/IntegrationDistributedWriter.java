package br.com.cea.transporte.batch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import br.com.cea.transporte.batch.sercdc.model.PalletsModel;

public class IntegrationDistributedWriter implements ItemWriter<PalletsModel> {

	@Override
	public void write(List<? extends PalletsModel> items) throws Exception {
		// TODO Auto-generated method stub

	}

}
