module com.example.demo6 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.demo6 to javafx.fxml;
    exports com.example.demo6;
}