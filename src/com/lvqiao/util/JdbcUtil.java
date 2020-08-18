package com.lvqiao.util;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.swing.JTextArea;

import com.lvqiao.model.StudentType;

public class JdbcUtil {
	
	private static Connection conn=null;
	private PreparedStatement pstm=null;
	private ResultSet rs=null;
	private static final String classname = "com.mysql.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/manager_lvqiao?characterEncoding=utf-8";/**/
	private static final String username="root";
	private static final String password="root";
	private PreparedStatement sql;
    private ResultSet resultSet;
	private StudentType pstms;
	static{
		try {
			Class.forName(classname);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public static  Connection getConn(){
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	//管理员登录验证
	public boolean Select(String user, String pass) throws SQLException, ClassNotFoundException {
		conn = this.getConn();
        sql = conn.prepareStatement("select *from manager_lvqiao.t_user");
        int flag = 0;
        try {
            resultSet = sql.executeQuery();
            while (resultSet.next()) {
                String username = resultSet.getString("t_name");
                String passWord = resultSet.getString("t_psd");
                if (user.equals(username) && pass.equals(passWord))
                    flag = 1;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        if (flag == 1)
            return true;
        else
            return false;
    }
	//学生添加验证
	public boolean Selectadd(String user) throws SQLException, ClassNotFoundException {
		conn = this.getConn();
        sql = conn.prepareStatement("select *from manager_lvqiao.t_user");
        int flag = 0;
        try {
            resultSet = sql.executeQuery();
            while (resultSet.next()) {
                String username = resultSet.getString("t_name");
                String passWord = resultSet.getString("t_psd");
                if (user.equals(username))
                    flag = 1;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        if (flag == 1)
            return true;
        else
            return false;
    }
	
	//课程添加验证
		public boolean SelectCla(String user) throws SQLException, ClassNotFoundException {
			conn = this.getConn();
	        sql = conn.prepareStatement("select *from manager_lvqiao.t_class");
	        int flag = 0;
	        try {
	            resultSet = sql.executeQuery();
	            while (resultSet.next()) {
	                String username = resultSet.getString("c_name");
	                if (user.equals(username))
	                    flag = 1;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();

	        }
	        if (flag == 1)
	            return true;
	        else
	            return false;
	    }
		//留言添加验证
		public boolean SelectRea(String title) throws SQLException, ClassNotFoundException {
			conn = this.getConn();
	        sql = conn.prepareStatement("select *from manager_lvqiao.t_from_mes");
	        int flag = 0;
	        try {
	            resultSet = sql.executeQuery();
	            while (resultSet.next()) {
	                String title0 = resultSet.getString("title");
	                if (title.equals(title0))
	                    flag = 1;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();

	        }
	        if (flag == 1)
	            return true;
	        else
	            return false;
	    }
		
		//回复留言验证
		public boolean SelectReRea(String title) throws SQLException, ClassNotFoundException {
			conn = this.getConn();
	        sql = conn.prepareStatement("select *from manager_lvqiao.t_to_mes");
	        int flag = 0;
	        try {
	            resultSet = sql.executeQuery();
	            while (resultSet.next()) {
	                String title0 = resultSet.getString("title");
	                if (title.equals(title0))
	                    flag = 1;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();

	        }
	        if (flag == 1)
	            return true;
	        else
	            return false;
	    }
		
	
	//学生登录验证
		public boolean Selectstu(String user, String pass) throws SQLException, ClassNotFoundException {
			conn = this.getConn();
	        sql = conn.prepareStatement("select *from manager_lvqiao.t_student");
	        int flag = 0;
	        try {
	            resultSet = sql.executeQuery();
	            while (resultSet.next()) {
	                String username = resultSet.getString("s_name");
	                String passWord = resultSet.getString("s_psd");
	                if (user.equals(username) && pass.equals(passWord))
	                    flag = 1;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();

	        }
	        if (flag == 1)
	            return true;
	        else
	            return false;
	    }
		
		
	
	//管理员注册
	public boolean Insert(String t_name, String t_psd) throws SQLException, ClassNotFoundException {
        conn = this.getConn();
//     sql=connection.prepareStatement("insert into library.db_book(ID,username, password) values(?,?,?)");
        boolean result = this.Select(t_name, t_psd);
        if (!result) {
            sql = conn.prepareStatement("insert into manager_lvqiao.t_user(t_name, t_psd) values(?,?)");
//          sql.setInt(1,0);
            sql.setString(1, t_name);
            sql.setString(2, t_psd);
            sql.executeUpdate();
            return true;
        } else {
            return false;
        }
    }
	//学生注册
		public boolean Insertstu(String s_name, String s_psd,String s_cno, String s_number,String s_teacher) throws SQLException, ClassNotFoundException {
	        conn = this.getConn();
	        boolean result = this.Select(s_name, s_psd);
	        if (!result) {
	            sql = conn.prepareStatement("insert into manager_lvqiao.t_student(s_name, s_psd, s_cno, s_number, s_teacher) values(?,?,?,?,?)");
	            sql.setString(1, s_name);
	            sql.setString(2, s_psd);
	            sql.setString(3, s_cno);
	            sql.setString(4, s_number);
	            sql.setString(5, s_teacher);
	            sql.executeUpdate();
	            return true;
	        } else {
	            return false;
	        }
	    }
		
		//添加学生
				public boolean Insertstudent(String s_name, String s_cno, String s_number,String s_teacher) throws SQLException, ClassNotFoundException {
			        conn = this.getConn();
			        boolean result = this.Selectadd(s_name);
			        if (!result) {
			            sql = conn.prepareStatement("insert into manager_lvqiao.t_student(s_name, s_cno, s_number, s_teacher) values(?,?,?,?)");
			            sql.setString(1, s_name);
			            sql.setString(2, s_cno);
			            sql.setString(3, s_number);
			            sql.setString(4, s_teacher);
			            sql.executeUpdate();
			            return true;
			        } else {
			            return false;
			        }
			    }
				//添加留言
				public boolean Insertreader(String title, String content1, String from_name, String to_name) throws SQLException, ClassNotFoundException {
			        conn = this.getConn();
			        boolean result = this.Selectadd(title);
			        if (!result) {
			            sql = conn.prepareStatement("insert into manager_lvqiao.t_from_mes(title, content, from_name, to_name) values(?,?,?,?)");
			            sql.setString(1, title);
			            sql.setString(2, content1);
			            sql.setString(3, from_name);
			            sql.setString(4, to_name);
			            sql.executeUpdate();
			            return true;
			        } else {
			            return false;
			        }
			    }
				//回复留言
				public boolean InsertRereader(String title, String content1, String from_name, String to_name) throws SQLException, ClassNotFoundException {
			        conn = this.getConn();
			        boolean result = this.Selectadd(title);
			        if (!result) {
			            sql = conn.prepareStatement("insert into manager_lvqiao.t_to_mes(title, count, from_name, to_name) values(?,?,?,?)");
			            sql.setString(1, title);
			            sql.setString(2, content1);
			            sql.setString(3, from_name);
			            sql.setString(4, to_name);
			            sql.executeUpdate();
			            return true;
			        } else {
			            return false;
			        }
			    }
				//添加课程
				public boolean Insertclass(String c_name, String c_time, String c_teacher,String c_site) throws SQLException, ClassNotFoundException {
			        conn = this.getConn();
			        boolean result = this.Selectadd(c_name);
			        if (!result) {
			            sql = conn.prepareStatement("insert into manager_lvqiao.t_class(c_name, c_time, c_teacher, c_site) values(?,?,?,?)");
			            sql.setString(1, c_name);
			            sql.setString(2, c_time);
			            sql.setString(3, c_teacher);
			            sql.setString(4, c_site);
			            sql.executeUpdate();
			            return true;
			        } else {
			            return false;
			        }
			    }
	
		//增删改
		public void updatePreparedStatement(String sql,List<Object> params){
			getConn();
			try {
				pstm = conn.prepareStatement(sql);
				
				if(params!=null){
					for(int i=0;i<params.size();i++){
						pstm.setObject(i+1, params.get(i));
					}
				}
				
				pstm.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void updatePreparedStatement(String sql,Object... params){
			getConn();
			try {
				pstm = conn.prepareStatement(sql);
				
				if(params!=null){
					for(int i=0;i<params.length;i++){
						pstm.setObject(i+1, params[i]);
					}
				}
				
				pstm.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*public List<StudentType> stuPreparedStatement(String sql,Object... params){
			getConn();
			try {
				pstm = conn.prepareStatement(sql);
				
				if(params!=null){
					for(int i=0;i<params.length;i++){
						pstm.setObject(i+1, params[i]);
					}
				}
				
				pstm.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		//查询
		public <T> List<T> queryPreparedStatement(String sql,Class<T> clazz,List<Object> params){
			getConn();
			List<T> result = new ArrayList<T>();
			try {
				pstm = conn.prepareStatement(sql);
				
				if(params!=null){
					for(int i=0;i<params.size();i++){
						pstm.setObject(i+1, params.get(i));
					}
				}
				
				rs = pstm.executeQuery();
				
				ResultSetMetaData rsmd = rs.getMetaData();
				//获取列的数量
				int count = rsmd.getColumnCount();
				//存储所有列的名字
				List<String> column = new ArrayList<String>();
				for(int i=0;i<count;i++){
					column.add(rsmd.getColumnName(i+1));
				}
				
				while(rs.next()){
					//创建对象
					T obj = clazz.newInstance();
					
					for(int i=0;i<count;i++){
						String name = column.get(i).toLowerCase();
						
						//根据列明获取属性
						Field f = clazz.getDeclaredField(name);
						f.setAccessible(true);
						//获取属性的类型
						String type = f.getType().getName();
						if("int".equals(type) || "java.lang.Integer".equals(type)){
							int val = rs.getInt(name);
							f.set(obj, val);
						}else if("double".equals(type) || "java.lang.Double".equals(type)){
							double val = rs.getDouble(name);
							f.set(obj, val);
						}else if("float".equals(type) || "java.lang.Float".equals(type)){
							float val = rs.getFloat(name);
							f.set(obj, val);
						}else if("java.lang.String".equals(type)){
							String val = rs.getString(name);
							f.set(obj, val);
						}else if("java.util.Date".equals(type)){
							Date val = rs.getDate(name);
							f.set(obj, val);
						}else if("boolean".equals(type) || "java.lang.Boolean".equals(type)){
							boolean val = rs.getBoolean(name);
							f.set(obj, val);
						}
						
					}
					
					result.add(obj);
					
					
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return result;
		}
		
		public <T> List<T> queryPreparedStatement(String sql,Class<T> clazz,Object...params){
			getConn();
			List<T> result = new ArrayList<T>();
			try {
				pstm = conn.prepareStatement(sql);
				
				if(params!=null){
					for(int i=0;i<params.length;i++){
						pstm.setObject(i+1, params[i]);
					}
				}
				
				rs = pstm.executeQuery();
				
				ResultSetMetaData rsmd = rs.getMetaData();
				//获取列的数量
				int count = rsmd.getColumnCount();
				//存储所有列的名字
				List<String> column = new ArrayList<String>();
				for(int i=0;i<count;i++){
					column.add(rsmd.getColumnName(i+1));
				}
				
				while(rs.next()){
					//创建对象
					T obj = clazz.newInstance();
					
					for(int i=0;i<count;i++){
						String name = column.get(i).toLowerCase();
						
						//根据列明获取属性
						Field f = clazz.getDeclaredField(name);
						f.setAccessible(true);
						//获取属性的类型
						String type = f.getType().getName();
						if("int".equals(type) || "java.lang.Integer".equals(type)){
							int val = rs.getInt(name);
							f.set(obj, val);
						}else if("double".equals(type) || "java.lang.Double".equals(type)){
							double val = rs.getDouble(name);
							f.set(obj, val);
						}else if("float".equals(type) || "java.lang.Float".equals(type)){
							float val = rs.getFloat(name);
							f.set(obj, val);
						}else if("java.lang.String".equals(type)){
							String val = rs.getString(name);
							f.set(obj, val);
						}else if("java.util.Date".equals(type)){
							Date val = rs.getDate(name);
							f.set(obj, val);
						}else if("boolean".equals(type) || "java.lang.Boolean".equals(type)){
							boolean val = rs.getBoolean(name);
							f.set(obj, val);
						}
						
					}
					
					result.add(obj);
					
					
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return result;
		}
		public int stucount() {
			Connection conn = JdbcUtil.getConn();  
	        String countSQL = "select count(*) as result from t_student";  
	        PreparedStatement pstmt = null;  
	        ResultSet rs = null;  
	        int count = 0;  
	        try{  
	              
	            pstmt = conn.prepareStatement(countSQL);  
	            rs = pstmt.executeQuery();  
	            while(rs.next())  
	            {  
	                count = rs.getInt(1); // count = rs.getInt("result");  
	            }  
	        
	        }catch (Exception e) {
				// TODO: handle exception
			}
	        return count;
		}
		public int classcount() {
			Connection conn = JdbcUtil.getConn();  
	        String countSQL = "select count(*) as result from t_class";  
	        PreparedStatement pstmt = null;  
	        ResultSet rs = null;  
	        int count = 0;  
	        try{  
	              
	            pstmt = conn.prepareStatement(countSQL);  
	            rs = pstmt.executeQuery();  
	            while(rs.next())  
	            {  
	                count = rs.getInt(1); // count = rs.getInt("result");  
	            }  
	        
	        }catch (Exception e) {
				// TODO: handle exception
			}
	        return count;
		}
		
		public int mescount() {
			Connection conn = JdbcUtil.getConn();  
	        String countSQL = "select count(*) as result from t_from_mes";  
	        PreparedStatement pstmt = null;  
	        ResultSet rs = null;  
	        int count = 0;  
	        try{  
	              
	            pstmt = conn.prepareStatement(countSQL);  
	            rs = pstmt.executeQuery();  
	            while(rs.next())  
	            {  
	                count = rs.getInt(1); // count = rs.getInt("result");  
	            }  
	        
	        }catch (Exception e) {
				// TODO: handle exception
			}
	        return count;
		}
		
		
		public void close(){
			try {
				if(pstm!=null){
					pstm.close();
				}
				if(conn!=null){
					conn.close();
				}
				if(rs!=null){
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public StudentType querystuself(String sql2, Class<StudentType> class1) {
			try {
				pstms = (StudentType) conn.prepareStatement(sql2);;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return pstms;
		}
		
		
		
		
	
	
}
