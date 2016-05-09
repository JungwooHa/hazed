package org.zerock.persistence;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;

public class TimeDAO {

	@Inject
	private DataSource ds;
	
	private SqlSessionTemplate session;

	public void setDs(DataSource ds) {
		this.ds = ds;
	}

	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
	
	
	
}
