package tag;

import getinformation.VNIndex;

public class TagII1 extends Tag {
	private static final String tagName = "Chỉ số VN-Index chốt phiên";
	private String s;
	private VNIndex vnIndex;

	public TagII1(VNIndex vnIndex) {
		this.vnIndex = vnIndex;
		AddSentences();
	}

	@Override
	void AddSentences() {
		sentences.add(tagName);
		sentences.add(Sentence1());
	}

	private final String Sentence1() {
		if (vnIndex.isRise()) {
			s = "Kết thúc phiên giao dịch, VN-Index tăng " + vnIndex.getChangeIndex() + " điểm, đóng của đạt "
					+ vnIndex.getCloseIndex() + " diểm.";
		} else if (vnIndex.isFall()) {
			s = "Kết thúc phiên giao dịch ngày, VN-Index giảm " + vnIndex.getChangeIndex() + " điểm, đóng của với "
					+ vnIndex.getCloseIndex() + " diểm.";
		} else {
			s = "Kết thúc phiên giao dịch, chỉ số VN-Index không thay đổi, ở mức " + vnIndex.getCloseIndex() + " điểm.";
		}
		return s;
	}
}
