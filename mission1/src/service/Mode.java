package service;

import repository.NormalRepository;
import repository.TestRepository;

import java.io.*;

public class Mode {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    Service service;
    public Mode(String mode) {
        if(mode.equals("normal")) service = new NormalService();
        else if(mode.equals("test")) service = new TestService();
    }

    public void run() throws IOException {
        printSelectList();

        String num = bf.readLine();
        if(num.equals("1")) {
            bw.write("[System] 도서 등록 메뉴로 넘어갑니다.");
            service.register();
        } else if(num.equals("2")) {
            bw.write("[System] 전체 도서 목록입니다.");
            service.list();
        } else if(num.equals("3")) {
            bw.write("[System] 제목으로 도서 검색 메뉴로 넘어갑니다.");
            service.search();
        } else if(num.equals("4")) {
            bw.write("[System] 도서 대여 메뉴로 넘어갑니다.");
            service.rental();
        } else if(num.equals("5")) {
            bw.write("[System] 도서 반납 메뉴로 넘어갑니다.");
            service.returnBook();
        } else if(num.equals("6")) {
            bw.write("[System] 도서 분실 처리 메뉴로 넘어갑니다.");
            service.lostBook();
        } else if(num.equals("7")) {
            bw.write("[System] 도서 삭제 처리 메뉴로 넘어갑니다.");
            service.deleteBook();
        }
    }

    private void printSelectList() throws IOException {
        bw.write("Q. 사용할 기능을 선택해주세요.\n" +
                "1. 도서 등록\n" +
                "2. 전체 도서 목록 조회\n" +
                "3. 제목으로 도서 검색\n" +
                "4. 도서 대여\n" +
                "5. 도서 반납\n" +
                "6. 도서 분실\n" +
                "7. 도서 삭제");
    }
}
