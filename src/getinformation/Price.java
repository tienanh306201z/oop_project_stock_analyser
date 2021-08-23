
//Lớp dùng để lưu và lấy các thông tin về giá
//Kiểm tra thông tin giá trị tổng quan của mã chứng khoán

package getinformation;

public class Price {
    private float referencePrice; //giá tham chiếu
    private float closePrice; //giá đóng cửa
    private float changeValue; //thay đổi giá
    private float changePerValue; //tỉ lệ thay đổi

    private boolean reachCeilingCode = false;
    private boolean risingCode = false;
    private boolean reachFloorCode = false;
    private boolean fallingCode = false;
    private boolean unchangedReferenceCode = false;

    //Constructor để lưu các giá trị về giá
    public Price(float referencePrice, float closePrice, float ceil, float floor) {
        this.referencePrice = referencePrice;
        this.closePrice = closePrice;

        if (closePrice == referencePrice) //Kiểm tra xem mã là tăng trần, tăng, giảm sàn, giảm hay đứng giá tham chiếu
            unchangedReferenceCode = true;
        else if (closePrice > referencePrice) {
            risingCode = true;
            if (closePrice == ceil)
                reachCeilingCode = true;
        }
        else {
            fallingCode = true;
            if (closePrice == floor)
                reachFloorCode = true;
        }
    }

    public float getChangePerValue() {
        changePerValue = (changeValue/referencePrice) * 100;
        return changePerValue;
    }

    public float getReferencePrice() {
        return referencePrice;
    }

    public float getClosePrice() {
        return closePrice;
    }

    public float getChangeValue() {
        changeValue = Math.abs(closePrice - referencePrice);
        return changeValue;
    }

    //Trả về loại mã tương ứng
    public boolean isReachCeilingCode() {
        return reachCeilingCode;
    }

    public boolean isReachFloorCode() {
        return reachFloorCode;
    }

    public boolean isRisingCode() {
        return risingCode;
    }

    public boolean isFallingCode() {
        return fallingCode;
    }

    public boolean isUnchangedReferenceCode() {
        return unchangedReferenceCode;
    }
}