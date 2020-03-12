package it.polito.tdp.indovinaNumero;

import it.polito.tdp.indovinaNumero.model.*;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

public class FXMLController {
	
	private Partita partita;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnNuova;

    @FXML
    private ProgressBar barProgresso;

    @FXML
    private HBox layoutTentativo;

    @FXML
    private TextField txtTentativi;

    @FXML
    private Button btnProva;

    @FXML
    private TextArea txtRisultato;
    
    @FXML
    private RadioButton radFacile;

    @FXML
    private ToggleGroup difficoltà;

    @FXML
    private RadioButton radNormale;

    @FXML
    private RadioButton radDifficile;

    @FXML
    void doNuova(ActionEvent event) {
    	// inizializzazione nuova partita
    	if(radFacile.isSelected()) {
    		partita=new Partita("Facile");
    	}else if(radNormale.isSelected()) {
    		partita=new Partita("Normale");
    	}else {
    		partita=new Partita("Difficile");
    	}
    	
    	
    	// gestione dell'interfaccia
    	layoutTentativo.setDisable(false);
    	txtRisultato.clear();
    	barProgresso.setProgress(0);
    }

    @FXML
    void doTentativo(ActionEvent event) {
    	//leggere input utente
    	String ts=txtTentativi.getText();
    	txtTentativi.clear();
    	txtRisultato.appendText(partita.doTentativo(ts));
    	barProgresso.setProgress(partita.getProgresso());
    	
    	if(!partita.isInGioco()) {
    		layoutTentativo.setDisable(true);
    	}
    		
    }

    @FXML
    void initialize() {
        assert btnNuova != null : "fx:id=\"btnNuova\" was not injected: check your FXML file 'Scene.fxml'.";
        assert barProgresso != null : "fx:id=\"barProgresso\" was not injected: check your FXML file 'Scene.fxml'.";
        assert layoutTentativo != null : "fx:id=\"layoutTentativo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTentativi != null : "fx:id=\"txtTentativi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnProva != null : "fx:id=\"btnProva\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert radFacile != null : "fx:id=\"radFacile\" was not injected: check your FXML file 'Scene.fxml'.";
        assert difficoltà != null : "fx:id=\"Difficoltà\" was not injected: check your FXML file 'Scene.fxml'.";
        assert radNormale != null : "fx:id=\"radNormale\" was not injected: check your FXML file 'Scene.fxml'.";
        assert radDifficile != null : "fx:id=\"radDifficile\" was not injected: check your FXML file 'Scene.fxml'.";
    }
}
