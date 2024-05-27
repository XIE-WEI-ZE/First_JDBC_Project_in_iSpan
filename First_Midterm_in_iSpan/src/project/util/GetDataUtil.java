package project.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

//這個類的主要功能是從指定的 URL 獲取數據，並將數據存儲在一個列表中。
public class GetDataUtil {
	// 從給定的 URL 獲取數據並返回數據列表
	/*
	 * 定義了一個名為 GetDataUtil 的 public class ，其中包含一個 static  
	 * getDataFromURL，該方法接受一個 dataURL 作為參數，
	 * 並返回一個包含數據的列表。
	 * */
    public static List<String> getDataFromURL(String dataURL) {
        ArrayList<String> list = new ArrayList<>();
        try {
        	// 創建 URL 對象
            URL url = new URL(dataURL);
            // 打開 URL 連接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //使用給定的 dataURL 創建一個 URL 對象，然後打開連結，將請求設為 get
            conn.setRequestMethod("GET");            
            // 讀取數據並存儲在列表中
            /*
             * 使用 BufferedReader 從連接的輸入流中逐行讀取數據，並將每行數據添加到列表中。
             * 這裡使用 try-with-resources 語句來確保 BufferedReader 自動關閉。
             * */
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"))) {
                String content;
                
                // 逐行讀取並加入列表
                while ((content = bufferedReader.readLine()) != null) {
                    System.out.println(content);
                    list.add(content);
                }
            }

            // 刪除表頭，如果列表不為空，移除列表中第一個元素，
            if (!list.isEmpty()) {
                list.remove(0);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        // 返回結果
        return list;
    }
}