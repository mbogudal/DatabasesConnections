import java.sql.*;

public class JdbcConn{

    String database;
    String user;
    String password;
    Connection conn;

    void loadDriver(String driverName, String[] args){

        database += args[1]; //ustawiam nazwe bazy danych i adres
        user = args[2]; //ustawiam uzytkownika
        password = args[3]; //ustawiam haslo

        try{ Class.forName(driverName); }  // laduje sterownik jdbc dla postgresa
        catch (ClassNotFoundException exception){

            exception.printStackTrace();

        }

    }

    void connect(){

        try { conn = DriverManager.getConnection(database, user, password); }
        catch (SQLException exception){

            System.out.println("Error when connection.");
            exception.printStackTrace();

        }

    }

}






