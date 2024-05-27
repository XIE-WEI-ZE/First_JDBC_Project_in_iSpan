package project.service;

import java.util.ArrayList;
import java.util.List;

import project.model.Travel_Taipei;

// 在訪問 tokens array中的元素前，先確定陣列的長度夠，避免異常發生。
public class Travel_Taipei_Service {
	
	//將數據列表轉換為 Travel_Taipei 對象列表
    public List<Travel_Taipei> getData(List<String> dataList) {
        List<Travel_Taipei> list = new ArrayList<>();
        for (String data : dataList) {
        	// 使用逗號分隔每行數據
            String[] tokens = data.split(",");
            // 確保分割後的數據數量足夠（至少 10 個字段），
            // 以避免 ArrayIndexOutOfBoundsException。
            if (tokens.length >= 10) {
                Travel_Taipei travel_taipei = new Travel_Taipei();
                travel_taipei.setPeriod(tokens[0]);
                travel_taipei.setArtMuseumVisits(Integer.parseInt(tokens[1]));
                travel_taipei.setZooVisits(Integer.parseInt(tokens[2]));
                travel_taipei.setChildrenNewParkVisits(Integer.parseInt(tokens[3]));
                travel_taipei.setAstronomyMuseumVisits(Integer.parseInt(tokens[4]));
                travel_taipei.setShilinOfficialResidenceParkVisits(Integer.parseInt(tokens[5]));
                travel_taipei.setWaterParkVisits(Integer.parseInt(tokens[6]));
                travel_taipei.setHotSpringMuseumVisits(Integer.parseInt(tokens[7]));
                travel_taipei.setDiscoveryCenterVisits(Integer.parseInt(tokens[8]));
                travel_taipei.setBlueWaterwayVisits(Integer.parseInt(tokens[9]));
                list.add(travel_taipei);
            }
        }
        return list;
        
        
    }
}