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

import history.object.Festival;

public class SearchFestival implements Search {

	private ArrayList<Festival> leHoi = new ArrayList<Festival>();
	
	public void input(String name) {
		
		JSONParser jsonParser = new JSONParser();
		
		try (FileReader reader = new FileReader("src\\history\\data\\festival.json"))
		{
			Object obj = jsonParser.parse(reader);
			
			JSONArray festivalList = (JSONArray) obj;
			ArrayList<Festival> leHoibd = new ArrayList<Festival>();
            
            int check = 0;
			for(int i=0; i<festivalList.size(); i++)
			{
				Festival festival = new Festival();
				JSONObject jsonObject = (JSONObject) festivalList.get(i);
				
				festival.setLanDauToChuc((String) jsonObject.get("Lần đầu tổ chức"));
				festival.setNhanVatLienQuan((String) jsonObject.get("Nhân vật liên quan"));
				festival.setViTri((String) jsonObject.get("Vị trí"));
				festival.setNgayBatDau((String) jsonObject.get("Ngày bắt đầu (âm lịch)"));
				festival.setTenLeHoi((String) jsonObject.get("Tên lễ hội"));
	            
				if(festival.getTenLeHoi().contains(name))
	            {
					leHoibd.add(festival);
		            
		            check = 1;
	            }
			}
			
			if(check == 1) 
			{
				ArrayList<Festival> leHoiList = new ArrayList<Festival>();

				
				int mangCheck[] = new int[leHoibd.size()];
				for(int b = 0; b<mangCheck.length; b++)
				{
					mangCheck[b] = 0;
				}
				for(int x=0; (x<leHoibd.size()-1) && (mangCheck[x]==0); x++) 
				{
					mangCheck[x]++;
					leHoiList.add(leHoibd.get(x));
										
					for(int k=x+1; k<leHoibd.size(); k++) 
					{
						if(leHoibd.get(x).getTenLeHoi().equals(leHoibd.get(k).getTenLeHoi()))
						{
							leHoiList.add(leHoibd.get(k));
							mangCheck[k]++;
						}
					}
					
					String lanDauToChuc;
					String nhanVatLienQuan;
					String viTri;
					String ngayBatDau;
					
					if(leHoibd.get(0).getLanDauToChuc().equals(""))
					{
						for(int j=1; j<leHoibd.size(); j++)
						{
							if(!leHoibd.get(j).getLanDauToChuc().equals(""))
							{
								lanDauToChuc = leHoibd.get(j).getLanDauToChuc();
								leHoibd.get(0).setLanDauToChuc(lanDauToChuc);
								break;
							}
						}
					}
					if(leHoibd.get(0).getNhanVatLienQuan().equals(""))
					{
						for(int j=1; j<leHoibd.size(); j++)
						{
							if(!leHoibd.get(j).getNhanVatLienQuan().equals(""))
							{
								nhanVatLienQuan = leHoibd.get(j).getNhanVatLienQuan();
								leHoibd.get(0).setNhanVatLienQuan(nhanVatLienQuan);
								break;
							}
						}
					}
					if(leHoibd.get(0).getViTri().equals(""))
					{
						for(int j=1; j<leHoibd.size(); j++)
						{
							if(!leHoibd.get(j).getViTri().equals(""))
							{
								viTri = leHoibd.get(j).getViTri();
								leHoibd.get(0).setViTri(viTri);
								break;
							}
						}
					}
					if(leHoibd.get(0).getNgayBatDau().equals(""))
					{
						for(int j=1; j<leHoibd.size(); j++)
						{
							if(!leHoibd.get(j).getNgayBatDau().equals(""))
							{
								ngayBatDau = leHoibd.get(j).getNgayBatDau();
								leHoibd.get(0).setNgayBatDau(ngayBatDau);
								break;
							}
						}
					}
					
					leHoi.add(leHoiList.get(0));
					
	//				xóa toàn bộ vuaList để lưu lần mới						
					for(int n=0; n<=leHoiList.size(); n++)
					{
						leHoiList.remove(0);
					}
				}
				
	//								kiểm tra xem phần tử cuối đã check hay chưa, nếu chưa check thì add vô 
				if(mangCheck[leHoibd.size()-1]==0)
				{
					leHoi.add(leHoibd.get(leHoibd.size()-1));
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
		for(int i = 0; i < leHoi.size(); i++)
		{
			if(leHoi.get(i).getTenLeHoi().contains(name) && s.contains(leHoi.get(i).toString()) == false) s = s + leHoi.get(i).toString() + "\n\n";
		}
		return s;
	}
	
	
	public String printFull()
	{
		String s = "";
		for(int i = 0; i< leHoi.size();i++)
		{
			s = s + leHoi.get(i).toString() + "\n\n";
		}
		return s;
	}
}

