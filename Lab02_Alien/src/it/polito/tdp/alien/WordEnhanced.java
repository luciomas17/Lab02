package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class WordEnhanced {
	private String alienWord;
	private List<String> translation = new ArrayList<String>();
		
	public WordEnhanced(String alienWord, String translation) {
		this.alienWord = alienWord;
		this.translation.add(translation);
	}

	@Override
	public boolean equals(Object obj) {
		String w = (String)obj;
		if(this.alienWord.compareTo(w) == 0)
			return true;
		
		return false;
	}

	public List<String> getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation.add(translation);
	}

	public String getAlienWord() {
		return alienWord;
	}

	
}
