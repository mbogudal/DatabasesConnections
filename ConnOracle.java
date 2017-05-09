/*
Author: Mikolaj Bogudal
Date: 09-05-2017
*/

public class ConnOracle extends JdbcConn{

    ConnOracle(String args[]){

        database = "jdbc:oracle:thin:@";

        loadDriver("oracle.jdbc.driver.OracleDriver", args);

        connect();
    } //konstruktor

}

