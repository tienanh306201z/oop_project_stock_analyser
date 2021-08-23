package tag;

import java.util.ArrayList;

import getinformation.*;

public class Tag9 extends Tag {
	private static final String tagName = "Các cổ phiếu tăng giá";
	private ArrayList<StockCode> code;

	public Tag9(ArrayList<StockCode> code) {
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
		sentences.add(Sentence5());
	}
	
	private String getComName(String comCode) {
		if (StockData.companyNameHashMap.containsKey(comCode)) {
			return StockData.companyNameHashMap.get(comCode);
		} else return "Sàn HOSE";
	}	

	private final String Sentence1() {
		String s = "Nổi bật nhất nhóm này là" + code.get(0).getCodeName() + ", " + code.get(1).getCodeName() + ", "
				+ code.get(2).getCodeName() + ", " + code.get(3).getCodeName() + " lần lượt tăng "
				+ code.get(3).getPrice().getChangeValue() + "-" + code.get(0).getPrice().getChangeValue() + " đồng.";
		return s;
	}

	private final String Sentence2() {
		String s = "Trong nhóm tăng giá, " + code.get(0).getCodeName() + " lên mạnh nhất với "
				+ code.get(0).getPrice().getChangeValue() + " đồng, " + code.get(1).getCodeName() + " "
				+ code.get(1).getPrice().getChangeValue() + " đồng và " + code.get(2).getCodeName() + " "
				+ code.get(2).getPrice().getChangeValue() + " đồng.";
		return s;
	}

	private final String Sentence3() {
		String s = "Cổ phiếu " + code.get(0).getCodeName() + " của " + getComName(code.get(0).getCodeName()) + " tăng "
				+ code.get(0).getPrice().getChangeValue() + " đồng (" + code.get(0).getPrice().getChangePerValue()
				+ "%) lên " + code.get(0).getPrice().getClosePrice() + " đồng, còn " + code.get(1).getCodeName()
				+ " của " + getComName(code.get(1).getCodeName()) + " tăng " + code.get(1).getPrice().getChangeValue()
				+ " đồng (" + code.get(1).getPrice().getChangePerValue() + "%) lên "
				+ code.get(1).getPrice().getClosePrice() + " đồng.";
		return s;
	}

	private final String Sentence4() {
		String s = "Một vài cổ phiếu có mức tăng đáng chú ý như " + code.get(0).getCodeName() + " tăng "
				+ code.get(0).getPrice().getChangePerValue() + "%, " + code.get(1).getCodeName() + " tăng "
				+ code.get(1).getPrice().getChangePerValue() + "%, " + code.get(2).getCodeName() + " tăng "
				+ code.get(2).getPrice().getChangePerValue() + "%.";

		return s;
	}

	private final String Sentence5() {
		String s = "Trong khi đó, " + code.get(5).getCodeName() + " cũng tăng "
				+ code.get(5).getPrice().getChangeValue() + " đồng, " + code.get(6).getCodeName() + " cộng thêm "
				+ code.get(6).getPrice().getChangeValue() + " đồng với lượng sang tay gần "
				+ code.get(6).getTransaction().getAuctionVolume() + " cổ phiếu.";
		return s;
	}
}
