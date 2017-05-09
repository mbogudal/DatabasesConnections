/*
Author: Mikolaj Bogudal
Date: 09-05-2017
*/

import java.sql.*;

public class QueryExecutor{

    String result = "";
    String scheme = "Scheme: ";
    Connection conn;

    void execute(String query){

        int type;
        result = "";
        scheme = "Scheme: ";

        try{

            PreparedStatement pStm = conn.prepareStatement(query);
            ResultSet rS = pStm.executeQuery();
            ResultSetMetaData rSMD;

            rSMD = rS.getMetaData();

            for(int nCol = 1; nCol <= rSMD.getColumnCount(); nCol += 1) { //pobieram nazwy column

                if(nCol > 1) scheme += ", ";
                scheme += rSMD.getColumnName(nCol);

            } scheme += String.format("%n"); //dodawanie na koncu zmiennej znaku nowej lini niezaleznie od systemu operacyjnego.

            while(rS.next()){

                rSMD = rS.getMetaData();

                for(int nCol = 1; nCol <= rSMD.getColumnCount(); nCol += 1) {

                    if(nCol > 1) result += ", ";

                    type = rSMD.getColumnType(nCol);//pobranie typu kolumny

                    if(type == Types.VARCHAR || type == Types.CHAR ) result += rS.getString(nCol);
                    else result += rS.getLong(nCol);
                }

                result += String.format("%n");
            }

        } catch (SQLException exception){

            System.out.println("Error when executing query.");
            exception.printStackTrace();

        }

    }

}



