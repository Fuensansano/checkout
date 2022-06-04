import java.util.HashMap;
import java.util.Map;

public class CheckoutCart {
  Map <String,Double> items = new HashMap<>();

  public Double total() {
    if (items.isEmpty()) {
      return 0.0;
    }
     return items.get("carrot");
  }

  public void addItem(String item, Double price) {
      items.put(item, price);
  }
}
