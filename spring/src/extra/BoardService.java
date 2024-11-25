package extra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BoardService {
    @Autowired private BoardDao boardDao;

    public void addBoard(String title, String content) {
        boardDao.addBoard(title, content);
    }

    public List<String> getBoards() {
        return boardDao.getBoards();
    }
}