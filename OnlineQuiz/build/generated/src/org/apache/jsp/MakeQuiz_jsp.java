package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class MakeQuiz_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Header.jsp", out, false);
      out.write("\n");
      out.write("        <br>\n");
      out.write("        <form action=\"MakeQuiz\" method=\"POST\">\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Question : </td>\n");
      out.write("                    <!--<td><input type=\"text\" name=\"question\"></td>-->\n");
      out.write("                    <td><textarea cols=\"50\" rows=\"8\" name=\"question\" placeholder=\"Input your quesiotn here\"></textarea></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Option 1 : </td>\n");
      out.write("                    <td><textarea cols=\"50\" rows=\"3\" name=\"option1\"></textarea></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Option 2 : </td>\n");
      out.write("                    <td><textarea cols=\"50\" rows=\"3\" name=\"option2\"></textarea></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Option 3 : </td>\n");
      out.write("                    <td><textarea cols=\"50\" rows=\"3\" name=\"option3\"></textarea></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Option 4 : </td>\n");
      out.write("                    <td><textarea cols=\"50\" rows=\"3\" name=\"option4\"></textarea></td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("            <div>\n");
      out.write("                <h4 style=\"float: left\">Answer(s) : </h4><br>\n");
      out.write("                <table style=\"float: left\">\n");
      out.write("                    <tr>\n");
      out.write("                        <td><input type=\"checkbox\" name=\"ans_option_1\" value=\"1\" > Option 1</td>\n");
      out.write("                        <td><input type=\"checkbox\" name=\"ans_option_2\" value=\"2\"> Option 2</td>\n");
      out.write("                        <td><input type=\"checkbox\" name=\"ans_option_3\" value=\"3\" > Option 3</td>\n");
      out.write("                        <td><input type=\"checkbox\" name=\"ans_option_4\" value=\"4\"> Option 4</td>\n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("            <br><br>\n");
      out.write("            <input type=\"submit\" value=\"Save\">\n");
      out.write("        </form>\n");
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
