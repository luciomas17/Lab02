package it.polito.tdp.alien;

public class Word {
	private String alienWord;
	private String translation;
	
	public Word(String alienWord, String translation) {
		this.alienWord = alienWord;
		this.translation = translation;
	}

	@Override
	public boolean equals(Object obj) {
		String w = (String)obj;
		if(this.alienWord.compareTo(w) == 0)
			return true;
		
		return false;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}

	public String getAlienWord() {
		return alienWord;
	}

	
}
