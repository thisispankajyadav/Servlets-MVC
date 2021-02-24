package hospital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import hospital.pojo.Doctor;
import hospital.utility.DBUtility;

public class DoctorDaoImpl implements DoctorDao{
	DBUtility dbu=new DBUtility();
	Doctor d=new Doctor();
	List<Doctor> ld=new ArrayList<Doctor>();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	boolean f=false;
	int res=0;
	
	@Override
	public boolean addDoctor(Doctor d) {
		try
		{
			con=dbu.getConnection();
			String sql="insert into doctor(doc_name, doc_spl, doc_qual) values(?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1,d.getDoc_name());
			ps.setString(2,d.getDoc_spl());
			ps.setString(3,d.getDoc_qual());
			res=ps.executeUpdate();
			if(res>0)
			{
				f=true;
			}
			else
			{
				f=false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
	@Override
	public boolean deleteDoctor(int doc_id) {
		Doctor d2= new Doctor();
		try
		{
			con=dbu.getConnection();
			String sql= "delete from doctor where doc_id=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1,doc_id);
			res=ps.executeUpdate();
			if(res>0)
			{
				f=true;
			}
			else
			{
				f=false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
	@Override
	public List<Doctor> showAllDoctors() {
		
		try
		{
			con=dbu.getConnection();
			String sql="select * from doctor";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				Doctor d1= new Doctor();
				d1.setDoc_id(rs.getInt(1));
				d1.setDoc_name(rs.getString(2));
				d1.setDoc_spl(rs.getString(3));
				d1.setDoc_qual(rs.getString(4));
				ld.add(d1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ld;
	}
	@Override
	public boolean updateDoctor(Doctor d) {
		try
		{
			con=dbu.getConnection();
			String sql="update doctor set doc_name=?, doc_spl=?, doc_qual=? where doc_id=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, d.getDoc_name());
			ps.setString(2, d.getDoc_spl());
			ps.setString(3, d.getDoc_qual());
			ps.setInt(4, d.getDoc_id());
			res=ps.executeUpdate();
			if(res>0)
			{
				f=true;
			}
			else
			{
				f=false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
	@Override
	public Doctor searchDoctorById(int d_id) {
		Doctor d1= new Doctor();
		try
		{
			con=dbu.getConnection();
			String sql="select * from doctor where doc_id=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, d_id);
			rs=ps.executeQuery();
			while(rs.next())
			{
				d1.setDoc_id(rs.getInt(1));
				d1.setDoc_name(rs.getString(2));
				d1.setDoc_spl(rs.getString(3));
				d1.setDoc_qual(rs.getString(4));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return d1;
	}
}