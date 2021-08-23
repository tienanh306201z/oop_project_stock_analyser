package process;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import getinformation.StockCode;
import getinformation.StockData;
import tag.TagI2;

public class ProcessTagI2 extends ProcessTag {

	public ProcessTagI2() {
		sentences = Process();
	}

	@Override
	protected ArrayList<String> Process() {

		StockCode maxActioneValue = null;
		float b = 0;

		ArrayList<StockCode> top3AutioneValue = new ArrayList<StockCode>();

		ArrayList<StockCode> code = new ArrayList<StockCode>();

		code.addAll(StockData.stockCodeHashMap.values());

		for (StockCode abc : code) {
			if (abc.getTransaction().getAuctionValue() > b) {
				b = abc.getTransaction().getAuctionValue();
				maxActioneValue = abc;
			}
		}

		Collections.sort(code, new Comparator<StockCode>() {
			@Override
			public int compare(StockCode n1, StockCode n2) {
				if (n1.getTransaction().getSumOfVolume() == n2.getTransaction().getSumOfVolume()) {
					return 0;
				} else {
					if (n1.getTransaction().getSumOfVolume() > n2.getTransaction().getSumOfVolume()) {
						return -1;
					} else
						return 1;
				}
			}
		});

		for (int i = 0; i < 3; i++) {
			top3AutioneValue.add(code.get(i));
		}

		return (new TagI2(maxActioneValue, top3AutioneValue)).sentences;
	}

}
