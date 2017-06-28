package assignment7.session3.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assignment7.session3.dao.EmployeeDao;

@WebServlet("/AddEmployee")
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public AddEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int employeeId = Integer.parseInt(request.getParameter("id"));
		String employeeName = request.getParameter("name");
		String designation = request.getParameter("designation");
		int salary = Integer.parseInt(request.getParameter("salary"));
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		EmployeeDao dao = new EmployeeDao();
		
		String result = dao.insertEmployee(employeeId,employeeName,designation,salary);
		
		if(result.equals("success")){
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Employee Success</title>");
			out.println("<meta http-equiv = \"refresh\" content=\"3; URL=showEmployee.jsp\" />");
			out.println("</head>");
			out.println("<body>");
			out.println("<h2>Employee saved successfully!!!!</h2>");
			out.println("</body>");
			out.println("</html>");
		}
		else if(result.equals("error")){
			out.println("Error while inserting details!!!");
		}
	 
	}

}
