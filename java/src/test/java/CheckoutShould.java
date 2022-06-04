import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutShould {
  CheckoutCart cart;

  @BeforeEach
  public void create_checkout_cart() {
    cart = new CheckoutCart();
  }


  @Test
  public void add_item_to_checkout_cart() {
    cart.addItem("carrot", 50d);
    assertEquals(50,cart.total());
  }

  @Test
  public void add_two_different_items_to_checkout_cart() {
    cart.addItem("carrot", 50d);
    cart.addItem("orange", 30d);
    assertEquals(80d,cart.total());
  }

  @Test
  public void add_same_items_twice_to_checkout_cart() {
    cart.addItem("carrot", 50d);
    cart.addItem("carrot", 50d);
    assertEquals(100d,cart.total());
  }

  @Test
  public void offers_price_buy_three_carrots() {
    cart.addItem("carrot", 50d);
    cart.addItem("carrot", 50d);
    cart.addItem("carrot", 50d);
    assertEquals(130d,cart.total());
  }

  @Test
  public void offers_price_buy_four_carrots() {
    cart.addItem("carrot", 50d);
    cart.addItem("carrot", 50d);
    cart.addItem("carrot", 50d);
    cart.addItem("carrot", 50d);
    assertEquals(180d,cart.total());
  }

}
