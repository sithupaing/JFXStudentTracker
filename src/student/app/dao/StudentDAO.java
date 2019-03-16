/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.app.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import student.app.database.Database;
import student.app.model.Student;

/**
 *
 * @author Sithu
 */
public class StudentDAO {
    
    public int save(Student student) throws SQLException{
        Connection conn = Database.getInstance().getConnection();
        String sql = "insert into students (name,email,gender,dob) value (?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1,student.getName());
        stmt.setString(2,student.getEmail());
        stmt.setString(3, student.getGender());
        stmt.setDate(4,student.getDob());
        int rows = stmt.executeUpdate();
        return rows;
    }
    
    public List<Student> getStudents() throws SQLException{
        Connection conn = Database.getInstance().getConnection();
        String sql = "select * from students";
        Statement stmt = conn.createStatement();
        ResultSet result =  stmt.executeQuery(sql);
        List<Student> students = new ArrayList<>();
        while(result.next()){
            int id = result.getInt("id");
            String name = result.getString("name");
            String email = result.getString("email");
            String gender = result.getString("gender");
            Date dob = result.getDate("dob");
            Student sd = new Student(id, name, email, gender, dob);
            students.add(sd);
        }
        return students;
    }
    
    public int deleteStudent(int id) throws SQLException{
        Connection conn = Database.getInstance().getConnection();
        String sql = "delete from students where id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        int rows = stmt.executeUpdate();
        return rows;
    }

    public int updateStudent(Student sd) throws SQLException {
        Connection conn = Database.getInstance().getConnection();
        String sql = "update students set name=?,email=?,gender=?,dob=? where id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, sd.getName());
        stmt.setString(2, sd.getEmail());
        stmt.setString(3, sd.getGender());
        stmt.setDate(4, sd.getDob());
        stmt.setInt(5, sd.getId());
        int rows = stmt.executeUpdate();
        return rows;
    }
    
    
    
}
