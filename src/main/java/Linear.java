import javafx.util.Pair;

public class Linear {
    private Integer S = 8;
    private Integer usedS = 0;
    private Pair[] hashTable = new Pair[S];

    public int getS() {
        return S;
    }

    public int getUsedS() {
        return usedS;
    }

    public void setS(int s) {
        S = s;
    }

    public void setUsedS(int usedS) {
        this.usedS = usedS;
    }

    Linear() {}

    Linear(Integer S) {
        this.S = S;
        this.hashTable = new Pair[S];
    }

    // delete 释放?
    public void delete() {
    }

    public void set(Integer key, Integer value) {
        Pair<Integer, Integer> newPair = new Pair<>(key, value);
        int hashValue = key - (key / S) * S;
        //System.out.println("key\t" + key + '\t' + "hash is:\t" + hashValue);

        // from (key mod S) to S
        boolean ifSet = false;
        for (int i = hashValue; i < S; i++) {
            if (hashTable[i] == null) {
                hashTable[i] = newPair;
                ifSet = true;
                break;
            }
        }

        // from 0 to (key mod S)
        if (!ifSet) {
            for (int i=0; i<hashValue; i++) {
                if (hashTable[i] == null) {
                    hashTable[i] = newPair;
                    ifSet = true;
                    break;
                }
            }
        }

        usedS++;

        if (usedS > S / 2) {
            addSpace();
        }

        // todo: panduan kuorong! Judge if we need more Space
    }

    public Integer get(Integer key) {
        int hashValue = key - (key / S) * S;

        // from (key mod S) to S
        for (int i = hashValue; i < S; i++) {
            if (hashTable[i].getKey() == key) return (Integer) hashTable[i].getValue();
            if (hashTable[i] == null) return null;
            }

        for (int i = 0; i < hashValue; i++) {
            if (hashTable[i].getKey() == key) return (Integer) hashTable[i].getValue();
            if (hashTable[i] == null) return null;
        }

        return null;
    }

    public void delete(Integer key) {
        int hashValue = key - (key / S) * S;
        boolean ifReset = false;
        for (int i = hashValue; i < S; i++) {
            if (hashTable[i].getKey() == key) {
                hashTable[i] = null;
                usedS--;
            }
        }
    }

    // todo: 删除之后，整个hash可能要挪动很多个位子？？
    public void reset(int startNum, int position, int key) {

    }

    public void addSpace() {
        int tmpS = S;
        S = S*2;
        Pair[] newHashTable = new Pair[S];

        Pair[] tmpPair = hashTable;
        hashTable = newHashTable;

        for(int i = 0; i<tmpS; i++) {
            if (tmpPair[i] != null)
                set((Integer) tmpPair[i].getKey(),(Integer) tmpPair[i].getValue());
        }
    }

    public void print() {
        for (int i=0; i<S; i++) {
            System.out.print(hashTable[i]+ "\t ||");
        }
    }
}

