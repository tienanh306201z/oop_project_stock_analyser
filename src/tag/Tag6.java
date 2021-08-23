package tag;

import java.util.ArrayList;

import getinformation.ForeignTransaction;

public class Tag6 extends Tag {
	private final String tagName = "Top giá trị nước ngoài mua";
	// private ArrayList<String> sentenceSet = new ArrayList<String>();
	private ArrayList<ForeignTransaction> code = new ArrayList<ForeignTransaction>();

	public Tag6(ArrayList<ForeignTransaction> code) {
		this.code = code;
		AddSentences();
	}

	@Override
	void AddSentences() {
		// TODO Auto-generated method stub

		sentences.add(tagName);
		sentences.add(sentence1());
		sentences.add(sentence2());
		sentences.add(sentence3());
		sentences.add(sentence4());
	}

	private final String sentence1() {
		String s = "Khối ngoại hôm nay mua ròng tới " + code.get(0).getfBuyValue() + " đồng cổ phiếu của "
				+ code.get(0).getCodeName();
		return s;
	}

	private final String sentence2() {
		String s = code.get(0).getCodeName() + "," + code.get(1).getCodeName() + ", " + code.get(2).getCodeName() + ", "
				+ code.get(3).getCodeName() + ", " + code.get(4).getCodeName()
				+ " là các mã cổ phiếu có giá trị lớn nhất được nước ngoài gom trong hôm nay";
		return s;
	}

	private final String sentence3() {
		String s = "Tổng 5 mã được nhà đầu tư nước ngoài mua nhiều nhất có giá trị đạt "
				+ (code.get(0).getfBuyValue() + code.get(1).getfBuyValue() + code.get(2).getfBuyValue()
						+ code.get(3).getfBuyValue() + code.get(4).getfBuyValue());
		return s;
	}

	private final String sentence4() {
		String s = "Hôm nay mã cổ phiếu " + code.get(0).getCodeName()
				+ " đứng đầu bảng các mã cổ phiếu được các nhà đầu tư nước ngoài mua với giá trị mua đạt "
				+ code.get(0).getfBuyValue() + " đồng.";
		return s;
	}

}
