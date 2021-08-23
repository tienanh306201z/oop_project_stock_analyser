package tag;

import java.util.ArrayList;

import getinformation.StockCode;

public class Tag2 extends Tag {
	private static final String tagName = "Top 5 giảm mạnh";
	private ArrayList<StockCode> code;

	public Tag2(ArrayList<StockCode> code) {
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
		String s = "Top 5 mã giảm giá gồm có " + code.get(0).getCodeName() + " ("
				+ code.get(0).getPrice().getChangeValue() + " đồng), " + code.get(1).getCodeName() + " ("
				+ code.get(1).getPrice().getChangeValue() + " đồng), " + code.get(2).getCodeName() + " ("
				+ code.get(2).getPrice().getChangeValue() + " đồng), " + code.get(3).getCodeName() + " ("
				+ code.get(3).getPrice().getChangeValue() + " đồng), và " + code.get(4).getCodeName() + " ("
				+ code.get(4).getPrice().getChangeValue() + " đồng).";
		return s;
	}

	private final String Sentence2() {
		String s = "Top 5 cổ phiếu giảm giá nhiều nhất gồm " + code.get(0).getCodeName() + " ("
				+ code.get(0).getPrice().getChangeValue() + " đồng), " + code.get(1).getCodeName() + " ("
				+ code.get(1).getPrice().getChangeValue() + " đồng), " + code.get(2).getCodeName() + " ("
				+ code.get(2).getPrice().getChangeValue() + " đồng), " + code.get(3).getCodeName() + " ("
				+ code.get(3).getPrice().getChangeValue() + " đồng), và " + code.get(4).getCodeName() + " ("
				+ code.get(4).getPrice().getChangeValue() + " đồng).";
		return s;
	}

	private final String Sentence3() {
		String s = "Trong 5 cổ phiếu xuống giá nhất có " + code.get(0).getCodeName() + " ("
				+ code.get(0).getPrice().getChangeValue() + "), " + code.get(1).getCodeName() + " giảm nhiều nhất "
				+ code.get(1).getPrice().getChangeValue() + " đồng, theo sau là " + code.get(2).getCodeName() + " ("
				+ code.get(2).getPrice().getChangeValue() + " đồng), " + code.get(3).getCodeName() + " ("
				+ code.get(3).getPrice().getChangeValue() + " đồng), và " + code.get(4).getCodeName() + " ("
				+ code.get(4).getPrice().getChangeValue() + " đồng).";
		return s;
	}

	private final String Sentence4() {
		String s = "Nhóm 5 cổ phiếu giảm giá mạnh nhất gồm  " + code.get(0).getCodeName() + ", "
				+ code.get(1).getCodeName() + ", " + code.get(2).getCodeName() + ", " + code.get(3).getCodeName() + ", "
				+ code.get(4).getCodeName() + ".";
		return s;
	}
}
