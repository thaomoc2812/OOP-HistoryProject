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

import history.object.Dynasties;

public class SearchDynasties implements Search {
	
	private ArrayList<Dynasties> trieuDai = new ArrayList<Dynasties>();

	public void input(String name) {
		
		JSONParser jsonParser = new JSONParser();
		
		try (FileReader reader = new FileReader("src\\history\\data\\dynasties.json"))
		{
			Object obj = jsonParser.parse(reader);
			
			JSONArray dynastiesList = (JSONArray) obj;
			ArrayList<Dynasties> trieuDaibd = new ArrayList<Dynasties>();
			
            int check = 0;
			for(int i=0; i<dynastiesList.size(); i++)
			{
				Dynasties dynasties = new Dynasties();
				JSONObject jsonObject = (JSONObject) dynastiesList.get(i);
				
//				dynasties.setId((int) jsonObject.get("id"));
				dynasties.setId(i+1);
				dynasties.setName((String) jsonObject.get("name"));
				dynasties.setYearStart((String) jsonObject.get("yearStart"));
				dynasties.setYearEnd((String) jsonObject.get("yearEnd"));
				dynasties.setDescription((String) jsonObject.get("description"));
	            
				if(dynasties.getName().contains(name))
	            {
					trieuDaibd.add(dynasties);
		            
		            check = 1;
	            }
			}
			
			if(check == 1) 
			{
				ArrayList<Dynasties> trieuDaiList = new ArrayList<Dynasties>();
				
				int mangCheck[] = new int[trieuDaibd.size()];
				for(int b = 0; b<mangCheck.length; b++)
				{
					mangCheck[b] = 0;
				}
				for(int x=0; (x<trieuDaibd.size()-1) && (mangCheck[x]==0); x++) 
				{
					mangCheck[x]++;
					trieuDaiList.add(trieuDaibd.get(x));
										
					for(int k=x+1; k<trieuDaibd.size(); k++) 
					{
						if(trieuDaibd.get(x).getName().equals(trieuDaibd.get(k).getName()))
						{
							trieuDaiList.add(trieuDaibd.get(k));
							mangCheck[k]++;
						}
					}
					
					String yearStart;
					String yearEnd;
					String description;
					String countryName;
					
					String s = "Không rõ";
					String s1 = "Không có";
					if(trieuDaibd.get(0).getYearStart().equals(s))
					{
						for(int j=1; j<trieuDaibd.size(); j++)
						{
							if(!trieuDaibd.get(j).getYearStart().equals(s))
							{
								yearStart = trieuDaibd.get(j).getYearStart();
								trieuDaibd.get(0).setYearStart(yearStart);
								break;
							}
						}
					}
					if(trieuDaibd.get(0).getYearEnd().equals(s))
					{
						for(int j=1; j<trieuDaibd.size(); j++)
						{
							if(!trieuDaibd.get(j).getYearEnd().equals(s))
							{
								yearEnd = trieuDaibd.get(j).getYearEnd();
								trieuDaibd.get(0).setYearEnd(yearEnd);
								break;
							}
						}
					}
					if(trieuDaibd.get(0).getDescription().equals(s1))
					{
						for(int j=1; j<trieuDaibd.size(); j++)
						{
							if(!trieuDaibd.get(j).getDescription().equals(s1))
							{
								description = trieuDaibd.get(j).getDescription();
								trieuDaibd.get(0).setDescription(description);
								break;
							}
						}
					}
					
//					if(trieuDaibd.get(0).getCountryName().equals(s1))
//					{
//						for(int j=1; j<trieuDaibd.size(); j++)
//						{
//							if(!trieuDaibd.get(j).getCountryName().equals(s1))
//							{
//								countryName = trieuDaibd.get(j).getCountryName();
//								trieuDaibd.get(0).setCountryName(countryName);
//								break;
//							}
//						}
//					}
					trieuDai.add(trieuDaiList.get(0));
					
	//				xóa toàn bộ vuaList để lưu lần mới						
					for(int n=0; n<=trieuDaiList.size(); n++)
					{
						trieuDaiList.remove(0);
					}
				}
			
//								kiểm tra xem phần tử cuối đã check hay chưa, nếu chưa check thì add vô 
				if(mangCheck[trieuDaibd.size()-1]==0)
				{
					trieuDai.add(trieuDaibd.get(trieuDaibd.size()-1));
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
		for(int i = 0; i < trieuDai.size(); i++)
		{
			if(trieuDai.get(i).getName().contains(name) && s.contains(trieuDai.get(i).toString()) == false) s = s + trieuDai.get(i).toString() +"\n\n" ;
		}
		return s;
	}
	
	
	public String printFull()
	{
		String s = "";
		for(int i = 0; i< trieuDai.size();i++)
		{
			s = s + trieuDai.get(i).toString() + "\n\n";
		}
		return s;
	}
}

