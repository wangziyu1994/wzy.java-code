package com.springsource.annotationstudy.configurationstudy;

import com.springsource.annotationstudy.BeanMethodModel;
import com.springsource.annotationstudy.MyCondition;
import com.springsource.annotationstudy.Parent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Configuration
@PropertySource(value = {"classpath:MyPropertySource.properties"})
@ComponentScan(basePackages = {"com.springsource.annotationstudy.componentscanstudy"})
public class ConfigurationModel extends Parent {

@Value(value = "myname")
	private String name;
@Value(value="myage")
	private String age;

@Bean(name = "MyBeanMethodModel")
public BeanMethodModel getParentMethod(){
	return new BeanMethodModel("Bean方法创建的",1);
}


	@Component
	@Conditional(MyCondition.class)
	public class CmInnerModel1{
		private int id;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
	}
	@Component
	public class CmInnerModel2{
      private int id;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
}
