package process;

import getinformation.StockData;
import getinformation.ForeignTransaction;
import tag.Tag8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ProcessTag8 extends ProcessTag {
	
	
	
	public ProcessTag8() {
		sentences = Process();
	}
	@Override
	protected ArrayList<String> Process() {
		ArrayList<ForeignTransaction> code = new ArrayList<ForeignTransaction>();
		ArrayList<ForeignTransaction> topFS = new ArrayList<ForeignTransaction>();
		float fSumSellValue = 0;
		for (ForeignTransaction it : StockData.foreignHashMap.values()) {
			code.add(it);
			fSumSellValue += it.getfSellValue();
		}
	
		Collections.sort(code, new Comparator<ForeignTransaction>() {
			@Override
			public int compare(ForeignTransaction n1, ForeignTransaction n2){
				if(n1.getfSellValue() < n2.getfSellValue()) {
					return 1;
				}
				else if(n1.getfSellValue() > n2.getfSellValue()) {
					return -1;
				}
				else {
					return 0;
				}
			}
		});
		

		
		for (int i = 0; i < 10; i++) {
			topFS.add(code.get(i));
		}
		return (new Tag8(topFS,fSumSellValue)).sentences;
	}

}