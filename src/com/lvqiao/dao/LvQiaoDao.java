package com.lvqiao.dao;

import java.util.ArrayList;
import java.util.List;

import com.lvqiao.model.StudentType;
import com.lvqiao.util.JdbcUtil;;
//import top.xu.util.JdbcUtil;

public class LvQiaoDao {
	
	JdbcUtil jdbc = new JdbcUtil();
	
	public void insertType(String tname,String tdesc){
		
		String sql = "insert into tb_type value(null,?,?)";
		
		jdbc.updatePreparedStatement(sql,tname,tdesc);
	}
	
	/*public List<BookType> querybookType(String tname){
		String sql = "select * from tb_type where 1=1 ";
		List params = new ArrayList();
		if(tname!=null&&!tname.equals("")){
			params.add(tname);
			sql+=" and tname=?";
		}
		List<BookType> types = jdbc.queryPreparedStatement(sql,BookType.class,params);
		return types;
	}*/
	public void updatestuTable(String tid,String tname,String tdesc) {
		String sql = "update tb_type set tname=?,tdesc=? where tid=?";
		jdbc.updatePreparedStatement(sql, tname,tdesc,tid);
	}
	public void updateuserTable(String tid,String tname,String tdesc) {
		String sql = "update tb_type set tname=?,tdesc=? where tid=?";
		jdbc.updatePreparedStatement(sql, tname,tdesc,tid);
	}
	public List<StudentType> querystudentType(String tname){
		String sql = "select * from t_student where 1=1 ";
		List params = new ArrayList();
		if(tname!=null&&!tname.equals("")){
			params.add(tname);
			sql+=" and tname=?";
		}
		List<StudentType> types = jdbc.queryPreparedStatement(sql,StudentType.class,params);
		return types;  
}
}
