import java.util.Date;

public class Block {

    public Long index;
    public Long timeStamp;
    public String hash;
    public String prevBlockHash;
    private String data;
    public int nonce;

    public Block(String data, String prevBlockHash) {
        this.index = this.index;
        this.prevBlockHash = prevBlockHash;
        this.data = data;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }

    public String calculateHash() {

        String calculatedHash = StringUtil.applySHA256(Long.toString(index) + prevBlockHash + Long.toString(timeStamp) + Integer.toString(nonce) + data);
        return calculatedHash;
    }


    public void mineBlock(int difficulty) {
        String target = StringUtil.getDificultyString(difficulty);
        while(! hash.substring(0, difficulty).equals(target)) {
            nonce ++;
            hash = calculateHash();
        }
        System.out.println("Block Mined!!! : " + hash);
    }
}
