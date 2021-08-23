package process;

import getinformation.StockData;
import getinformation.VNIndex;
import tag.TagII2;

import java.util.ArrayList;
import java.time.LocalDate;

public class ProcessTagII2 extends ProcessTag {

	private LocalDate date;

	public ProcessTagII2(LocalDate date) {
		this.date = date;
		sentences = Process();
	}

	@Override
	protected ArrayList<String> Process() {
		VNIndex vnIndex = StockData.vnIndexHashMap.get(date);
		return (new TagII2(vnIndex)).sentences;
	}
}
