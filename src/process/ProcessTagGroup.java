package process;

import getinformation.StockData;
import getinformation.StockCode;
import getinformation.CompanyGroup;
import tag.TagGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ProcessTagGroup extends ProcessTag {
	public String tagName;
	
	@Override
	protected ArrayList<String> Process() {
		ArrayList<StockCode> risingCode = new ArrayList<StockCode>();
		ArrayList<StockCode> fallingCode = new ArrayList<StockCode>();
		ArrayList<StockCode> volumeCode = new ArrayList<StockCode>();
		CompanyGroup group = StockData.groupHashMap.get(tagName);
		for (String s :group.getList()) {
			if (StockData.stockCodeHashMap.containsKey(s)) {
				StockCode code = StockData.stockCodeHashMap.get(s);
				if (code.getPrice().isRisingCode()) risingCode.add(code);
				if (code.getPrice().isFallingCode()) fallingCode.add(code);
				volumeCode.add(code);
			}
		}
		
		if(volumeCode.isEmpty()) {
			return (new TagGroup(tagName, group, new ArrayList<StockCode>(), new ArrayList<StockCode>(), new ArrayList<StockCode>())).sentences;
		}
		else {
			if(risingCode.size() > 1) {
				Collections.sort(risingCode, new Comparator<StockCode>() {
					@Override
					public int compare(StockCode n1, StockCode n2){
						if(n1.getPrice().getChangeValue() < n2.getPrice().getChangeValue()) {
							return 1;
						}
						else if(n1.getPrice().getChangeValue() > n2.getPrice().getChangeValue()) {
							return -1;
						}
						else {
							return 0;
						}
					}
				});		
			}
			
			if(fallingCode.size() > 1) {
				Collections.sort(fallingCode, new Comparator<StockCode>() {
					@Override
					public int compare(StockCode n1, StockCode n2){
						if(n1.getPrice().getChangeValue() < n2.getPrice().getChangeValue()) {
							return 1;
						}
						else if(n1.getPrice().getChangeValue() > n2.getPrice().getChangeValue()) {
							return -1;
						}
						else {
							return 0;
						}
					}
				});	
			}
			
			if(volumeCode.size() > 1) {
				Collections.sort(volumeCode, new Comparator<StockCode>() {
					@Override
					public int compare(StockCode n1, StockCode n2){
						if(n1.getTransaction().getAuctionVolume() < n2.getTransaction().getAuctionVolume()) {
							return 1;
						}
						else if(n1.getTransaction().getAuctionVolume() > n2.getTransaction().getAuctionVolume()) {
							return -1;
						}
						else {
							return 0;
						}
					}
				});	
			}	
		}
		return (new TagGroup(tagName, group, risingCode, fallingCode, volumeCode)).sentences;
	}
}