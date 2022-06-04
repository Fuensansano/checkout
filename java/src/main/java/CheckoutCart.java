import java.util.ArrayList;
import java.util.List;

public class CheckoutCart {
  public static final double CARROT_PRICE_OFFER = 130d;
  public static final int CARROT_NUMBER_OFFER = 3;
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

      if (carrotCount % CARROT_NUMBER_OFFER == 0) {
        int timesToApplyOffer = (int) (carrotCount / CARROT_NUMBER_OFFER);
        return CARROT_PRICE_OFFER * timesToApplyOffer;
      } else if ( carrotCount > CARROT_NUMBER_OFFER && item.name().equals("carrot")) {
        return CARROT_PRICE_OFFER + item.price() * (carrotCount - CARROT_NUMBER_OFFER);
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
