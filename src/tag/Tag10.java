package tag;

import java.util.ArrayList;

import getinformation.StockCode;

public class Tag10 extends Tag {
	private static final String tagName = "Các cổ phiếu đứng giá";
	private ArrayList<StockCode> code;

	public Tag10(ArrayList<StockCode> code) {
		this.code = code;
		AddSentences();
	}

	@Override
	void AddSentences() {
		sentences.add(tagName);
		sentences.add(Sentence1());
		sentences.add(Sentence2());
	}

	private final String Sentence1() {
		String s = code.get(0).getCodeName() + ", " + code.get(1).getCodeName() + ", " + code.get(2).getCodeName()
				+ ", " + code.get(3).getCodeName() + ", " + code.get(4).getCodeName() + ", " + code.get(5).getCodeName()
				+ ",... cùng nhau đứng giá";
		return s;
	}

	private final String Sentence2() {
		String s = "Các mã đi ngang gồm có " + code.get(0).getCodeName() + ", " + code.get(1).getCodeName() + ", "
				+ code.get(2).getCodeName() + ", " + code.get(3).getCodeName() + ", " + code.get(4).getCodeName() + ", "
				+ code.get(5).getCodeName() + ",... ";
		return s;
	}
}
