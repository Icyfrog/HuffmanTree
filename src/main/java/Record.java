public class Record {
    private String keyword;
    private Integer count;

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getKeyword() {
        return keyword;
    }

    public Integer getCount() {
        return count;
    }

    public Record(String keyword, Integer count) {
        this.keyword = keyword;
        this.count = count;
    }

    Record() {}
}
