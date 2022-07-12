package ijse.lk.dbp.bo.custom.impl;

import ijse.lk.dbp.bo.custom.StudentBO;
import ijse.lk.dbp.dao.DAOFactory;
import ijse.lk.dbp.dao.custom.StudentDAO;
import ijse.lk.dbp.dto.StudentDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentBOImpl implements StudentBO {
    private final StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);


    @Override
    public ArrayList<StudentDTO> searchStudents(String enteredText) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<StudentDTO> getAllStudents() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean saveStudent(StudentDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updateStudent(StudentDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean StudentExist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean deleteStudent(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
