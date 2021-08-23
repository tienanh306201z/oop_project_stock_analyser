package process;

import java.util.ArrayList;
import java.util.Random;

public class ProcessTagGroup12 extends ProcessTagGroup {
	public ArrayList<String> sentences1;
	
	public ProcessTagGroup12() {
		sentences1 = new ArrayList<String>();
		tagName = "Các dịch vụ chuyên biệt và thương mại";
		sentences1 = Process();
	}
	@Override
	public String RandomSentences() {
		Random random = new Random();
		return sentences1.get(random.nextInt(sentences1.size() - 1) + 1);
	}
}
