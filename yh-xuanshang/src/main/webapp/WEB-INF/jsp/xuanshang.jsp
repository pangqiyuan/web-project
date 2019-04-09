<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
   <meta http-equiv="Cache-Control" content="max-age=300" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Document</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../css/base.css"/>
    <link rel="stylesheet" href="../css/index.css"/>
    <link rel="stylesheet" href="../css/xuanshang.css"/>
</head>
<body>
    <div class="title">
        <div class="titleLeft">
            <ul>
                <li class="tltleBlue">
                    <a href="http://localhost:8084/user/showLogin">
                        登录
                    </a>       
                </li>
                <li class="titleZuce">
                    <a href="http://localhost:8084/user/showRegister">
                        免费注册
                    </a>
                </li>
            </ul>
        </div>
        <div class="titleRight">
            <ul>
                <li class="tltleBlue"><a href="http://localhost:8082">悬赏首页</a></li>
                <li>我的易货<i class="glyphicon glyphicon-eur"></i></li>
                <li><i class="glyphicon glyphicon-eur"></i>收藏夹<i class="glyphicon glyphicon-eur"></i></li>
                <li class="titleRightPOR">商品分类<span class="titleRightXian">|</span></li>
                <li>卖家中心</li>
                <li>联系客服</li>
                <li><i class="glyphicon glyphicon-eur"></i>网站导航</li>
            </ul>
        </div>
    </div>
    <div class="renwu">
        <span class="span1">
            悬赏任务
            <button type="button" class="btn btn-primary btn-md" data-toggle="modal" data-target="#myModal">
                添加悬赏
                
            </button>

            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                    <div class="modal-dialog" role="document">
                      <div class="modal-content">
                        <div class="modal-header">
                          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                          <h4 class="modal-title" id="myModalLabel">请填写信息</h4>
                        </div>
                        <div class="modal-body">
                            标题：<input type="text" class="biaoti">      
                            内容：<input type="text" class="neirong"/>
                            价格：<input type="text" class="jiage"/>
                            地址：<input type="text" class="dizhi">
                            <p class="wanzheng" style="width: 100%;height: 24px; color: red; font-size: 14px;text-align: center;font-weight: 700; display: none;">*请填写完整信息*</p>
                        </div>
                        <div class="modal-footer">
                        <p class="chenggong" style="width: 100%;height: 24px; color: green; font-size: 14px;text-align: center;font-weight: 700; display: none;">*添加成功*</p>
                        <p class="shibai" style="width: 100%;height: 24px; color: red; font-size: 14px;text-align: center;font-weight: 700; display: none;">*添加失败*</p>
                          <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                          <button type="button" class="btn btn-primary btn-true" >确定</button>
                        </div>
                      </div>
                    </div>
                  </div>
        </span>       
    </div>
    <div class="shousuokuang">
        <div class="leibie" id="leibie">
            悬赏类别∨
        </div>
        <ul id="leibieUl">
            <li>代取快递</li>
            <li>代送外卖</li>
            <li>代买商品</li>
        </ul>
        <div class="shousuokuangTop">
            <div class="Center">
                <form class="form-inline">
                    <div class="form-group">
                      <label class="sr-only" for="exampleInputAmount"></label>
                      <div class="input-group">
                        <input type="text" id="input" class="form-control" id="exampleInputAmount" placeholder="">
                      </div>
                    </div>
                    <button type="button" id="botton" class="btn btn-primary">搜索</button>
                </form>
            </div>
        </div>
    </div>
    <div class="xuanshang">
        <div class="xuanshangneirong">
            <ul class="fenye">
                <c:forEach items="${msg.data }" var="m" >
                	<li>
                    <i>标题</i>
                    <span class="biaoti">${m.title }</span>
                    <i>价格</i>
                    <span class="jiage">${m.prices }</span>
                    <i>地址</i>
                    <span class="dizhi">${m.location }</span>
                    <i>内容</i>
                    <span class="neirong">${m.contet }</span>
                    <button type="button" class="btn btn-primary btn-chakan" data-toggle="modal" data-target=".bs-example-modal-lg">查看详情</button>
                    <div class="modal fade bs-example-modal-lg btn-xuanshang" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
					  <div class="modal-dialog modal-lg" role="document">
					    <div class="modal-content">
		                    <table>
		                    	<tr>
		                    		<td><i style="color: #000; width: 300px;height: 100px;word-break:break-all; overflow:auto; ">标题</i></td>
		                    		<td><span style="color: #000; width: 540px;height: 100px;word-break:break-all; overflow:auto; ">${m.title }</span></td>
		                    	</tr>
		                    	<tr>
		                    		<td><i style="color: #000; width: 300px;height: 100px;word-break:break-all; overflow:auto; ">价格</i></td>
		                    		<td><span style="color: #000; width: 540px;height: 100px;word-break:break-all; overflow:auto; ">${m.prices }</span></td>
		                    	</tr>
		                    	<tr>
		                    		<td><i style="color: #000; width: 300px;height: 100px;word-break:break-all; overflow:auto; ">地址</i></td>
		                    		<td><span style="color: #000; width: 540px;height: 100px;word-break:break-all; overflow:auto; ">${m.location }</span></td>
		                    	</tr>
		                    	<tr>
		                    		<td><i style="color: #000; width: 300px;height: 200px;word-break:break-all; overflow:auto; ">内容</i></td>
		                    		<td><span style="color: #000; width: 540px;height: 200px;word-break:break-all; overflow:auto; ">${m.contet }</span></td>
		                    	</tr>
		                    </table>
		                      <div class="modal-footer">
						        <button type="button" class="btn btn-default" data-dismiss="modal">接受悬赏</button>
						      </div>	
					    </div>
					  </div>	
					  </div>   
					
                </li>    
                
                </c:forEach>    
                    
            </ul>
            
        </div>
        <!-- <div id="page"></div> -->
    </div>
    <script src="../js/jquery-3.3.1.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/template-web.js"></script>
    <script src="../dist/easySlider.js"></script>
    <script src="../js/index.js"></script>
    <script src="../js/xuanshang.js"></script>
    <script>
    	$('.btn-chakan').on('click', function() {
    	 	//$('.btn-xuanshang').siblings().remove();
    	 	console.log($('.btn-xuanshang'))
    	})
    	
        $('.btn-true').on('click', function() {
        var x = '';
            $('.modal-body input[type="text"]').each(function() {
                //console.log(this.value)
                if (this.value == '') {
                    $('.btn-true').attr("disabled",true); 
                    // alert("请填写完整信息")
                    $('.wanzheng').css('display', 'inline-block');
                } else {
                    $('.btn-true').attr("disabled",false);
                    $('.wanzheng').css('display', 'none');
					x += this.value+ ','
                }
            })
             $.ajax({
                    	url: encodeURI('http://localhost:8086/Money/insert?name=' + x),
                    	type: 'get',
                    	dataType: 'json',
                    	scriptCharset: 'UTF-8',
                    	contentType: "application/x-www-form-urlencoded; charset=UTF-8",
                    	//contentType:'application/json',
                    	success: function(a){
                    		if(a.status==200){
                    		$('.chenggong').css('display', 'inline-block');
                    			//alert("添加成功")
                    		}else{
                    			//alert("添加失败，请重新添加")
                    			$('.shibai').css('display', 'inline-block');
                    		}
                    		
                 }
            })
        })
        
        $('.btn-md').on('click', function() {
            $('.btn-true').attr("disabled",false);
            $('.chenggong').css('display', 'none');
            $('.shibai').css('display', 'none');
            
        })
                   

	$(".neirong").each(function(){
       var len=$(this).text().length;   //当前HTML对象text的长度
       if(len>7){
           var str="";
           str=$(this).text().substring(0,7)+"......";  //使用字符串截取，获取前30个字符，多余的字符使用“......”代替
           $(this).html(str);                   //将替换的值赋值给当前对象
       }
    });
    
   

    </script>
</body>
</html>