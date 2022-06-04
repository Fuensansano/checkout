import java.util.ArrayList;
import java.util.List;

public class CheckoutCart {
  public static final double CARROT_PRICE_OFFER = 130d;
  public static final int CARROT_NUMBER_OFFER = 3;
  private static final int ORANGE_NUMBER_OFFER = 2;
  private static final Double ORANGE_PRICE_OFFER = 45d;
  List<Product> itemsProvisional = new ArrayList<>();

  public Double total() {
    if (itemsProvisional.isEmpty()) {
      return 0.0;
    }

    Double totalPrice = 0d;
    Long carrotCount = itemsProvisional.stream()
      .filter(product -> product.name().equals("carrot"))
      .count();

    Long orangeCount = itemsProvisional.stream()
      .filter(product -> product.name().equals("orange"))
      .count();

    for (Product item: itemsProvisional) {
      if ( carrotCount >= CARROT_NUMBER_OFFER && item.name().equals("carrot")) {
        int timesToApplyOffer = (int) (carrotCount / CARROT_NUMBER_OFFER);
        return (CARROT_PRICE_OFFER * timesToApplyOffer) + item.price() * (carrotCount - (CARROT_NUMBER_OFFER * timesToApplyOffer));
      } else if (orangeCount >= ORANGE_NUMBER_OFFER && item.name().equals("orange")) {
        int timesToApplyOfferForOrange = (int) (orangeCount / ORANGE_NUMBER_OFFER);
        return (ORANGE_PRICE_OFFER * timesToApplyOfferForOrange) + item.price() * (orangeCount - (ORANGE_NUMBER_OFFER * timesToApplyOfferForOrange));
      }else {
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
