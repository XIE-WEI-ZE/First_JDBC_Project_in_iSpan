# 台北市觀光統計專案 / Taipei Tourist Statistics Project

資料來源: 政府資料開放平台 / Data Source: Government Open Data Platform
https://data.gov.tw/dataset/145783

此專案旨在管理和分析台北市各景點的觀光統計數據。專案包括從 URL 獲取數據、將數據存儲到 SQL Server 數據庫以及對數據執行 CRUD 操作的功能。 / This project aims to manage and analyze tourist statistics data for various attractions in Taipei. It includes functionalities to retrieve data from a URL, store the data in a SQL Server database, and perform CRUD (Create, Read, Update, Delete) operations.

## 專案簡介 / Project Overview

此專案從指定的 URL 獲取數據，將數據存儲在 SQL Server 數據庫中，並提供一系列功能來對數據進行增刪改查（CRUD）操作。此外，我們還實現了將數據導出為 CSV 文件的功能，方便進行後續的數據處理和分析。 / This project retrieves data from a specified URL, stores the data in a SQL Server database, and provides a range of functionalities to perform CRUD operations. Additionally, we implemented a feature to export the data to a CSV file, making it convenient for further data processing and analysis.

## 技術細節 / Technical Details

- **後端** / **Backend**: Java
- **數據庫** / **Database**: SQL Server
- **數據庫連接** / **Database Connection**: JDBC
- **數據導出** / **Data Export**: CSV file

## 專案結構 / Project Structure

- **ConnectionUtil**：提供數據庫連接方法 / Provides methods to establish a connection to the database
- **GetDataUtil**：從 URL 獲取數據並存儲在列表中 / Retrieves data from a URL and stores it in a list
- **Travel_Taipei_Service**：將數據從字符串列表轉換為 `Travel_Taipei` 對象列表 / Converts data from a list of strings to a list of `Travel_Taipei` objects
- **Travel_Taipei**：表示台北市各景點的觀光統計數據 / Represents tourist statistics data for various attractions in Taipei
- **Travel_TaipeiDao**：提供 CRUD 操作和數據導出功能 / Provides CRUD operations and data export functionality

## 主要功能 / Key Features

- 從 URL 獲取觀光數據 / Retrieve tourist data from a URL
- 將數據保存到 SQL Server 數據庫 / Save data to a SQL Server database
- 根據 ID 獲取數據 / Retrieve data by ID
- 獲取所有數據 / Retrieve all data
- 更新數據 / Update data
- 刪除數據 / Delete data by ID
- 將數據導出到 CSV 文件 / Export data to a CSV file

## 數據庫設置 / Database Setup

使用以下 SQL 腳本在 SQL Server 數據庫中創建表 / Create a table in the SQL Server database using the following SQL script:

```sql
CREATE TABLE [dbo].[台北市觀光] (
    [id] INT IDENTITY(1,1) PRIMARY KEY,
    [period] NVARCHAR(50) NOT NULL,
    [artMuseumVisits] INT NOT NULL,
    [zooVisits] INT NOT NULL,
    [childrenNewParkVisits] INT NOT NULL,
    [astronomyMuseumVisits] INT NOT NULL,
    [shilinOfficialResidenceParkVisits] INT NOT NULL,
    [waterParkVisits] INT NOT NULL,
    [hotSpringMuseumVisits] INT NOT NULL,
    [discoveryCenterVisits] INT NOT NULL,
    [blueWaterwayVisits] INT NOT NULL
);

SELECT * FROM 台北市觀光;

public class Main {
    public static void main(String[] args) {
        // 示例數據 URL / Example URL for data retrieval
        String dataURL = "http://example.com/data.csv";
        
        // 從 URL 獲取數據 / Retrieve data from URL
        List<String> dataList = GetDataUtil.getDataFromURL(dataURL);
        
        // 將數據轉換為 Travel_Taipei 對象列表 / Convert data to Travel_Taipei objects
        Travel_Taipei_Service service = new Travel_Taipei_Service();
        List<Travel_Taipei> travelList = service.getData(dataList);
        
        // 將數據保存到數據庫 / Save data to the database
        Travel_TaipeiDao dao = new Travel_TaipeiDao();
        for (Travel_Taipei travel : travelList) {
            dao.saveTravel_Taipei(travel);
        }
        
        // 將數據導出到 CSV 文件 / Export data to CSV
        dao.exportToCSV("output.csv");
    }
}

private static String url = "jdbc:sqlserver://localhost:1433;databasename=TouristStats;encrypt=false";
private static String user = "sa";
private String pwd = "你的密碼 / your_password";
