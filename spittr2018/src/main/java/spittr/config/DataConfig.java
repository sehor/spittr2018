package spittr.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages={"spittr.data"})
public class DataConfig {

	@Bean
	public DataSource dataSource(){
		
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.addScript("schema.sql")
				.build();
	}
	
	@Bean
	public JdbcOperations JdbcTemplate(DataSource dataSource){
		
		return new JdbcTemplate(dataSource);
	}
	
	
}
