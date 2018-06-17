package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Videos;
import tools.DBConn;

/**
 * 电影的业务逻辑处理
 * 
 * @author Administrator
 *
 */

public class VideosDao {

	// 查询到电影
	// 获得数据库连接
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement stmt = null;

	// 获得所有电影信息
	public ArrayList<Videos> getAllVideos() {

		ArrayList<Videos> list = new ArrayList<Videos>(); // 电影集合

		try {
			// 获得数据库连接对象
			conn = DBConn.getConnection();
			String sql = "select * from videos";
			stmt = conn.prepareStatement(sql);

			rs = stmt.executeQuery();

			while (rs.next()) {
				// 创建Videos对象将查询到的数据封装
				Videos videos = new Videos();
				// 对应字段封装
				videos.setId(rs.getInt("id"));
				videos.setVideoname(rs.getString("videoname"));
				
				videos.setUrl(rs.getString("url"));
				videos.setPassword(rs.getString("password"));
				videos.setPicture(rs.getString("picture"));

				// 将vidoes添加到集合中
				list.add(videos);

			}
			return list;// 返回电影集合

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
		// 释放资源
		finally {
			// 因为是单例模式conn不能释放
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	/**
	 * 通过ID查询电影
	 * @param id
	 * @return
	 */
	
	public Videos getVideosById(int id) {
		
		Videos videos = new Videos();

		try {
			// 获得数据库连接对象
			conn = DBConn.getConnection();
			String sql = "select * from videos where id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				// 创建Videos对象将查询到的数据封装
				
				// 对应字段封装
				videos.setId(rs.getInt("id"));
				videos.setVideoname(rs.getString("videoname"));
				
				videos.setUrl(rs.getString("url"));
				videos.setPassword(rs.getString("password"));
				videos.setPicture(rs.getString("picture"));

				

			}
			return videos;

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
		// 释放资源
		finally {
			// 因为是单例模式conn不能释放
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		
		
	}
	
	
	/*
	 * 通过电影名查询
	 */

	public Videos getVideosByName(String videoName) {
		Videos videos = new Videos();

		try {
			// 获得数据库连接对象
			conn = DBConn.getConnection();
			String sql = "select * from videos where videoname=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, videoName);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				// 创建Videos对象将查询到的数据封装
				
				// 对应字段封装
				videos.setId(rs.getInt("id"));
				videos.setVideoname(rs.getString("videoname"));
				
				videos.setUrl(rs.getString("url"));
				videos.setPassword(rs.getString("password"));
				videos.setPicture(rs.getString("picture"));

				

			}
			return videos;

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
		// 释放资源
		finally {
			// 因为是单例模式conn不能释放
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		
	}

}
