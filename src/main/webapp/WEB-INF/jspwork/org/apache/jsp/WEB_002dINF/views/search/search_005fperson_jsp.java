/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.62
 * Generated at: 2022-06-09 00:05:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.search;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class search_005fperson_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1651196450364L));
    _jspx_dependants.put("jar:file:/C:/workspace/5_Server/moochelinGuide/src/main/webapp/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425946270000L));
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
      out.write("<html lang=\"ko\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>moochelinGuide</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/css/main-style.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/css/searchPerson-style.css\">\r\n");
      out.write("    \r\n");
      out.write("    <script src=\"https://kit.fontawesome.com/1163d62f29.js\" crossorigin=\"anonymous\"></script> <!-- 검색 결과 없는 경우 표시할 아이콘-->\r\n");
      out.write("    <script src=\"https://kit.fontawesome.com/e4f51ae88c.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n");
      out.write("    <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Dongle&family=Gowun+Batang&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    \r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/common/header.jsp", out, false);
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    <main> \r\n");
      out.write("        <section class=\"content-explain\">\r\n");
      out.write("            <div>\r\n");
      out.write("                <p>\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${query}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"의 검색결과</p>\r\n");
      out.write("            </div>\r\n");
      out.write("        </section>\r\n");
      out.write("        <section class=\"sch-menu\">\r\n");
      out.write("            <ul>\r\n");
      out.write("                <li><a href=\"title?query=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${query}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">제목</a></li>\r\n");
      out.write("                <li><b>인물</b></li>\r\n");
      out.write("                <li><a href=\"user?query=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${query}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">유저</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </section>\r\n");
      out.write("        <section class=\"content-main\">\r\n");
      out.write("            <section class=\"movie-list-row\">\r\n");
      out.write("                    <div class=\"sch-person\">\r\n");
      out.write("                        <div>\r\n");
      out.write("                            <img src=\"#\" class=\"sch-img-person\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"sch-person-info\">\r\n");
      out.write("                            <div>배우이름</div>\r\n");
      out.write("                            <div>배우</div>\r\n");
      out.write("                            <div><a href=#\"\">영화이름</a><a href=\"#\">영화이름</a></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"sch-person\">\r\n");
      out.write("                        <div>\r\n");
      out.write("                            <img src=\"#\" class=\"sch-img-person\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"sch-person-info\">\r\n");
      out.write("                            <div>배우이름</div>\r\n");
      out.write("                            <div>배우</div>\r\n");
      out.write("                            <div><a href=#\"\">영화이름</a><a href=\"#\">영화이름</a></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"sch-person\">\r\n");
      out.write("                        <div>\r\n");
      out.write("                            <img src=\"#\" class=\"sch-img-person\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"sch-person-info\">\r\n");
      out.write("                            <div>배우이름</div>\r\n");
      out.write("                            <div>배우</div>\r\n");
      out.write("                            <div><a href=#\"\">영화이름</a><a href=\"#\">영화이름</a></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"sch-person\">\r\n");
      out.write("                        <div>\r\n");
      out.write("                            <img src=\"#\" class=\"sch-img-person\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"sch-person-info\">\r\n");
      out.write("                            <div>배우이름</div>\r\n");
      out.write("                            <div>배우</div>\r\n");
      out.write("                            <div><a href=#\"\">영화이름</a><a href=\"#\">영화이름</a></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"sch-person\">\r\n");
      out.write("                        <div>\r\n");
      out.write("                            <img src=\"#\" class=\"sch-img-person\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"sch-person-info\">\r\n");
      out.write("                            <div>배우이름</div>\r\n");
      out.write("                            <div>배우</div>\r\n");
      out.write("                            <div><a href=#\"\">영화이름</a><a href=\"#\">영화이름</a></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"sch-person\">\r\n");
      out.write("                        <div>\r\n");
      out.write("                            <img src=\"#\" class=\"sch-img-person\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"sch-person-info\">\r\n");
      out.write("                            <div>배우이름</div>\r\n");
      out.write("                            <div>배우</div>\r\n");
      out.write("                            <div><a href=#\"\">영화이름</a><a href=\"#\">영화이름</a></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"sch-person\">\r\n");
      out.write("                        <div>\r\n");
      out.write("                            <img src=\"#\" class=\"sch-img-person\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"sch-person-info\">\r\n");
      out.write("                            <div>배우이름</div>\r\n");
      out.write("                            <div>배우</div>\r\n");
      out.write("                            <div><a href=#\"\">영화이름</a><a href=\"#\">영화이름</a></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"sch-person\">\r\n");
      out.write("                        <div>\r\n");
      out.write("                            <img src=\"#\" class=\"sch-img-person\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"sch-person-info\">\r\n");
      out.write("                            <div>배우이름</div>\r\n");
      out.write("                            <div>배우</div>\r\n");
      out.write("                            <div><a href=#\"\">영화이름</a><a href=\"#\">영화이름</a></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("            </section>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"view-more\">\r\n");
      out.write("                <button>더보기 ▽ </button>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </section>\r\n");
      out.write("    </main>\r\n");
      out.write("\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/common/footer.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.6.0.js\" integrity=\"sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("	<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/js/main.js\"></script>\r\n");
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
