import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CheckoutCart {
  public static final double CARROT_PRICE_OFFER = 130d;
  public static final int CARROT_NUMBER_OFFER = 3;
  private static final int ORANGE_NUMBER_OFFER = 2;
  private static final Double ORANGE_PRICE_OFFER = 45d;
  List<Product> itemsProvisional = new ArrayList<>();
  private int carrotCount = 0;
  private int orangeCount = 0;
  private Double carrotPricePerUnit = 0d;
  private Double orangePricePerUnit = 0d;


  public Double total() {
    Double totalPrice = 0d;

    totalPrice += calculateDiscount(carrotCount, CARROT_NUMBER_OFFER, CARROT_PRICE_OFFER, carrotPricePerUnit);
    totalPrice += calculateDiscount(orangeCount, ORANGE_NUMBER_OFFER, ORANGE_PRICE_OFFER, orangePricePerUnit);

    return totalPrice;
  }

  private Double calculateDiscount(int itemCount, int numberOfItemsToApplyOffer, Double offerPrice, Double pricePerUnit) {
    int timesToApplyOffer = (int) (itemCount / numberOfItemsToApplyOffer);
    return  (offerPrice * timesToApplyOffer) + pricePerUnit * (itemCount - (numberOfItemsToApplyOffer * timesToApplyOffer));
  }

  public void addItem(String item, Double price) {
    if (item.equals("carrot")) {
      carrotPricePerUnit = price;
      carrotCount++;
    } else if (item.equals("orange")) {
      orangePricePerUnit = price;
      orangeCount++;
    }
    Product product = new Product(item, price);
    itemsProvisional.add(product);
  }
}
