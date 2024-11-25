package extra;

import java.util.List;

public class BoardService {
    private final BoardDao boardDao;

    public BoardService() {
        this.boardDao = new BoardDao();
    }

    public void addBoard(String title, String content) {
        boardDao.addBoard(title, content);
    }

    public List<String> getBoards() {
        return boardDao.getBoards();
    }
}