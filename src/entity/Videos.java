package entity;
/**
 * 电影实体类
 * @author Administrator
 *
 */
public class Videos {
	
	private int id;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	private String videoname; //电影名字
	private String url;		  //电影链接
	private String password;  //云盘密码
	private String picture;	  //电影图片
	
	/**
	 * @return the videoname
	 */
	public String getVideoname() {
		return videoname;
	}
	/**
	 * @param videoname the videoname to set
	 */
	public void setVideoname(String videoname) {
		this.videoname = videoname;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the picture
	 */
	public String getPicture() {
		return picture;
	}
	/**
	 * @param picture the picture to set
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	
	

}
