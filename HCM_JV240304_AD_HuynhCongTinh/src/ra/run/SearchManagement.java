package ra.run;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import ra.service.SongService;
import ra.service.SingerService;
import ra.model.Song;
import ra.model.Singer;

public class SearchManagement {
    private SongService songService;
    private SingerService singerService;
    private Scanner scanner;
    private Song[] songs;

    public SearchManagement(SongService songService, SingerService singerService, Scanner scanner) {
        this.songService = songService;
        this.singerService = singerService;
        this.scanner = scanner;
    }

    public SearchManagement() {
        this.songService = new SongService();
        this.singerService = new SingerService();
        this.scanner = new Scanner(System.in);
    }

    public void showSearchMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("*********************SEARCH-MANAGEMENT************************");
            System.out.println("1. Tìm kiếm bài hát theo tên ca sĩ hoặc thể loại.");
            System.out.println("2. Tìm kiếm ca sĩ theo tên hoặc thể loại.");
            System.out.println("3. Hiển thị danh sách bài hát theo thứ tự tên tăng dần.");
            System.out.println("4. Hiển thị 10 bài hát được đăng mới nhất.");
            System.out.println("5. Thoát.");
            System.out.print("Chọn: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    searchArtistByNameOrGenre();
                    break;
                case 2:
                    searchArtistByNameOrGenre();
                    break;
                case 3:
                    displaySongsInAscendingOrder();
                    break;
                case 4:
                    Song[] latestSongs = songService.getLatestSongs(10);
                    displaySongs(latestSongs);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    public Song[] searchSongsByArtistOrGenre(String keyword) {
        int count = 0;
        for (Song song : songs) {
            if (song.getSinger().getSingerName().equalsIgnoreCase(keyword) || song.getDescriptions().equalsIgnoreCase(keyword)) {
                count++;
            }
        }

        Song[] foundSongs = new Song[count];
        int index = 0;
        for (Song song : songs) {
            if (song.getSinger().getSingerName().equalsIgnoreCase(keyword) || song.getDescriptions().equalsIgnoreCase(keyword)) {
                foundSongs[index++] = song;
            }
        }

        return foundSongs;
    }

    private void searchArtistByNameOrGenre() {
        System.out.println("Chọn 1 để tìm theo tên, 2 để tìm theo thể loại: ");
        int option = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (option) {
            case 1:
                System.out.println("Nhập tên ca sĩ: ");
                String artistName = scanner.nextLine();
                Singer[] foundSingersByName = singerService.searchSingersByName(artistName);
                displaySingers(foundSingersByName);
                break;
            case 2:
                System.out.println("Nhập thể loại: ");
                String genre = scanner.nextLine();
                Singer[] foundSingersByGenre = singerService.searchSingersByGenre(genre);
                displaySingers(foundSingersByGenre);
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
    }

    private void displaySongsInAscendingOrder() {
        Song[] songs = songService.getAllSongs();
        Arrays.sort(songs, Comparator.comparing(Song::getSongName)); // Sort by song name

        displaySongs(songs);
    }

    private void displaySongs(Song[] songs) {
        if (songs.length == 0) {
            System.out.println("Không tìm thấy bài hát phù hợp.");
        } else {
            System.out.println("Danh sách bài hát:");
            for (Song song : songs) {
                System.out.println(song);
            }
        }
    }

    private void displaySingers(Singer[] singers) {
        if (singers.length == 0) {
            System.out.println("Không tìm thấy ca sĩ phù hợp.");
        } else {
            System.out.println("Danh sách ca sĩ:");
            for (Singer singer : singers) {
                System.out.println(singer);
            }
        }
    }

    public static void main(String[] args) {
        SearchManagement searchManagement = new SearchManagement();
        searchManagement.showSearchMenu();
    }

}
