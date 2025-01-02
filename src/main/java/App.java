import wiseSaying.SystemController;
import wiseSaying.WiseSaying;
import wiseSaying.WiseSayingController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {


    // final이므로 반드시 생성자에서 초기화
    private final WiseSayingController wiseSayingController;
    private final SystemController systemController;

    public App() {
        // 외부에서 Scanner 객체를 만든 후, WiseSayingController 생성자에 전달
        Scanner scanner = new Scanner(System.in);
        wiseSayingController = new WiseSayingController(scanner);
        systemController = new SystemController();
    }

    public void run() {
        System.out.println(" == 명언 앱 ==");


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("명령) ");
            String command = scanner.nextLine();

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
                wiseSayingController.fixWiseSaying(command);
            }

            System.out.println("명령) 종료");
        }
    }
}
