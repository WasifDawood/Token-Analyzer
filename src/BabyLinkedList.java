
public class BabyLinkedList {
     private BabyLink head;
    
    public BabyLinkedList() {
        this.head = null;
    }
    
    public BabyLink getHead() {
        return head;
    }
    
    public void setHead(BabyLink head) {
        this.head = head;
    }
    public BabyLink find(String word) {
    BabyLink current = head;
    while (current != null && !current.getWord().equals(word)) {
        current = current.getNext();
    }
    return current;
}

public void insert(BabyLink link) {
    link.setNext(head);
    head = link;
}

  public int size() {
        int count = 0;
        BabyLink current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }
  
   public BabyLink get(int randomIndex) {
        if (head == null) {
            return null;
        }

        BabyLink current = head;
        for (int i = 0; i < randomIndex; i++) {
            if (current.getNext() == null) {
                return null;
            }
            current = current.getNext();
        }
        return current;
    }
   
    public boolean isEmpty() {
        return head == null;
    }
}

