/*
Author: Mikolaj Bogudal
Date: 09-05-2017
*/

import java.sql.*;
import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class Main{

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        String strInput = "";

        QueryExecutor query = new QueryExecutor();

        if( args[0].equals( "postgres" ) ){

            ConnPostgres connect = new ConnPostgres(args); //deklaruje obiekt odpowiedzialny za polaczenie z baza danych
            query.conn = connect.conn;

        }

        if( args[0].equals( "oracle" ) ){

            ConnOracle connect = new ConnOracle(args); //deklaruje obiekt odpowiedzialny za polaczenie z baza danych
            query.conn = connect.conn;

        }



        while(!strInput.equals("\\q")){//warunek konczacy petle

            if(!strInput.equals("")){

                query.execute(strInput);//wykonuje zapytanie
                
                OutputTypeSelector select = new OutputTypeSelector(query);//zrzucam wynik do pliku
                
                if(select.strInput.equals("\\q")) break;//sprawdzam czy uzytkownik nie chcial wyjsc z programu przed zapisem wyniku do pliku
            }
            	System.out.println("Wpisz zapytanie");
            System.out.print("=> ");//takie tam zeby bylo ladniej

            strInput = input.nextLine();
        }

        try {query.conn.close();}catch (SQLException exception){

            System.out.println("Error when connection.");
            exception.printStackTrace();

        } //zamykam polaczenie z baza danych

    }

}