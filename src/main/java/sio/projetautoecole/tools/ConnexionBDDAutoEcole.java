package sio.projetautoecole.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

public class ConnexionBDDAutoEcole {
    private static Connection cnx;
    public ConnexionBDDAutoEcole() {
    }

    // Méthode pour initialiser la connexion
    public static void initConnexion() throws ClassNotFoundException, SQLException {
        if (cnx == null) { // Initialise la connexion une seule fois
            String pilote = "com.mysql.cj.jdbc.Driver";
            Class.forName(pilote); // Chargement du pilote
            cnx = DriverManager.getConnection(
                    "jdbc:mysql://localhost/bddautoecole?useSSL=true&serverTimezone=" + TimeZone.getDefault().getID(),
                    "root",
                    ""
            );
        }
    }
    public static Connection getCnx() {
        return cnx;
    }
}
