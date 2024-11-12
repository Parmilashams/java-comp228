package com.oopdevelop.lab04;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HelloController {

    @FXML
    private TextField fullNameField, addressField, cityField, provinceField, postalCodeField, phoneNumberField, emailField;

    @FXML
    private RadioButton compSciRadio, businessRadio;

    @FXML
    private ComboBox<String> courseComboBox;

    @FXML
    private ListView<String> courseListView;

    @FXML
    private CheckBox studentCouncilCheckBox, volunteerWorkCheckBox;

    @FXML
    private TextArea outputTextArea;

    @FXML
    private ToggleGroup majorGroup;

    private final ObservableList<String> computerScienceCourses = FXCollections.observableArrayList("Java", "C#", "Python");
    private final ObservableList<String> businessCourses = FXCollections.observableArrayList("Marketing", "Finance", "Management");

    public void initialize() {
        majorGroup = new ToggleGroup();
        compSciRadio.setToggleGroup(majorGroup);
        businessRadio.setToggleGroup(majorGroup);

        compSciRadio.setOnAction(event -> courseComboBox.setItems(computerScienceCourses));
        businessRadio.setOnAction(event -> courseComboBox.setItems(businessCourses));

        courseListView.setItems(FXCollections.observableArrayList());
    }

    @FXML
    protected void onAddCourseClick() {
        String selectedCourse = courseComboBox.getValue();
        if (selectedCourse != null && !courseListView.getItems().contains(selectedCourse)) {
            courseListView.getItems().add(selectedCourse);
        }
    }

    @FXML
    protected void onDisplayButtonClick() {
        StringBuilder studentInfo = new StringBuilder();
        studentInfo.append("Name: ").append(fullNameField.getText()).append("\n")
                .append("Address: ").append(addressField.getText()).append("\n")
                .append("City: ").append(cityField.getText()).append("\n")
                .append("Province: ").append(provinceField.getText()).append("\n")
                .append("Postal Code: ").append(postalCodeField.getText()).append("\n")
                .append("Phone Number: ").append(phoneNumberField.getText()).append("\n")
                .append("Email: ").append(emailField.getText()).append("\n");

        RadioButton selectedMajor = (RadioButton) majorGroup.getSelectedToggle();
        if (selectedMajor != null) {
            studentInfo.append("Major: ").append(selectedMajor.getText()).append("\n");
        }

        studentInfo.append("Courses: ").append(String.join(", ", courseListView.getItems())).append("\n");

        if (studentCouncilCheckBox.isSelected()) {
            studentInfo.append("Activities: Student Council\n");
        }
        if (volunteerWorkCheckBox.isSelected()) {
            studentInfo.append("Activities: Volunteer Work\n");
        }

        outputTextArea.setText(studentInfo.toString());
    }
}
