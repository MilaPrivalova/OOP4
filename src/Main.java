import java.util.Scanner;


public class Main {
    static Scanner sc = new Scanner(System.in);

    public static String getValue() {
        System.out.println(
                "1-предыдущая задача\n2-следующая задача\n3-добавить задачу\n4-удалить задачу\n5-крайний срок обновления списка задач\n6-читать список задач\n7-записать список задач\n8-распечатать список задач");
        System.out.print("Введите цифру: ");
        return sc.next();
    }

    public static void main(String[] args) {
        int currentTask = 0;
        while (true) {
            if (PurposeList.getPurpose().size() > 0) {
                Purpose.print(PurposeList.getPurposeById(0));
            }
            switch (getValue()) {
                case ("1"):
                    currentTask--;
                    if (currentTask < 0) {
                        currentTask = PurposeList.getPurpose().size() - 1;
                    }
                    break;
                case ("2"):
                    currentTask++;
                    if (currentTask > PurposeList.getPurpose().size() - 1) {
                        currentTask = 0;
                    }
                    break;
                case ("3"):
                    AddPurpose.purposeAdd();
                    currentTask = 0;
                    break;
                case ("4"):
                    DeletePurpose.purposeDelete();
                    currentTask = 0;
                    break;
                case ("5"):
                    PurposeList.newTerm();
                    currentTask = 0;
                    break;
                case ("6"):
                    ReadingService.getChoice();
                    break;
                case ("7"):
                    WriteService.getChoice();
                    break;
                case ("8"):
                    for (Purpose task : PurposeList.getPurpose()) {
                        Purpose.print(task);
                    }
                    break;
                default:
                    System.out.println("Неверный ввод");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
            }
        }
    }
}