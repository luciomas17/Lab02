package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	private AlienDictionary model;
	
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
        
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	
    }
  
    
    @FXML
    void doTranslate(ActionEvent event) {
    	String[] input = this.txtWord.getText().trim().split(" ");
    	
    	boolean syntaxErrors = false;
    	
    	for(int i=0; i<input.length; i++) {
    		if(i == 0) {
    			if(input[i].matches("[a-zA-Z?]*")) {
            		input[i] = input[i].toLowerCase();
            	} else {
        			txtResult.appendText("Errore: la parola aliena deve contenere solo caratteri alfabetici e al massimo un '?'.\n");
        			syntaxErrors = true;
        		}
    		} else {
    			if(input[i].matches("[a-zA-Z]*")) {
            		input[i] = input[i].toLowerCase();
            	} else {
        			txtResult.appendText("Errore: la traduzione deve contenere solo caratteri alfabetici.\n");
        			syntaxErrors = true;
        		}
    		}
    		
    	}
    	
    	int countWildcards = 0;
    	
		for(int i=0; i<input[0].length(); i++) {
    		if(input[0].charAt(i) == '?') {
    			countWildcards++;
    		}
    	}
    	
    	if(syntaxErrors == false) {
    		if(input.length < 1 || input.length > 2) {
        		txtResult.appendText("Errore: formato di inserimento non corretto.\n");
        	}
        	
        	if(input.length == 2) {
        		if(countWildcards == 0) {
        			model.addWord(input[0], input[1]);
            		txtResult.appendText("Aggiunta traduzione per la parola " + input[0] + ".\n");
        		}
        		
        		if(countWildcards == 1) {
        			txtResult.appendText("Errore: il carattere '?' può essere inserito solo in caso di ricerca.\n");
        		}
        	}
        	
        	if(input.length == 1) {
            	if(countWildcards == 0) {
            		String translation = model.translateWord(input[0]);
            		if(translation == null) {
            			txtResult.appendText("Errore: parola " + input[0] + " non trovata.\n");
            		} else {
            			txtResult.appendText("Le possibili traduzioni della parola " + input[0] + " sono: " + translation + ".\n");
            		}
            	}
            	
            	if(countWildcards == 1) {
            		List<String> wordsFound = new ArrayList<String>();
            		char c = 'a';
            		
            		while(c <= 'z') {
            			String tentativo = input[0].replace('?', c);
            			String translation = model.translateWord(tentativo);
                		if(translation != null) 
                			wordsFound.add(tentativo);
                		c++;
            		}
            		
            		txtResult.appendText(wordsFound.size() + " parola/e trovate");
            		if(wordsFound.size() == 0)
            			txtResult.appendText(".\n");
            		else {
            			txtResult.appendText(":\n");
            			
            			for(int i=0; i<wordsFound.size(); i++) {
                			String translation = model.translateWord(wordsFound.get(i));
                			txtResult.appendText("Le possibili traduzioni della parola " + wordsFound.get(i) + " sono: " + translation + ".\n");
                		}
            		}
            	}
        	}
    	}
    	
    	txtWord.clear();
    }
    
    
    @FXML
    void doReset(ActionEvent event) {
    	txtWord.clear();
    	txtResult.clear();
    }
    
    public void setModel(AlienDictionary model) {
    	this.model = model;
    }
}
