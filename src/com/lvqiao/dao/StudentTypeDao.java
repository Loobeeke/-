package com.lvqiao.dao;

import java.util.ArrayList;

import java.util.List;

import com.lvqiao.model.ClassType;
import com.lvqiao.model.ReaderType;
import com.lvqiao.model.StudentType;
import com.lvqiao.model.TeacerType;
import com.lvqiao.util.*;
public class StudentTypeDao {
	static String stucount;
	JdbcUtil jdbc = new JdbcUtil();
	
	
	public List<StudentType> querystuType(String tname){
		String sql = "select s_id,s_name,s_cno,s_teacher from t_student where 1=1 ";
		List params = new ArrayList();
		if(tname!=null&&!tname.equals("")){
			params.add(tname);
			sql+=" and s_name= ?";
		}
		List<StudentType> types = jdbc.queryPreparedStatement(sql,StudentType.class,params);
		return types;
	}
	
	public List<StudentType> querystudentType(String tname){
		String sql = "select s_name,s_cno,s_number,s_teacher from t_student where s_name=? ";
		List params = new ArrayList();
		List<StudentType> types =jdbc.queryPreparedStatement(sql,StudentType.class, tname);
		return types;
	}
	
	
	
	public List<ClassType> queryclaType(String tname){
		String sql = "select c_id, c_name, c_time, c_teacher, c_site from t_class where 1=1 ";
		List params = new ArrayList();
		if(tname!=null&&!tname.equals("")){
			params.add(tname);
			sql+=" and c_name= ?";
		}
		List<ClassType> types = jdbc.queryPreparedStatement(sql,ClassType.class,params);
		return types;
	}
	
	public List<TeacerType> queryteaType(String tname){
		String sql = "select tid, t_name, t_phone, t_class from t_teacher where 1=1 ";
		List params = new ArrayList();
		if(tname!=null&&!tname.equals("")){
			params.add(tname);
			sql+=" and c_name= ?";
		}
		List<TeacerType> types = jdbc.queryPreparedStatement(sql,TeacerType.class,params);
		return types;
	}
	
	public List<ReaderType> queryreaType(String tname){
		String sql = "select id, title, content, from_name from t_from_mes where 1=1 ";
		List params = new ArrayList();
		if(tname!=null&&!tname.equals("")){
			params.add(tname);
			sql+=" and title= ?";
		}
		List<ReaderType> types = jdbc.queryPreparedStatement(sql,ReaderType.class,params);
		return types;
	}
	
	
	public void updatebookTable(String tid,String tname,String tdesc) {
		String sql = "update tb_type set tname=?,tdesc=? where tid=?";
		jdbc.updatePreparedStatement(sql, tname,tdesc,tid);
	}
	public void updatestuTable(String tname,String tcno,String tphone,String tteacher) {
		String sql = "update t_student set s_cno=?,s_number=?,s_teacher=? where s_name=?";
		jdbc.updatePreparedStatement(sql, tcno,tphone,tteacher,tname);
	}
	public void updatestudentTable(String aid,String aname,String cno,String atea) {
		String sql = "update t_student set s_id=?,s_cno=?,s_teacher=? where s_name=?";
		jdbc.updatePreparedStatement(sql, aid,cno,atea,aname);
	}
	
	public void updatereaTable(String tid,String ttile,String tcontent,String tname) {
		String sql = "update t_from_mes set title=?,content=?,from_name=? where id=?";
		jdbc.updatePreparedStatement(sql, ttile,tcontent,tname,tid);
	}
	
	public void updateclaTable(String rid,String aname,String atea,String atime,String asite) {
		String sql = "update t_class set c_name=?,c_teacher=?,c_time=? ,c_site=? where c_id=?";
		jdbc.updatePreparedStatement(sql, aname,atea,atime,asite,rid);
	}
	
	public void stucount() {
		String sql = "SELECT count(1) AS count FROM t_student";
		
	}
	
	public void delrea(String tname) {
		String sql = "delete from t_from_mes where title=?";
		jdbc.updatePreparedStatement(sql, tname);
	}
	public void delcla(String tname) {
		String sql = "delete from t_class where c_name=?";
		jdbc.updatePreparedStatement(sql, tname);
	}
	public void delstu(String tname) {
		String sql = "delete from t_student where s_name=?";
		jdbc.updatePreparedStatement(sql, tname);
	}
}
