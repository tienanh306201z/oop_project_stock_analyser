package tag;

import java.util.ArrayList;

import getinformation.StockCode;
import getinformation.StockData;
import getinformation.CompanyGroup;

public class TagGroup extends Tag {
	public String tagName ;
	protected CompanyGroup group;
	protected ArrayList<StockCode> risingCode, fallingCode, volumeCode; 
		
	public TagGroup(String tagName, CompanyGroup group, ArrayList<StockCode> risingcode, ArrayList<StockCode> fallingCode, ArrayList<StockCode> volumeCode) {
		if (volumeCode.isEmpty()) {
			sentences.add("Không có dữ liệu về công ty");
		}
		else {
			this.tagName = tagName;
			this.group = group;
			this.risingCode = risingcode;
			this.fallingCode = fallingCode;
			this.volumeCode = volumeCode;
			AddSentences();
		}
	}
	
	@Override
	void AddSentences() {
		sentences.add(tagName);
		sentences.add(Sentence1());
		sentences.add(Sentence2());
		sentences.add(Sentence3());
		sentences.add(Sentence4());
		sentences.add(Sentence5());
	}
	
	private String getComName(String comCode) {
		if (StockData.companyNameHashMap.containsKey(comCode)) {
			return StockData.companyNameHashMap.get(comCode);
		} else return "Sàn HOSE";
	}	
	
	private final String Sentence1() {
		String s ;
		if(volumeCode.size() >= 6) {
			if (group.isGroupTrendUp(volumeCode)) {
			    s = "Ở nhóm cổ phiếu " + group.getGroupName() + " ghi nhận nhiều mã tăng, tăng mạnh nhất là mã " 
			            + risingCode.get(0).getCodeName() + " của " + getComName(risingCode.get(0).getCodeName()) + ", tăng " 
					    + risingCode.get(0).getPrice().getChangeValue() + " đồng.";	
			}
			
			else if (group.isGroupTrendDown(volumeCode)) {
			    s = "Ở nhóm cổ phiếu "+ group.getGroupName()+ " ghi nhận nhiều mã giảm, giảm mạnh nhất là mã " 
			            + fallingCode.get(0).getCodeName() + " của " + getComName(fallingCode.get(0).getCodeName()) + ", giảm " 
				     	+ fallingCode.get(0).getPrice().getChangeValue() + " đồng.";
			}
		    else {
		    	s = "Ở nhóm cổ phiếu " + group.getGroupName() + ", ghi nhận nhiều mã đứng giá,chỉ có một số mã " 
		    			+ risingCode.get(0).getCodeName() + ", " + risingCode.get(1).getCodeName() + " tăng nhẹ.";
		    }
		}
		else s = "Không có đủ dữ liệu hiển thị của tag này";
	    	return s;
	}
	
	private final String Sentence2() {
		if(volumeCode.size() >= 6) {
			if (group.isGroupTrendDown(volumeCode)) {
				return ( "Nhóm " + tagName + " có xu hướng đi xuống, ghi nhận nhiều mã giảm như " 
						+ fallingCode.get(0).getCodeName() + ", " 
						+ fallingCode.get(1).getCodeName() + ", " 
						+ fallingCode.get(2).getCodeName() + " giảm sâu." );
			}
			else if (group.isGroupTrendUp(volumeCode)) {
				return ( "Nhóm " + tagName + " có xu hướng đi lên, ghi nhận nhiều mã tăng như " 
						+ risingCode.get(0).getCodeName() + ", " 
						+ risingCode.get(1).getCodeName() + ", " 
						+ risingCode.get(2).getCodeName() + " tăng mạnh." );
			}
			else {
				return ( "Nhóm " + tagName + " giao dịch hôm nay không quá sôi động, các mã đa phần đều đứng giá." );
			}
		}
		else return "Không có đủ dữ liệu hiển thị của tag này";
	}
	
    	private final String Sentence3() {
    		String s;
    		if(volumeCode.size() >= 2) {
    			s = "Hôm nay " + volumeCode.get(0).getCodeName() + ", " + volumeCode.get(1).getCodeName()
    					+ " là 2 mã thuộc nhóm " + tagName + " khớp lệnh với khối lượng lớn lần lượt với " + volumeCode.get(0).getTransaction().getAuctionVolume()
    					+ " và " + volumeCode.get(1).getTransaction().getAuctionVolume() + " đơn vị.";
    		}
    		else s = "Không có đủ dữ liệu hiển thị của tag này";
		return s;
	}
	
	private final String Sentence4() {
		String s;
		if(volumeCode.size() >= 3) {
			s = "Các mã nhóm " + tagName + " tiếp tục xu thế mua bán khá sôi động, " 
					+ volumeCode.get(0).getCodeName() + ", " 
					+ volumeCode.get(1).getCodeName() + ", " 
					+ volumeCode.get(2).getCodeName() + " sang tay " 
					+ volumeCode.get(0).getTransaction().getAuctionVolume()
					+ " - " + volumeCode.get(2).getTransaction().getAuctionVolume() + " chứng khoán.";
		}
		else s = "Không có đủ dữ liệu hiển thị của tag này";
		return s;
	}
	
	private final String Sentence5() {
		String s;
		if(volumeCode.size() >= 4) {
			if (group.isGroupTrendUp(volumeCode)) {
				s = "Thanh khoản của nhóm cổ phiếu " + tagName + " lên cao, mã " + volumeCode.get(0).getCodeName()
					+ " khớp hơn " + volumeCode.get(0).getTransaction().getAuctionVolume() + " cổ phiếu, mã "
					+  volumeCode.get(1).getCodeName()
					+ " khớp hơn " + volumeCode.get(1).getTransaction().getAuctionVolume() + " cổ phiếu.";
			}
			else if (group.isGroupTrendDown(volumeCode))
			s = "Thanh khoản của nhóm cổ phiếu " + tagName + " không nhiều, mã" + volumeCode.get(0).getCodeName()
				+ " khớp được " + volumeCode.get(1).getTransaction().getAuctionVolume()
				+ " cổ phiếu, mã " + volumeCode.get(1).getCodeName()
				+ " khớp được " + volumeCode.get(1).getTransaction().getAuctionVolume() 
				+ " cổ phiếu.";
			else {
			    s = "Thanh khoản của nhóm cổ phiếu bất động sản có phần chững lại, khá nhất nhóm này là " 
			    + volumeCode.get(0).getCodeName() + " khớp hơn " 
			    + volumeCode.get(0).getTransaction().getAuctionVolume()
				+ " đơn vị.";		
			}
		}
		else s = "Không có đủ dữ liệu hiển thị của tag này";
		return s;
	}
}