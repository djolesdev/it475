package blockchain.miner;

import blockchain.block.Block;
import blockchain.Blockchain;
import blockchain.transaction.Transaction;
import blockchain.transaction.TransactionPool;
import utill.constants.Constants;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Miner {

    private double reward;
    public double getReward() {
        return reward;
    }

    public void mine(TransactionPool pool, Blockchain blockchain) {

        List<Transaction> validTransactions = new ArrayList<>();

        for (Transaction temp : pool.getListaTransakcija()) {
            if (isTransactionValid(temp)) {
                validTransactions.add(temp);
                continue;
            }
            pool.getListaTransakcija().remove(temp);
        }

        Block lastBlock = blockchain.getBlockChain().get(blockchain.getSize() -1);
        Block block = new Block(lastBlock.getId() + 1, validTransactions, lastBlock.getHash());

        while(!isGoldenHash(block)) {
            block.incrementNonce();
            block.generateHash();
        // TEST
//            System.out.println("PKUSAJ: " + block.getHash());
        }

        System.out.println("Miner je izmajnovao block sa hasom: " + block.getHash());
        blockchain.addBlock(block);
        reward += Constants.REWARD;

        pool.setListaTransakcija(new ArrayList<Transaction>());
    }

    private boolean isTransactionValid(Transaction transaction) {
        // Proveriti da li je Nepokretnost vec upisana u blockchain!
        if (transaction.getNepokretnost() == null || transaction.getKorisnik() == null) return false;
        return true;
    }

    private boolean isGoldenHash(Block block) {
        String leadingZeros =
                new String(new char[Constants.DIFFICULTY]).replace('\0', '0');
        return block.getHash().substring(0,Constants.DIFFICULTY).equals(leadingZeros);
    }


}