package process;

import java.util.ArrayList;
import java.util.Random;

public abstract class ProcessTag {
	protected abstract ArrayList<String> Process();

	public ArrayList<String> sentences;

	public String RandomSentences() {
		Random random = new Random();
		return sentences.get(random.nextInt(sentences.size() - 1) + 1);
	}
}
