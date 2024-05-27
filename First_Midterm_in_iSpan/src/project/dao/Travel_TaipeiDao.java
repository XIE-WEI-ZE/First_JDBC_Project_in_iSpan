package project.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import project.connection.ConnectionUtil;
import project.model.Travel_Taipei;
/*
 * Travel_TaipeiDao 類提供了一個與資料庫進行交互的完整解決方案，
 * 實現了資料的增刪改查和導出功能。
 * 通過這個類，可以方便地對 Travel_Taipei 資料進行操作，
 * 並且將數據導出為 CSV 文件，方便進行後續的數據處理和分析。
 * */
public class Travel_TaipeiDao {
    //保存 Travel_Taipei 資料到資料庫 
	/*
	  構建 SQL 插入語句。
	  使用 PreparedStatement 設置參數並執行語句。
	  獲取生成的自動遞增 id 並設置到 Travel_Taipei 對象中。
	 */
    public void saveTravel_Taipei(Travel_Taipei travel_taipei) {
        String sql = "INSERT INTO [dbo].[台北市觀光] " +
                     "([period], [artMuseumVisits], [zooVisits], [childrenNewParkVisits], [astronomyMuseumVisits], " +
                     "[shilinOfficialResidenceParkVisits], [waterParkVisits], [hotSpringMuseumVisits], " +
                     "[discoveryCenterVisits], [blueWaterwayVisits]) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        ConnectionUtil connectionUtil = new ConnectionUtil();
        try (Connection conn = connectionUtil.getConnection();
        		//告訴 JDBC 驅動程序在執行插入操作後返回生成的鍵值。
        		//如果 users 表的 id 欄位是自增的，資料庫會自動生成一個新的 id 值。
        		//id 值就是生成的鍵值。如果插入的記錄被分配了 id 值 1，則這個值就是生成的鍵值。
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, travel_taipei.getPeriod());
            pstmt.setInt(2, travel_taipei.getArtMuseumVisits());
            pstmt.setInt(3, travel_taipei.getZooVisits());
            pstmt.setInt(4, travel_taipei.getChildrenNewParkVisits());
            pstmt.setInt(5, travel_taipei.getAstronomyMuseumVisits());
            pstmt.setInt(6, travel_taipei.getShilinOfficialResidenceParkVisits());
            pstmt.setInt(7, travel_taipei.getWaterParkVisits());
            pstmt.setInt(8, travel_taipei.getHotSpringMuseumVisits());
            pstmt.setInt(9, travel_taipei.getDiscoveryCenterVisits());
            pstmt.setInt(10, travel_taipei.getBlueWaterwayVisits());
            pstmt.executeUpdate();

            //獲取並設定生成的ID
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    travel_taipei.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //根據id獲取 Travel_Taipei 資料
    /*
       根據給定的 ID 從資料庫中查詢對應的 Travel_Taipei 資料。
	   返回一個 Travel_Taipei 對象，包含資料庫中的對應數據。
     */
    public Travel_Taipei getTravel_TaipeiById(int id) {
        Travel_Taipei travel = null;
        String sql = "SELECT * FROM [dbo].[台北市觀光] WHERE id = ?";
        ConnectionUtil connectionUtil = new ConnectionUtil();
        try (Connection conn = connectionUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                travel = new Travel_Taipei();
                travel.setId(rs.getInt("id"));
                travel.setPeriod(rs.getString("period"));
                travel.setArtMuseumVisits(rs.getInt("artMuseumVisits"));
                travel.setZooVisits(rs.getInt("zooVisits"));
                travel.setChildrenNewParkVisits(rs.getInt("childrenNewParkVisits"));
                travel.setAstronomyMuseumVisits(rs.getInt("astronomyMuseumVisits"));
                travel.setShilinOfficialResidenceParkVisits(rs.getInt("shilinOfficialResidenceParkVisits"));
                travel.setWaterParkVisits(rs.getInt("waterParkVisits"));
                travel.setHotSpringMuseumVisits(rs.getInt("hotSpringMuseumVisits"));
                travel.setDiscoveryCenterVisits(rs.getInt("discoveryCenterVisits"));
                travel.setBlueWaterwayVisits(rs.getInt("blueWaterwayVisits"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return travel;
    }
    
    //獲取所有Travel_Taipei資料 
    /*
       從資料庫中查詢所有 Travel_Taipei 資料。
	   返回一個包含所有 Travel_Taipei 對象的列表。
    */
    public List<Travel_Taipei> getAllTravel_Taipei() {
        String sql = "SELECT * FROM [dbo].[台北市觀光]";
        List<Travel_Taipei> travelList = new ArrayList<>();
        ConnectionUtil connectionUtil = new ConnectionUtil();
        try (Connection conn = connectionUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Travel_Taipei travel_taipei = new Travel_Taipei();
                travel_taipei.setId(rs.getInt("id"));
                travel_taipei.setPeriod(rs.getString("period"));
                travel_taipei.setArtMuseumVisits(rs.getInt("artMuseumVisits"));
                travel_taipei.setZooVisits(rs.getInt("zooVisits"));
                travel_taipei.setChildrenNewParkVisits(rs.getInt("childrenNewParkVisits"));
                travel_taipei.setAstronomyMuseumVisits(rs.getInt("astronomyMuseumVisits"));
                travel_taipei.setShilinOfficialResidenceParkVisits(rs.getInt("shilinOfficialResidenceParkVisits"));
                travel_taipei.setWaterParkVisits(rs.getInt("waterParkVisits"));
                travel_taipei.setHotSpringMuseumVisits(rs.getInt("hotSpringMuseumVisits"));
                travel_taipei.setDiscoveryCenterVisits(rs.getInt("discoveryCenterVisits"));
                travel_taipei.setBlueWaterwayVisits(rs.getInt("blueWaterwayVisits"));
                travelList.add(travel_taipei);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return travelList;
    }

    //更新Travel_Taipei資料
     /*
       更新資料庫中的 Travel_Taipei 資料。
	   根據 Travel_Taipei 對象中的 ID，更新對應的紀錄。
     */
    public void updateTravel_Taipei(Travel_Taipei travel_taipei) {
        String sql = "UPDATE [dbo].[台北市觀光] SET " +
                     "period = ?, artMuseumVisits = ?, zooVisits = ?, childrenNewParkVisits = ?, " +
                     "astronomyMuseumVisits = ?, shilinOfficialResidenceParkVisits = ?, waterParkVisits = ?, " +
                     "hotSpringMuseumVisits = ?, discoveryCenterVisits = ?, blueWaterwayVisits = ? " +
                     "WHERE id = ?";
        ConnectionUtil connectionUtil = new ConnectionUtil();
        try (Connection conn = connectionUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, travel_taipei.getPeriod());
            pstmt.setInt(2, travel_taipei.getArtMuseumVisits());
            pstmt.setInt(3, travel_taipei.getZooVisits());
            pstmt.setInt(4, travel_taipei.getChildrenNewParkVisits());
            pstmt.setInt(5, travel_taipei.getAstronomyMuseumVisits());
            pstmt.setInt(6, travel_taipei.getShilinOfficialResidenceParkVisits());
            pstmt.setInt(7, travel_taipei.getWaterParkVisits());
            pstmt.setInt(8, travel_taipei.getHotSpringMuseumVisits());
            pstmt.setInt(9, travel_taipei.getDiscoveryCenterVisits());
            pstmt.setInt(10, travel_taipei.getBlueWaterwayVisits());
            pstmt.setInt(11, travel_taipei.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 
    //刪除指定id的travel_taipei資料
    /*
      根據給定的 ID 刪除資料庫中的 Travel_Taipei 資料。
     */
    public void deleteTravel_Taipei(int id) {
        String sql = "DELETE FROM [dbo].[台北市觀光] WHERE id = ?";
        ConnectionUtil connectionUtil = new ConnectionUtil();
        try (Connection conn = connectionUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //將所有travel_taipei資料匯出到csv文件
    public void exportToCSV(String filePath) {
        List<Travel_Taipei> travelList = getAllTravel_Taipei();
        try (FileWriter writer = new FileWriter(filePath,Charset.forName("MS950"))) {
        	//將字串附加到文件中。
        	//在 exportToCSV 方法中，writer.append 被用來逐行將 Travel_Taipei 資料寫入 CSV 文件。
            writer.append("id,period,artMuseumVisits,zooVisits,childrenNewParkVisits,astronomyMuseumVisits,shilinOfficialResidenceParkVisits,waterParkVisits,hotSpringMuseumVisits,discoveryCenterVisits,blueWaterwayVisits\n");
            for (Travel_Taipei travel : travelList) {
                writer.append(String.valueOf(travel.getId())).append(",");
                writer.append(travel.getPeriod()).append(",");
                writer.append(String.valueOf(travel.getArtMuseumVisits())).append(",");
                writer.append(String.valueOf(travel.getZooVisits())).append(",");
                writer.append(String.valueOf(travel.getChildrenNewParkVisits())).append(",");
                writer.append(String.valueOf(travel.getAstronomyMuseumVisits())).append(",");
                writer.append(String.valueOf(travel.getShilinOfficialResidenceParkVisits())).append(",");
                writer.append(String.valueOf(travel.getWaterParkVisits())).append(",");
                writer.append(String.valueOf(travel.getHotSpringMuseumVisits())).append(",");
                writer.append(String.valueOf(travel.getDiscoveryCenterVisits())).append(",");
                writer.append(String.valueOf(travel.getBlueWaterwayVisits())).append("\n");
            }
            System.out.println("Data exported to CSV file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}