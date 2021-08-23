package tag;

import getinformation.StockCode;

import java.util.ArrayList;

public class Tag1 extends Tag {
	private static final String tagName = "Top 5 tăng mạnh";
	private ArrayList<StockCode> code;

	public Tag1(ArrayList<StockCode> code) {
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
		String s = "Top 5 mã tăng giá gồm có " + code.get(0).getCodeName() + " ("
				+ code.get(0).getPrice().getChangeValue() + " đồng), " + code.get(1).getCodeName() + " ("
				+ code.get(1).getPrice().getChangeValue() + " đồng), " + code.get(2).getCodeName() + " ("
				+ code.get(2).getPrice().getChangeValue() + " đồng), " + code.get(3).getCodeName() + " ("
				+ code.get(3).getPrice().getChangeValue() + " đồng), và " + code.get(4).getCodeName() + " ("
				+ code.get(4).getPrice().getChangeValue() + " đồng).";
		return s;
	}

	private final String Sentence2() {
		String s = "Dẫn đầu danh sách tăng là " + code.get(0).getCodeName() + " với mức tăng "
				+ code.get(0).getPrice().getChangeValue() + " đồng, theo sau đó là " + code.get(1).getCodeName() + " ("
				+ code.get(1).getPrice().getChangeValue() + " đồng), " + code.get(2).getCodeName() + " ("
				+ code.get(2).getPrice().getChangeValue() + " đồng), " + code.get(3).getCodeName() + " ("
				+ code.get(3).getPrice().getChangeValue() + " đồng), và " + code.get(4).getCodeName() + " ("
				+ code.get(4).getPrice().getChangeValue() + " đồng).";
		return s;
	}

	private final String Sentence3() {
		String s = "Đến cuối phiên, " + code.get(0).getCodeName() + " tăng mạnh nhất với "
				+ code.get(0).getPrice().getChangeValue() + " đồng. Xếp thứ hai là " + code.get(1).getCodeName()
				+ " ( tăng " + code.get(1).getPrice().getChangeValue() + " đồng). Theo sau đó lần lượt là "
				+ code.get(2).getCodeName() + "), và " + code.get(3).getCodeName() + " tăng lần lượt "
				+ code.get(3).getPrice().getChangeValue() + " đồng,  " + code.get(4).getPrice().getChangeValue()
				+ " đồng.";
		return s;
	}

	private final String Sentence4() {
		String s = "Nhóm 5 cổ phiếu giảm giá mạnh nhất gồm  " + code.get(0).getCodeName() + ", "
				+ code.get(1).getCodeName() + ", " + code.get(2).getCodeName() + ", " + code.get(3).getCodeName() + ", "
				+ code.get(4).getCodeName() + ".";
		return s;
	}
}
