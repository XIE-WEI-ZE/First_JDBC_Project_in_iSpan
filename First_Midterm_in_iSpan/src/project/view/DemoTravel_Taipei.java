package project.view;

import java.util.List;

import project.dao.Travel_TaipeiDao;
import project.model.Travel_Taipei;
import project.service.Travel_Taipei_Service;
import project.util.GetDataUtil;

public class DemoTravel_Taipei {
	/*
	   從指定的 URL 獲取數據。
	   將獲取的數據轉換為 Travel_Taipei 對象。
	   將這些 Travel_Taipei 對象保存到資料庫中。
	 */
    public static void main(String[] args) {
        //指定數據來源的 URL
        String dataURL = "https://tsis.dbas.gov.taipei/statis/webMain.aspx?sys=220&ymf=8701&kind=21&type=0&funid=a04001201&cycle=1&outmode=12&compmode=0&outkind=1&deflst=2&nzo=1";
        /*
           使用 GetDataUtil 類中的 getDataFromURL 方法從指定的 URL 獲取數據，
           將這些數據存儲在 dataList 列表中。這些數據通常是以字串的形式存儲的。
         */
        List<String> dataList = GetDataUtil.getDataFromURL(dataURL);
        /*
           使用 Travel_Taipei_Service 類中的 getData 方法將獲取到的字串數據轉換為 Travel_Taipei 對象的列表。
           Travel_Taipei 對象表示每條數據記錄，包含各種訪問數據。
        */
        Travel_Taipei_Service service = new Travel_Taipei_Service();
        List<Travel_Taipei> travelList = service.getData(dataList);
        /*
           創建一個 Travel_TaipeiDao 對象，用於與資料庫進行交互。
           遍歷 travelList 列表中的每個 Travel_Taipei 對象，
           並使用 saveTravel_Taipei 方法將它們逐一保存到資料庫中。
         */
        Travel_TaipeiDao travelTaipeiDao = new Travel_TaipeiDao();
        for (Travel_Taipei travel : travelList) {
            travelTaipeiDao.saveTravel_Taipei(travel);
        }
    }
}