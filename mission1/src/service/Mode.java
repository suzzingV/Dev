package service;

import domain.Menu;
import domain.ModeType;
import repository.NormalRepository;
import repository.TestRepository;

import java.io.*;
import java.lang.reflect.Method;

public class Mode {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    Service service;
    public Mode(ModeType mode) throws IOException {
        if(mode == ModeType.NORMAL) service = new Service(new NormalRepository());
        else if(mode == ModeType.TEST) service = new Service(new TestRepository());
    }

    public void run() throws IOException, NoSuchMethodException {
        printSelectList();

        String num = bf.readLine();
        Menu menu = strToMenu(num);
        menu.printMenu();
        performFunction(menu);
    }

    private void performFunction(Menu menu) throws IOException {
        if(menu == Menu.REGISTER) service.register();
        else if(menu == Menu.LIST) service.list();
        else if(menu == Menu.LOST) service.lostBook();
        else if(menu == Menu.DELETE) service.deleteBook();
        else if(menu == Menu.RENTAL) service.rental();
        else if(menu == Menu.RETURN) service.returnBook();
        else if(menu == Menu.SEARCH) service.search();
    }
    private Menu strToMenu(String num) {
        if(num.equals("1")) return Menu.REGISTER;
        else if(num.equals("2")) return Menu.LIST;
        else if(num.equals("3")) return Menu.SEARCH;
        else if(num.equals("4")) return Menu.RENTAL;
        else if(num.equals("5")) return Menu.RETURN;
        else if(num.equals("6")) return Menu.LOST;
        return Menu.DELETE;
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
}
