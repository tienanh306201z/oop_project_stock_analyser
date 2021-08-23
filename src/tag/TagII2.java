package tag;

import getinformation.VNIndex;

public class TagII2 extends Tag {
	private static final String tagName = "Top cổ phiếu ảnh hưởng tới giá trị VN-Index";
	private VNIndex vnIndex;

	public TagII2(VNIndex vnIndex) {
		this.vnIndex = vnIndex;
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

	private final String Sentence1() {
		String s = "Kết thúc phiên giao dịch, " + vnIndex.getVnIndexInfluence().get(19).getCode()
				+ " có mức tác động giảm mạnh nhất khi khiến VN-Index giảm "
				+ (-1) * vnIndex.getVnIndexInfluence().get(19).getInfluencedPoint() + " điểm, kế tiếp là "
				+ vnIndex.getVnIndexInfluence().get(18).getCode() + " làm giảm "
				+ (-1) * vnIndex.getVnIndexInfluence().get(19).getInfluencedPoint() + " điểm.";
		return s;
	}

	private final String Sentence2() {
		String s = "Trong 10 cổ phiếu có mức tác động tích cực nhất, " + vnIndex.getVnIndexInfluence().get(0).getCode()
				+ " có tác động mạnh nhất khi kéo VN-Index lên "
				+ vnIndex.getVnIndexInfluence().get(0).getInfluencedPoint() + " điểm.";
		return s;
	}

	private final String Sentence3() {
		String s = "Trong 10 cổ phiếu có mức tác động giảm điểm lớn nhất , đứng đầu là "
				+ vnIndex.getVnIndexInfluence().get(0).getCode() + " khi khiến VN-Index giảm "
				+ vnIndex.getVnIndexInfluence().get(0).getInfluencedPoint() + " điểm.";
		return s;
	}

	private final String Sentence4() {
		String s = "5 cổ phiếu có mức tác động tăng mạnh nhất đến chỉ số VN-Index hôm nay là "
				+ vnIndex.getVnIndexInfluence().get(0).getCode() + ", " + vnIndex.getVnIndexInfluence().get(1).getCode()
				+ ", " + vnIndex.getVnIndexInfluence().get(3).getCode() + ", "
				+ vnIndex.getVnIndexInfluence().get(4).getCode() + ", và "
				+ vnIndex.getVnIndexInfluence().get(5).getCode() + ".";
		return s;
	}

	private final String Sentence5() {
		String s = "5 cổ phiếu có mức tác động giảm mạnh nhất đến chỉ số VN-Index hôm nay là "
				+ vnIndex.getVnIndexInfluence().get(19).getCode() + ", "
				+ vnIndex.getVnIndexInfluence().get(18).getCode() + ", "
				+ vnIndex.getVnIndexInfluence().get(17).getCode() + ", "
				+ vnIndex.getVnIndexInfluence().get(16).getCode() + ", và "
				+ vnIndex.getVnIndexInfluence().get(15).getCode() + ".";
		return s;
	}
}
