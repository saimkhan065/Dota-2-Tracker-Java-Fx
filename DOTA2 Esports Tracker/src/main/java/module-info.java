module code.java_2_project {
    requires javafx.controls;
    requires javafx.fxml;


    opens code.java_2_project to javafx.fxml;
    exports code.java_2_project;
}