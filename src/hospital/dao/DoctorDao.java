package hospital.dao;

import java.util.List;

import hospital.pojo.Doctor;

public interface DoctorDao {
	boolean addDoctor(Doctor d);
	
	boolean updateDoctor(Doctor d);
	
	boolean deleteDoctor(int doc_id);
	
	List<Doctor> showAllDoctors();
	
	Doctor searchDoctorById(int d_id);
}