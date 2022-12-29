import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class WriteAsJSON {
    public WriteAsJSON(File file) {
        try (FileWriter fr = new FileWriter(file, false);) {
            StringBuilder strBuilder = new StringBuilder();
            strBuilder.append("{");
            int iterator = 1;
            for (Purpose task : PurposeList.getPurpose()) {
                strBuilder.append("\"задача");
                strBuilder.append(iterator);
                strBuilder.append("\":{\"Дата создания\":\"");
                strBuilder.append(task.getAddDate());
                strBuilder.append("\",\"Время создания\":\"");
                strBuilder.append(task.getAddTime());
                strBuilder.append("\",\"Дедлайн\":\"");
                strBuilder.append(task.getDeadline());
                strBuilder.append("\",\"Автор\":\"");
                strBuilder.append(task.getAuthor());
                strBuilder.append("\",\"Описание\":\"");
                strBuilder.append(task.getDescription());
                strBuilder.append("\",\"Приоритет\":\"");
                strBuilder.append(task.getPurposePriority());
                strBuilder.append("\"},");
                iterator++;
            }
            strBuilder.setLength(strBuilder.length() - 1);
            strBuilder.append("}");
            fr.append(strBuilder.toString());
        } catch (IOException e) {
            System.out.printf("Ошибка записи! %s", e);
        }

    }
}
