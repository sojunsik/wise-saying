package wiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingMemRepository implements WiseSayingRepository {
    private List<WiseSaying> wiseSayings = new ArrayList<>();

    @Override
    public WiseSaying save(WiseSaying wiseSaying) {
        wiseSayings.add(wiseSaying);
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
        return wiseSayings.removeIf(ws -> ws.id == targetId);
    }

    @Override
    public WiseSaying update(WiseSaying wiseSaying) {
        // 메모리 상에서는 동일 객체를 이미 수정했으면
        // 리스트에도 자동 반영됨.
        // 필요하다면 추가 로직(인덱스 찾아 교체) 등을 넣을 수 있음.

        return wiseSaying;
    }
}
