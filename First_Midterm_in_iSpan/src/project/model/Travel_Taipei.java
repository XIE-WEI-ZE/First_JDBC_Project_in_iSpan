package project.model;

import java.io.Serializable;

/*
 * 重寫的 toString 方法提供了一個方便的方式來打印對象的所有屬性值。
 * */

// sql 類別，主要作用是表示台北市各個旅遊景點的訪問數據
// 定義一個 public 類別 Travel_Taipei 實現 Serializable 街口，使他能被序列化
public class Travel_Taipei implements Serializable {
    private int id;
    private String period;
    private int artMuseumVisits;
    private int zooVisits;
    private int childrenNewParkVisits;
    private int astronomyMuseumVisits;
    private int shilinOfficialResidenceParkVisits;
    private int waterParkVisits;
    private int hotSpringMuseumVisits;
    private int discoveryCenterVisits;
    private int blueWaterwayVisits;
    
    //get和set的方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public int getArtMuseumVisits() {
        return artMuseumVisits;
    }

    public void setArtMuseumVisits(int artMuseumVisits) {
        this.artMuseumVisits = artMuseumVisits;
    }

    public int getZooVisits() {
        return zooVisits;
    }

    public void setZooVisits(int zooVisits) {
        this.zooVisits = zooVisits;
    }

    public int getChildrenNewParkVisits() {
        return childrenNewParkVisits;
    }

    public void setChildrenNewParkVisits(int childrenNewParkVisits) {
        this.childrenNewParkVisits = childrenNewParkVisits;
    }

    public int getAstronomyMuseumVisits() {
        return astronomyMuseumVisits;
    }

    public void setAstronomyMuseumVisits(int astronomyMuseumVisits) {
        this.astronomyMuseumVisits = astronomyMuseumVisits;
    }

    public int getShilinOfficialResidenceParkVisits() {
        return shilinOfficialResidenceParkVisits;
    }

    public void setShilinOfficialResidenceParkVisits(int shilinOfficialResidenceParkVisits) {
        this.shilinOfficialResidenceParkVisits = shilinOfficialResidenceParkVisits;
    }

    public int getWaterParkVisits() {
        return waterParkVisits;
    }

    public void setWaterParkVisits(int waterParkVisits) {
        this.waterParkVisits = waterParkVisits;
    }

    public int getHotSpringMuseumVisits() {
        return hotSpringMuseumVisits;
    }

    public void setHotSpringMuseumVisits(int hotSpringMuseumVisits) {
        this.hotSpringMuseumVisits = hotSpringMuseumVisits;
    }

    public int getDiscoveryCenterVisits() {
        return discoveryCenterVisits;
    }

    public void setDiscoveryCenterVisits(int discoveryCenterVisits) {
        this.discoveryCenterVisits = discoveryCenterVisits;
    }

    public int getBlueWaterwayVisits() {
        return blueWaterwayVisits;
    }

    public void setBlueWaterwayVisits(int blueWaterwayVisits) {
        this.blueWaterwayVisits = blueWaterwayVisits;
    }

    @Override
    public String toString() {
        return "Travel_Taipei {" +
                "\n id=" + id +
                ",\n period='" + period + '\'' +
                ",\n artMuseumVisits=" + artMuseumVisits +
                ",\n zooVisits=" + zooVisits +
                ",\n childrenNewParkVisits=" + childrenNewParkVisits +
                ",\n astronomyMuseumVisits=" + astronomyMuseumVisits +
                ",\n shilinOfficialResidenceParkVisits=" + shilinOfficialResidenceParkVisits +
                ",\n waterParkVisits=" + waterParkVisits +
                ",\n hotSpringMuseumVisits=" + hotSpringMuseumVisits +
                ",\n discoveryCenterVisits=" + discoveryCenterVisits +
                ",\n blueWaterwayVisits=" + blueWaterwayVisits +
                "\n}";
    }
}