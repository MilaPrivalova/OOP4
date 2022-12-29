import java.io.File;
import java.util.Scanner;


public class WriteService {
    public static String path = "c:/Users/Bz/Desktop/Java_OOP/ДЗ от 22.12.2022/HW_5/PurposeList";
    static Scanner sc = new Scanner(System.in);

    public static void getChoice() {

        while (true) {
            System.out.println("Записать в формате: 1-XML, 2-CSV, 3-JSON");
            switch (sc.next()) {
                case ("1") -> {
                    writeAsXML();
                    break;
                }
                case ("2") -> {
                    writeAsCSV();
                    break;
                }
                case ("3") -> {
                    writeAsJSON();
                    break;
                }
                default -> System.out.println("Ошибка записи");
            }
        }
    }

    public static void writeAsXML() {
        path += ".xml";
        WriteAsXML purp = new WriteAsXML(new File(path));
    }

    public static void writeAsCSV() {
        path += ".csv";
        WriteAsCSV purp = new WriteAsCSV(new File(path));
    }

    public static void writeAsJSON() {
        path += ".json";
        WriteAsJSON purp = new WriteAsJSON(new File(path));
    }

}

