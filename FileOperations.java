/*
Author: Mikolaj Bogudal
Date: 09-05-2017
*/

import java.io.*;

public class FileOperations{

    String dir;

    void saveFile( String data ){

        try(  PrintWriter out = new PrintWriter( dir )  ){

            out.println( data );

        }catch( FileNotFoundException exception ){

            exception.printStackTrace();

        }

    }

}
