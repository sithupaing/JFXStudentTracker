/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Date;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import student.app.dao.StudentDAO;
import student.app.model.Student;

import static org.junit.Assert.*;

/**
 *
 * @author Sithu
 */
public class StudentDAOTest {
    
    public StudentDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
//     @Test
     public void testSave() throws SQLException {
         StudentDAO dao = new StudentDAO();
         Date dob = new Date(System.currentTimeMillis());
         Student sd = new Student("Aye Aye","ayeaye@gmail.com","Female",dob);
         assertEquals(1, dao.save(sd));
     }
     
//     @Test
     public void testGetStudents() throws SQLException{
         StudentDAO dao = new StudentDAO();
         assertEquals(2, dao.getStudents().size());
     }
     
     @Test
     public void testDeleteStudent() throws SQLException{
         StudentDAO dao = new StudentDAO();
         assertEquals(1, dao.deleteStudent(10));
     }
}
