package tag;

public class TagI1 extends Tag {
	private static final String tagName = "Tổng quan tăng giảm";

	private int numberRisingCode = 0;
	private int numberFallingCode = 0;
	private int numberUnchangedReFerenceode = 0;
	private int numberReachCeilingCode = 0;
	private int numberReachFloorCode = 0;

	public TagI1(int numberRisingCode, int numberFallingCode, int numberUnchangedReFerenceode,
			int numberReachCeilingCode, int numberReachFloorCode) {
		this.numberRisingCode = numberRisingCode;
		this.numberFallingCode = numberFallingCode;
		this.numberUnchangedReFerenceode = numberUnchangedReFerenceode;
		this.numberReachCeilingCode = numberReachCeilingCode;
		this.numberReachFloorCode = numberReachFloorCode;
		AddSentences();
	}

	@Override
	void AddSentences() {
		sentences.add(tagName);
		sentences.add(Sentence1());
		sentences.add(Sentence2());
	}

	private final String Sentence1() {
		String sentence = "Toàn phiên có " + numberRisingCode + " mã tăng giá, " + numberUnchangedReFerenceode
				+ " mã đứng giá và " + numberFallingCode + " mã giảm giá, " + "trong đó có " + numberReachCeilingCode
				+ " mã tăng trần và " + numberReachFloorCode + " mã giảm sàn.";
		return sentence;
	}

	private final String Sentence2() {
		String sentence;
		int sum = numberFallingCode + numberRisingCode + numberUnchangedReFerenceode;
		if (numberRisingCode > sum / 2) {
			sentence = "Số mã tăng khá lớn chiếm " + (float) numberRisingCode / sum * 100 + "% số mã, gấp "
					+ (float) numberRisingCode / numberFallingCode + " lần số mã giảm và gấp "
					+ (float) numberRisingCode / numberUnchangedReFerenceode + " lần số mã đứng giá.";
		} else {
			if (numberFallingCode > sum / 2) {
				sentence = "Số mã giảm khá lớn chiếm " + (float) numberFallingCode / sum * 100 + "% số mã, gấp "
						+ (float) numberFallingCode / numberRisingCode + " lần số mã tăng và gấp "
						+ (float) numberFallingCode / numberUnchangedReFerenceode + " lần số mã đứng giá.";
			} else {
				if (numberUnchangedReFerenceode > sum / 2) {
					sentence = "Số mã đứng giá khá lớn chiếm " + (float) numberUnchangedReFerenceode / sum * 100
							+ "% số mã, gấp " + (float) numberUnchangedReFerenceode / numberRisingCode
							+ " lần số mã tăng và gấp " + (float) numberUnchangedReFerenceode / numberFallingCode
							+ " lần số mã giảm.";
				} else {
					sentence = "Sự chênh lệch giữa số lượng mẵ tăng(" + numberRisingCode + " mã), mã giảm("
							+ numberFallingCode + " mã) và mã đứng giá(" + numberUnchangedReFerenceode
							+ " mã) là không nhiều";
				}
			}
		}
		return sentence;
	}
}
