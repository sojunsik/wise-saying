package wiseSaying;

import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private final Scanner scanner;
    private final WiseSayingService wiseSayingService;

    public WiseSayingController(Scanner scanner, WiseSayingService wiseSayingService) {
        this.scanner = scanner;
        this.wiseSayingService = wiseSayingService;
    }

    // 등록
    public void writeWiseSaying() {
        System.out.print("명언: ");
        String content = scanner.nextLine();

        System.out.print("작가: ");
        String author = scanner.nextLine();

        wiseSayingService.add(content, author);
    }

    // 목록
    public void printWiseSayingList() {
        List<WiseSaying> wiseSayings = wiseSayingService.getAll();

        System.out.println("번호 / 작가 / 명언");
        System.out.println("-----------------------");
        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying ws = wiseSayings.get(i);
            System.out.printf("%d / %s / %s\n", ws.id, ws.author, ws.content);
        }
    }

    // 삭제
    public void deleteWiseSaying(String command) {
        int targetId = parseId(command);
        boolean removed = wiseSayingService.deleteById(targetId);

        if (removed) {
            System.out.println(targetId + "번 명언이 삭제되었습니다.");
        } else {
            System.out.println(targetId + "번 명언은 존재하지 않습니다.");
        }
    }

    // 수정
    public void update(String command) {
        int targetId = parseId(command);
        WiseSaying found = wiseSayingService.findById(targetId);

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

        // Service에 수정 로직 위임
        WiseSaying updated = wiseSayingService.update(targetId, newContent, newAuthor);
        if (updated != null) {
            System.out.println(targetId + "번 명언이 수정되었습니다.");
        } else {
            System.out.println(targetId + "번 명언은 존재하지 않습니다.");
        }
    }

    private int parseId(String command) {
        // "삭제?id=3" 같은 형태를 가정
        String[] parts = command.split("\\?id=");
        return Integer.parseInt(parts[1]);
    }
}
