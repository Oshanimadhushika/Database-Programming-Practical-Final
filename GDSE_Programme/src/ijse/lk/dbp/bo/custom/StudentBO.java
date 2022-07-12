package ijse.lk.dbp.bo.custom;

import ijse.lk.dbp.bo.SuperBO;
import ijse.lk.dbp.dto.StudentDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentBO extends SuperBO {
    public ArrayList<StudentDTO> searchStudents(String enteredText) throws SQLException, ClassNotFoundException;

    ArrayList<StudentDTO> getAllStudents() throws SQLException, ClassNotFoundException;

    boolean saveStudent(StudentDTO dto) throws SQLException, ClassNotFoundException;

    boolean updateStudent(StudentDTO dto) throws SQLException, ClassNotFoundException;

    boolean StudentExist(String id) throws SQLException, ClassNotFoundException;

    boolean deleteStudent(String id) throws SQLException, ClassNotFoundException;
}
