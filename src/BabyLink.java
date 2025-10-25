public class BabyLink {
    private String word;
    private int frequency = 1;
    private BabyLink next;

public int getFrequency() {
    return frequency;
}

public void incrementFrequency() {
    frequency++;
}
    public BabyLink getNext(){
    
    return this.next;
    }
    
    public void setNext(BabyLink next) {
    this.next = next;
}
    public BabyLink(String word) {
        this.word = word;
    }
    
    public String getWord() {
        return word;
    }
    
    public void setWord(String word) {
        this.word = word;
    }
}
