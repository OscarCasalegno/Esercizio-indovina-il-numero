package it.polito.tdp.indovinaNumero.model;

public class Partita {
	
	private int numeroMassimo;
	private int tentativiMassimi;
	private int segreto;
	private int tentativiFatti;
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
    	this.segreto=(int) (Math.random()*numeroMassimo) +1;
    	this.tentativiFatti=0;
    	this.inGioco=true;
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
    	
    	this.tentativiFatti++;
    	if(tentativo==this.segreto) {
    		this.inGioco=false;
    		return "HAI VINTO!!! Hai utilizzato "+this.tentativiFatti+" tentativi";
    	}
    	
    	if(tentativiFatti==tentativiMassimi) {
    		//ho esaurito i tentativi --> ho perso
    		this.inGioco=false;
    		return "HAI PERSO!!! il numero segreto era "+this.segreto;
    	}
    	
    	if(tentativo<this.segreto) {
    		return "Tentativo troppo basso\n";
    	}else {
    		return "Tentativo troppo alto\n";
    	}
	}
	
	
	public Double getProgresso() {
		Double progresso;
		progresso=(double)tentativiFatti/tentativiMassimi;
		return progresso;
	}

	public int getnumeroMassimo() {
		return numeroMassimo;
	}

	public int gettentativiMassimi() {
		return tentativiMassimi;
	}

	public int getSegreto() {
		return segreto;
	}

	public int getTentativiFatti() {
		return tentativiFatti;
	}

	public boolean isInGioco() {
		return inGioco;
	}
	
	
}
