package br.com.cea.transporte.batch.rwms.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cea.transporte.batch.rwms.model.DistribuicaoContinua;
import br.com.cea.transporte.batch.rwms.repository.DistribuicaoContinuaRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class DistribuicaoContinuaService {

	@Autowired
	private DistribuicaoContinuaRepository repository;

	@Transactional
	public void consultar() {

		Iterable<DistribuicaoContinua> findAll = this.repository.findAll();
		log.info("Resultado: " +findAll);
	}
}
