package tag;

import java.util.ArrayList;
import getinformation.ForeignTransaction;

public class Tag8 extends Tag {
	private final String tagName = "Top giá trị nước ngoài bán";
	private ArrayList<ForeignTransaction> topFS;
	private float fSumSellValue;
	
	public Tag8(ArrayList<ForeignTransaction> topFS, float fSumSellValue) {
		this.topFS = topFS;
		this.fSumSellValue = fSumSellValue;
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
		String str = "Nhiều mã như "+ topFS.get(0).getCodeName() + ", " + topFS.get(1).getCodeName() + ", "
	            + topFS.get(2).getCodeName() +" và " + topFS.get(3).getCodeName()
				+ " lần lượt bị nhà đầu tư nước ngoài bán ròng " + topFS.get(0).getfSellValue() + ", "
	            + topFS.get(1).getfSellValue() + ", " + topFS.get(2).getfSellValue()
	            + " và " + topFS.get(3).getfSellValue() + " đồng.";
		return str;
	}

	private final String Sentence2() {
		String str = "Họ bán ra lượng cổ phiếu trị giá " + fSumSellValue
		        + " đồng, tập trung chủ yếu các cổ phiếu có tính thanh khoản cao là "
				+ topFS.get(0).getCodeName() +" và " + topFS.get(1).getCodeName();
		return str;
	}
	
	private final String Sentence3() {
		String str = "Đáng chú ý,các nhà đầu tư nước ngoài tham gia mua những mã " 
				+ topFS.get(0).getCodeName() + ", " + topFS.get(1).getCodeName()
				+ " với giá trị giao dịch " + topFS.get(0).getfSellValue() +" đồng.";
		return str;
	}
	
	private final String Sentence4() {
		String str = "Đáng chú ý,các nhà đầu tư nước ngoài tham gia mua những mã " 
				+ topFS.get(0).getCodeName() + ", " + topFS.get(1).getCodeName()
				+ " với giá trị giao dịch " + topFS.get(0).getfSellValue() +" đồng.";
		return str; 
	}
}