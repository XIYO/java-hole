package extra;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class BoardDao {
    private static final String FILE_PATH = "board.txt";

    // 생성자: 파일이 없으면 생성
    public BoardDao() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 게시글 추가
    public void addBoard(String title, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            String line = title + "||" + content; // 구분자로 "||" 사용
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 게시글 읽기
    public List<String> getBoards() {
        List<String> boards = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                boards.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return boards;
    }

    // 게시글 전체 삭제 (파일 초기화)
    public void clearBoards() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            // 파일 내용 지우기 위해 빈 파일로 덮어씀
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
