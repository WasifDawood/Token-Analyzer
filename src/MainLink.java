import java.util.LinkedList;

public class MainLink {
    private String keyword;
    private LinkedList<BabyLink> babyLinks;
    private MainLink next = null;
    
    public MainLink(String keyword) {
        this.keyword = keyword;
        this.babyLinks = new LinkedList<BabyLink>();
    }
    
    public String getKeyword() {
        return keyword;
    }
    
    public MainLink getNext(){
    
    return this.next;
    }
    
    public void setNext(MainLink next) {
    this.next = next;
}
    
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    public String getWord() {
    return keyword;
}


    public LinkedList<BabyLink> getBabyLinks() {
        return babyLinks;
    }
    
    public void addBabyLink(BabyLink babyLink) {
        babyLinks.add(babyLink);
    }
    
    public void addBabyLink(String word) {
    BabyLink babyLink = new BabyLink(word);
    babyLinks.add(babyLink);
}

    


    
    public int getFrequency(String word) {
        int frequency = 0;
        for (BabyLink babyLink : babyLinks) {
            if (babyLink.getWord().equals(word)) {
                frequency++;
            }
        }
        return frequency;
    }
    public BabyLinkedList getBabyList() {
    BabyLinkedList babyList = new BabyLinkedList();
    for (BabyLink babyLink : babyLinks) {
        babyList.insert(babyLink);
    }
    return babyList;
}

}
