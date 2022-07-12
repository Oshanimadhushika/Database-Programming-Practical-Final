package ijse.lk.dbp.controller;

import com.jfoenix.controls.JFXTextField;
import ijse.lk.dbp.bo.BOFactory;
import ijse.lk.dbp.bo.custom.StudentBO;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class StudentFormController {
    public AnchorPane StudentFormContext;
    public Button btnSaveStudent;
    public Button btnDeleteStudent;
    public JFXTextField txtStuId;
    public JFXTextField txtStuName;
    public JFXTextField txtEmail;
    public JFXTextField txtContact;
    public JFXTextField txtAddress;
    public JFXTextField txtNic;
    public TableView tblStudent;
    public TableColumn colstuId;
    public TableColumn colStuName;
    public TableColumn colEmail;
    public TableColumn colContact;
    public TableColumn coladdress;
    public TableColumn colNic;
    public Button btnAddNewStudent;
    public TextField txtSearch;

    private final StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);




    public void SaveStudentOnAction(ActionEvent actionEvent) {
    }

    public void DeleteStudentOnAction(ActionEvent actionEvent) {
    }

    public void AddNewStudentOnAction(ActionEvent actionEvent) {
    }

    public void SearchOnKeyReleased(KeyEvent keyEvent) {
    }
}
