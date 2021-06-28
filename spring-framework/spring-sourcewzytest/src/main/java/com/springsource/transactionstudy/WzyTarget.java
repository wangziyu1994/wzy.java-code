package com.springsource.transactionstudy;

import org.springframework.jdbc.core.JdbcTemplate;

public class WzyTarget {
	private WzyTarget2 wzyTarget2;

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public WzyTarget2 getWzyTarget2() {
		return wzyTarget2;
	}

	public void setWzyTarget2(WzyTarget2 wzyTarget2) {
		this.wzyTarget2 = wzyTarget2;
	}

	public void wzytargetMethod1() throws Exception {
		System.out.println("进入事务WzyTargetMethod1方法");
		String sql = "update spring_tx set money=? where name=?";
		jdbcTemplate.update(sql,99,"saber");
		throw new RuntimeException("wzytargetMethod1事务异常");
	}


	public void wzytargetMethod2(){
		System.out.println("进入事务WzyTargetMethod2方法");
		String sql = "update spring_tx set money=? where name=?";
		int updateFlag=jdbcTemplate.update(sql,99,"archer");
		try {
			wzyTarget2.wzytargetMethod3();
		}
		catch (Exception e){
			System.out.println("捕捉内层异常");
			e.printStackTrace();
		}
		//throw new RuntimeException("wzytargetMethod2事务异常");
	}




}
