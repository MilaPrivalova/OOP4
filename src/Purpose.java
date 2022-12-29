import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;


public class Purpose {
    private static int idCount = 0;
    private LocalDate addDate;
    private LocalTime addTime;
    private LocalDate deadline;
    private String author;
    private String description;
    private PurposePriority purposePriority;
    private int id;

    public Purpose(LocalDate addDate, LocalTime addTime, LocalDate deadline, String author, String description,
                   PurposePriority purposePriority) {
        this.addDate = addDate;
        this.addTime = addTime;
        this.deadline = deadline;
        this.author = author;
        this.description = description;
        this.purposePriority = purposePriority;
        this.id = ++idCount;
    }

    public LocalDate getAddDate() {
        return addDate;
    }

    public LocalTime getAddTime() {
        return addTime;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public PurposePriority getPurposePriority() {
        return purposePriority;
    }

    @Override
    public String toString() {
        Period gap = Period.between(LocalDate.now(), deadline);
        return "Задача{" +
                "id=" + id +
                ", дней до крайнего срока=" + gap.getYears() + "y:" + gap.getMonths() + "m:" + gap.getDays() +
                "d, дата создания=" + addDate +
                ", время создания=" + addTime +
                ", дедлайн=" + deadline +
                ", автор='" + author + '\'' +
                ", описание='" + description + '\'' +
                ", приоритет='" + purposePriority + '\'' +
                '}';
    }

    public static void print(Purpose purpose) {

        System.out.println("------------------------------------------------------");
        System.out.printf("ID задачи: \t\t%d\n", purpose.getId());
        System.out.printf("Дней до дедлайна: \t%s\n",
                purpose.getDeadline().toEpochDay() - LocalDate.now().toEpochDay());
        System.out.printf("дедлайн: \t\t%s\n", purpose.getDeadline());
        System.out.printf("Дата создания: \t\t%s\n", purpose.getAddDate());
        System.out.printf("Время создания: \t%s\n", purpose.getAddTime());
        System.out.printf("Автор : \t\t%s\n", purpose.getAuthor());
        System.out.printf("Описание: \t\t%s\n", purpose.getDescription());
        System.out.printf("Приоритет: \t\t%s\n", purpose.getPurposePriority());
        System.out.println("-------------------------------------------------------");
    }

    public static void print(int purposeById) {
    }
}


