$(function() {
	$('#saveBtn').click(function(){
		saveUserInfo();
	});
	$('#queryBtn').click(function(){
		query();
	});
});

/*
 * 查询用户信息
 */
function query(){
	var stuId = $('input[name=stuId]',$('.userInfo')).val();
	var param = {
		stuId : stuId
	};
	var requestJson = JSON.stringify(param);
	$.ajax({
		url : 'servlet/webServlet',
		type : "POST",
		async : true,
		cache : false,
		dataType : "json",
		data : {
			serviceName : "userService",
			methodName : "getUserInfo",
			requestJson : requestJson
		},
		success : function(data) {
			$('input[name=stuId]',$('.userInfo')).val(data.RtnData.stuId);
			$('input[name=stuName]',$('.userInfo')).val(data.RtnData.stuName);
			$('input[name=phone]',$('.userInfo')).val(data.RtnData.phone);
			$('input[name=idNumber]',$('.userInfo')).val(data.RtnData.idNumber);
		},
		error : function(data) {
			alert("ajax调用出错！" + JSON.stringify(data));
		}
	});
}

/*
 * 保存用户信息
 */
function saveUserInfo(){
	var stuId = $('input[name=stuId]',$('.userInfo')).val();
	var stuName = $('input[name=stuName]',$('.userInfo')).val();
	var phone = $('input[name=phone]',$('.userInfo')).val();
	var idNumber = $('input[name=idNumber]',$('.userInfo')).val();
	var param = {
		stuId : stuId,
		stuName : stuName,
		phone : phone,
		idNumber : idNumber
	};
	var requestJson = JSON.stringify(param);
	$.ajax({
		url : 'servlet/webServlet',
		type : "POST",
		async : true,
		cache : false,
		dataType : "json",
		data : {
			serviceName : "userService",
			methodName : "saveUserInfo",
			requestJson : requestJson
		},
		success : function(data) {
			if(data.RtnCode == '00') {
				alert('保存成功！');
			} else {
				alert('保存失败！');
			}
		},
		error : function(data) {
			alert("ajax调用出错！" + JSON.stringify(data));
		}
	});
}
