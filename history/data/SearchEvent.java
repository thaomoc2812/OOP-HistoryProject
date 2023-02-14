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

import history.object.Event;

public class SearchEvent implements Search {
	
	private ArrayList<Event> suKien = new ArrayList<Event>();

	public void input(String name) {
		
		
		JSONParser jsonParser = new JSONParser();
		
		try (FileReader reader = new FileReader("src\\history\\data\\event.json"))
		{
			Object obj = jsonParser.parse(reader);
			
			JSONArray eventList = (JSONArray) obj;
			ArrayList<Event> suKienbd = new ArrayList<Event>();
		
            int check = 0;
			for(int i=0; i<eventList.size(); i++)
			{
				Event event = new Event();
				JSONObject jsonObject = (JSONObject) eventList.get(i);
				
				event.setSuKien((String) jsonObject.get("Sự kiện"));
				event.setNam((String) jsonObject.get("Năm"));
	            
				if(event.getSuKien().contains(name))
	            {
					suKienbd.add(event);
		            
		            check = 1;
	            }
			}
			
			if(check == 1) 
			{
				ArrayList<Event> suKienList = new ArrayList<Event>();
				
				int mangCheck[] = new int[suKienbd.size()];
				for(int b = 0; b<mangCheck.length; b++)
				{
					mangCheck[b] = 0;
				}
				for(int x=0; (x<suKienbd.size()-1) && (mangCheck[x]==0); x++) 
				{
					mangCheck[x]++;
					suKienList.add(suKienbd.get(x));
										
					for(int k=x+1; k<suKienbd.size(); k++) 
					{
						if(suKienbd.get(x).getSuKien().equals(suKienbd.get(k).getSuKien()))
						{
							suKienList.add(suKienbd.get(k));
							mangCheck[k]++;
						}
					}
					
					String nam;
					
					if(suKienbd.get(0).getNam().equals(""))
					{
						for(int j=1; j<suKienbd.size(); j++)
						{
							if(!suKienbd.get(j).getNam().equals(""))
							{
								nam = suKienbd.get(j).getNam();
								suKienbd.get(0).setNam(nam);
								break;
							}
						}
					}
					suKien.add(suKienList.get(0));
					
		//				xóa toàn bộ vuaList để lưu lần mới						
					for(int n=0; n<=suKienList.size(); n++)
					{
						suKienList.remove(0);
					}
				}
				
		//								kiểm tra xem phần tử cuối đã check hay chưa, nếu chưa check thì add vô 
				if(mangCheck[suKienbd.size()-1]==0)
				{
					suKien.add(suKienbd.get(suKienbd.size()-1));
				}
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
		for(int i = 0; i < suKien.size(); i++)
		{
			if(suKien.get(i).getSuKien().contains(name) && s.contains(suKien.get(i).toString()) == false) s = s + suKien.get(i).toString() + "\n\n";
		}
		return s;
	}
	
	
	public String printFull()
	{
		String s = "";
		for(int i = 0; i< suKien.size();i++)
		{
			s = s + suKien.get(i).toString() + "\n\n";
		}
		return s;
	}
}

