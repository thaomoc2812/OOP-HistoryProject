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

import history.object.Locate;

public class SearchLocate implements Search  {

	private ArrayList<Locate> diTich = new ArrayList<Locate>();
	
	public void input(String name) {
		
		JSONParser jsonParser = new JSONParser();
		
		try (FileReader reader = new FileReader("src\\history\\data\\locate.json"))
		{
			Object obj = jsonParser.parse(reader);
			
			JSONArray locateList = (JSONArray) obj;
			ArrayList<Locate> diTichbd = new ArrayList<Locate>();
            
            int check = 0;
			for(int i=0; i<locateList.size(); i++)
			{
				Locate locate = new Locate();
				JSONObject jsonObject = (JSONObject) locateList.get(i);
				
				locate.setTt((String) jsonObject.get("TT"));
				locate.setLocate((String) jsonObject.get("Locate"));
				locate.setDescription((String) jsonObject.get("Description"));
				locate.setName((String) jsonObject.get("Name"));
	            
				if(locate.getName().contains(name))
	            {
					diTichbd.add(locate);
		            
		            check = 1;
	            }
			}
			
			if(check == 1) 
            {
				ArrayList<Locate> diTichList = new ArrayList<Locate>();
				
				int mangCheck[] = new int[diTichbd.size()];
				for(int b = 0; b<mangCheck.length; b++)
				{
					mangCheck[b] = 0;
				}
				for(int x=0; (x<diTichbd.size()-1) && (mangCheck[x]==0); x++) 
				{
					mangCheck[x]++;
					diTichList.add(diTichbd.get(x));
										
					for(int k=x+1; k<diTichbd.size(); k++) 
					{
						if(diTichbd.get(x).getName().equals(diTichbd.get(k).getName()))
						{
							diTichList.add(diTichbd.get(k));
							mangCheck[k]++;
						}
					}
					
				String tt;
				String Locate;
				String description;
				
				if(diTichbd.get(0).getTt()==null)
				{
					for(int j=1; j<diTichbd.size(); j++)
					{
						if(diTichbd.get(j).getTt()!=null)
						{
							tt = diTichbd.get(j).getTt();
							diTichbd.get(0).setTt(tt);
							mangCheck[j]++;
							break;
						}
					}
				}
				if(diTichbd.get(0).getLocate()==null)
				{
					for(int j=1; j<diTichbd.size(); j++)
					{
						if(diTichbd.get(j).getLocate()!=null)
						{
							Locate = diTichbd.get(j).getLocate();
							diTichbd.get(0).setLocate(Locate);
							mangCheck[j]++;
							break;
						}
					}
				}
				if(diTichbd.get(0).getDescription()==null)
				{
					for(int j=1; j<diTichbd.size(); j++)
					{
						if(diTichbd.get(j).getDescription()!=null)
						{
							description = diTichbd.get(j).getDescription();
							diTichbd.get(0).setDescription(description);
							mangCheck[j]++;
							break;
						}
					}
				}
				
				diTich.add(diTichList.get(0));
				
//				xóa toàn bộ vuaList để lưu lần mới						
				for(int n=0; n<=diTichList.size(); n++)
				{
					diTichList.remove(0);
				}
			}
			
//							kiểm tra xem phần tử cuối đã check hay chưa, nếu chưa check thì add vô 
			if(mangCheck[diTichbd.size()-1]==0)
			{
				diTich.add(diTichbd.get(diTichbd.size()-1));
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
		for(int i = 0; i < diTich.size(); i++)
		{
			if(diTich.get(i).getName().contains(name)&& s.contains(diTich.get(i).toString()) == false) s = s + diTich.get(i).toString() + "\n\n";
		}
		return s;
	}
	
	
	public String printFull()
	{
		String s = "";
		for(int i = 0; i< diTich.size();i++)
		{
			s = s + diTich.get(i).toString() + "\n\n";
		}
		return s;
	}
}

