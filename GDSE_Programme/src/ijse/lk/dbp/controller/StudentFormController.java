package ijse.lk.dbp.controller;

import com.jfoenix.controls.JFXTextField;
import ijse.lk.dbp.bo.BOFactory;
import ijse.lk.dbp.bo.custom.StudentBO;
import ijse.lk.dbp.dto.StudentDTO;
import ijse.lk.dbp.view.tdm.StudentTM;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.sql.SQLException;
import java.util.ArrayList;

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
    public TableView<StudentTM> tblStudent;
    public TableColumn colstuId;
    public TableColumn colStuName;
    public TableColumn colEmail;
    public TableColumn colContact;
    public TableColumn coladdress;
    public TableColumn colNic;
    public Button btnAddNewStudent;
    public TextField txtSearch;

    private final StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);


    public void initialize() {
        tblStudent.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("student_id"));
        tblStudent.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("student_name"));
        tblStudent.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("email"));
        tblStudent.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("contact"));
        tblStudent.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblStudent.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("nic"));

        initUI();

        tblStudent.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            btnDeleteStudent.setDisable(newValue == null);
            btnSaveStudent.setText(newValue != null ? "Update" : "Save");
            btnSaveStudent.setDisable(newValue == null);

            if (newValue != null) {
                txtStuName.setText(newValue.getStudent_id());
                txtStuName.setText(newValue.getStudent_name());
                txtEmail.setText(newValue.getEmail());
                txtContact.setText(newValue.getContact());
                txtAddress.setText(newValue.getAddress());
                txtNic.setText(newValue.getNic());


                txtStuId.setDisable(false);
                txtStuName.setDisable(false);
                txtEmail.setDisable(false);
                txtContact.setDisable(false);
                txtAddress.setDisable(false);
                txtNic.setDisable(false);
            }
        });

        txtAddress.setOnAction(event -> btnSaveStudent.fire());
        loadAllStudent();
    }
    private void loadAllStudent() {
        tblStudent.getItems().clear();

        try {
            ArrayList<StudentDTO> allstudents = studentBO.getAllStudents();
            for (StudentDTO student : allstudents) {
                tblStudent.getItems().add(new StudentTM(student.getStudent_id(),
                        student.getStudent_name(),
                        student.getEmail(),
                        student.getContact(),
                        student.getAddress(),
                        student.getNic()
                ));
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
    boolean existStudent(String id) throws SQLException, ClassNotFoundException {
        return studentBO.StudentExist(id);
    }

    public void SaveStudentOnAction(ActionEvent actionEvent) {
        String id = txtStuId.getText();
        String name = txtStuName.getText();
        String email = txtEmail.getText();
        String contact=txtContact.getText();
        String address=txtAddress.getText();
        String nic=txtNic.getText();

        if (btnSaveStudent.getText().equalsIgnoreCase("save")) {
            /*Save Customer*/
            try {
                if (existStudent(id)) {
                    new Alert(Alert.AlertType.ERROR, id + " already exists").show();
                }

                studentBO.saveStudent(new StudentDTO(id, name, email,contact,address,nic));
                tblStudent.getItems().add(new StudentTM(id, name, email,contact,address,nic));
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "Failed to save the student " + e.getMessage()).show();
                e.printStackTrace();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            /*Update customer*/
            try {
                if (!existStudent(id)) {
                    new Alert(Alert.AlertType.ERROR, "Sucessfully Updated..! " + id).show();
                }
                //Customer update
                studentBO.updateStudent(new StudentDTO(id, name, email,contact,address,nic));

            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "Failed to update the student " + id + e.getMessage()).show();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            StudentTM selectedCustomer = (StudentTM) tblStudent.getSelectionModel().getSelectedItem();
            selectedCustomer.setStudent_name(name);
            selectedCustomer.setEmail(email);
            selectedCustomer.setContact(contact);
            selectedCustomer.setAddress(address);
            selectedCustomer.setNic(nic);
            tblStudent.refresh();
        }
        btnAddNewStudent.fire();
    }
    private void initUI() {
        txtStuId.clear();
        txtStuName.clear();
        txtEmail.clear();
        txtContact.clear();
        txtAddress.clear();
        txtNic.clear();
        txtStuId.setDisable(true);
        txtStuName.setDisable(true);
        txtEmail.setDisable(true);
        txtContact.setDisable(true);
        txtAddress.setDisable(true);
        txtNic.setDisable(true);
        txtStuId.setEditable(true);
        btnSaveStudent.setDisable(true);
        btnDeleteStudent.setDisable(true);
    }

    public void DeleteStudentOnAction(ActionEvent actionEvent) {
        String id = tblStudent.getSelectionModel().getSelectedItem().getStudent_id();
        try {
            if (!existStudent(id)) {
                new Alert(Alert.AlertType.ERROR, "There is no such student associated with the id " + id).show();
            }
            studentBO.deleteStudent(id);
            tblStudent.getItems().remove(tblStudent.getSelectionModel().getSelectedItem());
            tblStudent.getSelectionModel().clearSelection();
            initUI();

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to delete the student " + id).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void AddNewStudentOnAction(ActionEvent actionEvent) {
        txtStuId.setDisable(false);
        txtStuName.setDisable(false);
        txtEmail.setDisable(false);
        txtContact.setDisable(false);
        txtAddress.setDisable(false);
        txtNic.setDisable(false);
        txtStuId.clear();
        //txtCusId.setText(generateNewId());
        txtStuName.clear();
        txtEmail.clear();
        txtContact.clear();
        txtAddress.clear();
        txtNic.clear();
        txtStuId.requestFocus();
        btnSaveStudent.setDisable(false);
        btnSaveStudent.setText("Save");
        tblStudent.getSelectionModel().clearSelection();
    }

    public void SearchOnKeyReleased(KeyEvent keyEvent) throws SQLException, ClassNotFoundException {
        String search = "%" + txtSearch.getText() + "%";

        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            ArrayList<StudentDTO> studentDTOS = studentBO.searchStudents(search);
            ObservableList<StudentTM> oBCustomerTMS = FXCollections.observableArrayList();

            for (StudentDTO stuDto : studentDTOS) {
                oBCustomerTMS.add(new StudentTM(stuDto.getStudent_id(),
                        stuDto.getStudent_name(),
                        stuDto.getEmail(),
                        stuDto.getContact(),
                        stuDto.getAddress(),
                        stuDto.getNic()));
            }
            tblStudent.getItems().clear();
            tblStudent.getItems().addAll(oBCustomerTMS);
            tblStudent.refresh();
        }
    }
}
