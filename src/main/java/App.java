import wiseSaying.WiseSaying;
import wiseSaying.WiseSayingController;
import wiseSaying.WiseSayingService;

import java.util.Scanner;

public class App {
    // Controller 안에 Service를 주입해줄 것이므로,
    // App에서 Service도 생성한다.
    public void run() {
        Scanner scanner = new Scanner(System.in);
        WiseSayingService wiseSayingService = new WiseSayingService();
        WiseSayingController wiseSayingController = new WiseSayingController(scanner, wiseSayingService);

        System.out.println(" == 명언 앱 ==");

        while(true) {
            System.out.print("명령) ");
            String command = scanner.nextLine();

            if (command.equals("종료")) {
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
                wiseSayingController.fixWiseSaying(command);
            }

            System.out.println("명령) 종료");
        }
    }
}
