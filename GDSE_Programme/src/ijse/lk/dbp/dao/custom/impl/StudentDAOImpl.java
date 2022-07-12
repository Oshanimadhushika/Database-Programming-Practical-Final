package ijse.lk.dbp.dao.custom.impl;

import ijse.lk.dbp.dao.SQLUtil;
import ijse.lk.dbp.dao.custom.StudentDAO;
import ijse.lk.dbp.entity.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public ArrayList<Student> searchStudents(String enteredText) throws SQLException, ClassNotFoundException {
        ResultSet result = SQLUtil.executeQuery("SELECT * FROM Student where student_id LIKE ? OR student_name LIKE ? OR email LIKE ? OR contact LIKE ? OR address LIKE ? OR nic LIKE ? ", enteredText, enteredText, enteredText, enteredText, enteredText, enteredText);
        ArrayList<Student> list = new ArrayList<>();

        while (result.next()) {
            list.add(new Student(result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getString(6)

            ));
        }
        return list;

    }

    @Override
    public ArrayList<Student> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM Student");
        ArrayList<Student> allStudent = new ArrayList<>();
        while (rst.next()) {
            allStudent.add(new Student(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6)
            ));
        }
        return allStudent;
    }

    @Override
    public boolean save(Student dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("INSERT INTO Student (student_id,student_name, email,contact,address,nic) VALUES (?,?,?,?,?,?)", dto.getStudent_id(), dto.getStudent_name(), dto.getEmail(),dto.getContact(),dto.getAddress(),dto.getNic());
    }

    @Override
    public boolean update(Student dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("UPDATE Student SET student_name=?, email=?,contact=?,address=?,nic=? WHERE student_id=?", dto.getStudent_id(), dto.getStudent_name(), dto.getEmail(),dto.getContact(),dto.getAddress(),dto.getNic());

    }

    @Override
    public Student search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeQuery("SELECT student_id FROM Student WHERE student_id=?", s).next();
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("DELETE FROM Student WHERE student_id=?", s);
    }
}
