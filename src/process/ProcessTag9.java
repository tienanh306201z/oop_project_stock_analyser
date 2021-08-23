package process;

import getinformation.StockData;
import getinformation.StockCode;
import tag.Tag9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ProcessTag9 extends ProcessTag {
	public ProcessTag9() {
		sentences = Process();
	}

	@Override
	protected ArrayList<String> Process() {
		ArrayList<StockCode> code = new ArrayList<StockCode>();
		ArrayList<StockCode> temp = new ArrayList<StockCode>();

		for (StockCode sc : StockData.stockCodeHashMap.values()) {
			if (sc.getPrice().isRisingCode())
				code.add(sc);
		}

		Collections.sort(code, new Comparator<StockCode>() {
			@Override
			public int compare(StockCode n1, StockCode n2) {
				if (n1.getPrice().getChangeValue() < n2.getPrice().getChangeValue()) {
					return 1;
				} else if (n1.getPrice().getChangeValue() > n2.getPrice().getChangeValue()) {
					return -1;
				} else {
					return 0;
				}
			}
		});
		for (int i = 0; i < 10; i++) {
			temp.add(code.get(i));
		}
		return (new Tag9(temp)).sentences;
	}
}