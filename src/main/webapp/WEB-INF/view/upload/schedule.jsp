<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://logx.com:8088/scriptss/jquery-1.10.2.min.js"></script>
<script src="http://logx.com:8088/scriptss/jquery-ui-1.10.1.custom.min.js"></script>
<script src="http://logx.com:8088/scriptss/ajaxfileupload.js"></script>
<script type="text/javascript">
var PATH = 'http://logx.com:8088';
function getProgress() {
	var now = new Date();
    $.ajax({
        type: "post",
        dataType: "json",
        url: PATH +  "/fileStatus/upfile/progress.htm",
        data: now.getTime(),
        success: function(data) {
        	$("#progress_percent").text(data.percent);
            $("#progress_bar").width(data.percent);
            $("#has_upload").text(data.mbRead);
            $("#upload_speed").text(data.speed);
       },
       error: function(err) {
      	$("#progress_percent").text("Error");
      }
   });
}

/**
 * 提交上传文件
 */
function fSubmit() {
	console.log('提交上传文件');
	$("#process").show();
	$("#cancel").show();
	$("#info").show();
	$("#success_info").hide();
    //文件名
   	fileName = $("#fileToUpload").val().split('/').pop().split('\\').pop();
    //进度和百分比
    $("#progress_percent").text("0%");
    $("#progress_bar").width("0%");
    $("#progress_all").show();
    oTimer = setInterval("getProgress()", 200);
    ajaxFileUpload();
    //document.getElementById("upload_form").submit();
    window.document.getElementById("fileToUpload").disabled = true;
}

/**
 * 上传文件
 */
function ajaxFileUpload() {
	console.log('上传文件');
    $.ajaxFileUpload({
        url: PATH + '/userFile/upload.htm',
        secureuri: false,
        fileElementId: 'fileToUpload',
        dataType: 'json',
        data: {
            name: 'file',
            id: 'id'
        },
        success: function(data, status) {
            if (typeof(data.status) != 'undefined') {
            	window.clearInterval(oTimer);
                if (data.status == 'success') {
                	$("#info").hide();
                	$("#success_info").show();
                	$("#success_info").text(fileName + "\t" +data.message);
                	$("#process").hide();
                	$("#cancel").hide();
                	$("#fileToUpload").val("");
                	window.document.getElementById("fileToUpload").disabled = false;
                	//上传进度和上传速度清0
                	$("#has_upload").text("0");
                    $("#upload_speed").text("0");
                    $("#progress_percent").text("0%");
                    $("#progress_bar").width("0%");
                } else{
                	$("#progress_all").hide();
                	$("#fileToUpload").val("");
                	if (typeof(data.message) != 'undefined') {
                		alert(data.message);
                	}
                	alert("上传错误！");
                }
            }
        },
        error: function(data, status, e) {
            alert(e);
        }
    })
    return false;
}
</script>
</head>
<body>
	<div class="yxbox">
	    <div class="pd15">
	    	<form name="uploadForm" id="upload_form"  action="#" method="post" enctype="multipart/form-data">
		    	<p class="mb20"><input type="file"  name="file" id="fileToUpload" title="请选择要上传的文件" onchange="fSubmit();"></p>
		        <div class="br"  style="" id="progress_all">
		        	<ul>
		            	<li>
		            		<!-- <h1><a href="#" class="fr" id="cancel">取消</a></h1> -->
		                	<div class="process clearfix" id="process">
								<span class="progress-box">
									<span class="progress-bar" style="width: 0%;" id="progress_bar"></span>
								</span>
		                        <span id="progress_percent">0%</span>
		                    </div>
		                    <!-- 进度信息 -->
		                    <div class="info" id="info">已上传：<span id="has_upload">0</span>MB  速度：<span id="upload_speed">0</span>KB/s</div>
		                    <!-- 上传成功 -->
		                    <div class="info" id="success_info" style="display: none;"></div>
		                </li>
		            </ul>
		        </div>
	        </form>
	    </div>
	</div>
</body>
</html>