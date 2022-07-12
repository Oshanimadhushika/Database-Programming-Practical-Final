package ijse.lk.dbp.bo.custom.impl;

import ijse.lk.dbp.bo.custom.StudentBO;
import ijse.lk.dbp.dao.DAOFactory;
import ijse.lk.dbp.dao.custom.StudentDAO;
import ijse.lk.dbp.dto.StudentDTO;
import ijse.lk.dbp.entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentBOImpl implements StudentBO {
    private final StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);


    @Override
    public ArrayList<StudentDTO> searchStudents(String enteredText) throws SQLException, ClassNotFoundException {
        ArrayList<Student> students = studentDAO.searchStudents(enteredText);
        ArrayList<StudentDTO> studentDTOS=new ArrayList<>();

        for (Student student : students) {
            studentDTOS.add(new StudentDTO(student.getStudent_id(),
                    student.getStudent_name(),
                    student.getEmail(),
                    student.getContact(),
                    student.getAddress(),
                    student.getNic()
            ));
        }
        return studentDTOS;
    }

    @Override
    public ArrayList<StudentDTO> getAllStudents() throws SQLException, ClassNotFoundException {
        ArrayList<Student> all = studentDAO.getAll();
        ArrayList<StudentDTO> allstudents=new ArrayList<>();

        for (Student student : all) {
            allstudents.add(new StudentDTO(student.getStudent_id(),
                    student.getStudent_name(),
                    student.getEmail(),
                    student.getContact(),
                    student.getAddress(),
                    student.getNic()
            ));
        }
        return allstudents;
    }

    @Override
    public boolean saveStudent(StudentDTO dto) throws SQLException, ClassNotFoundException {
        return studentDAO.save(new Student(dto.getStudent_id(),
                dto.getStudent_name(),
                dto.getEmail(),
                dto.getContact(),
                dto.getAddress(),
                dto.getNic()
        ));
    }

    @Override
    public boolean updateStudent(StudentDTO dto) throws SQLException, ClassNotFoundException {
        return studentDAO.update(new Student(dto.getStudent_id(),
                dto.getStudent_name(),
                dto.getEmail(),
                dto.getContact(),
                dto.getAddress(),
                dto.getNic()
        ));

    }

    @Override
    public boolean StudentExist(String id) throws SQLException, ClassNotFoundException {
        return studentDAO.exist(id);
    }

    @Override
    public boolean deleteStudent(String id) throws SQLException, ClassNotFoundException {
        return studentDAO.delete(id);
    }
}
