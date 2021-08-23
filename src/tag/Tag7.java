package tag;

import java.util.ArrayList;
import getinformation.ForeignTransaction;

public class Tag7 extends Tag {
	private final String tagName = "Top khối lượng nước ngoài bán";
	// private static ArrayList<String> sentenceSet = new ArrayList<String>();
	private ArrayList<ForeignTransaction> code = new ArrayList<ForeignTransaction>();
	private float sum = 0;

	public Tag7(ArrayList<ForeignTransaction> code, float sum) {
		this.code = code;
		this.sum = sum;
		AddSentences();
	}

	@Override
	void AddSentences() {

		sentences.add(tagName);
		sentences.add(sentence1());
		sentences.add(sentence2());
		sentences.add(sentence3());
		sentences.add(sentence4());

	}

	private final String sentence1() {
		String s = "Các cổ phiếu đáng chú ý được nhà đầu tư nước ngoài bán ra trong phiên này:  "
				+ code.get(0).getfSellVolume() + " cổ phiếu " + code.get(0).getCodeName() + ", "
				+ code.get(1).getfSellVolume() + " cổ phiểu " + code.get(1).getCodeName() + ", "
				+ code.get(2).getfSellVolume() + " cổ phiếu " + code.get(2).getCodeName() + ", "
				+ code.get(3).getfSellVolume() + " cổ phiếu " + code.get(3).getfSellVolume() + ", "
				+ code.get(3).getfSellVolume() + " cổ phiếu " + code.get(3).getfSellVolume() + ".";
		return s;
	}

	private final String sentence2() {
		String s = "Trong hôm nay 2 mã " + code.get(0).getCodeName() + " và " + code.get(1).getCodeName()
				+ " được khối ngoài bán ròng lần lượt " + code.get(0).getfSellVolume() + " và "
				+ code.get(1).getfSellVolume() + " cổ phiếu.";
		return s;
	}

	private final String sentence3() {

		String s = "Khối ngoài bán ra 24 mã với tổng khối lượng " + sum + " cổ phiếu và và " + code.get(0).getCodeName()
				+ " cũng được bán ra với " + code.get(0).getfSellValue() + " cổ phiếu.";
		return s;
	}

	private final String sentence4() {
		String s = "Sau giao dịch đầy biến động " + code.get(0).getCodeName()
				+ " là mã được các nhà đầu tư nước ngoài đẩy đi với khối lượng nhiều nhất đạt lên đến "
				+ code.get(0).getfSellVolume() + " cổ phiếu.";
		return s;
	}

}
