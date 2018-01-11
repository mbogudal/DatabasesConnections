/*
Author: Mikolaj Bogudal
Date: 09-05-2017
*/

import java.io.*;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;

public class TxtOperations implements FileOperations{
	
	private String fileDir;
	
	TxtOperations(String fileDir){
		this.fileDir = fileDir;
	}

	@Override
	public void write(String fileName, List<String> scheme, List<String> result) {
		// TODO Auto-generated method stub
		
		int nResultIndex = 0;
		String output = "";
		
		for(int nSchemeCells = 0; nSchemeCells < scheme.size(); nSchemeCells++ ) {
			
			output += scheme.get(nSchemeCells);
			output += "; ";
			
		}
		
		output += String.format("%n");
		
		for(int nResultRows = 0; nResultRows < (result.size()/scheme.size()); nResultRows++) {
			
			for(int nResultCells = 0; nResultCells < scheme.size(); nResultCells++) {
			
				output += result.get(nResultIndex++);
				output += "; ";
			
			}
			
			output += String.format("%n");
		}
		
		try(  PrintWriter out = new PrintWriter( fileDir+"/"+fileName+".txt" )  ){

            out.println( output );

        }catch( FileNotFoundException exception ){

            exception.printStackTrace();

        }
		
	}

	@Override
	public void read() {
		// TODO Auto-generated method stub
		
	}

}