package process;

import java.util.ArrayList;

import getinformation.StockCode;
import getinformation.StockData;
import tag.TagI1;

public class ProcessTagI1 extends ProcessTag {
	public ProcessTagI1() {
		sentences = Process();
	}

	@Override
	protected ArrayList<String> Process() {
		int numberRisingCode = 0;
		int numberFallingCode = 0;
		int numberUnchangedReFerenceode = 0;
		int numberReachCeilingCode = 0;
		int numberReachFloorCode = 0;

		for (StockCode abc : StockData.stockCodeHashMap.values()) {
			if (abc.getPrice().isRisingCode())
				numberRisingCode++;
			else {
				if (abc.getPrice().isUnchangedReferenceCode())
					numberUnchangedReFerenceode++;
				else
					numberFallingCode++;
			}
			if (abc.getPrice().isReachCeilingCode())
				numberReachCeilingCode++;
			if (abc.getPrice().isReachFloorCode())
				numberReachFloorCode++;
		}
		return (new TagI1(numberRisingCode, numberFallingCode, numberUnchangedReFerenceode, numberReachCeilingCode,
				numberReachFloorCode)).sentences;
	}
}
