package br.com.cea.transporte.batch.sercdc.service;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.cea.transporte.batch.rwms.model.DistribuicaoContinua;
import br.com.cea.transporte.batch.sercdc.model.PalletsModel;
import br.com.cea.transporte.batch.sercdc.repository.PalletsRepository;
import lombok.extern.java.Log;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class PalletsServiceTest {

	private List<DistribuicaoContinua> list;

	@Autowired
	private PalletsRepository repository;

	@Autowired
	private PalletsService service;

	@Before
	public void init() {
		DistribuicaoContinua continua1 = new DistribuicaoContinua("1000", "10", 10, 10, 10, 10);
		DistribuicaoContinua continua2 = new DistribuicaoContinua("1001", "20", 20, 20, 20, 20);
		DistribuicaoContinua continua3 = new DistribuicaoContinua("1002", "30", 30, 30, 30, 30);
		DistribuicaoContinua continua4 = new DistribuicaoContinua("1003", "40", 40, 40, 40, 40);
		DistribuicaoContinua continua5 = new DistribuicaoContinua("1004", "50", 50, 50, 50, 50);
		DistribuicaoContinua continua6 = new DistribuicaoContinua("1005", "60", 60, 60, 60, 60);
		DistribuicaoContinua continua7 = new DistribuicaoContinua("1005", "60", 60, 60, 60, 60);
		DistribuicaoContinua continua8 = new DistribuicaoContinua("1005", "60", 60, 60, 60, 60);
		DistribuicaoContinua continua9 = new DistribuicaoContinua("1005", "60", 60, 60, 60, 60);
		DistribuicaoContinua continua10 = new DistribuicaoContinua("1005", "60", 60, 60, 60, 60);
		DistribuicaoContinua continua11 = new DistribuicaoContinua("1005", "60", 60, 60, 60, 60);
		DistribuicaoContinua continua12 = new DistribuicaoContinua("1005", "60", 60, 60, 60, 60);
		DistribuicaoContinua continua13 = new DistribuicaoContinua("1005", "60", 60, 60, 60, 60);
		DistribuicaoContinua continua14 = new DistribuicaoContinua("1005", "60", 60, 60, 60, 60);
		DistribuicaoContinua continua15 = new DistribuicaoContinua("1005", "60", 60, 60, 60, 60);
		DistribuicaoContinua continua16 = new DistribuicaoContinua("1005", "60", 60, 60, 60, 60);
		DistribuicaoContinua continua17 = new DistribuicaoContinua("1005", "60", 60, 60, 60, 60);
		DistribuicaoContinua continua18 = new DistribuicaoContinua("1005", "60", 60, 60, 60, 60);
		DistribuicaoContinua continua19 = new DistribuicaoContinua("1005", "60", 60, 60, 60, 60);
		DistribuicaoContinua continua20 = new DistribuicaoContinua("1005", "60", 60, 60, 60, 60);
		DistribuicaoContinua continua21 = new DistribuicaoContinua("1005", "60", 60, 60, 60, 60);
		DistribuicaoContinua continua22 = new DistribuicaoContinua("1005", "60", 60, 60, 60, 60);
		DistribuicaoContinua continua23 = new DistribuicaoContinua("1005", "60", 60, 60, 60, 60);
		DistribuicaoContinua continua24 = new DistribuicaoContinua("1005", "60", 60, 60, 60, 60);
		DistribuicaoContinua continua25 = new DistribuicaoContinua("1005", "60", 60, 60, 60, 60);
		DistribuicaoContinua continua26 = new DistribuicaoContinua("1005", "60", 60, 60, 60, 60);
		DistribuicaoContinua continua27 = new DistribuicaoContinua("1005", "60", 60, 60, 60, 60);
		DistribuicaoContinua continua28 = new DistribuicaoContinua("1005", "60", 60, 60, 60, 60);
		DistribuicaoContinua continua29 = new DistribuicaoContinua("1005", "60", 60, 60, 60, 60);
		DistribuicaoContinua continua30 = new DistribuicaoContinua("1005", "60", 60, 60, 60, 60);
		DistribuicaoContinua continua31 = new DistribuicaoContinua("1005", "60", 60, 60, 60, 60);
		DistribuicaoContinua continua32 = new DistribuicaoContinua("1005", "60", 60, 60, 60, 60);
		DistribuicaoContinua continua33 = new DistribuicaoContinua("1005", "60", 60, 60, 60, 60);
		DistribuicaoContinua continua34 = new DistribuicaoContinua("1005", "60", 60, 60, 60, 60);
		DistribuicaoContinua continua35 = new DistribuicaoContinua("1005", "60", 60, 60, 60, 60);
		DistribuicaoContinua continua36 = new DistribuicaoContinua("1005", "60", 60, 60, 60, 60);
		DistribuicaoContinua continua37 = new DistribuicaoContinua("1005", "60", 60, 60, 60, 60);
		DistribuicaoContinua continua38 = new DistribuicaoContinua("1005", "60", 60, 60, 60, 60);

		this.list = Arrays.asList(continua1, continua2, continua3, continua4, continua5, continua6, continua7,
				continua8, continua9, continua10, continua11, continua12, continua13, continua14, continua15,
				continua16, continua17, continua18, continua19, continua20, continua21, continua22, continua23,
				continua24, continua25, continua26, continua27, continua28, continua29, continua30, continua31,
				continua32, continua33, continua34, continua35, continua36, continua37, continua38);
		log.info("Dados inseridos na lista: " + list);
	}

	@Test
	@Ignore
	public void executarProcedureInserindoDadosComSucesso() {
		long inicio = System.currentTimeMillis();
		log.info("Início: " + inicio);
		int errorCode = 0;
		log.info("Teste de inserção de dados");
		try {
			this.repository.atualizar(list);
		} catch (SQLException e) {
			errorCode = e.getErrorCode();
		}
		long fim = System.currentTimeMillis();
		log.info("Fim: " + fim);
		assertEquals(errorCode, 0);
		log.info("Tempo de execução do método executarProcedureInserindoDadosComSucesso: "  );
		tempoExecucao(inicio, fim);

	}

	@Test
	@Ignore
	public void executarProcedureAtualizandoDadosComSucesso() {
		long inicio = System.currentTimeMillis();
		Date dataSemHoras = this.zerarHoras(new Date());
		log.info("Data: " + dataSemHoras);

		List<PalletsModel> ultimo2 = this.repository.findByFecEnvioIsAfter(dataSemHoras);
		log.info("total de registros que serão apagados: " + ultimo2.size());

		ultimo2.forEach(listas -> {
			this.repository.deleteInBatch(ultimo2);
		});
		long fim = System.currentTimeMillis();

		List<PalletsModel> ultimo3 = this.repository.findByFecEnvioIsAfter(dataSemHoras);
		log.info("total de registros apagados: " + ultimo3.size());
		log.info("Tempo de execução do método executarProcedureAtualizandoDadosComSucesso: "  );
		tempoExecucao(inicio, fim);
	}

	private void tempoExecucao(long inicio, long fim) {
		log.info("Tempo de execução: " + new SimpleDateFormat("mm:ss").format(new Date(fim - inicio)));
	}

	private Date zerarHoras(Date data) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
}
