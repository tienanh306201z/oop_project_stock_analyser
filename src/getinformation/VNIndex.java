
//Lớp lấy ra điểm chỉ số VN-Index

package getinformation;

import java.util.ArrayList;

public class VNIndex {
    private float closeIndex;
    private float changeIndex;
    private boolean rise = false;
    private boolean fall = false;
    private boolean unchanged = false;
    ArrayList<VNIndexInfluence> vnIndexInfluence = new ArrayList<VNIndexInfluence>();

    public VNIndex(float closeIndex, float changeIndex) {
        this.closeIndex = closeIndex;
        this.changeIndex = changeIndex;
        if(changeIndex > 0) //Kiểm tra xem mã tăng, giảm hay đứng giá
            rise = true;
        else if(changeIndex < 0)
            fall = true;
        else unchanged = true;
    }

    public boolean isRise() {
        return rise;
    }

    public boolean isFall() {
        return fall;
    }

    public boolean isUnchanged() {
        return unchanged;
    }

    public float getCloseIndex() {
        return closeIndex;
    }

    public float getChangeIndex() {
        return changeIndex;
    }

    public ArrayList<VNIndexInfluence> getVnIndexInfluence() {
        return vnIndexInfluence;
    }

}
