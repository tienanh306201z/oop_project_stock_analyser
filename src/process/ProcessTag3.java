package process;

import getinformation.StockData;
import getinformation.StockCode;
import tag.Tag3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ProcessTag3 extends ProcessTag {
	public ProcessTag3() {
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
				if (n1.getTransaction().getAuctionVolume() < n2.getTransaction().getAuctionVolume()) {
					return 1;
				} else if (n1.getTransaction().getAuctionVolume() > n2.getTransaction().getAuctionVolume()) {
					return -1;
				} else {
					return 0;
				}
			}
		});
		for (int i = 0; i < 5; i++) {
			temp.add(code.get(i));
		}
		return (new Tag3(temp)).sentences;
	}
}
