package process;

import java.util.ArrayList;
import java.util.Random;

public class ProcessTagGroup1 extends ProcessTagGroup {
	public ArrayList<String> sentences1;
	
	//tạo 1 ArrayList ngay trong lớp này để sao chép kết quả từ tag
	// override phương thức random để lấy được câu sinh ra ngay từ trong ArraytLis thuộc lớp này
	
	public ProcessTagGroup1() {
		sentences1 = new ArrayList<String>();
		tagName = "Bất động sản";
		sentences1 = Process();
	}
	@Override
	public String RandomSentences() {
		Random random = new Random();
		return sentences1.get(random.nextInt(sentences1.size() - 1) + 1);
	}
}
