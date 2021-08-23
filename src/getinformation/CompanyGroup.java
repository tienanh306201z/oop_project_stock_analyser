
//Lớp chỉ ra xu hướng của nhóm các công ty

package getinformation;

import java.util.ArrayList;

public class CompanyGroup {
    public ArrayList<String> list;
    private String groupName;
    private String code;
    private boolean groupTrendUp = false, groupTrendDown = false, groupTrendUnchanged = false;

    //Constructor thêm các mã vào danh sách
    public CompanyGroup(String groupName, String code) {
        this.list = new ArrayList<String>();
        this.list.add(code);
        this.code = code;
        this.groupName = groupName;
    }

    //Kiểm tra xu hướng nhóm
    public boolean isGroupTrendUp(ArrayList<StockCode> list1) {
        int count = 0;
        for (int i = 0; i < list1.size(); i++) {
            if (StockData.stockCodeHashMap.containsKey(list1.get(i).getCodeName())) {
                boolean up = StockData.stockCodeHashMap.get(list1.get(i).getCodeName()).getPrice().isRisingCode();
                if (up) count ++;
            }
        }
        if (count >= list1.size()/2) groupTrendUp = true;
        return groupTrendUp;
    }

    public boolean isGroupTrendDown(ArrayList<StockCode> list1) {
        int count = 0;
        for (int i = 0; i < list1.size(); i++) {
            if (StockData.stockCodeHashMap.containsKey(list1.get(i).getCodeName())) {
                boolean down = StockData.stockCodeHashMap.get(list1.get(i).getCodeName()).getPrice().isRisingCode();
                if (down) count ++;
            }
        }
        if (count >= list1.size()/2) groupTrendDown = true;
        return groupTrendDown;
    }

    public boolean isGroupTrendUnchanged(ArrayList<StockCode> list1) {
        int count = 0;
        for (int i = 0; i < list1.size(); i++) {
            if (StockData.stockCodeHashMap.containsKey(list1.get(i).getCodeName())) {
                boolean unchanged = StockData.stockCodeHashMap.get(list1.get(i).getCodeName()).getPrice().isRisingCode();
                if (unchanged) count ++;
            }
        }
        if (count >= list1.size()/2) groupTrendUnchanged = true;
        return groupTrendUnchanged;
    }

    public String getGroupName() {
        return groupName;
    }

    public ArrayList<String> getList() {
        return list;
    }
}