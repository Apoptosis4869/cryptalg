<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head lang="en">
<base href="<%=basePath%>" >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Login Page | Amaze UI Example</title>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <meta name="format-detection" content="telephone=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="alternate icon" type="image/png" href="static/i/favicon.png">
  <link rel="stylesheet" href="static/css/amazeui.min.css"/>
  <link rel="stylesheet" href="static/css/admin.css"/>
  <link rel="stylesheet" href="static/css/amazeui.flat.min.css"/>
  <link rel="stylesheet" href="static/css/app.css"/>
  <script src="static/js/jquery.min.js"></script>
  <script src="static/js/amazeui.ie8polyfill.min.js"></script>
  <script src="static/js/amazeui.min.js"></script>
  <script src="static/js/amazeui.widgets.helper.min.js"></script>
  <script src="static/js/app.js"></script>
  <script src="static/js/handlebars.min.js"></script>
  <script>
	$(function(){
		$("#loginButton").bind("click",function(){
			var data = {userid:$("#doc-vld-email-2-1").val(),password:$("#doc-vld-pwd-2-1").val()};
			$.ajax({
				url:"index/login",
				type:"post",
				async:true,
				data:data,
				success:function(resp){
					if(resp.result == "SUCCESS"){
						window.location.href = "home";
					}else{
						openAlert("登录失败");
					}
				},
				error:function(err){
					alert("Ajax error at status: " + err.status);
				}
			});
		});
		
		function openAlert(msg){
			var loginAlert = $("#login-alert");
			$("#contentText").text(msg);
			loginAlert.modal("open");
		}
		
		
		$('#doc-vld-msg').validator({
		    onValid: function(validity) {
		      $(validity.field).closest('.am-form-group').find('.am-alert').hide();
		    },

		    onInValid: function(validity) {
		      var $field = $(validity.field);
		      var $group = $field.closest('.am-form-group');
		      var $alert = $group.find('.am-alert');
		      // 使用自定义的提示信息 或 插件内置的提示信息
		      var msg = $field.data('validationMessage') || this.getValidationMessage(validity);

		      if (!$alert.length) {
		        $alert = $('<div class="am-alert am-alert-danger"></div>').hide().
		          appendTo($group);
		      }

		      $alert.html(msg).show();
		    }
		  });
	});
</script>
  <style>
    .header {
      text-align: center;
    }
    .header h1 {
      font-size: 200%;
      color: #333;
      margin-top: 30px;
    }
    .header p {
      font-size: 14px;
    }
  </style>
</head>
<body>
<div class="header">
  <div class="am-g">
    <h1>APOPTOSIS System</h1>
    <p>Media Manage Environment</p>
  </div>
  <hr />
</div>
<div class="am-g">
  <div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">
    <h3>登录</h3>
    <hr>
    <div class="am-btn-group">
      <a href="#" class="am-btn am-btn-secondary am-btn-sm"><i class="am-icon-github am-icon-sm"></i> Github</a>
      <a href="#" class="am-btn am-btn-success am-btn-sm"><i class="am-icon-google-plus-square am-icon-sm"></i> Google+</a>
      <a href="#" class="am-btn am-btn-primary am-btn-sm"><i class="am-icon-stack-overflow am-icon-sm"></i> stackOverflow</a>
    </div>
    <br>
    <br>

    <form action="" class="am-form" id="doc-vld-msg">
  		<fieldset>
		    <div class="am-form-group">
		      <label for="doc-vld-email-2-1">邮箱：</label>
		      <input type="email" id="doc-vld-email-2-1" data-validation-message="EMAIL地址不正确" placeholder="输入EMAIL" required/>
		    </div>
      		<br>
	      	<div class="am-form-group">
		      <label for="doc-vld-pwd-2-1">密码：</label>
		      <input type="password" id="doc-vld-pwd-2-1" data-validation-message="请输入密码" placeholder="输入密码" required/>
		    </div>
      		<br>
      <label for="remember-me">
        <input id="remember-me" type="checkbox">
        	记住密码
      </label>
      <br />
      <div class="am-cf">
        <input id="loginButton" type="button" name="" value="登 录" class="am-btn am-btn-primary am-btn-sm am-fl">
        <input type="button" name="" value="忘记密码 " class="am-btn am-btn-default am-btn-sm am-fr">
      </div>
      </fieldset>
    </form>
    <hr>
    <p>© 2015 All Rights Released, Inc. Licensed under APOPTOSIS license.</p>
  </div>
</div>
<div class="am-modal am-modal-alert" tabindex="-1" id="login-alert">
  <div class="am-modal-dialog">
    <div class="am-modal-hd">ApoptosisSYS</div>
    <div id="contentText" class="am-modal-bd">
      
    </div>
    <div class="am-modal-footer">
      <span class="am-modal-btn">确定</span>
    </div>
  </div>
</div>

</body>
</html>