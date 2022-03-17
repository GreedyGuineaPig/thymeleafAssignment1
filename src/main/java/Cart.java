import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Cart {
    public final List<Item> items = new ArrayList<>();

    public double getItemsCount() {
        return items.size();
    }

    public double getTotal() {
        return items.stream().mapToDouble(Item::getTotalPrice).sum();
    }
}
