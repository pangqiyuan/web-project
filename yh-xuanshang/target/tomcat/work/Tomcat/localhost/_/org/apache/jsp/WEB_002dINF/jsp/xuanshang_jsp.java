/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-03-06 11:41:15 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class xuanshang_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("   <meta http-equiv=\"Cache-Control\" content=\"max-age=300\" />\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("    <title>Document</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../css/bootstrap.min.css\"/>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../css/base.css\"/>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../css/index.css\"/>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../css/xuanshang.css\"/>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div class=\"title\">\r\n");
      out.write("        <div class=\"titleLeft\">\r\n");
      out.write("            <ul>\r\n");
      out.write("                <li class=\"tltleBlue\">\r\n");
      out.write("                    <a href=\"http://localhost:8084/user/showLogin\">\r\n");
      out.write("                        登录\r\n");
      out.write("                    </a>       \r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"titleZuce\">\r\n");
      out.write("                    <a href=\"http://localhost:8084/user/showRegister\">\r\n");
      out.write("                        免费注册\r\n");
      out.write("                    </a>\r\n");
      out.write("                </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"titleRight\">\r\n");
      out.write("            <ul>\r\n");
      out.write("                <li class=\"tltleBlue\"><a href=\"http://localhost:8082\">悬赏首页</a></li>\r\n");
      out.write("                <li>我的易货<i class=\"glyphicon glyphicon-eur\"></i></li>\r\n");
      out.write("                <li><i class=\"glyphicon glyphicon-eur\"></i>收藏夹<i class=\"glyphicon glyphicon-eur\"></i></li>\r\n");
      out.write("                <li class=\"titleRightPOR\">商品分类<span class=\"titleRightXian\">|</span></li>\r\n");
      out.write("                <li>卖家中心</li>\r\n");
      out.write("                <li>联系客服</li>\r\n");
      out.write("                <li><i class=\"glyphicon glyphicon-eur\"></i>网站导航</li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"renwu\">\r\n");
      out.write("        <span class=\"span1\">\r\n");
      out.write("            悬赏任务\r\n");
      out.write("            <button type=\"button\" class=\"btn btn-primary btn-md\" data-toggle=\"modal\" data-target=\"#myModal\">\r\n");
      out.write("                添加悬赏\r\n");
      out.write("                \r\n");
      out.write("            </button>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"modal fade\" id=\"myModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\">\r\n");
      out.write("                    <div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("                      <div class=\"modal-content\">\r\n");
      out.write("                        <div class=\"modal-header\">\r\n");
      out.write("                          <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\r\n");
      out.write("                          <h4 class=\"modal-title\" id=\"myModalLabel\">请填写信息</h4>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"modal-body\">\r\n");
      out.write("                            标题：<input type=\"text\" class=\"biaoti\">      \r\n");
      out.write("                            内容：<input type=\"text\" class=\"neirong\"/>\r\n");
      out.write("                            价格：<input type=\"text\" class=\"jiage\"/>\r\n");
      out.write("                            地址：<input type=\"text\" class=\"dizhi\">\r\n");
      out.write("                            <p class=\"wanzheng\" style=\"width: 100%;height: 24px; color: red; font-size: 14px;text-align: center;font-weight: 700; display: none;\">*请填写完整信息*</p>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"modal-footer\">\r\n");
      out.write("                        <p class=\"chenggong\" style=\"width: 100%;height: 24px; color: green; font-size: 14px;text-align: center;font-weight: 700; display: none;\">*添加成功*</p>\r\n");
      out.write("                        <p class=\"shibai\" style=\"width: 100%;height: 24px; color: red; font-size: 14px;text-align: center;font-weight: 700; display: none;\">*添加失败*</p>\r\n");
      out.write("                          <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">取消</button>\r\n");
      out.write("                          <button type=\"button\" class=\"btn btn-primary btn-true\" >确定</button>\r\n");
      out.write("                        </div>\r\n");
      out.write("                      </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                  </div>\r\n");
      out.write("        </span>       \r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"shousuokuang\">\r\n");
      out.write("        <div class=\"leibie\" id=\"leibie\">\r\n");
      out.write("            悬赏类别∨\r\n");
      out.write("        </div>\r\n");
      out.write("        <ul id=\"leibieUl\">\r\n");
      out.write("            <li>代取快递</li>\r\n");
      out.write("            <li>代送外卖</li>\r\n");
      out.write("            <li>代买商品</li>\r\n");
      out.write("        </ul>\r\n");
      out.write("        <div class=\"shousuokuangTop\">\r\n");
      out.write("            <div class=\"Center\">\r\n");
      out.write("                <form class=\"form-inline\">\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                      <label class=\"sr-only\" for=\"exampleInputAmount\"></label>\r\n");
      out.write("                      <div class=\"input-group\">\r\n");
      out.write("                        <input type=\"text\" id=\"input\" class=\"form-control\" id=\"exampleInputAmount\" placeholder=\"\">\r\n");
      out.write("                      </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <button type=\"button\" id=\"botton\" class=\"btn btn-primary\">搜索</button>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"xuanshang\">\r\n");
      out.write("        <div class=\"xuanshangneirong\">\r\n");
      out.write("            <ul class=\"fenye\">\r\n");
      out.write("                ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("</ul>\r\n");
      out.write("            \r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- <div id=\"page\"></div> -->\r\n");
      out.write("    </div>\r\n");
      out.write("    <script src=\"../js/jquery-3.3.1.min.js\"></script>\r\n");
      out.write("    <script src=\"../js/bootstrap.min.js\"></script>\r\n");
      out.write("    <script src=\"../js/template-web.js\"></script>\r\n");
      out.write("    <script src=\"../dist/easySlider.js\"></script>\r\n");
      out.write("    <script src=\"../js/index.js\"></script>\r\n");
      out.write("    <script src=\"../js/xuanshang.js\"></script>\r\n");
      out.write("    <script>\r\n");
      out.write("    \t$('.btn-chakan').on('click', function() {\r\n");
      out.write("    \t \t//$('.btn-xuanshang').siblings().remove();\r\n");
      out.write("    \t \tconsole.log($('.btn-xuanshang'))\r\n");
      out.write("    \t})\r\n");
      out.write("    \t\r\n");
      out.write("        $('.btn-true').on('click', function() {\r\n");
      out.write("        var x = '';\r\n");
      out.write("            $('.modal-body input[type=\"text\"]').each(function() {\r\n");
      out.write("                //console.log(this.value)\r\n");
      out.write("                if (this.value == '') {\r\n");
      out.write("                    $('.btn-true').attr(\"disabled\",true); \r\n");
      out.write("                    // alert(\"请填写完整信息\")\r\n");
      out.write("                    $('.wanzheng').css('display', 'inline-block');\r\n");
      out.write("                } else {\r\n");
      out.write("                    $('.btn-true').attr(\"disabled\",false);\r\n");
      out.write("                    $('.wanzheng').css('display', 'none');\r\n");
      out.write("\t\t\t\t\tx += this.value+ ','\r\n");
      out.write("                }\r\n");
      out.write("            })\r\n");
      out.write("             $.ajax({\r\n");
      out.write("                    \turl: encodeURI('http://localhost:8086/Money/insert?name=' + x),\r\n");
      out.write("                    \ttype: 'get',\r\n");
      out.write("                    \tdataType: 'json',\r\n");
      out.write("                    \tscriptCharset: 'UTF-8',\r\n");
      out.write("                    \tcontentType: \"application/x-www-form-urlencoded; charset=UTF-8\",\r\n");
      out.write("                    \t//contentType:'application/json',\r\n");
      out.write("                    \tsuccess: function(a){\r\n");
      out.write("                    \t\tif(a.status==200){\r\n");
      out.write("                    \t\t$('.chenggong').css('display', 'inline-block');\r\n");
      out.write("                    \t\t\t//alert(\"添加成功\")\r\n");
      out.write("                    \t\t}else{\r\n");
      out.write("                    \t\t\t//alert(\"添加失败，请重新添加\")\r\n");
      out.write("                    \t\t\t$('.shibai').css('display', 'inline-block');\r\n");
      out.write("                    \t\t}\r\n");
      out.write("                    \t\t\r\n");
      out.write("                 }\r\n");
      out.write("            })\r\n");
      out.write("        })\r\n");
      out.write("        \r\n");
      out.write("        $('.btn-md').on('click', function() {\r\n");
      out.write("            $('.btn-true').attr(\"disabled\",false);\r\n");
      out.write("            $('.chenggong').css('display', 'none');\r\n");
      out.write("            $('.shibai').css('display', 'none');\r\n");
      out.write("            \r\n");
      out.write("        })\r\n");
      out.write("                   \r\n");
      out.write("\r\n");
      out.write("\t$(\".neirong\").each(function(){\r\n");
      out.write("       var len=$(this).text().length;   //当前HTML对象text的长度\r\n");
      out.write("       if(len>7){\r\n");
      out.write("           var str=\"\";\r\n");
      out.write("           str=$(this).text().substring(0,7)+\"......\";  //使用字符串截取，获取前30个字符，多余的字符使用“......”代替\r\n");
      out.write("           $(this).html(str);                   //将替换的值赋值给当前对象\r\n");
      out.write("       }\r\n");
      out.write("    });\r\n");
      out.write("    \r\n");
      out.write("   \r\n");
      out.write("\r\n");
      out.write("    </script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/jsp/xuanshang.jsp(103,16) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/jsp/xuanshang.jsp(103,16) '${msg.data }'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${msg.data }",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/jsp/xuanshang.jsp(103,16) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("m");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("<li>\r\n");
          out.write("                    <i>标题</i>\r\n");
          out.write("                    <span class=\"biaoti\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${m.title }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</span>\r\n");
          out.write("                    <i>价格</i>\r\n");
          out.write("                    <span class=\"jiage\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${m.prices }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</span>\r\n");
          out.write("                    <i>地址</i>\r\n");
          out.write("                    <span class=\"dizhi\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${m.location }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</span>\r\n");
          out.write("                    <i>内容</i>\r\n");
          out.write("                    <span class=\"neirong\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${m.contet }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</span>\r\n");
          out.write("                    <button type=\"button\" class=\"btn btn-primary btn-chakan\" data-toggle=\"modal\" data-target=\".bs-example-modal-lg\">查看详情</button>\r\n");
          out.write("                    <div class=\"modal fade bs-example-modal-lg btn-xuanshang\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myLargeModalLabel\">\r\n");
          out.write("\t\t\t\t\t  <div class=\"modal-dialog modal-lg\" role=\"document\">\r\n");
          out.write("\t\t\t\t\t    <div class=\"modal-content\">\r\n");
          out.write("\t\t                    <table>\r\n");
          out.write("\t\t                    \t<tr>\r\n");
          out.write("\t\t                    \t\t<td><i style=\"color: #000; width: 300px;height: 100px;word-break:break-all; overflow:auto; \">标题</i></td>\r\n");
          out.write("\t\t                    \t\t<td><span style=\"color: #000; width: 540px;height: 100px;word-break:break-all; overflow:auto; \">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${m.title }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</span></td>\r\n");
          out.write("\t\t                    \t</tr>\r\n");
          out.write("\t\t                    \t<tr>\r\n");
          out.write("\t\t                    \t\t<td><i style=\"color: #000; width: 300px;height: 100px;word-break:break-all; overflow:auto; \">价格</i></td>\r\n");
          out.write("\t\t                    \t\t<td><span style=\"color: #000; width: 540px;height: 100px;word-break:break-all; overflow:auto; \">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${m.prices }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</span></td>\r\n");
          out.write("\t\t                    \t</tr>\r\n");
          out.write("\t\t                    \t<tr>\r\n");
          out.write("\t\t                    \t\t<td><i style=\"color: #000; width: 300px;height: 100px;word-break:break-all; overflow:auto; \">地址</i></td>\r\n");
          out.write("\t\t                    \t\t<td><span style=\"color: #000; width: 540px;height: 100px;word-break:break-all; overflow:auto; \">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${m.location }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</span></td>\r\n");
          out.write("\t\t                    \t</tr>\r\n");
          out.write("\t\t                    \t<tr>\r\n");
          out.write("\t\t                    \t\t<td><i style=\"color: #000; width: 300px;height: 200px;word-break:break-all; overflow:auto; \">内容</i></td>\r\n");
          out.write("\t\t                    \t\t<td><span style=\"color: #000; width: 540px;height: 200px;word-break:break-all; overflow:auto; \">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${m.contet }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</span></td>\r\n");
          out.write("\t\t                    \t</tr>\r\n");
          out.write("\t\t                    </table>\r\n");
          out.write("\t\t                      <div class=\"modal-footer\">\r\n");
          out.write("\t\t\t\t\t\t        <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">接受悬赏</button>\r\n");
          out.write("\t\t\t\t\t\t      </div>\t\r\n");
          out.write("\t\t\t\t\t    </div>\r\n");
          out.write("\t\t\t\t\t  </div>\t\r\n");
          out.write("\t\t\t\t\t  </div>   \r\n");
          out.write("\t\t\t\t\t\r\n");
          out.write("                </li>    \r\n");
          out.write("                \r\n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}
