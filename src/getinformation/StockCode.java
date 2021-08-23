
//Lớp dùng để lưu dữ liệu về các mã chứng khoán

package getinformation;

public class StockCode {
    private String code;
    private String companyName;
    private Price price;
    private Transaction transaction;

    //Constructor dùng để lưu dữ liệu về mã chứng khoán
    public StockCode(String code, Price price, Transaction transaction) {
        this.code = code;
        this.price = price;
        this.transaction = transaction;
    }

    public String getCodeName() {
        return code;
    }

    //Getter dùng để lấy dữ liệu về mã chứng khoán
    public String getCompanyName() {
        if(companyName == null)
            return "sàn HOSE";
        return companyName;
    }

    public Price getPrice() {
        return price;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setCompanyName(String companyName) { //Set tên công ty
        this.companyName = companyName;
    }
}

