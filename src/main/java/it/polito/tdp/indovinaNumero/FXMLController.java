package it.polito.tdp.indovinaNumero;

import it.polito.tdp.indovinaNumero.model.*;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
    private TextField txtRimasti;

    @FXML
    private HBox layoutTentativo;

    @FXML
    private TextField txtTentativi;

    @FXML
    private Button btnProva;

    @FXML
    private TextArea txtRisultato;

    @FXML
    void doNuova(ActionEvent event) {
    	// inizializzazione nuova partita
    	partita=new Partita();
    	
    	// gestione dell'interfaccia
    	layoutTentativo.setDisable(false);
    	txtRisultato.clear();
    	txtRimasti.setText(Integer.toString(partita.getTentativiRimasti()));
    }

    @FXML
    void doTentativo(ActionEvent event) {
    	//leggere input utente
    	String ts=txtTentativi.getText();
    	txtTentativi.clear();
    	txtRisultato.appendText(partita.doTentativo(ts));
    	txtRimasti.setText(Integer.toString(partita.getTentativiRimasti()));
    	
    	if(!partita.isInGioco()) {
    		layoutTentativo.setDisable(true);
    	}
    		
    }

    @FXML
    void initialize() {
        assert btnNuova != null : "fx:id=\"btnNuova\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRimasti != null : "fx:id=\"txtRimasti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert layoutTentativo != null : "fx:id=\"layoutTentativo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTentativi != null : "fx:id=\"txtTentativi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnProva != null : "fx:id=\"btnProva\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
