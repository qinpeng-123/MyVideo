<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="entity.Videos"%>
<%@ page import="dao.VideosDao"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/video.css" rel="stylesheet" type="text/css">
<script type="text/javascript">

var ij=0;t=demo.scrollTop

demo2.innerHTML=demo1.innerHTML

function qswhMarquee2(){

if (ij==1)return

if(demo2.offsetTop-demo.scrollTop<=0)

demo.scrollTop-=demo1.offsetHeight

else

demo.scrollTop++

}

setInterval(qswhMarquee2,50)

</script>


<title>我的电影</title>
</head>
<body>
	<div id="main">
		<div id="top">

			<h1>热门电影</h1>
			<hr>
			<form action="search.jsp" method="post">
				<div align="right">
					搜索： <input type="text" name="content"> <input type="submit"
						name="search" value="搜素">


				</div>
			</form>

		</div>
		<!-- <div id="marquee"><marquee behavior="scroll" loop="" scrollamount="10" width="1000px" ></div><img src="images/神奇女侠.jpg" width=500px height="200px"></marquee></div> -->
	<!-- 	中部 -->
		<div id="center">
			

		<!-- 	内容区域 -->
			<div class="content">


				<!--循环开始-- 依次获得集合中的元素-->

				<%
					VideosDao videosDao = new VideosDao();

					ArrayList<Videos> list = videosDao.getAllVideos();
					if (list != null && list.size() > 0) {
						for (int i = 0; i < list.size(); i++) {

							Videos videos = list.get(i);
				%>
			<!-- 图片区域 -->
				<dl>
					<dt>
						<a href="detail.jsp?id=<%=videos.getId()%>"><img alt=""
							src="images/<%=videos.getPicture()%>" width="200" height="280"></a>
					</dt>
					<dd class="video_name"><%=videos.getVideoname()%>
					</dd>



				</dl>



				<!-- 循环结束 -->
				<%
					}

					}
				%>
			</div>

		 	
		</div>
	<!--center结束 -->
	
	<!--底部页脚 -->
		
 	<div class = "foot">@author:qinpeng</div>
	</div>

	

</body>
</html>