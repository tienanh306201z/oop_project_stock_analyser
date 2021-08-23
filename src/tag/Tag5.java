package tag;

import getinformation.ForeignTransaction;

import java.util.ArrayList;

public class Tag5 extends Tag {

	private static final String tagName = "Top khối lượng nước ngoài mua";
	private ArrayList<ForeignTransaction> code;

	public Tag5(ArrayList<ForeignTransaction> code) {
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
		String s = "Tại sàn HOSE " + code.get(0).getCodeName() + ", " + code.get(1).getCodeName() + ", "
				+ code.get(2).getCodeName() + ", " + code.get(3).getCodeName() + ", " + code.get(4).getCodeName()
				+ " lọt vào top những mã được nhà đầu tư nước ngoài săn hàng.";
		return s;
	}

	private final String Sentence2() {
		String s = "Các chứng khoán được người nước ngoài mua nhiều nhất là " + code.get(0).getCodeName() + ", "
				+ code.get(1).getCodeName() + ", " + code.get(2).getCodeName() + ", " + code.get(3).getCodeName() + ", "
				+ code.get(4).getCodeName() + ".";
		return s;
	}

	private final String Sentence3() {
		String s = "Cổ phiếu được nhà đầu tư nước ngoài săn đón nhiều nhất là " + code.get(0).getCodeName() + " với "
				+ code.get(0).getfBuyValue() + " đồng.";
		return s;
	}

	private final String Sentence4() {
		String s = "Khối ngoại đẩy mạnh giao dịch trong phiên hôm nay với lượng mua bán một số mã lên tới hàng triệu đơn vị như "
				+ code.get(0).getCodeName() + ", " + code.get(1).getCodeName() + ".";
		return s;
	}

}