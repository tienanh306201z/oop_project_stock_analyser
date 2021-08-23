
//Lớp trả về tổng giá trị giao dịch

package getinformation;

public class MarketSum {
    int totalMatchVol, totalPutVol;
    float totalMatchVal, totalPutVal;

    public MarketSum(int totalMatchVol, float totalMatchVal, int totalPutVol, float totalPutVal) {
        this.totalMatchVol = totalMatchVol;
        this.totalMatchVal = totalMatchVal;
        this.totalPutVol = totalPutVol;
        this.totalPutVal = totalPutVal;
    }

    public int getTotalMatchVol() { //Tổng khối lượng khớp lệnh
        return totalMatchVol;
    }
    public int getTotalPutVol() { //Tổng khối lượng thỏa thuận
        return totalPutVol;
    }
    public float getTotalMatchVal() { //Tổng giá trị khớp lệnh
        return totalMatchVal;
    }
    public float getTotalPutVal() { //Tổng giá trị thỏa thuận
        return totalPutVal;
    }

}
