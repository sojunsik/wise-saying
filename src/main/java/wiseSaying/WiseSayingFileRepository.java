package wiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingFileRepository implements WiseSayingRepository {
    private List<WiseSaying> wiseSayings = new ArrayList<>();

    @Override
    public WiseSaying save(WiseSaying wiseSaying) {
        wiseSayings.add(wiseSaying);

        // 파일에 쓰는 로직 등을 여기에 추가할 수 있음
        // ex) saveToFile();

        return wiseSaying;
    }

    @Override
    public WiseSaying findById(int id) {
        for (WiseSaying ws : wiseSayings) {
            if (ws.id == id) {
                return ws;
            }
        }
        return null;
    }

    @Override
    public List<WiseSaying> findAll() {
        return wiseSayings;
    }

    @Override
    public boolean deleteById(int targetId) {
        boolean removed = wiseSayings.removeIf(ws -> ws.id == targetId);

        if (removed) {
            // 파일 수정 로직 ...
        }
        return removed;
    }

    @Override
    public WiseSaying update(WiseSaying wiseSaying) {
        // 메모리에선 엔티티 수정 시 이미 반영.
        // 파일에서도 수정 내용 반영하려면 여기에 쓰기 로직 추가.

        return wiseSaying;
    }
}
