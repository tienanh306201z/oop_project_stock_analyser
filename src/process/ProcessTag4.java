package process;

import getinformation.StockData;
import getinformation.StockCode;
import tag.Tag4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ProcessTag4 extends ProcessTag {
	public ProcessTag4() {
		sentences = Process();
	}

	@Override
	protected ArrayList<String> Process() {
		ArrayList<StockCode> code = new ArrayList<StockCode>();
		ArrayList<StockCode> temp = new ArrayList<StockCode>();
		for (StockCode it : StockData.stockCodeHashMap.values()) {
			code.add(it);
		}

		Collections.sort(code, new Comparator<StockCode>() {
			@Override
			public int compare(StockCode n1, StockCode n2) {
				if (n1.getTransaction().getAuctionValue() < n2.getTransaction().getAuctionValue()) {
					return 1;
				} else if (n1.getTransaction().getAuctionValue() > n2.getTransaction().getAuctionValue()) {
					return -1;
				} else {
					return 0;
				}
			}
		});
		for (int i = 0; i < 5; i++) {
			temp.add(code.get(i));
		}
		return (new Tag4(temp)).sentences;
	}
}
