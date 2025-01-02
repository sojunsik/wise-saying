package wiseSaying; // 필요에 맞게 수정하세요

import java.util.Scanner;

public class App {
    public void run() {
        Scanner scanner = new Scanner(System.in);

        // 메모리에 저장하는 구현체 사용
        WiseSayingMemRepository wiseSayingMemRepository = new WiseSayingMemRepository();

        // 서비스 생성 (Repository 주입)
        WiseSayingService wiseSayingService = new WiseSayingService(wiseSayingMemRepository);

        // 컨트롤러 생성 (Scanner & Service 주입)
        WiseSayingController wiseSayingController = new WiseSayingController(scanner, wiseSayingService);
        SystemController systemController = new SystemController();
        System.out.println(" == 명언 앱 ==");

        while(true) {
            System.out.print("명령) ");
            String command = scanner.nextLine().trim();

            if (command.equals("종료")) {
                systemController.exit();
                break;
            }
            else if (command.equals("등록")) {
                wiseSayingController.writeWiseSaying();
            }
            else if (command.equals("목록")) {
                wiseSayingController.printWiseSayingList();
            }
            else if (command.startsWith("삭제?id=")) {
                wiseSayingController.deleteWiseSaying(command);
            }
            else if (command.startsWith("수정?id=")) {
                wiseSayingController.update(command);
            }
            else {
                System.out.println("알 수 없는 명령입니다: " + command);
            }
        }
    }
}
