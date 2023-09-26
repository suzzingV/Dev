package service;

import domain.Book;
import repository.Repository;

import java.io.*;

public class Service {
    private static Repository repository;
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public Service(Repository repository) {
        this.repository = repository;
    }

    public void run() throws IOException {
        printSelectList();

        String num = bf.readLine();
        if(num.equals("1")) {
            System.out.println("[System] 도서 등록 메뉴로 넘어갑니다.");
            register();
        } else if(num.equals("2")) {
            System.out.println("[System] 전체 도서 목록입니다.");
            list();
        } else if(num.equals("3")) {
            System.out.println("[System] 제목으로 도서 검색 메뉴로 넘어갑니다.");
            search();
        } else if(num.equals("4")) {
            System.out.println("[System] 도서 대여 메뉴로 넘어갑니다.");
            rental();
        } else if(num.equals("5")) {
            System.out.println("[System] 도서 반납 메뉴로 넘어갑니다.");
            returnBook();
        } else if(num.equals("6")) {
            System.out.println("[System] 도서 분실 처리 메뉴로 넘어갑니다.");
            lostBook();
        } else if(num.equals("7")) {
            System.out.println("[System] 도서 삭제 처리 메뉴로 넘어갑니다.");
            deleteBook();
        } else {
            System.out.println("프로그램을 종료합니다.");
            System.exit(0);
        }
    }

    private void printSelectList() {
        System.out.println("Q. 사용할 기능을 선택해주세요.\n" +
                "1. 도서 등록\n" +
                "2. 전체 도서 목록 조회\n" +
                "3. 제목으로 도서 검색\n" +
                "4. 도서 대여\n" +
                "5. 도서 반납\n" +
                "6. 도서 분실\n" +
                "7. 도서 삭제");
    }

    public void register() throws IOException {
        Book book = new Book();
        System.out.println("Q. 등록할 도서 제목을 입력하세요.");
        book.setTitle(bf.readLine());

        System.out.println("Q. 작가 이름을 입력하세요.");
        book.setWriter(bf.readLine());

        System.out.println("Q. 페이지 수를 입력하세요.");
        book.setPage(Integer.parseInt(bf.readLine()));

        repository.register(book);
        System.out.println("[System] 도서 등록이 완료되었습니다.");
    }

    public void list() {
        System.out.println("[System] 전체 도서 목록입니다.");
        repository.printList();
        System.out.println("[System] 도서 목록 끝");
    }

    public void search() throws IOException {
        System.out.println("Q. 검색할 도서 제목 일부를 입력하세요.");
        String titleWord = bf.readLine();
        repository.search(titleWord);
        System.out.println("[System] 검색된 도서 끝");
    }

    public void rental() throws IOException {
        System.out.println("Q. 대여할 도서번호를 입력하세요");
        int id = Integer.parseInt(bf.readLine());
        repository.rental(id);
    }

    public void returnBook() throws IOException {
        System.out.println("Q. 반납할 도서번호를 입력하세요");
        int id = Integer.parseInt(bf.readLine());
        repository.returnBook(id);
    }

    public void lostBook() throws IOException {
        System.out.println("Q. 분실 처리할 도서번호를 입력하세요");
        int id = Integer.parseInt(bf.readLine());
        repository.lostBook(id);
    }

    public void deleteBook() throws IOException {
        System.out.println("Q. 삭제 처리할 도서번호를 입력하세요");
        int id = Integer.parseInt(bf.readLine());
        repository.deleteBook(id);
    }
}
