$(function() {
	var fullName = $.cookie('fullName1');
	if (null != fullName) {
		$("#jsus1").text(fullName);
	}

	$("#outlogin1").click(function() {

		$.ajaxSeentao($.getRootPath() + "/user/outLogin.rest", function(json) {
			if (json.code == '1') {

				ischool.layout.success("退出成功");
				window.location.reload();

			} else {
				ischool.layout.error(json.errorMessage, 2000);

			}

		}, {
			type : "post"
		});
	});
	
	$.ajaxSeentao($.getRootPath() + "/user/getUserMenu.rest",function(json) {
						if (json.code == '1') {
							ischool.layout.hide();
							var obj = JSON.parse(json.data);
							var str1 = "";
							var str2 = "";
							var str3 = "";
							var str6 = "";
							for (var int = 0; int < obj.length; int++) {
								var menuId = obj[int].menuId;
								if (2 === menuId) {
									str1 += "<li id='yhzlxg' class=''>"
											+ "<a href='' onclick=\"$(this).attr('href',$.getRootPath()+'/webpage/pages/xkuser/xkUser.html')\">"
											+ "<i class=\"icon-caret-right\"></i>"
											+ "<span>用户资料修改</span>"
											+ "</a></li>";

								} else if (4 === menuId) {
									str3 += "<li id='dssjdc' class=''>"
											+ "<a href='' onclick=\"$(this).attr('href',$.getRootPath()+'/webpage/pages/datastatistics/citydata.html')\">"
											+ "<i class=\"icon-caret-right\"></i>"
											+ "<span>地市数据导出</span>"
											+ "</a></li>";

								} else if (5 === menuId) {
									str3 += "<li id='yhsjdc' class=''>"
											+ "<a href='' onclick=\"$(this).attr('href',$.getRootPath()+'/webpage/pages/datastatistics/userdata.html')\">"
											+ "<i class=\"icon-caret-right\"></i>"
											+ "<span>用户数据导出</span>"
											+ "</a></li>";

								} else if (7 === menuId) {
									str6 += "<li id='ptyhgl' class=''>"
											+ "<a href='' onclick=\"$(this).attr('href',$.getRootPath()+'/webpage/pages/user/adduser.html')\">"
											+ "<i class=\"icon-caret-right\"></i>"
											+ "<span>平台用户管理</span>"
											+ "</a></li>";

								} else if (8 === menuId) {
									str6 += "<li id='zdbdr' class=''>"
											+ "<a href='' onclick=\"$(this).attr('href',$.getRootPath()+'/webpage/pages/updictionary/updictionary.html')\">"
											+ "<i class=\"icon-caret-right\"></i>"
											+ "<span>字典表导入</span>"
											+ "</a></li>";

								} else if (9 === menuId) {
									str6 += "<li id='xtrzcx' class=''>"
											+ "<a href='' onclick=\"$(this).attr('href',$.getRootPath()+'/webpage/pages/log/selectlog.html')\">"
											+ "<i class=\"icon-caret-right\"></i>"
											+ "<span>系统日志查询</span>"
											+ "</a></li>";

								} else if (10 === menuId) {
									str6 += "<li id='xgmm' class=''>"
											+ "<a href='' onclick=\"$(this).attr('href',$.getRootPath()+'/webpage/pages/user/updatepass.html')\">"
											+ "<i class=\"icon-caret-right\"></i>"
											+ "<span>修改密码</span>" + "</a></li>";

								
							} else if (11 === menuId) {
								str1 += "<li id='ptrzcx' class=''>"
									+ "<a href='' onclick=\"$(this).attr('href',$.getRootPath()+'/webpage/pages/xklog/xklog.html')\">"
									+ "<i class=\"icon-caret-right\"></i>"
									+ "<span>平台输入日志</span>" + "</a></li>";
								
							} else if (12 === menuId) {
								str1 += "<li id='yhtccx' class=''>"
									+ "<a href='' onclick=\"$(this).attr('href',$.getRootPath()+'/webpage/pages/userpackage/userPackage.html')\">"
									+ "<i class=\"icon-caret-right\"></i>"
									+ "<span>用户套餐查询</span>" + "</a></li>";
								
							} else if (13 === menuId) {
								str1 += "<li id='ddjlcx' class=''>"
									+ "<a href='' onclick=\"$(this).attr('href',$.getRootPath()+'/webpage/pages/userOrder/userOrder.html')\">"
									+ "<i class=\"icon-caret-right\"></i>"
									+ "<span>订单记录查询</span>" + "</a></li>";
								
							} else if (14 === menuId) {
								str1 += "<li id='xjxxgl' class=''>"
									+ "<a href='' onclick=\"$(this).attr('href',$.getRootPath()+'/webpage/pages/teachinformation/teachinformation.html')\">"
									+ "<i class=\"icon-caret-right\"></i>"
									+ "<span>任教信息管理</span>" + "</a></li>";
								
							} else if (15 === menuId) {
								str1 += "<li id='dxrzcx' class=''>"
									+ "<a href='' onclick=\"$(this).attr('href',$.getRootPath()+'/webpage/pages/xkmsglog/xkmsglog.html')\">"
									+ "<i class=\"icon-caret-right\"></i>"
									+ "<span>短信日志查询</span>" + "</a></li>";
								
							}else if (16 === menuId) {
								str1 += "<li id='scrzcx' class=''>"
									+ "<a href='' onclick=\"$(this).attr('href',$.getRootPath()+'/webpage/pages/xkoutlog/xkoutlog.html')\">"
									+ "<i class=\"icon-caret-right\"></i>"
									+ "<span>平台输出日志</span>" + "</a></li>";							
							}else if (18 === menuId) {
								str2 += "<li id='pzgngl' class=''>"
									+ "<a href='' onclick=\"$(this).attr('href',$.getRootPath()+'/webpage/pages/userpackage/configFunction.html')\">"
									+ "<i class=\"icon-caret-right\"></i>"
									+ "<span>配置功能管理</span>" + "</a></li>";							
							}else if (19 === menuId) {
								str2 += "<li id='tcpzgl' class=''>"
									+ "<a href='' onclick=\"$(this).attr('href',$.getRootPath()+'/webpage/pages/userpackage/packageConfig.html')\">"
									+ "<i class=\"icon-caret-right\"></i>"
									+ "<span>套餐配置管理</span>" + "</a></li>";							
							}else if (20 === menuId) {
								str2 += "<li id='tcdggl' class=''>"
									+ "<a href='' onclick=\"$(this).attr('href',$.getRootPath()+'/webpage/pages/userpackage/packageOrder.html')\">"
									+ "<i class=\"icon-caret-right\"></i>"
									+ "<span>套餐订购管理</span>" + "</a></li>";							
							}else if (22 === menuId) {
								str1 += "<li id='cjxkxx' class=''>"
									+ "<a href='' onclick=\"$(this).attr('href',$.getRootPath()+'/webpage/pages/xkdataimport/addSchool.html')\">"
									+ "<i class=\"icon-caret-right\"></i>"
									+ "<span>创建学酷学校</span>" + "</a></li>";							
							}else if (23 === menuId) {
								str1 += "<li id='cjxxbj' class=''>"
									+ "<a href='' onclick=\"$(this).attr('href',$.getRootPath()+'/webpage/pages/xkdataimport/addClass.html')\">"
									+ "<i class=\"icon-caret-right\"></i>"
									+ "<span>创建学校班级</span>" + "</a></li>";							
							}else if (24 === menuId) {
								str1 += "<li id='drxxjs' class=''>"
									+ "<a href='' onclick=\"$(this).attr('href',$.getRootPath()+'/webpage/pages/xkdataimport/teacherImport.html')\">"
									+ "<i class=\"icon-caret-right\"></i>"
									+ "<span>导入学校教师</span>" + "</a></li>";							
							}else if (25 === menuId) {
								str1 += "<li id='drxsjz' class=''>"
									+ "<a href='' onclick=\"$(this).attr('href',$.getRootPath()+'/webpage/pages/xkdataimport/stuImport.html')\">"
									+ "<i class=\"icon-caret-right\"></i>"
									+ "<span>导入学生家长</span>" + "</a></li>";							
							}else if (26 === menuId) {
								str1 += "<li id='drxsjz' class=''>"
									+ "<a href='' onclick=\"$(this).attr('href',$.getRootPath()+'/webpage/pages/xkdataimport/teacherImport2.html')\">"
									+ "<i class=\"icon-caret-right\"></i>"
									+ "<span>导入学校教师(江苏)</span>" + "</a></li>";							
							}else if (28 === menuId) {
								str3 += "<li id='ydrbdssjdc' class=''>"
									+ "<a href='' onclick=\"$(this).attr('href',$.getRootPath()+'/webpage/pages/datastatistics/dailybycounty.html')\">"
									+ "<i class=\"icon-caret-right\"></i>"
									+ "<span>移动日报地市数据导出</span>" + "</a></li>";							
							}else if (29 === menuId) {
								str3 += "<li id='ydrbdssjqx' class=''>"
									+ "<a href='' onclick=\"$(this).attr('href',$.getRootPath()+'/webpage/pages/datastatistics/dailybycity.html')\">"
									+ "<i class=\"icon-caret-right\"></i>"
									+ "<span>移动日报区县数据导出</span>" + "</a></li>";							
							}

							}
							$("#yhxxglzk").html(str1);
							$("#sjtjbbzk").html(str3);
							$("#yhglzk").html(str6);
							$("#tcglzk").html(str2);

						} else {
							ischool.layout.error(json.errorMessage, 2000);

						}

					}, {
						type : "post"
					});

});