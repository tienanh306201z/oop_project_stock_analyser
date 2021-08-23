package tag;

import java.util.ArrayList;

import getinformation.StockCode;

import readdata.GetStockInfo;

public class TagI2 extends Tag {

	private final String nameTag = "Tổng quan toàn sàn";

	private StockCode maxActioneValue;

	private ArrayList<StockCode> top3AutioneValue = new ArrayList<StockCode>();

	public TagI2(StockCode maxActioneValue, ArrayList<StockCode> top3AutioneValue) {
		this.maxActioneValue = maxActioneValue;
		this.top3AutioneValue = top3AutioneValue;
		AddSentences();
	}

	@Override
	void AddSentences() {
		sentences.add(nameTag);
		sentences.add(Sentence1());
		sentences.add(Sentence2());
		sentences.add(Sentence3());
		sentences.add(Sentence4());
	}

	private String Sentence1() {
		String s = "HOSE thỏa thuận " + GetStockInfo.totalMatchVol + " đơn vị, trị giá " + GetStockInfo.totalMatchVal
				+ " đồng .";
		return s;
	}

	private String Sentence2() {
		String s = "HOSE khớp lệnh được " + GetStockInfo.totalPutVol + " đơn vị, trị giá " + GetStockInfo.totalPutVal
				+ " đồng, trong đó " + maxActioneValue.getCodeName() + " dẫn đầu danh sách khớp lệnh với "
				+ maxActioneValue.getTransaction().getAuctionVolume() + " lệnh, đạt "
				+ maxActioneValue.getTransaction().getAuctionValue() + " đồng.";
		return s;
	}

	private String Sentence3() {
		String s = top3AutioneValue.get(0).getCodeName() + ", " + top3AutioneValue.get(1).getCodeName() + ", "
				+ top3AutioneValue.get(2).getCodeName()
				+ " lần lượt giao dịch nhiều nhất sàn, với tổng khối lượng giao dịch hơn "
				+ (top3AutioneValue.get(0).getTransaction().getSumOfVolume()
						+ top3AutioneValue.get(1).getTransaction().getSumOfVolume()
						+ top3AutioneValue.get(2).getTransaction().getSumOfVolume())
				+ " cổ phiếu";
		return s;
	}

	private String Sentence4() {
		// TODO Auto-generated method stub
		String s = "Khối lượng giao dịch lớn nhất trong phiên hôm nay thuộc về " + top3AutioneValue.get(0).getCodeName()
				+ " với " + top3AutioneValue.get(0).getTransaction().getSumOfVolume() + " cổ phiếu, giá trị tăng "
				+ top3AutioneValue.get(0).getPrice().getChangeValue() + " đồng lên "
				+ top3AutioneValue.get(0).getPrice().getClosePrice() + " đồng mỗi cổ phiếu.";
		return s;
	}
}