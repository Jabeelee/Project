/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.54
 * Generated at: 2021-12-30 06:31:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.admin.notice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class updateNotice_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("jar:file:/C:/CamFlex/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/CamFlex/WEB-INF/lib/jstl-1.2.jar!/META-INF/fn.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1635990631419L));
    _jspx_dependants.put("jar:file:/C:/CamFlex/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/CamFlex/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>공지사항 수정 페이지</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\r\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n");
      out.write("  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"https://code.jquery.com/jquery-1.12.4.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(function(){\r\n");
      out.write("	var value = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${update.n_photo}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\";\r\n");
      out.write("	if(value != \"\"){\r\n");
      out.write("		var img = $(\"<img>\");\r\n");
      out.write("		$(\"#imgView\").hover(function(){\r\n");
      out.write("			img.attr({\r\n");
      out.write("				src:\"/uploadStorage/notice/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${update.n_photo}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\",\r\n");
      out.write("				width:\"200px\",\r\n");
      out.write("				height:\"100px\"\r\n");
      out.write("			});\r\n");
      out.write("			img.addClass(\"imgViewDate\");\r\n");
      out.write("			$(\"#imgArea\").append(img);\r\n");
      out.write("		},function(){\r\n");
      out.write("			img.remove();\r\n");
      out.write("		});\r\n");
      out.write("	}else{\r\n");
      out.write("		$('#imgView').hide();\r\n");
      out.write("	}\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("$(function(){\r\n");
      out.write("	$(\"#updateNoticeBtn\").click(function(){\r\n");
      out.write("		if(!chkSubmit($('#n_title'), \"공지사항 제목을\")) return;\r\n");
      out.write("		else if(!chkSubmit($('#n_content'), \"내용을\")) return;\r\n");
      out.write("		else{\r\n");
      out.write("			if($('#file').val() != \"\"){\r\n");
      out.write("				if(!chkFile($('#file')))return;\r\n");
      out.write("			}\r\n");
      out.write("			if(confirm('수정을 진핼할까요?')){\r\n");
      out.write("		$(\"#updateForm\").attr({\r\n");
      out.write("			\"method\":\"post\",\r\n");
      out.write("			\"action\":\"/admin/notice/update\"\r\n");
      out.write("		});	\r\n");
      out.write("		\r\n");
      out.write("		$(\"#updateForm\").submit();\r\n");
      out.write("		}\r\n");
      out.write("		}\r\n");
      out.write("	});\r\n");
      out.write("\r\n");
      out.write("	$(\"#noticeListBtn\").click(function(){\r\n");
      out.write("		location.href=\"/admin/notice/noticeList\";\r\n");
      out.write("	});\r\n");
      out.write("});	\r\n");
      out.write("function chkFile(item){\r\n");
      out.write("\r\n");
      out.write("	var ext = item.val().split('.').pop().toLowerCase();\r\n");
      out.write("	if(jQuery.inArray(ext, ['gif','png','jpg','jpeg']) == -1) {\r\n");
      out.write("		alert('gif, png, jpg, jpeg 파일만 업로드 할 수 있습니다.');\r\n");
      out.write("		return false;\r\n");
      out.write("	}else{\r\n");
      out.write("		return true;	\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("}\r\n");
      out.write("function chkSubmit(item, msg){\r\n");
      out.write("	if(item.val().replace(/\\s/g,\"\") == \"\"){\r\n");
      out.write("		alert(msg + \"입력해 주세요.\");\r\n");
      out.write("		item.val(\"\");\r\n");
      out.write("		item.focus();\r\n");
      out.write("		return false();\r\n");
      out.write("	}else{\r\n");
      out.write("		return true;\r\n");
      out.write("	}\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("	<div align=\"center\"><h3>공지사항 글 수정</h3></div>\r\n");
      out.write("	<div align=\"center\">\r\n");
      out.write("		<form id=\"updateForm\" name=\"updateForm\" enctype=\"multipart/form-data\">\r\n");
      out.write("			<input type=\"hidden\" id=\"n_number\" name=\"n_number\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${update.n_number}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" />\r\n");
      out.write("\r\n");
      out.write("			<table class=\"table\" border=\"1\">\r\n");
      out.write("				<colgroup>\r\n");
      out.write("					<col width=\"17%\" />\r\n");
      out.write("					<col width=\"83%\" />\r\n");
      out.write("				</colgroup>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>글 제목</td>\r\n");
      out.write("					<td><input type=\"text\" class=\"form-control\" name=\"n_title\" id=\"n_title\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${update.n_title}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"></td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>글 내용</td>\r\n");
      out.write("					<td><textarea name=\"n_content\" class=\"form-control\" id=\"n_content\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${update.n_content}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</textarea></td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>이미지</td>\r\n");
      out.write("					<td><input type=\"file\" name=\"file\" id=\"file\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${update.n_photo}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" /><span\r\n");
      out.write("							id=\"imgView\">기존 이미지 파일명: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${update.n_photo}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("<span\r\n");
      out.write("								id=\"imgArea\"></span></span></td>\r\n");
      out.write("				</tr>\r\n");
      out.write("			</table>\r\n");
      out.write("		</form>\r\n");
      out.write("	</div>\r\n");
      out.write("	<div align=\"right\">\r\n");
      out.write("			<input type=\"button\" value=\"수정\" id=\"updateNoticeBtn\" class=\"btn btn-default\"> <input\r\n");
      out.write("				type=\"button\" value=\"목록\" id=\"noticeListBtn\" class=\"btn btn-default\">\r\n");
      out.write("		</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
