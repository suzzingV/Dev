package dev.mission1.domain;

public enum Menu {
    REGISTER("register") {
        public void printMenu() {
            System.out.println("[System] 도서 등록 메뉴로 넘어갑니다.");
        }
    },
    LIST("list") {
        public void printMenu() {
            System.out.println("[System] 전체 도서 목록입니다.");
        }
    },
    SEARCH("search") {
        public void printMenu() {
            System.out.println("[System] 제목으로 도서 검색 메뉴로 넘어갑니다.");
        }
    },
    RENTAL("rental") {
        public void printMenu() {
            System.out.println("[System] 도서 대여 메뉴로 넘어갑니다.");
        }
    },
    RETURN("returnBook") {
        public void printMenu() {
            System.out.println("[System] 도서 반납 메뉴로 넘어갑니다.");
        }
    },
    LOST("lostBook") {
        public void printMenu() {
            System.out.println("[System] 도서 분실 처리 메뉴로 넘어갑니다.");
        }
    },
    DELETE("deleteBook") {
        public void printMenu() {
            System.out.println("[System] 도서 삭제 처리 메뉴로 넘어갑니다.");
        }
    };

    public String menu;
    Menu(String menu) {
        this.menu = menu;
    }

    public void printMenu() {

    }
}
