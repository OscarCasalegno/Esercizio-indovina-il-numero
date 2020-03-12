package it.polito.tdp.indovinaNumero.model;

import java.util.ArrayList;

public class Partita {
	
	private int numeroMassimo;
	private int tentativiMassimi;
	private int min;
	private int max;
	private int segreto;
	private ArrayList<Integer> tentativi;
	private boolean inGioco= false;
	
	
	public Partita(String difficolta) {
		//gestione dell'inizio di una nuova partita - Logica del gioco
		if(difficolta.contentEquals("Facile")) {
			numeroMassimo=10;
			tentativiMassimi=4;
		}else if(difficolta.contentEquals("Normale")) {
			numeroMassimo=50;
			tentativiMassimi=6;
		}else if(difficolta.contentEquals("Difficile")) {
			numeroMassimo=100;
			tentativiMassimi=7;
		}
		min=0;
		max=numeroMassimo+1;
    	this.segreto=(int) (Math.random()*numeroMassimo) +1;
    	this.inGioco=true;
    	tentativi=new ArrayList<Integer>();
	}

	public String doTentativo(String ts) {
		int tentativo;
    	try {
    		tentativo=Integer.parseInt(ts);
    	}catch(NumberFormatException e){
    		return "DEVI INSERIRE UN NUMERO\n";
    		    	}
    	
    	if(tentativo<1 || tentativo>numeroMassimo) {
    		return "Inserisci un numero nell'intervallo [1;"+numeroMassimo+"]\n";
    	}
    	
    	if(tentativi.contains(tentativo)) {
    		return "Numero già inserito\n";
    	}
    	
    	tentativi.add(tentativo);
    	if(tentativo==this.segreto) {
    		this.inGioco=false;
    		return "HAI VINTO!!! Hai utilizzato "+this.tentativi.size()+" tentativi";
    	}
    	
    	if(tentativi.size()==tentativiMassimi) {
    		//ho esaurito i tentativi --> ho perso
    		this.inGioco=false;
    		return "HAI PERSO!!! il numero segreto era "+this.segreto;
    	}
    	
    	if(tentativo<this.segreto) {
    		if(tentativo>min) {
    			min=tentativo;
    		}
    		return "Tentativo troppo basso\n";
    	}else {
    		if(tentativo<max) {
    			max=tentativo;
    		}
    		return "Tentativo troppo alto\n";
    	}
	}
	
	
	public Double getProgresso() {
		Double progresso;
		progresso=(double)tentativi.size()/tentativiMassimi;
		return progresso;
	}
	
	public String getRange() {
		return "["+(min+1)+";"+(max-1)+"]";
	}

	public boolean isInGioco() {
		return inGioco;
	}


}
