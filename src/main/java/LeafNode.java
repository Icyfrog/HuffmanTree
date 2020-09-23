public class LeafNode {
    private char c;
    private String huffmanCode;

    public LeafNode(char c, String huffmanCode) {
        this.c = c;
        this.huffmanCode = huffmanCode;
    }

    public LeafNode() {}

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public String getHuffmanCode() {
        return huffmanCode;
    }

    public void setHuffmanCode(String huffmanCode) {
        this.huffmanCode = huffmanCode;
    }
}
