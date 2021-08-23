package tag;

import getinformation.StockCode;

import java.util.ArrayList;

public class Tag4 extends Tag {
	private static final String tagName = "Top giá trị khớp lệnh";
	private ArrayList<StockCode> code;

	public Tag4(ArrayList<StockCode> code) {
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
		String s = "Trên bảng tổng sắp, giá trị khớp lệnh " + code.get(0).getCodeName() + " đạt cao nhất với "
				+ code.get(0).getTransaction().getAuctionValue() + " đồng.";
		return s;
	}

	private final String Sentence2() {
		String s = "Cổ phiếu " + code.get(0).getCodeName() + " chiếm vị trí dẫn đầu về giá trị khớp lệnh khi đạt "
				+ code.get(0).getTransaction().getAuctionValue() + " đồng.";
		return s;
	}

	private final String Sentence3() {
		String s = "Ba cổ phiếu có giá trị khớp lệnh cao nhất thị trường là " + code.get(0).getCodeName() + " với "
				+ code.get(0).getTransaction().getAuctionValue() + " đồng, " + code.get(1).getCodeName() + " với "
				+ code.get(1).getTransaction().getAuctionValue() + " đồng, " + code.get(2).getCodeName() + " với "
				+ code.get(2).getTransaction().getAuctionValue() + " đồng.";
		return s;
	}

	private final String Sentence4() {
		String s = "Xét theo giá trị khớp lệnh cao nhất, đứng sau cổ phiếu " + code.get(0).getCodeName() + " ("
				+ code.get(0).getTransaction().getAuctionValue() + ") đồng" + " là các cổ phiếu "
				+ code.get(1).getCodeName() + " (" + code.get(1).getTransaction().getAuctionValue() + ") đồng, "
				+ code.get(2).getCodeName() + " (" + code.get(1).getTransaction().getAuctionValue() + ") đồng, "
				+ code.get(3).getCodeName() + " (" + code.get(1).getTransaction().getAuctionValue() + ") đồng, "
				+ code.get(4).getCodeName() + " (" + code.get(1).getTransaction().getAuctionValue() + ") đồng.";
		return s;
	}

}
