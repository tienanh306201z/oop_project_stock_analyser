package process;

import getinformation.ForeignTransaction;
import getinformation.StockData;
import tag.Tag5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ProcessTag5 extends ProcessTag {
	public ProcessTag5() {
		sentences = Process();
	}

	@Override
	protected ArrayList<String> Process() {
		ArrayList<ForeignTransaction> code = new ArrayList<ForeignTransaction>();
		ArrayList<ForeignTransaction> temp = new ArrayList<ForeignTransaction>();
		for (ForeignTransaction it : StockData.foreignHashMap.values()) {
			code.add(it);
		}

		Collections.sort(code, new Comparator<ForeignTransaction>() {
			@Override
			public int compare(ForeignTransaction n1, ForeignTransaction n2) {
				if (n1.getfBuyValue() < n2.getfBuyValue()) {
					return 1;
				} else if (n1.getfBuyValue() > n2.getfBuyValue()) {
					return -1;
				} else {
					return 0;
				}
			}
		});
		for (int i = 0; i < 5; i++) {
			temp.add(code.get(i));
		}
		return (new Tag5(temp)).sentences;
	}
}