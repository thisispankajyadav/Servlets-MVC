
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hospital.dao.DoctorDao;
import hospital.dao.DoctorDaoImpl;
import hospital.pojo.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class DoctorServlet
 */
@WebServlet("/DoctorServlet")
public class DoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DoctorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out= response.getWriter();
		Doctor d= new Doctor();
		DoctorDao dao=new DoctorDaoImpl();
		HttpSession session=request.getSession();
		String opn=request.getParameter("operation");
		if(opn!=null && opn.equals("delete"))
		{
		int id=Integer.parseInt(request.getParameter("docId"));
		boolean flag=dao.deleteDoctor(id);
		if(flag)
		{
			out.print("Deleted successfully");
			request.setAttribute("success","record deleted successfully");
			List<Doctor> ld= dao.showAllDoctors();
			session.setAttribute("doctorlist", ld);
			RequestDispatcher rd= request.getRequestDispatcher("DoctorList.jsp");
			rd.forward(request, response);
		}
		else
		{
			request.setAttribute("failure","record not deleted ..... try again");
			RequestDispatcher rd= request.getRequestDispatcher("DoctorList.jsp");
			rd.forward(request, response);
		}
		}
		else if(opn!=null && opn.equals("getDoc"))
		{
			int id=Integer.parseInt(request.getParameter("docId"));
			Doctor d1=dao.searchDoctorById(id);
			
			session.setAttribute("doctorobj", d1);
			RequestDispatcher rd= request.getRequestDispatcher("UpdateDoctor.jsp");
			rd.forward(request, response);
			
		}
		else
		{
			List<Doctor> l= dao.showAllDoctors();
			session.setAttribute("doctorlist", l);
			RequestDispatcher rd= request.getRequestDispatcher("DoctorList.jsp");
			rd.forward(request, response);
		}
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		PrintWriter out= response.getWriter();
		HttpSession session=request.getSession();
		Doctor d= new Doctor();
		DoctorDao dao= new DoctorDaoImpl();
		String op=request.getParameter("operation");
		
		String name=request.getParameter("docname");
		String spl=request.getParameter("docspl");
		String qual=request.getParameter("docqual");

		d.setDoc_name(name);
		d.setDoc_spl(spl);
		d.setDoc_qual(qual);
		
		if(op!=null && op.equals("adddoc"))	
		{
			boolean flag=dao.addDoctor(d);
			if(flag)
			{
				//out.print("Doctor added successfully");
				request.setAttribute("success","record added successfully");
				List<Doctor> dl=dao.showAllDoctors();
				session.setAttribute("doctorlist", dl);
				RequestDispatcher rd=request.getRequestDispatcher("DoctorList.jsp");
				rd.forward(request, response);
			}
			else
			{

				request.setAttribute("failure","record not added...try again!!!!");
				RequestDispatcher rd=request.getRequestDispatcher("AddDoctor.jsp");
				rd.forward(request, response);
			}
		}
		else if(op!=null&&op.equals("updatedoc"))
		{
			int id=Integer.parseInt(request.getParameter("docId"));
			d.setDoc_id(id);
			
			boolean flag=dao.updateDoctor(d);
			if(flag)
			{
				request.setAttribute("success","record updated successfully");
				List<Doctor> dl= dao.showAllDoctors();
				session.setAttribute("doctorlist", dl);
				RequestDispatcher rd= request.getRequestDispatcher("DoctorList.jsp");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("failure","record not updated... try again");
				RequestDispatcher rd= request.getRequestDispatcher("UpdateDoctor.jsp");
				rd.forward(request, response);
			}
			
		}
		
	}

}
