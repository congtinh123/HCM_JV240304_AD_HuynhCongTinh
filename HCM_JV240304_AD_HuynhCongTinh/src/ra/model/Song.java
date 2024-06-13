//package ra.model;
//
//import java.util.Date;
//import java.util.Scanner;
//
//public class Song {
//    private String songId;
//    private String songName;
//    private String descriptions;
//    private Singer singer;
//    private String songWriter;
//    private Date createdDate;
//    private boolean songStatus;
//    public int autoSongId = 1 ;
//
//    public Song() {
//        this.createdDate = new Date();
//    }
//
//    public Song(String songId, String songName, String descriptions, Singer singer, String songWriter, boolean songStatus) {
//        this.songId = new String(String.valueOf(autoSongId++));
//        this.songName = songName;
//        this.descriptions = descriptions;
//        this.singer = singer;
//        this.songWriter = songWriter;
//        this.createdDate = new Date();
//        this.songStatus = songStatus;
//    }
//
//    public String getSongId() {
//        return songId;
//    }
//
//    public void setSongId(String songId) {
//        this.songId = songId;
//    }
//
//    public String getSongName() {
//        return songName;
//    }
//
//    public void setSongName(String songName) {
//        this.songName = songName;
//    }
//
//    public String getDescriptions() {
//        return descriptions;
//    }
//
//    public void setDescriptions(String descriptions) {
//        this.descriptions = descriptions;
//    }
//
//    public Singer getSinger() {
//        return singer;
//    }
//
//    public void setSinger(Singer singer) {
//        this.singer = singer;
//    }
//
//    public String getSongWriter() {
//        return songWriter;
//    }
//
//    public void setSongWriter(String songWriter) {
//        this.songWriter = songWriter;
//    }
//
//    public Date getCreatedDate() {
//        return createdDate;
//    }
//
//    public boolean isSongStatus() {
//        return songStatus;
//    }
//
//    public void setSongStatus(boolean songStatus) {
//        this.songStatus = songStatus;
//    }
//
//    public void inputData(Singer[] singers, int singerCount) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Nhập id bài hát: ");
//        this.songId = scanner.nextLine();
//        while (this.songId.length() != 4 || !this.songId.startsWith("S")) {
//            System.out.print("Mã số bài hát phải dài hơn 4 ký tự và phải bắt đầu bằng chữ 'S'.Vui lòng nhập lại: ");
//            this.songId = scanner.nextLine();
//        }
//
//        System.out.print("Nhập tên bài hát: ");
//        this.songName = scanner.nextLine();
//        while (this.songName.isEmpty()) {
//            System.out.print("Không tìm thấy bài hát,vui lòng nhập lại: ");
//            this.songName = scanner.nextLine();
//        }
//
//        System.out.print("Nhập mô tả bài hát: ");
//        this.descriptions = scanner.nextLine();
//
//        System.out.println("Ca sĩ có sẵn: ");
//        for (int i = 0; i < singerCount; i++) {
//            System.out.println((i + 1) + ". " + singers[i].getSingerName());
//        }
//
//        System.out.print("Nhập mã bài hát: ");
//        int singerId = scanner.nextInt();
//        this.singer = null;
//        for (int i = 0; i < singerCount; i++) {
//            if (singers[i].getSingerId() == singerId) {
//                this.singer = singers[i];
//                break;
//            }
//        }
//
//        while (this.singer == null) {
//            System.out.println("Không tìm thấy tên ca sĩ,vui lòng thêm ca sĩ trước.");
//            Singer newSinger = new Singer();
//            newSinger.toString();
//            singers[singerCount++] = newSinger;
//            System.out.print("Nhập mã số ca sĩ: ");
//            singerId = scanner.nextInt();
//            for (int i = 0; i < singerCount; i++) {
//                if (singers[i].getSingerId() == singerId) {
//                    this.singer = singers[i];
//                    break;
//                }
//            }
//        }
//
//        scanner.nextLine();
//        System.out.print("Nhập tác giả bài hát: ");
//        this.songWriter = scanner.nextLine();
//        while (this.songWriter.isEmpty()) {
//            System.out.print("Tác giả không đươc để trống,vui lòng nhập lại: ");
//            this.songWriter = scanner.nextLine();
//        }
//
//        System.out.print("Nhập trạng thái bài hát(đúng,sai): ");
//        this.songStatus = scanner.nextBoolean();
//    }
//
//    public void displayData() {
//        System.out.println("Mã số bài hát: " + this.songId);
//        System.out.println("Tên bài hát: " + this.songName);
//        System.out.println("Mô tả bàu hát: " + this.descriptions);
//        System.out.println("Ca sĩ trình bày: " + this.singer);
//        System.out.println("Tác giả bài hát: " + this.songWriter);
//        System.out.println("Ngày tạo bài hát: " + this.createdDate);
//        System.out.println("Trạng thái bài hát: " + (this.songStatus ? "Hoạt động" : "Ngừng hoạt động"));
//    }
//    public void inputData(){
//    }
//}
package ra.model;
import ra.model.Singer;
import java.util.Date;
import java.util.Scanner;
public class Song {
    private static int autoSongId = 1;
    private String songId;
    private String songName;
    private String descriptions;
    private Singer singer;
    private String songWriter;
    private Date createdDate;
    private boolean songStatus;

    public Song(String songName, String descriptions, Singer singer, String songWriter, Date createdDate, boolean songStatus) {
        this.songId = String.valueOf(autoSongId++);
        this.songName = songName;
        this.descriptions = descriptions;
        this.singer = singer;
        this.songWriter = songWriter;
        this.createdDate = createdDate;
        this.songStatus = songStatus;
    }

    public Song() {
    }

    // Getters and setters
    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isSongStatus() {
        return songStatus;
    }

    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }

    @Override
    public String toString() {
        return "Song{" +
                "songId='" + songId + '\'' +
                ", songName='" + songName + '\'' +
                ", descriptions='" + descriptions + '\'' +
                ", songWriter='" + songWriter + '\'' +
                ", createdDate=" + createdDate +
                ", songStatus=" + songStatus +
                '}';
    }

    // Method to input data

    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Tên bài hát: ");
        this.songName = scanner.nextLine();
        System.out.print("Mô tả: ");
        this.descriptions = scanner.nextLine();
        System.out.print("Ca sĩ: ");
        this.singer = new Singer();
        System.out.print("Nhạc sĩ: ");
        this.songWriter = scanner.nextLine();
        this.createdDate = new Date();
        System.out.print("Trạng thái bài hát (true/false): ");
        this.songStatus = scanner.nextBoolean();
    }
}
