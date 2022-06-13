import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutShould {
  CheckoutCart cart;
  private final static double CARROT_PRICE = 50d;
  private final static double ORANGE_PRICE = 30d;

  @BeforeEach
  public void create_checkout_cart() {
    cart = new CheckoutCart();
  }

  @Test
  public void total_empty_cart() {
    assertEquals(0,cart.total());
  }

  @Test
  public void add_item_to_checkout_cart() {
    cart.addItem("carrot",CARROT_PRICE,1);
    assertEquals(50,cart.total());
  }

  @Test
  public void add_two_different_items_to_checkout_cart() {
    cart.addItem("carrot",CARROT_PRICE,1);
    cart.addItem("orange",ORANGE_PRICE,1);
    assertEquals(80d,cart.total());
  }

  @Test
  public void add_same_items_twice_to_checkout_cart() {
    cart.addItem("carrot",CARROT_PRICE,2);
    assertEquals(100d,cart.total());
  }

  @Test
  public void offers_price_buy_three_carrots() {
    cart.addItem("carrot",CARROT_PRICE,3);
    assertEquals(130d,cart.total());
  }

  @Test
  public void offers_price_buy_four_carrots() {
    cart.addItem("carrot",CARROT_PRICE,4);
    assertEquals(180d,cart.total());
  }

  @Test
  public void offers_price_buy_five_carrots() {
    cart.addItem("carrot",CARROT_PRICE,5);
    assertEquals(230d,cart.total());
  }

  @Test
  public void offers_price_buy_six_carrots() {
    cart.addItem("carrot",CARROT_PRICE,6);
    assertEquals(260d,cart.total());
  }

  @Test
  public void offers_price_buy_seven_carrots() {
    cart.addItem("carrot",CARROT_PRICE,7);
    assertEquals(310d,cart.total());
  }

  @Test
  public void offers_price_buy_two_orange() {
    cart.addItem("orange",ORANGE_PRICE,2);
    assertEquals(45d,cart.total());
  }

  @Test
  public void offers_price_five_two_orange() {
    cart.addItem("orange",ORANGE_PRICE,5);
    assertEquals(120d,cart.total());
  }

  @Test
  public void two_offer_items() {
    cart.addItem("orange",ORANGE_PRICE, 3);
    cart.addItem("carrot",CARROT_PRICE, 4);
    assertEquals(255d,cart.total());
  }

}
