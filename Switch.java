import java.sql.*;
import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Switch{

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        String strInput = "";
        FileOperations queryToFile = new FileOperations(); // deklaruje obiekt do operacji na plikach
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
        Date date;

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

                date = new Date(); //pobieram aktualna date

                query.execute(strInput);

                queryToFile.dir = dateFormat.format(date) +".txt";
                if(!query.result.equals(""))queryToFile.saveFile(query.scheme+query.result); //zapis do pliku jesli zapytanie cokolwiek zwrocilo
            }

            System.out.print("=> ");//takie tam zeby bylo ladniej

            strInput = input.nextLine();
        }

        try {query.conn.close();}catch (SQLException exception){

            System.out.println("Error when connection.");
            exception.printStackTrace();

        } //zamykam polaczenie z baza danych

    }

}
