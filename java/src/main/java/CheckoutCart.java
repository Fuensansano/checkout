import java.util.HashMap;
import java.util.Map;

public class CheckoutCart {
  Map <String,Double> items = new HashMap<>();
  Map <String,Integer> quantity = new HashMap<>();

  public Double total() {
    if (items.isEmpty()) {
      return 0.0;
    }

    Double totalPrice = 0d;

    for (Map.Entry<String,Double> item: items.entrySet()) {
      if (item.getKey().equals("carrot") && quantity.get(item.getKey()).equals(3)){
        totalPrice += 130;
      } else {
        totalPrice += item.getValue() * quantity.get(item.getKey());
      }

    }

    return totalPrice;
  }

  public void addItem(String item, Double price) {
    if (items.get(item) == null) {
      items.put(item,price);
      quantity.put(item, 1);
      return;
    }
    /*
      Double actualItemPrice = items.get(item);
      items.put(item, (actualItemPrice + price));

     */
    Integer actualQuantity = quantity.get(item);
    quantity.put(item, actualQuantity + 1);

  }
}
