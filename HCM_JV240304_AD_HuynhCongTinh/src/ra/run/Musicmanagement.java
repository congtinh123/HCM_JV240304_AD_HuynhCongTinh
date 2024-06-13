package ra.run;

import ra.controller.SingerController;
import ra.controller.SongController;

import java.text.ParseException;
import java.util.Scanner;

public class Musicmanagement {
    SingerController singerController = new SingerController();
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        SingerController singerController = new SingerController();
        SongController songController = new SongController();
        SearchManagement searchManagement = new SearchManagement();

        while (true) {
            System.out.println("************************MUSIC-MANAGEMENT*************************");
            System.out.println("1. Quản lý ca sĩ");
            System.out.println("2. Quản lý bài hát");
            System.out.println("3. Tìm kiếm bài hát");
            System.out.println("4. Thoát");
            System.out.print("Chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    singerController.manageSingers();
                    break;
                case 2:
                    songController.manageSongs();
                    break;
                case 3:
                    searchManagement.showSearchMenu();
                    break;
                case 4:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không đúng, vui lòng nhập lại.");
            }
        }
    }
}
