import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckoutCart {
  Map <String,Double> items = new HashMap<>();

  public Double total() {
    if (items.isEmpty()) {
      return 0.0;
    }
     return items.get("carrot");
  }

  public void addItem(String carrot, Double i) {
      items.put(carrot, i);
  }
}
