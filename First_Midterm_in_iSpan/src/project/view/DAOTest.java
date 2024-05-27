package project.view;

import java.util.List;
import java.util.Scanner;

import project.dao.Travel_TaipeiDao;
import project.model.Travel_Taipei;

public class DAOTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Travel_TaipeiDao dao = new Travel_TaipeiDao();
		boolean i = true;

		while (i) {
			System.out.println("歡迎使用資料庫: ");
			System.out.println("\n請選擇要使用的功能");
			System.out.println("1. 新增旅遊資料");
			System.out.println("2. 查詢旅遊資料");
			System.out.println("3. 修改旅遊資料");
			System.out.println("4. 刪除旅遊資料");
			System.out.println("5. 匯出旅遊資料");
			System.out.println("6. 匯出為.csv檔案");
			System.out.println("7. 離開");

			int input = sc.nextInt();
			sc.nextLine();

			switch (input) {
			case 1:
				do {
					System.out.println("請輸入新的旅遊資料");
					Travel_Taipei travel_taipei = new Travel_Taipei();

					System.out.print("請輸入ID");
					travel_taipei.setId(sc.nextInt());

					sc.nextLine();

					System.out.print("請輸入旅遊年度月份:(例如 '113年4月') ");
					travel_taipei.setPeriod(sc.nextLine());

					System.out.print("輸入美術館的訪問人數: ");
					travel_taipei.setArtMuseumVisits(sc.nextInt());

					System.out.print("輸入動物園的訪問人數: ");
					travel_taipei.setZooVisits(sc.nextInt());

					System.out.print("輸入兒童公園的訪問人數: ");
					travel_taipei.setChildrenNewParkVisits(sc.nextInt());

					System.out.print("輸入天文館的訪問人數: ");
					travel_taipei.setAstronomyMuseumVisits(sc.nextInt());

					System.out.print("輸入士林公園的訪問人數: ");
					travel_taipei.setShilinOfficialResidenceParkVisits(sc.nextInt());

					System.out.print("輸入水族館的訪問人數: ");
					travel_taipei.setWaterParkVisits(sc.nextInt());

					System.out.print("輸入熱泉公園的訪問人數: ");
					travel_taipei.setHotSpringMuseumVisits(sc.nextInt());

					System.out.print("輸入發現中心的訪問人數: ");
					travel_taipei.setDiscoveryCenterVisits(sc.nextInt());

					System.out.print("輸入藍色水道訪問的訪問人數: ");
					travel_taipei.setBlueWaterwayVisits(sc.nextInt());

					// 使用DAO保存到SQL
					dao.saveTravel_Taipei(travel_taipei);
					System.out.println("資料已經新增");

					System.out.print("是否繼續輸入資料?(Y/N)");
					sc.nextLine();

				} while (sc.nextLine().equalsIgnoreCase("Y"));
				break;
			case 2:
				do {
					System.out.print("請輸入欲查詢的旅遊ID: ");
					int id = sc.nextInt();
					sc.nextLine();
					Travel_Taipei fetchedTravel = dao.getTravel_TaipeiById(id);
					if (fetchedTravel != null) {
						System.out.println("查詢結果的旅遊期間: " + fetchedTravel.getPeriod());
						System.out.println("查詢結果的藝術博物館參觀人數: " + fetchedTravel.getArtMuseumVisits());
						System.out.println("查詢結果的動物園參觀人數: " + fetchedTravel.getZooVisits());
						System.out.println("查詢結果的兒童新樂園參觀人數: " + fetchedTravel.getChildrenNewParkVisits());
						System.out.println("查詢結果的天文博物館參觀人數: " + fetchedTravel.getAstronomyMuseumVisits());
						System.out.println("查詢結果的士林官邸公園參觀人數: " + fetchedTravel.getShilinOfficialResidenceParkVisits());
						System.out.println("查詢結果的水上樂園參觀人數: " + fetchedTravel.getWaterParkVisits());
						System.out.println("查詢結果的溫泉博物館參觀人數: " + fetchedTravel.getHotSpringMuseumVisits());
						System.out.println("查詢結果的發現中心參觀人數: " + fetchedTravel.getDiscoveryCenterVisits());
						System.out.println("查詢結果的藍色水道參觀人數:  " + fetchedTravel.getBlueWaterwayVisits());
					} else {
						System.out.println("查無此資料");
					}
				} while (sc.nextLine().equalsIgnoreCase("Y"));
				break;
			case 3:
				do {
					System.out.print("請輸入欲更新的旅遊ID: ");
					int id = sc.nextInt();
					sc.nextLine();
					Travel_Taipei updatedTravel = dao.getTravel_TaipeiById(id);

					if (updatedTravel != null) {
						System.out.println("當前旅遊資料: " + updatedTravel);

						System.out.print("請輸入新的美術館訪問人數 (輸入-1保持不變): ");
						int artVisits = sc.nextInt();
						if (artVisits != -1) {
							updatedTravel.setArtMuseumVisits(artVisits);
						}
						sc.nextLine();

						System.out.print("請輸入新的動物園訪問人數 (輸入-1保持不變): ");
						int zooVisits = sc.nextInt();
						if (zooVisits != -1) {
							updatedTravel.setZooVisits(zooVisits);
						}
						sc.nextLine();

						System.out.print("請輸入新的兒童公園訪問人數 (輸入-1保持不變): ");
						int childrenParkVisits = sc.nextInt();
						if (childrenParkVisits != -1) {
							updatedTravel.setChildrenNewParkVisits(childrenParkVisits);
						}
						sc.nextLine();

						System.out.print("請輸入新的天文館訪問人數 (輸入-1保持不變): ");
						int astronomyVisits = sc.nextInt();
						if (astronomyVisits != -1) {
							updatedTravel.setAstronomyMuseumVisits(astronomyVisits);
						}
						sc.nextLine();

						System.out.print("請輸入新的士林公園訪問人數 (輸入-1保持不變): ");
						int shilinVisits = sc.nextInt();
						if (shilinVisits != -1) {
							updatedTravel.setShilinOfficialResidenceParkVisits(shilinVisits);
						}
						sc.nextLine();

						System.out.print("請輸入新的水族館訪問人數 (輸入-1保持不變): ");
						int waterParkVisits = sc.nextInt();
						if (waterParkVisits != -1) {
							updatedTravel.setWaterParkVisits(waterParkVisits);
						}
						sc.nextLine();

						System.out.print("請輸入新的熱泉公園訪問人數 (輸入-1保持不變): ");
						int hotSpringVisits = sc.nextInt();
						if (hotSpringVisits != -1) {
							updatedTravel.setHotSpringMuseumVisits(hotSpringVisits);
						}
						sc.nextLine();

						System.out.print("請輸入新的發現中心訪問人數 (輸入-1保持不變): ");
						int discoveryVisits = sc.nextInt();
						if (discoveryVisits != -1) {
							updatedTravel.setDiscoveryCenterVisits(discoveryVisits);
						}
						sc.nextLine();

						System.out.print("請輸入新的藍色水道訪問人數 (輸入-1保持不變): ");
						int blueWaterwayVisits = sc.nextInt();
						if (blueWaterwayVisits != -1) {
							updatedTravel.setBlueWaterwayVisits(blueWaterwayVisits);
						}
						sc.nextLine();

						// 更新到sql server
						dao.updateTravel_Taipei(updatedTravel);
						System.out.println("資料已更新。");
					} else {
						System.out.println("未找到指定ID的Travel_Taipei記錄。");
					}

					System.out.print("是否繼續更新其他資料？(Y/N): ");
				} while (sc.nextLine().equalsIgnoreCase("Y"));
				break;
			case 4:
				do {
					System.out.print("請輸入欲刪除的旅遊ID: ");
					int deleteId = sc.nextInt();
					sc.nextLine();
					dao.deleteTravel_Taipei(deleteId);
					Travel_Taipei deletedTravel = dao.getTravel_TaipeiById(deleteId);
					System.out.println("Deleted Travel: " + (deletedTravel == null ? "Deleted" : "Not Deleted"));

					System.out.print("是否繼續刪除其他資料？(Y/N): ");
				} while (sc.nextLine().equalsIgnoreCase("Y"));
				break;
			case 5:
				List<Travel_Taipei> travelList = dao.getAllTravel_Taipei();
				System.out.println("Total Travels: " + travelList.size());

				for (Travel_Taipei travel : travelList) {
					System.out.println("ID: " + travel.getId());
					System.out.println("期間: " + travel.getPeriod());
					System.out.println("美術館參觀人數: " + travel.getArtMuseumVisits());
					System.out.println("動物園參觀人數: " + travel.getZooVisits());
					System.out.println("兒童新樂園參觀人數: " + travel.getChildrenNewParkVisits());
					System.out.println("天文館參觀人數: " + travel.getAstronomyMuseumVisits());
					System.out.println("士林官邸公園參觀人數: " + travel.getShilinOfficialResidenceParkVisits());
					System.out.println("水上樂園參觀人數: " + travel.getWaterParkVisits());
					System.out.println("溫泉博物館參觀人數: " + travel.getHotSpringMuseumVisits());
					System.out.println("探索館參觀人數: " + travel.getDiscoveryCenterVisits());
					System.out.println("藍色水道參觀人數: " + travel.getBlueWaterwayVisits());
					System.out.println("--------------------------------");

				}
				break;
			case 6:
				System.out.print("請輸入要保存的檔案路徑 (例如 C:\\Users\\ASUS ROG\\Desktop\\旅遊資料.csv): ");
				String filePath = sc.nextLine();
				dao.exportToCSV(filePath);
				System.out.println("資料已匯出到 " + filePath);
				break;
			case 7:
				System.out.print("感謝您的使用，期待下次您的光臨");
				i = false;
				break;
			}
		}

	}
}