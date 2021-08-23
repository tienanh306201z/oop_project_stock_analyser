package process;

import getinformation.StockData;
import getinformation.ForeignTransaction;

import tag.Tag7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ProcessTag7 extends ProcessTag {
	public ProcessTag7() {
		sentences = Process();
	}

	@Override
	protected ArrayList<String> Process() {
		ArrayList<ForeignTransaction> code = new ArrayList<>();
		ArrayList<ForeignTransaction> temp = new ArrayList<>();
		code.addAll(StockData.foreignHashMap.values());

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

		float sum = 0;
		for (int i = 0; i < 24; i++) {
			sum += code.get(i).getfBuyValue();
		}
		code.clear();
		return (new Tag7(temp, sum)).sentences;

	}

}
