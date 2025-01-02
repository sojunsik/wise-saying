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

    public void writeWiseSaying() {
        System.out.print(" 명언: ");
        String content = scanner.nextLine();

        System.out.print("작가: ");
        String author = scanner.nextLine();

        // 서비스에 "명언 추가" 요청
        wiseSayingService.addWiseSaying(content, author);
    }

    public void printWiseSayingList() {
        List<WiseSaying> wiseSayings = wiseSayingService.getAll();

        System.out.println("번호 / 작가 / 명언");
        System.out.println("-----------------------");
        // 최신 등록 순으로 역순 출력하고 싶다면 reverse 반복
        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying ws = wiseSayings.get(i);
            System.out.printf("%d / %s / %s\n", ws.id, ws.author, ws.content);
        }
    }

    public void deleteWiseSaying(String command) {
        int targetId = parseId(command);
        boolean removed = wiseSayingService.deleteById(targetId);

        if (removed) {
            System.out.println(targetId + " 번 명언이 삭제되었습니다.");
        } else {
            System.out.println(targetId + "번 명언은 존재하지 않습니다.");
        }
    }

    public void fixWiseSaying(String command) {
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

        // found(원본) 객체에 덮어쓰기
        found.content = newContent;
        found.author = newAuthor;

        System.out.println(targetId + "번 명언이 수정되었습니다.");
    }

    // "삭제?id=3" 이런 식의 command에서 id 부분을 파싱
    private int parseId(String command) {
        String[] parts = command.split("\\?id=");
        return Integer.parseInt(parts[1]);
    }
}
