import java.util.Scanner;


public class DeletePurpose {
    static Scanner sc = new Scanner(System.in);

    public static void purposeDelete() {
        boolean repeatInput = true;
        int id = -1;
        while (repeatInput) {
            System.out.println("Введите ID задачи, которую нужно удалить: ");
            try {
                id = sc.nextInt();
                if (PurposeList.getPurposeById(id) != -1) {
                    repeatInput = false;
                    PurposeList.removeById(id);
                } else {
                    System.out.println("Неверный ID");
                }
            } catch (Exception ex) {
                System.out.println("Неверный ID");
            }

        }
    }

}



