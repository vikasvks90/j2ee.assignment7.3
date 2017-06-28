package assignment7.session3.dao;

import java.sql.*;

import assignment7.session3.factories.ConnectionFactory;

public class EmployeeDao {
	Connection con = null;
	PreparedStatement pst = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public String insertEmployee(int employeeId,String employeeName,String designation,int salary){
		try {
			con = ConnectionFactory.getConnection();
			pst = con.prepareStatement("insert into employee(employee_id,employee_name,designation,salary) values(?,?,?,?)");
		    pst.setInt(1,employeeId);
		    pst.setString(2,employeeName);
		    pst.setString(3,designation);
		    pst.setInt(4,salary);
			pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error while inserting into books");
			e.printStackTrace();
			return "error";
		} finally{
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("Error while closing the connection");
				e.printStackTrace();
			}
		}
		return "success";
	}
}
