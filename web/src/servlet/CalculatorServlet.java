package servlet;

import beans.CalculatorBean;

import javax.ejb.EJB;
import java.io.IOException;

/**
 * Created by Виктор on 24.12.13.
 */
@javax.servlet.annotation.WebServlet(name = "CalculatorServlet", urlPatterns = "/calculator")
public class CalculatorServlet extends javax.servlet.http.HttpServlet {
    @EJB
    private CalculatorBean calculatorBean;
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        if (request.getParameter("operation")!=null)
        {
            String operation = request.getParameter("operation");

            if (operation.equals("+"))
            {
                double val1 = Double.parseDouble(request.getParameter("val1"));
                double val2 = Double.parseDouble(request.getParameter("val2"));
                double res = calculatorBean.sum(val1, val2);
                request.setAttribute("res", res);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            else if (operation.equals("-"))
            {
                double val1 = Double.parseDouble(request.getParameter("val1"));
                double val2 = Double.parseDouble(request.getParameter("val2"));
                double res = calculatorBean.sub(val1, val2);
                request.setAttribute("res", res);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            else if (operation.equals("/"))
            {
                double val1 = Double.parseDouble(request.getParameter("val1"));
                double val2 = Double.parseDouble(request.getParameter("val2"));
                double res = calculatorBean.div(val1, val2);
                request.setAttribute("res", res);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            else if (operation.equals("*"))
            {
                double val1 = Double.parseDouble(request.getParameter("val1"));
                double val2 = Double.parseDouble(request.getParameter("val2"));
                double res = calculatorBean.mul(val1, val2);
                request.setAttribute("res", res);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            else if(operation.equals("M+"))
            {
                double value = Double.parseDouble(request.getParameter("result"));
                calculatorBean.setMemoryValue(value);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            else if(operation.equals("MR"))
            {
                double value = calculatorBean.getMemoryValue();
                request.setAttribute("val1", value);
                request.setAttribute("val2", value);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
        else
        {
            request.setAttribute("res", 0);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

        //String hello = calculatorBean.test();
       // request.setAttribute("op", operation);
        //request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
