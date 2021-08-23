
//Lớp chứa thông tin về giao dịch của nhà đầu tư nước ngoài

package getinformation;

public class ForeignTransaction {
    private float fSellValue; //Giá trị nước ngoài dán
    private float fBuyValue; //Giá trị nước ngoài mua
    private float fBuyVolume; //Khối lượng nước ngoài mua
    private float fSellVolume; //Khối lượng nước ngoài bán
    private String codeName; //Tên công ty

    //Constructors để lưu các giá trị
    public ForeignTransaction(String codeName, float fSellValue, float fBuyValue, float fBuyVolume, float fSellVolume) {
        this.codeName = codeName;
        this.fSellValue = fSellValue;
        this.fBuyValue = fBuyValue;
        this.fBuyVolume = fBuyVolume;
        this.fSellVolume = fSellVolume;
    }


    //Getters dùng để lấy ra thông tin của giao dịch nhà đầu tư nước ngoài
    public String getCodeName() {
        return codeName;
    }

    public float getfSellValue() {
        return fSellValue;
    }

    public float getfBuyValue() {
        return fBuyValue;
    }

    public float getfBuyVolume() {
        return fBuyVolume;
    }

    public float getfSellVolume() {
        return fSellVolume;
    }
}
