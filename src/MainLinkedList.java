
import java.util.LinkedList;



public class MainLinkedList {
    private MainLink head;
    
    public MainLinkedList() {
        this.head = null;
    }
    
    public MainLink getHead() {
        return head;
    }
    
    public void setHead(MainLink head) {
        this.head = head;
    }
    
    public void insert(MainLink mainLink) {
        if (head == null) {
            head = mainLink;
            return;
        }
        
        MainLink current = head;
        while (current != null) {
          if (current.getKeyword().equals(mainLink.getKeyword())) {
    for (BabyLink babyLink : mainLink.getBabyLinks()) {
        BabyLink currentBabyLink = current.getBabyList().find(babyLink.getWord());
        if (currentBabyLink == null) {
            current.addBabyLink(babyLink);
        } else {
            currentBabyLink.incrementFrequency();
        }
    }
    return;
}

            if (current.getBabyLinks().isEmpty() || mainLink.getKeyword().compareTo(current.getKeyword()) < 0) {
                mainLink.setNext(current);
                if (current == head) {
                    head = mainLink;
                } else {
                    MainLink previous = head;
                    while (previous.getNext() != current) {
                        previous = previous.getNext();
                    }
                    previous.setNext(mainLink);
                }
                return;
            }
            current = current.getNext();
        }
    }
    public MainLink getMainLink(String keyword) {
    MainLink current = head;
    while (current != null) {
        if (current.getKeyword().equals(keyword)) {
            return current;
        }
        current = current.getNext();
    }
    return null;
}

public MainLink getPeaceLink() {
    return getMainLink("peace");
}
    public MainLink find(String keyword) {
        MainLink current = head;
        while (current != null) {
            if (current.getKeyword().equals(keyword)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }
    
    public LinkedList<MainLink> getMainLinks() {
        LinkedList<MainLink> mainLinks = new LinkedList<>();
    MainLink current = head;
    while (current != null) {
        mainLinks.add(current);
        current = current.getNext();
    }
    return mainLinks;
}
public MainLink getRandomMainLink() {
    MainLink current = head;
    int size = 0;
    while (current != null) {
        size++;
        current = current.getNext();
    }

    if (size == 0) {
        return null;
    }

    int randomIndex = (int) (Math.random() * size);

    current = head;
    for (int i = 0; i < randomIndex; i++) {
        current = current.getNext();
    }

    return current;
}

}
