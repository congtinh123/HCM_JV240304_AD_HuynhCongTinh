package ra.controller;

import ra.service.SongService;

import java.text.ParseException;
import java.util.Scanner;

public class SongController {
    private SongService songService;
    public SongController(SongService songService) {
        this.songService = songService;
    }

    public SongController() {
        this.songService = new SongService();
    }

    public void manageSongs() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("**********************SONG-MANAGEMENT*************************");
            System.out.println("1. Nhập vào số lượng bài hát cần thêm và nhập thông tin cần thêm mới");
            System.out.println("2. Hiển thị danh sách tất cả bài hát đã lưu trữ");
            System.out.println("3. Thay đổi thông tin bài hát theo mã id");
            System.out.println("4. Xóa bài hát theo mã id");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    songService.addSong();
                    break;
                case 2:
                    songService.displayAllSongs();
                    break;
                case 3:
                    System.out.println("Nhập mã số bài hát cần chỉnh sửa: ");
                    String updateId = scanner.nextLine();
                    songService.updateSong(updateId);
                    break;
                case 4:
                    System.out.println("Nhập mã số bài hát cần xoá: ");
                    int deleteId = scanner.nextInt();
                    int id = deleteId;
                    songService.deleteSong(String.valueOf(id));
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Lựa chọn sai, vui lòng nhập lại.");
            }
        }
    }

    public void displayAllSongs() {
    }
}
