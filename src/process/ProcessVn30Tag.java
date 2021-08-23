package process;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import getinformation.StockCode;
import getinformation.StockData;

import tag.Vn30;

public class ProcessVn30Tag extends ProcessTag {

	public ProcessVn30Tag() {
		sentences = Process();
	}

	@Override
	protected ArrayList<String> Process() {

		StockCode top1RisingCode = null;
		StockCode top2RisingCode = null;

		StockCode top1VolumeTransacTioneCode = null;
		float top1Volume = -1000000;

		StockCode top1FallingCode = null;
		StockCode top2FallingCode = null;
		StockCode top3FallingCode = null;
		StockCode top4FallingCode = null;
		StockCode top5FallingCode = null;

		StockCode top3RisingCode = null;
		StockCode top4RisingCode = null;
		StockCode top5RisingCode = null;

		StockCode top1ValueTransactionCode = null;
		float top1Value = -1000000;

		int numberRisingCode = 0;

		int numberFallingCode = 0;

		ArrayList<StockCode> code = new ArrayList<StockCode>();

		for (StockCode xyz : StockData.stockCodeHashMap.values()) {
			for (int i = 0; i < StockData.vn30.size(); i++) {
				if (xyz.getCodeName().equals(StockData.vn30.get(i))) {
					code.add(xyz);
					break;
				}
			}
		}

		Collections.sort(code, new Comparator<StockCode>() {
			@Override
			public int compare(StockCode n1, StockCode n2) {
				if (n1.getPrice().getChangeValue() < n2.getPrice().getChangeValue()) {
					return -1;
				} else if (n1.getPrice().getChangeValue() > n2.getPrice().getChangeValue()) {
					return 1;
				} else {
					return 0;
				}
			}
		});

		top1FallingCode = code.get(0);
		top2FallingCode = code.get(1);
		top3FallingCode = code.get(2);
		top4FallingCode = code.get(3);
		top5FallingCode = code.get(4);

		top1RisingCode = code.get(code.size() - 1);
		top2RisingCode = code.get(code.size() - 2);
		top3RisingCode = code.get(code.size() - 3);
		top4RisingCode = code.get(code.size() - 4);
		top5RisingCode = code.get(code.size() - 5);

		for (StockCode xyz : code) {
			if (xyz.getTransaction().getAuctionValue() > top1Value) {
				top1Value = xyz.getTransaction().getAuctionValue();
				top1ValueTransactionCode = xyz;
			}
			if (xyz.getTransaction().getAuctionVolume() > top1Volume) {
				top1Volume = xyz.getTransaction().getAuctionVolume();
				top1VolumeTransacTioneCode = xyz;
			}
			if (xyz.getPrice().getChangeValue() > 0) {
				numberRisingCode++;
			} else {
				if (xyz.getPrice().getChangeValue() < 0) {
					numberFallingCode++;
				}
			}
		}

		return (new Vn30(top1RisingCode, top2RisingCode, top1VolumeTransacTioneCode, top1FallingCode, top2FallingCode,
				top3FallingCode, top4FallingCode, top5FallingCode, top3RisingCode, top4RisingCode, top5RisingCode,
				top1ValueTransactionCode, numberRisingCode, numberFallingCode)).sentences;
	}
}
