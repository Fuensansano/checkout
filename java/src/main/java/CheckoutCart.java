import java.util.HashMap;
import java.util.Map;

public class CheckoutCart {
  Map <String,Double> items = new HashMap<>();


  public Double total() {
    if (items.isEmpty()) {
      return 0.0;
    }

    Double totalPrice = 0d;

    for (Map.Entry<String,Double> item: items.entrySet()) {
      totalPrice += item.getValue();
    }

    return totalPrice;
  }

  public void addItem(String item, Double price) {
    if (items.get(item) == null) {
      items.put(item,price);
      return;
    }
      Double actualItemPrice = items.get(item);
      items.put(item, (actualItemPrice + price));
  }
}
