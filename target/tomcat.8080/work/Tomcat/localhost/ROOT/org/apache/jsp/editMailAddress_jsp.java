/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.13
 * Generated at: 2018-12-29 14:13:03 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class editMailAddress_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

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
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
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

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/actionTagHead.jsp", out, false);
      out.write("\n");
      out.write("<title>Insert title here</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/actionTagHeader.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("\t<div class=\"body-wrapper\">\n");
      out.write("\n");
      out.write("\t\t<!-- メールアドレス変更のフォーム -->\n");
      out.write("\t\t<div class=\"editinfo-t\">Change Mail Address</div>\n");
      out.write("\t\t<form action=\"/unmold/EditMailLogic\" name=\"editForm\" method=\"post\"\n");
      out.write("\t\t\tonsubmit=\"return validateEditInfo()\" class=\"editinfo-f\">\n");
      out.write("\n");
      out.write("\t\t\t");

				if (request.getParameter("update") != null) {
					String updatedSuccess = request.getParameter("update");
			
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t");

				if (updatedSuccess.equals("failure")) {
			
      out.write("\n");
      out.write("\t\t\t<div class=\"error-msg\">\n");
      out.write("\t\t\t\tFailed.<br>Entered password was wrong or new mail address is\n");
      out.write("\t\t\t\talready in use...\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t");

				}}
			
      out.write("\n");
      out.write("\n");
      out.write("\t\t\tNew Mail Address <br> <input type=\"text\" name=\"mail\"\n");
      out.write("\t\t\t\tplaceholder=\"New Mail Address\" maxlength=\"200\"><br> <br>\n");
      out.write("\t\t\tCurrent password <br> <input type=\"password\"\n");
      out.write("\t\t\t\tname=\"passwordForEditMail\" placeholder=\"Current password\"\n");
      out.write("\t\t\t\tmaxlength=\"30\"><br> <br>\n");
      out.write("\t\t\t<button type=\"submit\" name=\"submit\" class=\"button\">submit</button>\n");
      out.write("\t\t</form>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t<!-- パスワード変更のフォーム -->\n");
      out.write("\t\t<div class=\"editinfo-t\">Change Password</div>\n");
      out.write("\t\t<form action=\"/unmold/EditPasswordLogic\" name=\"editPasswordForm\"\n");
      out.write("\t\t\tmethod=\"post\" onsubmit=\"return validateEditPassword()\"\n");
      out.write("\t\t\tclass=\"editinfo-f\" id=\"editPassword\">\n");
      out.write("\t\t\t<!-- jsでチェックあるのでエラーメッセージ返すことはないと思う -->\n");
      out.write("\t\t\t");

				if (request.getParameter("update") != null) {
					String updatedSuccess = request.getParameter("update");
			
      out.write("\n");
      out.write("\t\t\t");

				if (updatedSuccess.equals("failure2")) {
			
      out.write("\n");
      out.write("\t\t\t<div class=\"error-msg\">\n");
      out.write("\t\t\t\tFailed.<br>Password is too long or empty..\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t");

				}}
			
      out.write("\n");
      out.write("\t\t\tNew password<br> <input type=\"password\"\n");
      out.write("\t\t\t\tname=\"newPassword\" placeholder=\"New password\" maxlength=\"30\"><br>\n");
      out.write("\t\t\t<br>Re-type new password<br> <input type=\"password\"\n");
      out.write("\t\t\t\tname=\"newPassword2\" placeholder=\"Re-type new password\"\n");
      out.write("\t\t\t\tmaxlength=\"30\"><br> <br>\n");
      out.write("\t\t\t\tCurrent password<br> <input type=\"password\"\n");
      out.write("\t\t\t\tname=\"currentPassword\" placeholder=\"Current password\" maxlength=\"30\"><br> <br><br>\n");
      out.write("\t\t\t<button type=\"submit\" name=\"submit\" class=\"button\">submit</button>\n");
      out.write("\t\t</form>\n");
      out.write("\t</div>\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/actionTagFooter.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
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
