/*Progetta un semplice sistema per la gestione di veicoli. 
Crea una classe base Veicolo che contenga almeno due attributi (es. marca, anno) e un metodo dettagli().
 
1 Applica l'incapsulamento rendendo gli attributi privati e usando getter/setter. 
2 Crea due sottoclassi: Auto e Moto, che ereditano da Veicolo. 
3 Sovrascrivi il metodo dettagli() nelle sottoclassi per polimorfismo.
    Infine, nel main, crea un arraylist di Veicolo e stampa i dettagli di ogni elemento.
4 Gestisci il tutto tramite menu */

import java.util.ArrayList;
import java.util.Scanner;

public class TestEsercizio1 {
    public static void main(String[] args) {
        ArrayList<Veicolo> listaVeicoli = new ArrayList<>(); // creo l'arraylist che ospiterà i veicoli
        try(Scanner scannerNum = new Scanner(System.in); Scanner scannerStr = new Scanner(System.in)){// creato gli scanner all'interno di un try with resources
        int codice; //valore del comando selezionato
        String continua = new String(); // stringa per continuare
        
        do {
            System.out.println("Inserisci il codice per l'operazione desiderata:");
            System.out.println("1  Inserisci un'Auto"); 
            System.out.println("2  Inserisci una Moto");
            System.out.println("3  Visualizza tutti veicoli");
            //stampa menu
            codice = scannerNum.nextInt(); //input del codice selezionato
            switch (codice) {
                case 1://   Inserisci un'Auto
                    System.out.println("Inserisci la targa dell'auto");
                    String targaAuto = scannerStr.nextLine(); // chiedo e prendo il input la targa di un auto
                    System.out.println("Inserisci il numero di porte dell'auto");
                    int numeroPorte = scannerNum.nextInt(); // chiedo e prendo in input in numero di porte
                    listaVeicoli.add(new Auto(targaAuto, numeroPorte)); // aggiungo l'auto con i dati forniti in input alla lista
                    break;
            
                case 2://   Inserisci una Moto
                    System.out.println("Inserisci la targa della moto");
                    String targaMoto = scannerStr.nextLine(); // chiedo e prendo il input la targa di una moto
                    System.out.println("Inserisci la cilindrata");
                    int cilindrata = scannerNum.nextInt(); // chiedo e prendo in input la cilindrata
                    listaVeicoli.add(new Moto(targaMoto, cilindrata)); // aggiungo l'auto con i dati forniti in input alla lista
                    break;

                case 3://   Visualizza tutti veicoli
                    System.out.println("Ecco i dettagli di tutti i veicoli nella lista");
                    for( Veicolo veicolo :listaVeicoli){ //scorro l'arraylist
                        veicolo.dettagli(); //per ogni veicolo all'interno invoco dettagli per stampare i dettagli
                    }
                    break;
                    
                default:
                    System.out.println("Codice dell'operazione errato"); //stampa codice non presente
                    break;
            }

            System.out.println("vuoi continuare? (si/no)"); //chiedo se vuole continuare
            continua = scannerStr.nextLine(); //input della risposta
        }while (!continua.equals("no")); //ciclo finchè continua è diverso da no
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
}

class Veicolo { // classe che modella un veicolo
    private String targa; // attributo privato della classe

    Veicolo(String targa){ //costruttore della classe
        this.targa = targa;
    }

    public String getTarga() { // metodo set della targa
        return targa;
    }

    public void setTarga(String targa) { // metodo get dela targa
        this.targa = targa;
    }

    public void dettagli(){ //stampa a video la targa del veicolo
        System.out.println("La targa del veicolo è: "+ this.getTarga());
    }
}

class Auto extends Veicolo{
    
    private int numeroPorte; //attributo privato della classe

    Auto(String nome, int numeroPorte) { // costruttore della classe con all'interno il richiamo al costruttore della superclasse
        super(nome);
        this.numeroPorte = numeroPorte;
        
    }

    public int getNumeroPorte() { // get del numero delle porte dell'auto
        return numeroPorte;
    }

    public void setNumeroPorte(int numeroPorte) { // set del numero di porte dell'auto
        this.numeroPorte = numeroPorte;
    }

    public void dettagli(){ //stampa a video i dettagli dell'auto (targa e numero di porte)
        System.out.println("Dettagli dell'auto:");
        super.dettagli();
        System.out.println("Il numero di porte dell'auto è: " + getNumeroPorte());
    }

}

class Moto extends Veicolo{

    private int cilindrata; //attributo privato della classe

  
    Moto(String nome, int cilindrata) { // costruttore della classe con all'interno il richiamo al costruttore della superclasse
        super(nome);
        this.cilindrata = cilindrata;
    }

    public int getCilindrata() { // get della cilindrata
        return cilindrata;
    }

    public void setCilindrata(int cilindrata) { // set della cilindrata
        this.cilindrata = cilindrata;
    }

    public void dettagli(){ //stampa a video i dettagli della moto (targa e cilindrata)
        System.out.println("Dettagli della moto:");
        super.dettagli();
        System.out.println("La cilindrata della moto è: " + getCilindrata());
    }
}