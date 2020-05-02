package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Account;

public final class Header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    ");

        Account a = Account.class.cast(request.getSession().getAttribute("account"));
    
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <table id=\"header\">\n");
      out.write("            <tr id=\"header\">\n");
      out.write("                <td id=\"header\"><a href=\"Home.jsp\">Home</a></td>\n");
      out.write("                ");
if (a != null) {
      out.write("\n");
      out.write("                    ");
if (a.getType().equals("0")) {
      out.write("\n");
      out.write("                        <td id=\"header\"><a href=\"TakeQuiz-NumberOfQuestion.jsp\">Take Quiz</a></td>\n");
      out.write("                    ");
} else {
      out.write("\n");
      out.write("                        <td id=\"header\"><a href=\"MakeQuiz.jsp\">Make Quiz</a></td>\n");
      out.write("                        <td id=\"header\"><a href=\"ManageQuiz\">Manage Quiz</a></td>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                    <td id=\"header\"><a href=\"Logout\">Logout</a></td>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
