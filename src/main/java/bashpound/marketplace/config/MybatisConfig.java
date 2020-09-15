package bashpound.marketplace.config;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class MybatisConfig {
	
	 @Autowired
	    private ApplicationContext applicationContext;
	    
	    @Bean
	    public DriverManagerDataSource dataSource() {
	        DriverManagerDataSource source = new DriverManagerDataSource();
	        source.setDriverClassName("com.mysql.cj.jdbc.Driver");
	        // 자바 설정으로 쓸 때에는 url에 &을 &amp; 로 치환하면 에러나더라.        
	        source.setUrl("jdbc:mysql://localhost:3306/test_db?serverTimezone=UTC&useSSL=false");
	        source.setUsername("user01");
	        source.setPassword("1234");
	        
	        return source;
	    }
	    
	    @Bean
	    public SqlSessionFactory sqlSessionFactory() throws Exception {
	        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
	        sqlSessionFactoryBean.setDataSource(dataSource());
	        sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:mybatis/config/mybatis-config.xml"));
	        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mybatis/mapper/*.xml"));
	        
	        return sqlSessionFactoryBean.getObject();
	    }
	    
	    
	    @Bean
	    public SqlSession sqlSession() throws Exception {
	        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
	        return sqlSessionTemplate;
	    }
	
}
