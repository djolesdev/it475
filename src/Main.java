import blockchain.Blockchain;
import blockchain.miner.Miner;
import blockchain.transaction.Transaction;
import blockchain.transaction.TransactionPool;
import entity.Korisnik;
import entity.Nepokretnost;
import entity.Tip;
import java.util.Scanner;


public class Main {

    static final Blockchain blockchain = new Blockchain();
    static final TransactionPool pool = new TransactionPool();
    static Miner miner = new Miner();
    static Scanner sc;
    static boolean finished = false;

    public static void main(String[] args) {

        sc = new Scanner(System.in);

       while (!finished) {

           System.out.println("UNOS PODATAKA O VLASNIKU NEPOKRETNOSTI.");
           System.out.print("Unesite ime: ");
           String name = sc.next();
           System.out.print("Unesite prezime:" );
           String surname = sc.next();
           System.out.print("Unesite JMBG: ");
           String jmbg = sc.next();

           System.out.println("UNOS PODATAKA O NEPOKRETNOSTI");
           System.out.print("Unesite broj opstine nepokretnosti: ");
           int brOpstine = sc.nextInt();
           System.out.print("Unesite povrsinu izrazenu u arima: ");
           double povrsina = sc.nextDouble();
           System.out.println("Odaberite tip nepokretnosti: ");
           System.out.print("1) Plodno zemljiste " + "\n" + "2) Neplodno zemljiste" + "\n" + "Unesite broj tipa: ");
           int tip = sc.nextInt();


           Korisnik korisnik = new Korisnik(name, surname, jmbg);
           Nepokretnost nepokretnost = null;
           if (tip == 1) {  nepokretnost = new Nepokretnost(brOpstine, povrsina, Tip.NEPLODNO_ZEMLJISTE); }
           if (tip == 2) {  nepokretnost = new Nepokretnost(brOpstine, povrsina, Tip.PLODNO_ZEMLJISTE); }

           Transaction transaction = new Transaction(korisnik, nepokretnost);

           pool.getListaTransakcija().add(transaction);

           System.out.println("Transakcija dodata!");

           if (pool.getPoolSize() == 2){
               miner.mine(pool, blockchain);

            // Napraviti lepsu print metodu za prikaz blockchain-a !!!
               System.out.println(blockchain.getBlockChain());
           }

           System.out.print("Zelite da nastavite? ");
           String isFinished = sc.next();

           if (isFinished.equals("da")){
               finished = false;
           } else {
               finished = true;
           }
       }
    }
}
