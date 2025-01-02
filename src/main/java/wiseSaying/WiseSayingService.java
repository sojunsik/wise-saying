package wiseSaying;

import java.util.List;

public class WiseSayingService {
    private final WiseSayingRepository wiseSayingRepository;
    private int count = 1;  // 자동 증가 ID

    public WiseSayingService(WiseSayingRepository wiseSayingRepository) {
        this.wiseSayingRepository = wiseSayingRepository;
    }

    // 명언 등록
    public WiseSaying add(String content, String author) {
        // ID 자동 증가 처리
        WiseSaying ws = new WiseSaying(count, content, author);
        wiseSayingRepository.save(ws);

        System.out.println(count + "번 명언이 등록되었습니다.");
        count++;

        return ws;
    }

    // 전체 명언 조회
    public List<WiseSaying> getAll() {
        return wiseSayingRepository.findAll();
    }

    // ID로 명언 삭제
    public boolean deleteById(int targetId) {
        return wiseSayingRepository.deleteById(targetId);
    }

    // ID로 명언 찾기
    public WiseSaying findById(int targetId) {
        return wiseSayingRepository.findById(targetId);
    }

    // 수정 기능 (나중에 DB 업데이트를 고려)
    public WiseSaying update(int id, String newContent, String newAuthor) {
        // 1) 엔티티 찾기
        WiseSaying ws = wiseSayingRepository.findById(id);
        if (ws == null) {
            return null;
        }
        // 2) 필드 수정
        ws.content = newContent;
        ws.author = newAuthor;
        // 3) Repository에 반영 (DB/파일이면 실제 UPDATE 수행)
        wiseSayingRepository.update(ws);

        return ws;
    }
}
