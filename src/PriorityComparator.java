import java.util.Comparator;


public class PriorityComparator implements Comparator<Purpose> {
@Override
public int compare(Purpose o1, Purpose o2) {
        return o1.getPurposePriority().compareTo(o2.getPurposePriority());
        }

        }


