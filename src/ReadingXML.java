import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ReadingXML {
    public List<Purpose> tasks = new ArrayList<>();

    public ReadingXML(File fName) {
        try (Scanner reading = new Scanner(new BufferedReader(new FileReader(fName)))) {
            StringBuilder stringBuilder = new StringBuilder();
            while (reading.hasNext()) {
                stringBuilder.append(reading.nextLine());
            }
            String str = stringBuilder.toString();
            str = str.replace("\n", "");
            int startIndex = 0;
            while (startIndex < str.length()) {
                int index1 = str.indexOf("<", startIndex);
                int index2 = str.indexOf(">", index1);
                String temporary = new String();
                if (index1 < 0) {
                    index2 = str.length();
                    temporary = "endOfFile";
                } else {
                    temporary = str.substring(index1, index2 + 1);
                }

                if (temporary.equals("<purpose>")) {
                    LocalDate createData = LocalDate.now();
                    LocalDate deadLine = LocalDate.now();
                    LocalTime createTime = LocalTime.now();
                    String author = new String();
                    String description = new String();
                    String priority = new String();
                    boolean purposeNotEnded = true;
                    while (purposeNotEnded) {
                        int tagIndexStart = str.indexOf("<", index2 + 1);
                        int tagIndexStop = str.indexOf(">", tagIndexStart);
                        String tag = str.substring(tagIndexStart, tagIndexStop + 1);
                        int nextTag = str.indexOf("<", tagIndexStop);
                        String tagValue = str.substring(tagIndexStop + 1, nextTag);
                        switch (tag) {
                            case ("<createDate>") -> {
                                createData = LocalDate.parse(tagValue);
                                index2 = nextTag + tag.length();
                            }
                            case ("<createTime>") -> {
                                createTime = LocalTime.parse(tagValue);
                                index2 = nextTag + tag.length();
                            }
                            case ("<deadline>") -> {
                                deadLine = LocalDate.parse(tagValue);
                                index2 = nextTag + tag.length();
                            }
                            case ("<author>") -> {
                                author = tagValue;
                                index2 = nextTag + tag.length();
                            }
                            case ("<purposeDescription>") -> {
                                description = tagValue;
                                index2 = nextTag + tag.length();
                            }
                            case ("<priority>") -> {
                                priority = tagValue;
                                index2 = nextTag + tag.length();
                            }
                            case ("</purpose>") -> {
                                purposeNotEnded = false;
                                index2 = tagIndexStop;
                            }
                        }

                    }
                    PurposePriority purposePriority = PurposePriority.valueOf(priority);
                    tasks.add(new Purpose(createData, createTime, deadLine, author, description, purposePriority));
                }
                startIndex = index2;
            }
            PurposeList.addAll(tasks);

        } catch (Exception e) {
            System.out.println("Ошибка чтения задач");
            System.out.println(e);
        }
    }

}

