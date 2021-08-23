package tag;

import getinformation.StockCode;

public class Vn30 extends Tag {
	private final String tagName = "Cổ phiếu VN30";

	private StockCode top1RisingCode = null;
	private StockCode top2RisingCode = null;

	private StockCode top1VolumeTransacTionCode = null;

	private StockCode top1FallingCode = null;
	private StockCode top2FallingCode = null;
	private StockCode top3FallingCode = null;
	private StockCode top4FallingCode = null;
	private StockCode top5FallingCode = null;

	private StockCode top3RisingCode = null;
	private StockCode top4RisingCode = null;
	private StockCode top5RisingCode = null;

	private StockCode top1ValueTransactionCode = null;

	private int numberRisingCode = 0;

	private int numberFallingCode = 0;

	public Vn30(StockCode top1RisingCode, StockCode top2RisingCode, StockCode top1VolumeTransacTionCode,
			StockCode top1FallingCode, StockCode top2FallingCode, StockCode top3FallingCode, StockCode top4FallingCode,
			StockCode top5FallingCode, StockCode top3RisingCode, StockCode top4RisingCode, StockCode top5RisingCode,
			StockCode top1ValueTransactionCode, int numberRisingCode, int numberFallingCode) {

		this.top1RisingCode = top1RisingCode;
		this.top2RisingCode = top2RisingCode;
		this.top1VolumeTransacTionCode = top1VolumeTransacTionCode;
		this.top1FallingCode = top1FallingCode;
		this.top2FallingCode = top2FallingCode;
		this.top3FallingCode = top3FallingCode;
		this.top4FallingCode = top4FallingCode;
		this.top5FallingCode = top5FallingCode;
		this.top3RisingCode = top3RisingCode;
		this.top4RisingCode = top4RisingCode;
		this.top5RisingCode = top5RisingCode;
		this.top1ValueTransactionCode = top1ValueTransactionCode;
		this.numberRisingCode = numberRisingCode;
		this.numberFallingCode = numberFallingCode;
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
		sentences.add(Sentence6());
		sentences.add(Sentence7());
		sentences.add(Sentence8());
	}

	private final String Sentence1() {
		String s = top1RisingCode.getCodeName() + " và " + top2RisingCode.getCodeName()
				+ " là 2 mã lên giá mạnh nhất rổ VN30 với mức tăng " + top2RisingCode.getPrice().getChangeValue()
				+ " đồng đến " + top1RisingCode.getPrice().getChangeValue() + "đồng.";
		return s;
	}

	private final String Sentence2() {
		String s = "Rổ VN30, cổ phiếu " + top1VolumeTransacTionCode.getCodeName()
				+ " được giao dịch nhiều nhất với hơn " + top1VolumeTransacTionCode.getTransaction().getSumOfVolume()
				+ " triệu đơn vị.";
		return s;
	}

	private final String Sentence3() {
		String s = "Rổ VN30 ghi nhận " + top5FallingCode.getCodeName() + ", " + top4FallingCode.getCodeName() + ", "
				+ top3FallingCode.getCodeName() + ", " + top2FallingCode.getCodeName() + ", "
				+ top1FallingCode.getCodeName() + " lần lượt rớt " + top5FallingCode.getPrice().getChangeValue() + "-"
				+ top1FallingCode.getPrice().getChangeValue() * -1 + " đồng.";
		return s;
	}

	private final String Sentence4() {
		String s = "Rổ VN30 ghi nhận: " + top5RisingCode.getCodeName() + ", " + top4RisingCode.getCodeName() + ", "
				+ top3RisingCode.getCodeName() + ", " + top2RisingCode.getCodeName() + ", "
				+ top1RisingCode.getCodeName() + " tăng " + top5RisingCode.getPrice().getChangeValue() + "-"
				+ top1RisingCode.getPrice().getChangeValue() + " đồng.";
		return s;
	}

	private final String Sentence5() {
		String s = "Bên cạnh đó, " + top1ValueTransactionCode.getCodeName()
				+ " đứng nhất rổ VN30 sáng nay về khối lượng giao dịch khi khớp lệnh thành công trên "
				+ top1ValueTransactionCode.getTransaction().getAuctionValue() + " đồng";
		return s;
	}

	private final String Sentence6() {
		String s = "Hơn " + (float) numberFallingCode / 30 * 100
				+ "% rổ VN30 đi xuống, trong đó những mã giảm sâu gồm: " + top3FallingCode.getCodeName() + ", "
				+ top2FallingCode.getCodeName() + " và " + top1FallingCode.getCodeName() + " lần lượt giảm "
				+ top3FallingCode.getPrice().getChangeValue() * -1 + " - "
				+ top1FallingCode.getPrice().getChangeValue() * -1 + " đồng";
		return s;
	}

	private final String Sentence7() {
		String s = "Hơn " + (float) numberRisingCode / 30 * 100
				+ "% rổ VN30 đi lên, trong đó những mã tăng mạnh nhất gồm: " + top3RisingCode.getCodeName() + ", "
				+ top2RisingCode.getCodeName() + " và " + top1RisingCode.getCodeName() + " lần lượt tăng "
				+ top3RisingCode.getPrice().getChangeValue() + " - " + top1RisingCode.getPrice().getChangeValue()
				+ " đồng.";
		return s;
	}

	private final String Sentence8() {
		String s = "Rổ VN30 có đến " + numberFallingCode + " mã đỏ điểm với " + top1FallingCode.getCodeName() + " rớt "
				+ top1FallingCode.getPrice().getChangeValue() + " đồng một cổ phiếu, " + top4FallingCode.getCodeName()
				+ ", " + top3FallingCode.getCodeName() + " giảm " + top4FallingCode.getPrice().getChangeValue() * -1
				+ "-" + top3FallingCode.getPrice().getChangeValue() * -1 + " đồng";
		return s;
	}

}