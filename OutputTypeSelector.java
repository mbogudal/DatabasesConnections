import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class OutputTypeSelector {
	
	public String strInput;
	
	OutputTypeSelector( QueryExecutor query){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
        Date date;
        date = new Date(); //pobieram aktualna date zeby miec nowa nazwe pliku
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("podaj typ pliku i sciezke");
        System.out.print("=>");
        strInput = input.nextLine();
		if(strInput.length() > 4) {
			if(strInput.substring(0,3).equals("txt")) {
			
				FileOperations queryToFile = new TxtOperations(strInput.substring(4));
				queryToFile.write(dateFormat.format(date), query.scheme, query.result);
			
			}else if(strInput.substring(0,3).equals("xls")) {
			
				FileOperations queryToFile = new ExcelOperations(strInput.substring(4));
				queryToFile.write(dateFormat.format(date), query.scheme, query.result);
			
			}
		}else {
			
			System.out.println("Zapis zakonczyl sie nie powodzeniem");
			
		}
		
	}

}
