<%@page import="entity.Videos"%>
<%@page import="dao.VideosDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
	body{margin: auto;padding: 0px;background-color: #eff4f8;}
	
	.center{
		text-align: center;
		font-family: sans-serif;
	}
	#top ul li{list-style: none;float:left; }
	dl{margin-top: 100px;}
	dd{margin: 10px; }
	#top{
		position: absolute;
		left: 20px;
		top: 0px;
	
	}


</style>
<title>电影详情</title>
</head>
<body>
	
	<div id ="top">
	
		<ul >
			<li ><a href="index.jsp" ><h2 >首页</h2></a></a></li>
		
		
		
		</ul>
		
		
	
	</div>
	<%	
		//涉及到中文转码问题，否则乱码
		request.setCharacterEncoding("UTF-8");  
		String str = request.getParameter("content");
		VideosDao videosDao = new VideosDao();
		Videos videos = videosDao.getVideosByName(str);
	
	
	%>
	
	<div class = "center">
						<dl>
							<dt>
								<a href="detail.jsp"><img alt="" src="images/<%=videos.getPicture() %>" width="500" height="600"></a>
							</dt>
							<dd class = "video_name">电影名：<%=videos.getVideoname() %> </dd>
							
							<dd class = "video_url"><a href="<%= videos.getUrl() %>">云盘链接</a> </dd>
							<dd class = "video_password">云盘密码：<%=videos.getPassword() %></dd>
							
						
						</dl>
					
					
					</div>
	

</body>
</html>