package process;

import getinformation.StockData;
import getinformation.StockCode;
import tag.Tag10;

import java.util.ArrayList;

public class ProcessTag10 extends ProcessTag {
	public ProcessTag10() {
		sentences = Process();
	}

	@Override
	protected ArrayList<String> Process() {
		ArrayList<StockCode> code = new ArrayList<StockCode>();

		for (StockCode it : StockData.stockCodeHashMap.values()) {
			if (it.getPrice().isUnchangedReferenceCode()) {
				code.add(it);
			}
		}
		return (new Tag10(code)).sentences;
	}
}
