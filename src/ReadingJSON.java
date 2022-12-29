import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ReadingJSON {
    public ReadingJSON(File file) {
        try (Scanner reader = new Scanner(new BufferedReader(new FileReader(file)))) {
            StringBuilder stringBuilder = new StringBuilder();
            while (reader.hasNext()) {
                stringBuilder.append(reader.nextLine());
            }
            String temporary = stringBuilder.toString();
            temporary = temporary.replace("\n", "");
            int startIndex = temporary.indexOf("{");
            int finishIndex = temporary.lastIndexOf("}");
            temporary = temporary.substring(startIndex + 1, finishIndex);
            temporary = temporary.trim();
            startIndex = temporary.indexOf("{");
            List<String> strings = new ArrayList<>();
            while (startIndex < temporary.length()) {
                finishIndex = temporary.indexOf("}", startIndex);
                strings.add(temporary.substring(startIndex + 1, finishIndex).trim());
                startIndex = temporary.indexOf("{", finishIndex + 1);
                if (startIndex < 0) {
                    startIndex = temporary.length();
                }
            }
            for (String purpose : strings) {
                boolean duplicate = true;
                startIndex = 0;
                LocalDate createDate = LocalDate.now();
                LocalDate deadline = LocalDate.now();
                LocalTime createTime = LocalTime.now();
                String author = new String();
                String description = new String();
                String priority = new String();
                while (duplicate) {
                    startIndex = purpose.indexOf("\"", startIndex);
                    finishIndex = purpose.indexOf("\"", startIndex + 1);
                    String tag = purpose.substring(startIndex + 1, finishIndex);
                    startIndex = purpose.indexOf("\"", finishIndex + 1);
                    finishIndex = purpose.indexOf("\"", startIndex + 1);
                    String value = purpose.substring(startIndex + 1, finishIndex);
                    startIndex = finishIndex + 1;
                    switch (tag) {
                        case ("createDate") -> createDate = LocalDate.parse(value);
                        case ("createTime") -> createTime = LocalTime.parse(value);
                        case ("deadline") -> deadline = LocalDate.parse(value);
                        case ("author") -> author = value;
                        case ("description") -> description = value;
                        case ("priority") -> priority = value;
                        default -> duplicate = false;

                    }
                    if (finishIndex == purpose.length() - 1) {
                        duplicate = false;
                    }
                }
                PurposePriority taskPriority = PurposePriority.valueOf(priority);
                PurposeList.add(new Purpose(createDate, createTime, deadline, author, description, taskPriority));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
