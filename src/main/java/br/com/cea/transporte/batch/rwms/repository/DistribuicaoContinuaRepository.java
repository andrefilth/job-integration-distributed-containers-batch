package br.com.cea.transporte.batch.rwms.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.cea.transporte.batch.rwms.model.DistribuicaoContinua;

@Repository
@Transactional
public interface DistribuicaoContinuaRepository extends CrudRepository<DistribuicaoContinua, Integer> {

}
