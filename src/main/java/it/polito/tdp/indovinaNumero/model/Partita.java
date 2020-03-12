package it.polito.tdp.indovinaNumero.model;

public class Partita {
	
	private final int NMAX = 100;
	private final int TMAX = 8;
	private int segreto;
	private int tentativiFatti;
	private boolean inGioco= false;
	
	
	public Partita() {
		//gestione dell'inizio di una nuova partita - Logica del gioco
    	this.segreto=(int) (Math.random()*NMAX) +1;
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
    	
    	this.tentativiFatti++;
    	if(tentativo==this.segreto) {
    		this.inGioco=false;
    		return "HAI VINTO!!! Hai utilizzato "+this.tentativiFatti+" tentativi";
    	}
    	
    	if(tentativiFatti==TMAX) {
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

	
	
	
	public int getTentativiRimasti() {
		return TMAX-this.tentativiFatti;
	}

	public int getNMAX() {
		return NMAX;
	}

	public int getTMAX() {
		return TMAX;
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
