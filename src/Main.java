import blockchain.Blockchain;
import blockchain.block.Block;
import blockchain.miner.Miner;
import blockchain.transaction.Transaction;
import blockchain.transaction.TransactionPool;
import entity.Korisnik;
import entity.Nepokretnost;
import entity.Tip;
import utill.constants.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    static final Blockchain blockchain = new Blockchain();
    static final TransactionPool pool = new TransactionPool();
    static Scanner sc;


    public static void main(String[] args) {

//        Dodati da preko standardnog ulaza user unese podatke o Korisniku i podatke o Nepokretnosti
//        Zatim korisnik koji je kreiran treba da inicializuje kreiranje transakcije koja se ubacuje u MiningPool, odatle preuzima Miner

        Korisnik k1 = new Korisnik("Djordje", "Stefanovic", "12345");
        Nepokretnost n1 = new Nepokretnost(1, 50, Tip.NEPLODNO_ZEMLJISTE);

        Transaction t1 = new Transaction(k1, n1);
        List<Transaction> lista = new ArrayList<>();
        lista.add(t1);

        Block b1 = new Block(1, lista, Constants.GENESIS_HASH);
        Miner m1 = new Miner();

        m1.mine(b1, blockchain);

        System.out.println(blockchain.getBlockChain());


    }
}
