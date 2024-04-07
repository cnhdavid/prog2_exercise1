module at.ac.fhcampuswien.fhmdb {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.jfoenix;
    requires okhttp3;

    opens at.ac.fhcampuswien.fhmdb;
    exports at.ac.fhcampuswien.fhmdb;
}