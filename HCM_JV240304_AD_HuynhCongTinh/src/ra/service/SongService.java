//package ra.service;
//
//import ra.model.Singer;
//import ra.model.Song;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.Date;
//import java.util.Scanner;
//
//public class SongService {
//    private Song[] songs;
//
//    public SongService(Song[] songs) {
//        this.songs = songs;
//    }
//
//    public SongService() {
//        this.songs = new Song[0];
//    }
//
//    public void addSong() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Nhập số lượng bài hát cần thêm: ");
//        int numberOfSongs = scanner.nextInt();
//        scanner.nextLine(); // Consume newline
//
//        Song[] newSongs = new Song[numberOfSongs];
//
//        for (int i = 0; i < numberOfSongs; i++) {
//            System.out.println("Nhập thông tin bài hát thứ " + (i + 1) + ":");
//
//            while (true) {
//                System.out.print("Nhập tên bài hát: ");
//                String name = scanner.nextLine();
//                if (name.length() < 0) {
//                    System.out.println("Tên bài hát không được để trống. Vui lòng nhập lại.");
//                }
//            }
//
//            while (true) {
//                System.out.print("Mô tả: ");
//                String descriptions = scanner.nextLine();
//                if (descriptions.length() < 0) {
//                    System.out.println("Mô tả không được để trống. Vui lòng nhập lại.");
//                }
//
//                String singerName;
//                while (true) {
//                    System.out.print("Ca sĩ trình bày: ");
//                    singerName = scanner.nextLine();
//                    if (!singerName.trim().isEmpty()) {
//                        break;
//                    }
//                    System.out.println("Tên ca sĩ không được để trống. Vui lòng nhập lại.");
//                }
//                Singer singer = new Singer(singerName);
//
//                while (true) {
//                    System.out.print("Người sáng tác: ");
//                    String author = scanner.nextLine();
//                    if (author.length() < 0) {
//                        System.out.println("Tên tác giả không được để trống. Vui lòng nhập lại.");
//                    }
//                }
//
//                Date makingDate;
//                while (true) {
//                    System.out.print("Ngày tạo (YYYY-MM-DD): ");
//                    try {
//                        makingDate = new SimpleDateFormat("YYYY-MM-DD").parse(scanner.nextLine());
//                        break;
//                    } catch (ParseException e) {
//                        System.out.println("Định dạng ngày không hợp lệ. Vui lòng nhập lại (YYY-MM-DD): ");
//                    }
//                }
//
//                System.out.print("Trạng thái (true/false): ");
//                boolean status = scanner.nextBoolean();
//                scanner.nextLine(); // Consume newline
//
//                newSongs[i] = new Song();
//
//                System.out.println("Đã thêm bài hát: " + newSongs[i]);
//            }
//
//            // Combine existing songs with new songs
//            Song[] allSongs = Arrays.copyOf(songs, songs.length + numberOfSongs);
//            System.arraycopy(newSongs, 0, allSongs, songs.length, numberOfSongs);
//            this.songs = allSongs;
//        }
//
//
//        public void updateSong (String id){
//            Scanner scanner = new Scanner(System.in);
//            SingerService singerService = new SingerService(); // Instantiate SingerService if not done already
//
//            for (Song song : songs) {
//                if (song.getSongId().equals(id)) {
//                    System.out.println("Nhập thông tin mới cho bài hát:");
//
//                    System.out.print("Tên bài hát: ");
//                    song.setSongName(scanner.nextLine());
//
//                    System.out.print("Mô tả: ");
//                    song.setDescriptions(scanner.nextLine());
//
//                    System.out.print("Ca sĩ trình bày: ");
//                    String singerId = scanner.nextLine();
//
//                    System.out.println("Người sáng tác: ");
//                    String author = scanner.nextLine();
//
//                }
//            }
//
//            System.out.println("Không tìm thấy bài hát với mã ID: " + id);
//        }
//
//        public Song[] getLatestSongs ( int count){
//            // Check if there are enough songs to retrieve
//            if (count <= 0 || count > songs.length) {
//                System.out.println("Không có đủ bài hát để trả về.");
//                return new Song[0]; // Return empty array if count is invalid
//            }
//
//            // Sort songs based on creation date in descending order
//            Arrays.sort(songs, Comparator.comparing(Song::getCreatedDate).reversed());
//
//            // Create a new array to store the latest songs
//            return Arrays.copyOfRange(songs, 0, count);
//        }
//
//        public Song[] getAllSongs () {
//            return songs;
//        }
//
//        public void displayAllSongs () {
//            for (Song song : songs) {
//                System.out.println(song);
//            }
//        }
//        public void deleteSong ( int id){
//            Song[] newSongs = new Song[songs.length - 1];
//            int index = 0;
//            for (Song song : songs) {
//                if (!song.getSongId().equals(id)) {
//                    newSongs[index++] = song;
//                }
//            }
//            if (index == songs.length) {
//                System.out.println("Không tìm thấy bài hát với mã ID: " + id);
//                return;
//            }
//            this.songs = newSongs;
//            System.out.println("Bài hát với mã ID " + id + " đã được xoá.");
//        }
//    }
//}

package ra.service;

import ra.model.Singer;
import ra.model.Song;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class SongService {
    private Song[] songs;

    public SongService(Song[] songs) {
        this.songs = songs;
    }

    public SongService() {
        this.songs = new Song[0];
    }

    public void addSong() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng bài hát cần thêm: ");
        int numberOfSongs = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Song[] newSongs = new Song[numberOfSongs];

        for (int i = 0; i < numberOfSongs; i++) {
            System.out.println("Nhập thông tin bài hát thứ " + (i + 1) + ":");

            String name;
            while (true) {
                System.out.print("Nhập tên bài hát: ");
                name = scanner.nextLine();
                if (!name.trim().isEmpty()) {
                    break;
                }
                System.out.println("Tên bài hát không được để trống. Vui lòng nhập lại.");
            }

            String descriptions;
            while (true) {
                System.out.print("Mô tả: ");
                descriptions = scanner.nextLine();
                if (!descriptions.trim().isEmpty()) {
                    break;
                }
                System.out.println("Mô tả không được để trống. Vui lòng nhập lại.");
            }

            String singerName;
            while (true) {
                System.out.print("Ca sĩ trình bày: ");
                singerName = scanner.nextLine();
                if (!singerName.trim().isEmpty()) {
                    break;
                }
                System.out.println("Tên ca sĩ không được để trống. Vui lòng nhập lại.");
            }
            Singer singer = new Singer();

            String author;
            while (true) {
                System.out.print("Người sáng tác: ");
                author = scanner.nextLine();
                if (!author.trim().isEmpty()) {
                    break;
                }
                System.out.println("Tên tác giả không được để trống. Vui lòng nhập lại.");
            }

            Date makingDate;
            while (true) {
                System.out.print("Ngày tạo (yyyy-MM-dd): ");
                try {
                    makingDate = new SimpleDateFormat("yyyy-MM-dd").parse(scanner.nextLine());
                    break;
                } catch (ParseException e) {
                    System.out.println("Định dạng ngày không hợp lệ. Vui lòng nhập lại (yyyy-MM-dd): ");
                }
            }

            System.out.print("Trạng thái (true/false): ");
            boolean status = scanner.nextBoolean();
            scanner.nextLine(); // Consume newline

            newSongs[i] = new Song(name, descriptions, singer, author, makingDate, status);
            System.out.println("Đã thêm bài hát: " + name);
        }

        // Combine existing songs with new songs
        Song[] allSongs = Arrays.copyOf(songs, songs.length + numberOfSongs);
        System.arraycopy(newSongs, 0, allSongs, songs.length, numberOfSongs);
        this.songs = allSongs;
    }

    public void updateSong(String id) {
        Scanner scanner = new Scanner(System.in);
        SingerService singerService = new SingerService(); // Instantiate SingerService if not done already

        for (Song song : songs) {
            if (song.getSongId().equals(id)) {
                System.out.println("Nhập thông tin mới cho bài hát:");

                System.out.print("Tên bài hát: ");
                song.setSongName(scanner.nextLine());

                System.out.print("Mô tả: ");
                song.setDescriptions(scanner.nextLine());

                String singerName;
                while (true) {
                    System.out.print("Ca sĩ trình bày: ");
                    singerName = scanner.nextLine();
                    if (!singerName.trim().isEmpty()) {
                        break;
                    }
                    System.out.println("Tên ca sĩ không được để trống. Vui lòng nhập lại.");
                }
                Singer singer = new Singer();
                song.setSinger(singer);

                System.out.print("Người sáng tác: ");
                song.setSongWriter(scanner.nextLine());

                System.out.println("Thông tin bài hát đã được cập nhật.");
                return; // Exit the method after updating the song
            }
        }

        System.out.println("Không tìm thấy bài hát với mã ID: " + id);
    }

    public Song[] getLatestSongs(int count) {
        // Check if there are enough songs to retrieve
        if (count <= 0 || count > songs.length) {
            System.out.println("Không có đủ bài hát để trả về.");
            return new Song[0]; // Return empty array if count is invalid
        }

        // Sort songs based on creation date in descending order
        Arrays.sort(songs, Comparator.comparing(Song::getCreatedDate).reversed());

        // Create a new array to store the latest songs
        return Arrays.copyOfRange(songs, 0, count);
    }

    public Song[] getAllSongs() {
        return songs;
    }

    public void displayAllSongs() {
        for (Song song : songs) {
            System.out.println(song);
        }
    }

    public void deleteSong(String id) {
        if (songs.length == 0) {
            System.out.println("Không có bài hát nào để xoá.");
            return;
        }
        int newSize = songs.length - 1;
        Song[] newSongs = new Song[newSize];
        int index = 0;
        boolean found = false;
        for (Song song : songs) {
            if (song.getSongId().equals(id)) {
                found = true;
                continue;
            }
            newSongs[index++] = song;
        }
        if (!found) {
            System.out.println("Không tìm thấy bài hát với mã ID: " + id);
            return;
        }
        this.songs = newSongs;
        System.out.println("Bài hát với mã ID " + id + " đã được xoá.");
    }



}
