package wiseSaying;

import java.util.List;

public interface WiseSayingRepository {
     // 새로 등록 or 만들어진 엔티티 저장
     WiseSaying save(WiseSaying wiseSaying);

     // ID로 조회
     WiseSaying findById(int id);

     // 전체 조회
     List<WiseSaying> findAll();

     // ID로 삭제
     boolean deleteById(int targetId);

     // 수정된 엔티티 반영 (DB/파일에 UPDATE할 때 사용)
     WiseSaying update(WiseSaying wiseSaying);
}
