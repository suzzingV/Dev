package repository;

import domain.Book;

import java.io.*;
import java.nio.BufferOverflowException;
import java.util.ArrayList;
import java.util.List;

public class NormalRepository implements Repository {
    File file = new File("C:/Users/skylim/IdeaProjects/lecture/mission1/src/도서.csv");
    List<Book> books = new ArrayList<>();
    BufferedWriter bw;

    public NormalRepository() throws IOException {
        fileToList(books, file);
    }

    @Override
    public void register(Book book) throws IOException {
        book.setState("대여 가능");
        books.add(book);
        updateFile(books, file);
    }

    @Override
    public void printList() throws IOException {
        books.stream().forEach(book -> {
            try {
                printBookInfo(book);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    public void search(String titleWord) {
        books.stream().forEach(book -> {
            String title = book.getTitle();
            if(title.contains(titleWord)) {
                try {
                    printBookInfo(book);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    @Override
    public void rental(int id) throws IOException {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Book selectedBook = books.stream().filter(book -> book.getId() == id)
                .findAny()
                .get();

        if (selectedBook.getState().equals("대여중")) {
            bw.write("[System] 이미 대여중인 도서입니다.");
        } else if(selectedBook.getState().equals("대여 가능")) {
            selectedBook.setState("대여중");
            updateFile(books, file);
            bw.write("[System] 도서가 대여 처리 되었습니다.");
        } else if(selectedBook.getState().equals("도서 정리중")){
            bw.write("[System] 정리 중인 도서입니다.");
        } else if(selectedBook.getState().equals("분실됨")) {
            bw.write("[System] 분실된 도서입니다.");
        }
    }

    @Override
    public void returnBook(int id) throws IOException {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Book selectedBook = books.stream().filter(book -> book.getId() == id)
                .findAny()
                .get();

        if (selectedBook.getState().equals("대여중") || selectedBook.getState().equals("분실됨")) {
            selectedBook.setState("도서 정리중");
            updateFile(books, file);
            //5분 지나면 selectedBook.setState("대여 가능");
            bw.write("[System] 도서가 반납 처리 되었습니다.");
        } else if(selectedBook.getState().equals("대여 가능")) {
            bw.write("[System] 원래 대여가 가능한 도서입니다.");
        } else {
            bw.write("[System] 반납이 불가능한 도서입니다.");
        }
    }

    @Override
    public void lostBook(int id) throws IOException {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Book selectedBook = books.stream().filter(book -> book.getId() == id)
                .findAny()
                .get();
        if (selectedBook.getState().equals("대여중")) {
            selectedBook.setState("분실됨");
            updateFile(books, file);
            bw.write("[System] 도서가 분실 처리 되었습니다.");
        } else if(selectedBook.getState().equals("대여 가능") || selectedBook.getState().equals("도서 정리중")) {
            bw.write("[System] 분실 처리가 불가능한 도서입니다.");
        } else if(selectedBook.getState().equals("분실됨")){
            bw.write("[System] 이미 분실 처리된 도서입니다.");
        }
    }

    @Override
    public void deleteBook(int id) throws IOException {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Book selectedBook = books.stream().filter(book -> book.getId() == id)
                .findAny()
                .get();

        if(selectedBook == null) {
            bw.write("[System] 존재하지 않는 도서번호 입니다.");
        } else {
            books.remove(selectedBook);
            updateFile(books, file);
            bw.write("[System] 도서가 삭제 처리 되었습니다.");
        }
    }

    private void updateFile(List<Book> books, File file) throws IOException {
        bw = new BufferedWriter(new FileWriter(file));
        books.stream().forEach(book -> {
            try {
                bw.write(String.valueOf(book.getId()) + "," + book.getTitle() + ","
                        + book.getWriter() + "," + String.valueOf(book.getPage()) + "," + book.getState());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void fileToList(List<Book> books, File file) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader(file));
        String line = "";

        while((line = bf.readLine()) != null) {
            String[] split = line.split(",");
            Book tmpBook = new Book();

            tmpBook.setId(Integer.parseInt(split[0]));
            tmpBook.setTitle(split[1]);
            tmpBook.setWriter(split[2]);
            tmpBook.setPage(Integer.parseInt(split[3]));
            tmpBook.setState(split[4]);

            books.add(tmpBook);
        }
    }
}
