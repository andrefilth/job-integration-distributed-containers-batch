package br.com.cea.transporte.batch.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(	  entityManagerFactoryRef = "EntityManagerFactory"
						, transactionManagerRef = "TransactionManager"
						, basePackages = {"br.com.cea.transporte.batch.rwms.repository" })
public class RwmsDataBaseConfig {

	@Bean(name = "rwmDataSource")
	@ConfigurationProperties(prefix = "spring.bar.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create()
							    .build();
	}

	@Bean(name = "EntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean EntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("rwmDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource)
				      .packages("br.com.cea.transporte.batch.rwms.model")
				      .persistenceUnit("rwms")
				      .build();
	}

	@Bean(name = "TransactionManager")
	public PlatformTransactionManager TransactionManager(
			@Qualifier("EntityManagerFactory") EntityManagerFactory EntityManagerFactory) {
		return new JpaTransactionManager(EntityManagerFactory);
	}

}
