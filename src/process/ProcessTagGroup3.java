package process;

import java.util.ArrayList;
import java.util.Random;

public class ProcessTagGroup3 extends ProcessTagGroup {
	public ArrayList<String> sentences1;
	
	public ProcessTagGroup3() {
		sentences1 = new ArrayList<String>();
		tagName = "Hàng hóa chủ chốt";
		sentences1 = Process();
	}
	@Override
	public String RandomSentences() {
		Random random = new Random();
		return sentences1.get(random.nextInt(sentences1.size() - 1) + 1);
	}
}
