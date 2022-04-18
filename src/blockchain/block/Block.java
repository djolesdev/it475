package blockchain.block;
import utill.Sha256;
import blockchain.transaction.Transaction;

import java.util.Date;
import java.util.List;

public class Block {

    private int id;
    private List<Transaction> transactions;
    private String hash;
    private String previoushash;
    private int nonce;
    private long timeStamp;

    public Block(int id, List<Transaction> transactions, String previoushash) {
        this.id = id;
        this.transactions = transactions;
        this.previoushash = previoushash;
        this.timeStamp = new Date().getTime();
        generateHash();
    }

    public void generateHash() {
        String dataToHash = String.valueOf("" + this.id + this.previoushash + this.transactions + this.nonce + this.timeStamp);
        this.hash = Sha256.generateHash(dataToHash);
    }

    public void incrementNonce() {
        this.nonce++;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPrevioushash() {
        return previoushash;
    }

    public void setPrevioushash(String previoushash) {
        this.previoushash = previoushash;
    }

    @Override
    public String toString() {
        return "Block " + this.id + "\n" +
                " hashBloka: " + this.hash + "\n" +
                ", hashPredhodnog: " + this.previoushash + "\n" +
                ", transakcije: " + this.transactions + "\n" +
                ", nonce je: " + this.nonce;
    }
}