package com.example;

/*
Scrivi un programma Java che si connetta a un database MySQL (può essere school, biblioteca, o simile).
 1 Crea una classe DbManager che gestisca la connessione JDBC. 
 2 Recupera tutti i record da una tabella a scelta (es. studenti da un  DB che devi creare e riempire) e stampali in console. 
 3 Prevedi l’uso di PreparedStatement per evitare SQL injection.
 4 Assicurati di gestire correttamente le eccezioni e di chiudere tutte le risorse (ResultSet, Statement, Connection). 
 */


import java.sql.*; // import delle classi necessarie per la connessione al DB 
import java.util.Scanner; // import della classe Scanner
        
    public class TestEsercizio2 {
        

    public static void main(String[] args) {
   

    }

}

class DbManager{
    static String URL = "jdbc:mysql://localhost:3306/";
    static String USER = null;
    static String PASSWORD = null;
    

    public static void insertConnectionData() {
        Scanner scannerStr = new Scanner(System.in); // creo uno scanner per le stringhe in input
        System.out.println("Inserisci il nome del db"); // chiedo il nome del db
        String dbname = scannerStr.nextLine(); //prendo in inpur il nome del db dallo scanner
        URL = URL.concat(dbname); // concateno il nome del db alla prima parte fissa dell'attributo statico URL
        System.out.println("Inserisci il nome utente"); //chiedo di inserire il nome utente
        USER = scannerStr.nextLine(); //inserisco nell'attributo statico USER il valore in input 
        System.out.println("Inserisci la password"); //chiedo di inserire la password
        PASSWORD = scannerStr.nextLine();  //inserisco nell'attributo statico PASSWORD il valore in input 
        

    }

    public static void createTable (Scanner scannerStr, Scanner ScannerNum){
        String sql = "CREATE TABLE ? ;";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            System.out.println("Inserisci il nome della tabella da creare");
            String nomeTabella = scannerStr.nextLine();
            stmt.setString(1, nomeTabella);
            
            stmt.executeUpdate();
            System.out.println("Creata tabella.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    }



   