package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;

public final class TimeRemaining_jsp extends org.apache.jasper.runtime.HttpJspBase
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

//        int number_of_question = Integer.parseInt(String.valueOf(request.getSession().getAttribute("number_of_question")));
    
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <h4>Time remaining :<strong id=\"count_down\" style=\"padding-left: 10px\"></strong></h4>\n");
      out.write("        <script>\n");
      out.write("            var time_end = ");
      out.print(request.getSession().getAttribute("time_end"));
      out.write(";\n");
      out.write("            function count_down() { \n");
      out.write("                var time_now = new Date().getTime();\n");
      out.write("                if(time_now > time_end) window.location.href = \"Result.jsp\";\n");
      out.write("                var sub = time_end - time_now;\n");
      out.write("                var sec = parseInt(sub/1000);\n");
      out.write("                var min = parseInt(sec/60);\n");
      out.write("                sec = sec - min*60;\n");
      out.write("                document.getElementById(\"count_down\").innerHTML = min + \" : \" + sec;\n");
      out.write("                setTimeout(\"count_down()\", 1000); \n");
      out.write("            }\n");
      out.write("            count_down();\n");
      out.write("        </script>\n");
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
