package ijse.lk.dbp.dao.custom;

import ijse.lk.dbp.dao.CrudDAO;
import ijse.lk.dbp.entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentDAO extends CrudDAO<Student,String> {
    public ArrayList<Student> searchStudents(String enteredText) throws SQLException, ClassNotFoundException;

}
