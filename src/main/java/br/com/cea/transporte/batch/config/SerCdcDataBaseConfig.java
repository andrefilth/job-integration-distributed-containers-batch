package br.com.cea.transporte.batch.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "serEntityManagerFactory"
					 , transactionManagerRef = "serTransactionManager"
					 , basePackages = {	"br.com.cea.transporte.batch.sercdc.repository" })
public class SerCdcDataBaseConfig {

	@Primary
	@Bean(name = "dataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "serEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean serEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("dataSource") DataSource dataSource) {
		
		return builder.dataSource(dataSource)
				      .packages("br.com.cea.transporte.batch.sercdc.model")
				      .persistenceUnit("sercdc")
				      .build();
	}

	@Primary
	@Bean(name = "serTransactionManager")
	public PlatformTransactionManager serTransactionManager(
			@Qualifier("serEntityManagerFactory") EntityManagerFactory serEntityManagerFactory) {
		return new JpaTransactionManager(serEntityManagerFactory);
	}

}
