package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
	private List<Word> dictionary;
	
	public AlienDictionary() {
		this.dictionary = new ArrayList<Word>();
	}

	public void addWord(String alienWord, String translation) {
		for(int i=0; i<dictionary.size(); i++) {
			if(dictionary.get(i).getAlienWord().equals(alienWord)) {
				dictionary.get(i).setTranslation(translation);
				return;
			}
		}
		
		dictionary.add(new Word(alienWord, translation));
	}
	
	public String translateWord(String alienWord) {
		for(int i=0; i<dictionary.size(); i++) {
			if(dictionary.get(i).getAlienWord().equals(alienWord)) 
				return dictionary.get(i).getTranslation();
		}
		
		return null;
	}

}
