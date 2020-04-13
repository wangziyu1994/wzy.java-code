package wang;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

@Configuration
@MapperScan(basePackages= {"com.wang.mapper"},sqlSessionTemplateRef="st1")
public class MyDataSource {

	
	
	@Bean(name="dt1")
	@ConfigurationProperties(prefix="spring.datasource.druid.data1")
	public DruidDataSource  getDruidDataSource() throws Exception {
		return DruidDataSourceBuilder.create().build();
	}
	
	
	@Bean(name="sqlSessionFactory1")
	public SqlSessionFactory  getSqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(getDruidDataSource());
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean(name="st1")
	public SqlSessionTemplate getSqlSessionTemplate () throws Exception {
		return new SqlSessionTemplate(getSqlSessionFactory());
	}
	
	
}
