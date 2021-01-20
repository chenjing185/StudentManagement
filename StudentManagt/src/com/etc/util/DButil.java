package com.etc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;

/**
 * 数据库通用工具,返回连接,通用的增加,删除和修改的操作,查询,释放资源
 * @author Administrator
 *
 */
public class DButil {
	private static final String URL="jdbc:mysql://localhost:3306/test";
	private static final String USER="root";
	private static final String PASSWORD="123456";


	/**
	 * 返回一个连接对象
	 * @return 连接对象
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static Connection getConn() throws ClassNotFoundException, SQLException {
		//加载驱动(可省)
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

	/**
	 * 通用的增加,删除和修改的操作
	 */
	public static boolean execUpdate(String sql,Object...params ) {

		Connection conn =null;
		PreparedStatement pstm=null;
		int n=0;
		try {
			//1.获取连接对象
			conn = getConn();
			//2.通过connection对象得到预编译处理对象
			pstm=conn.prepareStatement(sql);
			//3.补齐?参数(给?赋值)
			setPareStatement(pstm,params);
			//4.执行增删改的动作
			n=pstm.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//释放资源
			closeAll(null,pstm,conn);
		}
		return n>0;
	}
	
	/**
	 * 查询
	 * @return ResultSet结果集
	 */
	public static CachedRowSet execQuery(String sql,Object...params) {
		Connection conn = null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		CachedRowSet crs=null;
		try {
			//1.获取连接对象
			conn = getConn();
			//2.通过connection对象得到预编译处理对象
			pstm=conn.prepareStatement(sql);
			//3.补齐?参数(给?赋值)
			setPareStatement(pstm,params);
			//4.执行查询的动作
			rs=pstm.executeQuery();
			//5.创建一个离线结果集
			crs=new CachedRowSetImpl();
			//6.使用取自给定 ResultSet 对象的数据填充此 CachedRowSet 对象。
			crs.populate(rs);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll(rs,pstm, conn);
		}
		return crs;
	}

	/**
	 * 释放资源
	 */
	private static void closeAll(ResultSet rs, PreparedStatement pstm,Connection conn) {

		try {
			//判断如果不为空,再关 ,如果为空,会报空指针异常
			if (null!=rs) {
				rs.close();
			}
			if (null!=pstm) {
				pstm.close();
			}
			//连接放在最后释放
			if (null!=conn) {
				conn.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}






	/**
	 * 补齐占位符?的值
	 * @param pstm PreparedStatement对象
	 * @param params可变参数的数组
	 */
	public static void setPareStatement(PreparedStatement pstm,Object...params ) {
		if (null!=pstm && null!=params) {
			for (int i = 0; i < params.length; i++) {
				try {
					pstm.setObject(i+1,params[i] );
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
