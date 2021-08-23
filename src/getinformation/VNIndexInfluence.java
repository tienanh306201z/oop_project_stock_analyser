
//Lớp cung cấp các thông tin về điểm ảnh hưởng VNindex của các mã trong ngày

package getinformation;

public class VNIndexInfluence {
    private String code;
    private float influencedPoint;

    public VNIndexInfluence(String code, float influencedPoint) {
        this.code = code;
        this.influencedPoint = influencedPoint;
    }

    public String getCode() {
        return code;
    }

    public float getInfluencedPoint() {
        return influencedPoint;
    }
}
	