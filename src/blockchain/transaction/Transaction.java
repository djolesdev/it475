package blockchain.transaction;

import entity.Korisnik;
import entity.Nepokretnost;
import utill.Sha256;

public class Transaction {
    private Korisnik korisnik;
    private Nepokretnost nepokretnost;
    private String transactionHash;
    private String status;

    public Transaction(Korisnik korisnik, Nepokretnost nepokretnost) {
        this.korisnik = korisnik;
        this.nepokretnost = nepokretnost;
        this.transactionHash = Sha256.generateHash(String.valueOf("" + this.korisnik + this.nepokretnost));
        // Transakcija je status = Pending dok se ne validira od strane Minera!
        this.status = "Pending";
    }


    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Nepokretnost getNepokretnost() {
        return nepokretnost;
    }

    public void setNepokretnost(Nepokretnost nepokretnost) {
        this.nepokretnost = nepokretnost;
    }

    public String getHashCode() {
        return transactionHash;
    }

    public void setHashCode(String hashCode) {
        this.transactionHash = hashCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Transakcija: hashTransakcije: " + this.transactionHash + " " + "Korisnik: " + this.korisnik.getJMBG() + " " + "Nepokretnost: " + "(" + this.getNepokretnost().getTip() + " " + this.getNepokretnost().getPovrsina() + "a)";
    }
}
