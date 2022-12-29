import java.util.Comparator;


public class TermComparator implements Comparator<Purpose> {
    @Override
    public int compare(Purpose o1, Purpose o2) {
        return o1.getDeadline().compareTo(o2.getDeadline());
    }
}

