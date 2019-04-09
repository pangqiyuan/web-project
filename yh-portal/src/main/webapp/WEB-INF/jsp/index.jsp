<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../css/base.css"/>
    <link rel="stylesheet" href="../css/index.css"/>
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
                <li class="tltleBlue"><a href="http://localhost:8086/Money/show">悬赏首页</a></li>
                <li>我的易货<i class="glyphicon glyphicon-eur"></i></li>
                <li><i class="glyphicon glyphicon-eur"></i>收藏夹<i class="glyphicon glyphicon-eur"></i></li>
                <li class="titleRightPOR">商品分类<span class="titleRightXian">|</span></li>
                <li>卖家中心</li>
                <li>联系客服</li>
                <li><i class="glyphicon glyphicon-eur"></i>网站导航</li>
            </ul>
        </div>
    </div>
    <div class="shangpin">
        商品信息
    </div>
    <div class="shousuokuang">
        <div class="shousuokuangTop">
            <div class="Left">
                <img src="../image/logo.jpg" alt="">
            </div>
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
            <div class="Right">
                <div class="guanggao">

                </div>
            </div>
            <div class="Bottom">
                <div class="fenlei" id="fenlei">
                    <img src="../image/fenlei.jpg" alt=""/>
                    <p>商品分类</p>
                </div>
                <div class="fenleineirong" id="fenleineirong">
                    <ul>
                        <li>
                            <a href="http://localhost:8083/search.html?q=运动">
                                <span class="span1">运动</span>
                                <img src="../image/zuqiu.jpg">
                            </a>   
                        </li>
                        <li>
                            <a href="http://localhost:8083/search.html?q=数码">
                                <span class="span2">数码</span>
                                <img src="../image/shuma.jpg">  
                            </a>
                        </li>
                        <li>
                            <a href="http://localhost:8083/search.html?q=美妆">
                                <span class="span3">美妆</span>
                                <img src="../image/meizhuang.jpg" alt="">
                            </a>
                        </li>
                        <li>
                            <a href="http://localhost:8083/search.html?q=服饰">
                                <span class="span4">服饰</span>
                                <img src="../image/fushi.jpg" alt="">
                            </a>
                        </li>
                        <li>
                            <a href="http://localhost:8083/search.html?q=美食">
                                <span class="span5">美食</span>
                                <img src="../image/meishi.jpg" alt="">
                            </a>
                        </li>
                        <li>
                            <a href="http://localhost:8083/search.html?q=家居">
                                <span class="span6">家居</SPan>
                                <img src="../image/jiaju.jpg" alt="">
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="banner">
        <div class="htmleaf-container">
        	<div id="slider">
                <ul class="slides clearfix">
                    <li><img class="responsive" src="../img/1.jpg"></li>
                    <li><img class="responsive" src="../img/2.jpg"></li>
                    <li><img class="responsive" src="../img/3.jpg"></li>
                    <li><img class="responsive" src="../img/4.jpg"></li>
                </ul>
                <ul class="controls">
                    <li><img src="../img/prev.png" alt="previous" class="imgzuo"></li>
                    <li><img src="../img/next.png" alt="next" class="imgyou"></li>
                </ul>
                <ul class="pagination">
                    <li class="active"></li>
                    <li></li>
                    <li></li>
                    <li></li>
                </ul>
            </div>
        </div>
        <div class="banner_guanggao">
            <div class="banner_guanggao_zuo1">
            </div>
            <div class="banner_guanggao_you1">
            </div>
            <div class="banner_guanggao_zuo2">
            </div>
            <div class="banner_guanggao_you2">
            </div>
        </div>
    </div>
    <div class="jinrituijian">
        <div class="jinrituijian_title">
            <span>
                今日推荐
            </span>
        </div>
        <div class="jinrituijian_tuijian1">

        </div>
        <div class="jinrituijian_tuijian2">

        </div>
        <div class="jinrituijian_tuijian3">

        </div>
    </div>
    <div class="jinrituijian cainixihuan">
        <div class="jinrituijian_title">
            <span>
                猜你喜欢
            </span>
        </div>
        <div class="jinrituijian_tuijian1">

        </div>
        <div class="jinrituijian_tuijian2">

        </div>
        <div class="jinrituijian_tuijian3">

        </div>
    </div>
    <div class="footer">
        联系电话
    </div>
    <script src="../js/jquery-3.3.1.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/template-web.js"></script>
    <script src="../dist/easySlider.js"></script>
    <script src="../js/index.js"></script>
    <script type="text/javascript">
        $(function() {
            $("#slider").easySlider( {
                slideSpeed: 500,
                paginationSpacing: "15px",
                paginationDiameter: "12px",
                paginationPositionFromBottom: "20px",
                slidesClass: ".slides",
                controlsClass: ".controls",
                paginationClass: ".pagination"					
            });
        });
        
        $("#botton").on('click', function(){
        	location.href="http://localhost:8083/search.html?q="+$('#input').val();
        	
        })
        
    </script>
</body>
</html>