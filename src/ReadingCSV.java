import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;


public class ReadingCSV {
    public ReadingCSV(File fName) {
        try (Scanner reader = new Scanner(new BufferedReader(new FileReader(fName)))) {

            while (reader.hasNext()) {
                String str = reader.nextLine();
                if (!str.equals("\n")) {
                    String[] stringArray = str.split(";");
                    LocalDate createDate = LocalDate.parse(stringArray[0]);
                    LocalTime createTime = LocalTime.parse(stringArray[1]);
                    LocalDate deadline = LocalDate.parse(stringArray[2]);
                    String author = stringArray[3];
                    String description = stringArray[4];
                    String priority = stringArray[5];
                    PurposePriority purposePriority = PurposePriority.valueOf(priority);
                    PurposeList.add(new Purpose(createDate,
                            createTime,
                            deadline,
                            author,
                            description,
                            purposePriority));
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

