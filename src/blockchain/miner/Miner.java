package blockchain.miner;

import blockchain.block.Block;
import blockchain.Blockchain;
import blockchain.transaction.Transaction;
import utill.constants.Constants;

import java.sql.SQLOutput;
import java.util.List;

public class Miner {

    private double reward;
    public double getReward() {
        return reward;
    }

    public void mine(Block block, Blockchain blockchain) {

        Transaction invalidTransaction = null;

        // Provera validnosti transakcija
        // U slucaju da je transakcija invalid, izbacuje se iz Mining Pool-a
        // Promeniti da metoda mine() prima TransactionPool umesto Block-a
        // Block treba biti kreiran nako sto se validiraju transakcije

        for (Transaction temp : block.getTransactions()) {
            if (isTransactionValid(temp)) continue;
            invalidTransaction = temp;
            block.getTransactions().remove(temp);
        }

        // Pokrenuti majnera u zasebnom threadu koji ce konstantno osluskivati
        // TransactionPool i validirati transakcije, u momentu kad budu validiranih 5 transakcija
        // Blok treba biti kreiran, zatim Miner treba da trazi GoldenHash, u momentu kad ga nadje da upise u blockchain

        while(!isGoldenHash(block)) {
            block.incrementNonce();
            block.generateHash();
        // TEST
            System.out.println("PKUSAJ: " + block.getHash());
        }

        System.out.println("Miner je izmajnovao block sa hasom: " + block.getHash());
        blockchain.addBlock(block);
        reward += Constants.REWARD;
    }

    private boolean isTransactionValid(Transaction transaction) {
        if (transaction.getNepokretnost() == null || transaction.getKorisnik() == null) return false;
        return true;
    }

    private boolean isGoldenHash(Block block) {
        String leadingZeros =
                new String(new char[Constants.DIFFICULTY]).replace('\0', '0');
        return block.getHash().substring(0,Constants.DIFFICULTY).equals(leadingZeros);
    }


}