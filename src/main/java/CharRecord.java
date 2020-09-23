public class CharRecord {
    private char keyword;
    private Integer count;
    private CharRecord left;
    private CharRecord right;
    private String huffmanCode;

    public String getHuffmanCode() {
        return huffmanCode;
    }

    public void setHuffmanCode(String huffmanCode) {
        this.huffmanCode = huffmanCode;
    }

    public void setLeft(CharRecord left) {
        this.left = left;
    }

    public void setRight(CharRecord right) {
        this.right = right;
    }

    public CharRecord getLeft() {
        if (left == null) return null;
        return left;
    }

    public CharRecord getRight() {
        if (right == null) return null;
        return right;
    }

    public void setKeyword(char keyword) {
        this.keyword = keyword;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public char getKeyword() {
        return keyword;
    }

    public Integer getCount() {
        return count;
    }

    public void addCount(Integer i) {
        this.count = this.count + i;
    }

    public CharRecord(char keyword, Integer count) {
        this.keyword = keyword;
        this.count = count;
    }

    CharRecord() {}
}
