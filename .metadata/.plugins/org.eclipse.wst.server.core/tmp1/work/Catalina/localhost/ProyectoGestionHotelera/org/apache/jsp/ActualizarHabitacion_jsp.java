/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.1
 * Generated at: 2024-10-23 19:08:10 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Habitacion;

public final class ActualizarHabitacion_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html; charset=ISO-8859-1");
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
      out.write("<html lang=\"es\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"ISO-8859-1\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>Actualizar Habitación</title>\r\n");
      out.write("    <style>\r\n");
      out.write("        body {\r\n");
      out.write("            font-family: Arial, sans-serif;\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            padding: 0;\r\n");
      out.write("            background-color: #f4f4f4;\r\n");
      out.write("            display: flex;\r\n");
      out.write("            flex-direction:column;\r\n");
      out.write("            justify-content: center;\r\n");
      out.write("            align-items: center;\r\n");
      out.write("            height: 100vh;\r\n");
      out.write("        }\r\n");
      out.write("        h1 {\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            color: #333;\r\n");
      out.write("            margin-bottom: 20px;\r\n");
      out.write("        }\r\n");
      out.write("        .box-registro {\r\n");
      out.write("            background-color: #ffffff;\r\n");
      out.write("            padding: 20px;\r\n");
      out.write("            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\r\n");
      out.write("            border-radius: 10px;\r\n");
      out.write("            width: 400px;\r\n");
      out.write("        }\r\n");
      out.write("        form {\r\n");
      out.write("            display: flex;\r\n");
      out.write("            flex-direction: column;\r\n");
      out.write("        }\r\n");
      out.write("        label {\r\n");
      out.write("            margin-bottom: 5px;\r\n");
      out.write("            color: #333;\r\n");
      out.write("        }\r\n");
      out.write("        input[type=\"text\"], input[type=\"number\"], select {\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            padding: 10px;\r\n");
      out.write("            margin-bottom: 15px;\r\n");
      out.write("            border: 1px solid #ccc;\r\n");
      out.write("            border-radius: 5px;\r\n");
      out.write("            box-sizing: border-box;\r\n");
      out.write("        }\r\n");
      out.write("        button {\r\n");
      out.write("            background-color: #4CAF50;\r\n");
      out.write("            color: white;\r\n");
      out.write("            border: none;\r\n");
      out.write("            padding: 10px 20px;\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("            border-radius: 5px;\r\n");
      out.write("            font-size: 16px;\r\n");
      out.write("            margin-top: 10px;\r\n");
      out.write("        }\r\n");
      out.write("        button:hover {\r\n");
      out.write("            background-color: #45a049;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<h1>Actualizar Habitación</h1>\r\n");
      out.write("\r\n");
      out.write("<div class=\"box-registro\">\r\n");
      out.write("    <form action=\"ControladorHabitacion\" method=\"post\">\r\n");
      out.write("        ");

        String id = (request.getAttribute("id") != null) ? request.getAttribute("id").toString() : "";
        String tipoHabitacion = (request.getAttribute("tipoHabitacion") != null) ? request.getAttribute("tipoHabitacion").toString() : "";
        String precio = (request.getAttribute("precio") != null) ? request.getAttribute("precio").toString() : "";
        String comodidades = (request.getAttribute("comodidades") != null) ? request.getAttribute("comodidades").toString() : "";
        String estadoHabitacion = (request.getAttribute("estadoHabitacion") != null) ? request.getAttribute("estadoHabitacion").toString() : "";
        
      out.write("\r\n");
      out.write("        <label for=\"id\">ID HABITACIÓN</label>\r\n");
      out.write("        <input type=\"text\" id=\"id\" name=\"id\" value=\"");
      out.print(id);
      out.write("\" readonly>\r\n");
      out.write("        \r\n");
      out.write("        <label for=\"tipoHabitacion\">TIPO DE HABITACIÓN</label>\r\n");
      out.write("        <input type=\"text\" id=\"tipoHabitacion\" name=\"tipoHabitacion\" value=\"");
      out.print(tipoHabitacion);
      out.write("\" required>\r\n");
      out.write("        \r\n");
      out.write("        <label for=\"precio\">PRECIO</label>\r\n");
      out.write("        <input type=\"text\" id=\"precio\" name=\"precio\" value=\"");
      out.print(precio);
      out.write("\" required>\r\n");
      out.write("        \r\n");
      out.write("        <label for=\"comodidades\">COMODIDADES</label>\r\n");
      out.write("        <input type=\"text\" id=\"comodidades\" name=\"comodidades\" value=\"");
      out.print(comodidades);
      out.write("\" required>\r\n");
      out.write("        \r\n");
      out.write("        <label for=\"estadoHabitacion\">ESTADO</label>\r\n");
      out.write("        <input type=\"text\" id=\"estadoHabitacion\" name=\"estadoHabitacion\" value=\"");
      out.print(estadoHabitacion);
      out.write("\" required>\r\n");
      out.write("        \r\n");
      out.write("        <button type=\"submit\">Actualizar Habitación</button>\r\n");
      out.write("    </form>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
}
