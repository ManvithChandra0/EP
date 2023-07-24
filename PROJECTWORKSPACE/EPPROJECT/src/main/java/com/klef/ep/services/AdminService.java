package com.klef.ep.services;

import java.util.List;

import javax.ejb.Remote;

import com.klef.ep.models.Admin;
import com.klef.ep.models.Faculty;
import com.klef.ep.models.Student;

@Remote
public interface AdminService 
{
   public Admin CheckAdminLogin(String username,String password);
   public String AddStudent(Student student);
   public String AddFaculty(Faculty faculty);
   public List<Student> ViewAllStudents();
   public List<Faculty> ViewAllFaculty();
}
