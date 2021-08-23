
//Lớp dùng để lưu và lấy thông tin khối lượng giao dịch

package getinformation;

public class Transaction {
    private int auctionVolume; //Khối lượng khớp lệnh
    private float auctionValue;	//Giá trị khớp lệnh
    private int dealVolume; //Khối lượng giao dịch
    private float dealValue; //Giá trị giao dịch

    //Constructor để lưu thông tin về khối lượng giao dịch
    public Transaction(int auctionVolume, float auctionValue, int dealVolume, float dealValue) {
        this.auctionVolume = auctionVolume;
        this.auctionValue = auctionValue;
        this.dealVolume = dealVolume;
        this.dealValue = dealValue;
    }

    //Getter để lấy thông tin về khối lượng giao dịch
    public int getAuctionVolume() {
        return auctionVolume;
    }

    public float getAuctionValue() {
        return auctionValue;
    }

    public int getSumOfVolume() { //lấy ra tổng khối lượng giao dịch
        return auctionVolume + dealVolume;
    }

    public float getSumOfValue() {
        return auctionValue + dealValue; //lấy ra tổng giá trị giao dịch
    }
}
