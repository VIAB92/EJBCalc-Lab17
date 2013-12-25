<%--
  Created by IntelliJ IDEA.
  User: Виктор
  Date: 24.12.13
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
  <%! double result=0, value1=0, value2=0; %>
  <form action="calculator" method="get">
      <%
          if (request.getAttribute("val1")!=null)
          {
              value1 = Double.parseDouble(String.valueOf(request.getAttribute("val1")));
          }
          if (request.getAttribute("val2")!=null)
          {
              value2 = Double.parseDouble(String.valueOf(request.getAttribute("val2")));
          }
      %>
      <p>Введите первое значение: <input type="text" id="val1" name="val1" value="<%=value1%>"/></p>
      <p>Введите второе значение: <input type="text" id="val2" name="val2" value="<%=value2%>"/></p>
        <%
            if (request.getAttribute("res")!=null)
            {
                result = Double.parseDouble(String.valueOf(request.getAttribute("res")));
            }
        %>

      <input type="radio" name="operation" value="+"/> + <br/>
      <input type="radio" name="operation" value="-"/> - <br/>
      <input type="radio" name="operation" value="*"/> * <br/>
      <input type="radio" name="operation" value="/"/> / <br/>
      <input type="radio" name="operation" value="M+"/> M+ <br/>
      <input type="radio" name="operation" value="MR"/> MR <br/>
      <input type="submit" value="Submit"/> <br/>
      <b>Result: </b><input type="text" readonly name="result" id="result" value="<%=result%>"/>
  </form>
  </body>
</html>
