package blockchain;

import blockchain.block.Block;
import blockchain.transaction.Transaction;
import utill.constants.Constants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Blockchain {
    private List<Block> blockChain;

    public Blockchain() {
        this.blockChain = new LinkedList<>();
//        this.blockChain.add(new Block(0, new ArrayList<Transaction>(), Constants.GENESIS_HASH));
    }

    public void addBlock(Block block) {
        this.blockChain.add(block);
    }

    public List<Block> getBlockChain() {
        return blockChain;
    }

    public int getSize() {
        return this.blockChain.size();

    }

    @Override
    public String toString() {
        String s = "";
        for (Block block : this.blockChain) {
            s += block.toString() + "\n";
        }
        return s;
    }

}


