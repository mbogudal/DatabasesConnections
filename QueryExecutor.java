/*
Author: Mikolaj Bogudal
Date: 09-05-2017
*/

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class QueryExecutor{

    public List<String> result = new ArrayList();
    public List<String> scheme = new ArrayList();
    Connection conn;

    void execute(String query){

        scheme.removeAll(scheme);
        result.removeAll(result);

        try{

            PreparedStatement pStm = conn.prepareStatement(query);
            ResultSet rS = pStm.executeQuery();
            ResultSetMetaData rSMD;

            rSMD = rS.getMetaData();

            for(int nCol = 1; nCol <= rSMD.getColumnCount(); nCol += 1) { //pobieram nazwy column

                
                scheme.add(rSMD.getColumnName(nCol));

            }  

            while(rS.next()){

                rSMD = rS.getMetaData();

                for(int nCol = 1; nCol <= rSMD.getColumnCount(); nCol += 1) {

                    result.add(rS.getString(nCol));

                }

            }

        } catch (SQLException exception){

            System.out.println("Error when executing query.");
            exception.printStackTrace();

        }

    }

}



