package org.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/add")
public class AddServlet extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse resp)throws IOException  {
		String insert="insert into muliplation (idmuliplation)  value(?)";
		int i=Integer.parseInt(req.getParameter("num1"));
		int j=Integer.parseInt(req.getParameter("num2"));
		int k=i+j;
		PrintWriter out=resp.getWriter();
		
		out.print("Result:"+k);
		try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/chowdary_tt ?user=root&&password=root ");
PreparedStatement prepares=con.prepareStatement(insert);

prepares.setInt(1, k);
int result=prepares.executeUpdate();
if(result!=0) {
	out.print("<html>");
	out.print("<h1>addition suggesfully </h1>");
}else {
	out.print("<h1>not addition</h1>");
}
out.println("</html>");
	
		}catch(Exception e) {
			
		}
	}
	
}
