import java.util.ArrayList;
import java.util.List;


public class PurposeList {
    private final static List<Purpose> purpose = new ArrayList<>();

    public static List<Purpose> getPurpose() {
        return purpose;
    }

    public static void add(Purpose purposes) {
        purpose.add(purposes);
    }

    public static void addAll(List<Purpose> purposes) {
        purposes.addAll(purposes);
    }

    public static int getPurposeById(int id) {
        int i = 0;
        boolean notFound = true;
        while (notFound && i < purpose.size()) {
            if (purpose.get(i).getId() == id) {
                notFound = false;
            } else {
                i++;
            }
        }
        if (notFound) {
            i = -1;
        }
        return i;
    }

    public static void removeById(int id) {
        if (getPurposeById(id) > -1) {
            int index = getPurposeById(id);
            purpose.remove(index);
        }
    }

    public static void newTerm() {
        purpose.sort(new TermComparator());
    }

    public static void newPriority() {
        purpose.sort(new PriorityComparator());
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Purpose element : purpose) {
            str.append(element + "\n");
        }
        return str.toString();

    }
}


