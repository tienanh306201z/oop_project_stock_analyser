package process;

import getinformation.StockData;
import getinformation.StockCode;
import tag.Tag11;

import java.util.ArrayList;

public class ProcessTag11 extends ProcessTag {
	public ProcessTag11() {
		sentences = Process();
	}

	@Override
	protected ArrayList<String> Process() {
		ArrayList<StockCode> code = new ArrayList<StockCode>();

		for (StockCode it : StockData.stockCodeHashMap.values()) {
			if (it.getPrice().isFallingCode()) {
				code.add(it);
			}
		}
		return (new Tag11(code)).sentences;
	}
}
