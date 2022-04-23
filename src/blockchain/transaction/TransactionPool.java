package blockchain.transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionPool {
    private List<Transaction> listaTransakcija;

    public TransactionPool() {
        this.listaTransakcija = new ArrayList<>();
    }

    public List<Transaction> getListaTransakcija() {
        return listaTransakcija;
    }

    public void setListaTransakcija(List<Transaction> listaTransakcija) {
        this.listaTransakcija = listaTransakcija;
    }

    public int getPoolSize() {
        return this.listaTransakcija.size();
    }

}
