module sio.projetautoecole {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;
    opens sio.projetautoecole to javafx.fxml;
    opens sio.projetautoecole.models to javafx.base, javafx.fxml;
    exports sio.projetautoecole;
    exports sio.projetautoecole.models;
}
