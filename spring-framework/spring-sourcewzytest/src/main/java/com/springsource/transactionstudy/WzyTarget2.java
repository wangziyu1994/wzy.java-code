package com.springsource.transactionstudy;

import org.springframework.jdbc.core.JdbcTemplate;

public class WzyTarget2 {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void wzytargetMethod3(){
		System.out.println("进入事务WzyTargetMethod3方法");
		String sql = "update spring_tx set money=? where name=?";
		int updateFlag=jdbcTemplate.update(sql,99,"lancer");

			throw new RuntimeException("wzytargetMethod3事务异常");


	}
}
