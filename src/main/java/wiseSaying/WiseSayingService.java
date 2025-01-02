package wiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingService {
    private List<WiseSaying> wiseSayings = new ArrayList<>();
    private int count = 1;

    // 명언 추가
    public void addWiseSaying(String content, String author) {
        WiseSaying ws = new WiseSaying(count, content, author);
        wiseSayings.add(ws);
        System.out.println(count + "번 명언이 등록되었습니다.");
        count++;
    }

    // 모든 명언 조회
    public List<WiseSaying> getAll() {
        return wiseSayings;
    }

    // 명언 삭제
    public boolean deleteById(int targetId) {
        // removeIf로 삭제 시도 → 성공 여부(boolean) 반환
        return wiseSayings.removeIf(ws -> ws.id == targetId);
    }

    // 명언 하나 찾기
    public WiseSaying findById(int targetId) {
        for (WiseSaying ws : wiseSayings) {
            if (ws.id == targetId) {
                return ws;
            }
        }
        return null; // 없으면 null
    }
}
