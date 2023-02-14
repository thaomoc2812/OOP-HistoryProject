package history.data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import history.object.King;

public class SearchKing implements Search{
	
	private ArrayList<King> vua = new ArrayList<King>();

	public void input(String name) {
//		King king = new King();
		
JSONParser jsonParser = new JSONParser();
		
		try (FileReader reader = new FileReader("D:\\LapTrinhHuongDT\\ProjectFinalTerm\\src\\history\\data\\king.json"))
		{
			Object obj = jsonParser.parse(reader);
			
			JSONArray kingList = (JSONArray) obj;
			
    
			for(int i=0; i<kingList.size(); i++)
			{
				King king = new King();
				JSONObject jsonObject = (JSONObject) kingList.get(i);
				
				king.setPaperURL((String) jsonObject.get("paperURL"));
				king.setMieuHieu((String) jsonObject.get("mieuHieu"));
				king.setThuyHieu((String) jsonObject.get("thuyHieu"));
				king.setNienHieu((String) jsonObject.get("nienHieu"));
				king.setTenHuy((String) jsonObject.get("tenHuy"));
				king.setTheThu((String) jsonObject.get("theThu"));
				king.setNamTriVi((String) jsonObject.get("namTriVi"));
				king.setTen((String) jsonObject.get("ten"));
	            
				
				vua.add(king);
				
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
}
	
	
	public String print(String name)
	{
		String s = "";
		for(int i = 0; i < vua.size(); i++)
		{
			if(vua.get(i).getTen().contains(name) && s.contains(vua.get(i).toString()) == false) s = s + vua.get(i).toString() + "\n\n";
		}
		return s;
	}
	
	
	public String printFull()
	{
		String s = "";
		for(int i = 0; i< vua.size();i++)
		{
			s = s + vua.get(i).toString() + "\n\n";
		}
		return s;
	}
}

