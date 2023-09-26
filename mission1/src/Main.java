import domain.ModeType;
import service.Mode;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchMethodException {
        Mode mode = selectMode();
        while(true) mode.run();
    }

    public static Mode selectMode() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Q. 모드를 선택해주세요.\r\n" +
                        "1. 일반 모드\r\n" +
                        "2. 테스트 모드\r\n");
        String num = bf.readLine();
        ModeType modeType;
        if(num.equals("1")) {
            modeType = ModeType.NORMAL;
        } else {
            modeType = ModeType.TEST;
        }
        System.out.println("[System] " + modeType.mode + "로 애플리케이션을 실행합니다.");
        return new Mode(modeType);
    }
}
