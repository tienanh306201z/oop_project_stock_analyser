package tag;

import getinformation.StockCode;

import java.util.ArrayList;

public class Tag3 extends Tag {
	private static final String tagName = "Top khối lượng khớp lệnh";
	private ArrayList<StockCode> code;

	public Tag3(ArrayList<StockCode> code) {
		this.code = code;
		AddSentences();
	}

	@Override
	void AddSentences() {
		sentences.add(tagName);
		sentences.add(Sentence1());
		sentences.add(Sentence2());
		sentences.add(Sentence3());
		sentences.add(Sentence4());
	}

	private final String Sentence1() {
		String s = "5 cổ phiếu có khối lượng khớp lệnh lớn nhất là  " + code.get(0).getCodeName() + " ("
				+ code.get(0).getTransaction().getAuctionVolume() + "), " + code.get(1).getCodeName() + " ("
				+ code.get(1).getTransaction().getAuctionVolume() + "), " + code.get(2).getCodeName() + " ("
				+ code.get(2).getTransaction().getAuctionVolume() + "), " + code.get(3).getCodeName() + " ("
				+ code.get(3).getTransaction().getAuctionVolume() + "), và " + code.get(4).getCodeName() + " ("
				+ code.get(4).getTransaction().getAuctionVolume() + ").";
		return s;
	}

	private final String Sentence2() {
		String s = "Xếp thứ nhất về giao dịch là " + code.get(0).getCodeName() + ": "
				+ code.get(0).getPrice().getChangeValue() + " cổ phiếu, tiếp theo sau lần lượt là "
				+ code.get(1).getCodeName() + " (" + code.get(1).getPrice().getChangeValue() + "), "
				+ code.get(2).getCodeName() + " (" + code.get(2).getPrice().getChangeValue() + "), "
				+ code.get(3).getCodeName() + " (" + code.get(3).getPrice().getChangeValue() + "), và "
				+ code.get(4).getCodeName() + " (" + code.get(4).getPrice().getChangeValue() + ").";
		return s;
	}

	private final String Sentence3() {
		String s = "Số lượng giao dịch của " + code.get(0).getCodeName() + " ở mức cao với "
				+ code.get(0).getPrice().getChangeValue() + " cổ phiếu, vượt lên " + code.get(1).getCodeName() + " với "
				+ code.get(1).getPrice().getChangeValue() + " cổ phiếu để dẫn đầu thị phần giao dịch. "
				+ code.get(2).getCodeName() + " đứng thứ 3 với " + code.get(2).getPrice().getChangeValue()
				+ " cổ phiếu khớp lệnh.";
		return s;
	}

	private final String Sentence4() {
		String s = "5 mã chứng khoán được ghi nhận có khối lượng khớp lệnh lớn nhất là  " + code.get(0).getCodeName()
				+ ", " + code.get(1).getCodeName() + ", " + code.get(2).getCodeName() + ", " + code.get(3).getCodeName()
				+ ", " + code.get(4).getCodeName() + ".";
		return s;
	}
}
