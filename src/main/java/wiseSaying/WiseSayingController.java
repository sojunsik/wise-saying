package wiseSaying;
import java.util.*;

public class WiseSayingController {
    private List<WiseSaying> wiseSayings = new ArrayList<>();
    private int count = 1;

    private final Scanner scanner;


    public WiseSayingController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void writeWiseSaying() {
        System.out.print(" 명언: ");
        String content = scanner.nextLine();

        System.out.print("작가 :");
        String author = scanner.nextLine();

        WiseSaying ws = new WiseSaying(count, content, author);
        wiseSayings.add(ws);

        System.out.println(count + "번 명언이 등록되었습니다.");
        count++;
    }

    public void printWiseSayingList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-----------------------");
        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying ws = wiseSayings.get(i);
            System.out.printf("%d / %s / %s\n", ws.id, ws.author, ws.content);
        }
    }

    public void deleteWiseSaying(String command) {
        String[] parts = command.split("\\?id=");
        int targetId = Integer.parseInt(parts[1]);

        boolean removed = wiseSayings.removeIf(ws -> ws.id == targetId);
        if (removed) {
            System.out.println(targetId + " 번 명언이 삭제되었습니다.");
        } else {
            System.out.println(targetId + "번 명언은 존재하지 않습니다.");
        }
    }

    public void fixWiseSaying(String command) {
        String[] parts = command.split("\\?id=");
        int targetId = Integer.parseInt(parts[1]);
        WiseSaying found = null;
        for (WiseSaying ws : wiseSayings) {
            if (ws.id == targetId) {
                found = ws;
                break;
            }
        }
        if (found == null) {
            System.out.println(targetId + "번 명언은 존재하지 않습니다.");
            return;
        }
        System.out.printf("명언(기존): %s\n", found.content);
        System.out.print("명언: ");
        String newContent = scanner.nextLine();
        System.out.printf("작가(기존): %s\n", found.author);
        System.out.print("작가: ");
        String newAuthor = scanner.nextLine();

        found.content = newContent;
        found.author = newAuthor;
        System.out.println(targetId + "번 명언이 수정되었습니다.");
    }
}
