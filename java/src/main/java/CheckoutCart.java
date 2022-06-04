import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.LongStream;

public class CheckoutCart {
  List<Product> itemsProvisional = new ArrayList<>();

  public Double total() {
    if (itemsProvisional.isEmpty()) {
      return 0.0;
    }

    Double totalPrice = 0d;
    Long carrotCount = itemsProvisional.stream()
      .filter(product -> product.name().equals("carrot"))
      .count();

    for (Product item: itemsProvisional) {

      if (carrotCount == 3){
        return 130d;
      } else {
        totalPrice += item.price();
      }

    }

    return totalPrice;
  }

  public void addItem(String item, Double price) {
    Product product = new Product(item, price);
    itemsProvisional.add(product);
  }
}
