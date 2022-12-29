import java.io.File;
import java.util.Scanner;


public class ReadingService {
    static Scanner sc = new Scanner(System.in);
    public static String path = "c:/Users/Bz/Desktop/Java_OOP/ДЗ от 22.12.2022/HW_5/PurposeList";

    public static void getChoice() {
        boolean repeatInput = true;
        while (repeatInput) {
            System.out.println("Из какого файла прочитать: 1-XML, 2-CSV, 3-JSON");
            switch (sc.next()) {
                case ("1") -> {
                    ReadingXML();
                    repeatInput = false;
                }
                case ("2") -> {
                    ReadingCSV();
                    repeatInput = false;
                }
                case ("3") -> {
                    ReadingJSON();
                    repeatInput = false;
                }
                default -> System.out.println("Ошибка чтения");
            }
        }
    }

    public static void ReadingXML() {
        path += ".xml";
        ReadingXML imp = new ReadingXML(new File(path));
    }

    public static void ReadingCSV() {
        path += ".csv";
        ReadingCSV imp = new ReadingCSV(new File(path));
    }

    public static void ReadingJSON() {
        path += ".json";
        ReadingJSON imp = new ReadingJSON(new File(path));
    }
}
