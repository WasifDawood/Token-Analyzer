
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class BookAnalyzer {
    private MainLinkedList mainList;

    public BookAnalyzer() {
        this.mainList = new MainLinkedList();
    }

    public void analyze(String filePath) {
        try {
            String text = new String(Files.readAllBytes(Paths.get(filePath)));
            String[] words = text.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");

            for (int i = 0; i < words.length - 1; i++) {
                MainLink mainLink = mainList.getMainLink(words[i]);
                if (mainLink == null) {
                    mainLink = new MainLink(words[i]);
                    BabyLink babyLink = new BabyLink(words[i + 1]);
                    mainLink.addBabyLink(babyLink);
                    mainList.insert(mainLink);
                } else {
                    BabyLink babyLink = mainLink.getBabyList().find(words[i + 1]);
                    if (babyLink == null) {
                        babyLink = new BabyLink(words[i + 1]);
                        mainLink.addBabyLink(babyLink);
                    } else {
                        babyLink.incrementFrequency();
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public MainLinkedList getMainList() {
        return mainList;
    }
    
  public String generateParagraph(String startWord, int length) {
    StringBuilder sb = new StringBuilder();
    MainLink current = mainList.getMainLink(startWord);
    if (current == null) {
        return "";
    }

    sb.append(startWord);
    sb.append(" ");

    int currentLength = 1;
    while (currentLength < length) {
        BabyLinkedList babyList = current.getBabyList();
        if (babyList.isEmpty()) {
            break;
        }
        int randomIndex = (int) (Math.random() * babyList.size());
        BabyLink babyLink = babyList.get(randomIndex);
        sb.append(babyLink.getWord());
        sb.append(" ");
        current = mainList.getMainLink(babyLink.getWord());
        if (current == null) {
            break;
        }
        currentLength++;
    }

    if (currentLength < length) {
        // not enough words were generated, so try again with a new starting word
        String newStartWord = mainList.getRandomMainLink().getWord();
        sb.append(generateParagraph(newStartWord, length - currentLength));
    }

    return sb.toString();
}

}