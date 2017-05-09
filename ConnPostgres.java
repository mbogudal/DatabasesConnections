/*
Author: Mikolaj Bogudal
Date: 09-05-2017
*/

public class ConnPostgres extends JdbcConn{

    ConnPostgres(String args[]){

        database = "jdbc:postgresql:";

        loadDriver("org.postgresql.Driver", args);

        connect();
    } //konstruktor

}
