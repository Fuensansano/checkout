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
    addItemsToCart("carrot",1,50);
    assertEquals(50,cart.total());
  }

  @Test
  public void add_two_different_items_to_checkout_cart() {
    addItemsToCart("carrot",1,50);
    addItemsToCart("orange",1,30);
    assertEquals(80d,cart.total());
  }

  @Test
  public void add_same_items_twice_to_checkout_cart() {
    addItemsToCart("carrot",2,50);
    assertEquals(100d,cart.total());
  }

  @Test
  public void offers_price_buy_three_carrots() {
    addItemsToCart("carrot",3,50);
    assertEquals(130d,cart.total());
  }

  @Test
  public void offers_price_buy_four_carrots() {
    addItemsToCart("carrot",4,50);
    assertEquals(180d,cart.total());
  }

  @Test
  public void offers_price_buy_five_carrots() {
    addItemsToCart("carrot",5,50);
    assertEquals(230d,cart.total());
  }

  @Test
  public void offers_price_buy_six_carrots() {
    addItemsToCart("carrot",6,50);
    assertEquals(260d,cart.total());
  }

  @Test
  public void offers_price_buy_seven_carrots() {
    addItemsToCart("carrot",7,50);
    assertEquals(310d,cart.total());
  }

  @Test
  public void offers_price_buy_two_orange() {
    addItemsToCart("orange",2,30);
    assertEquals(45d,cart.total());
  }

  @Test
  public void offers_price_five_two_orange() {
    addItemsToCart("orange",5,30);
    assertEquals(120d,cart.total());
  }

  @Test
  public void two_offer_items() {
    addItemsToCart("orange",3,30);
    addItemsToCart("carrot",4,50);
    assertEquals(255d,cart.total());
  }

  public void addItemsToCart(String name, int quantity, double price) {
    for (int i = 0; i < quantity ; i++) {
      cart.addItem(name,price);
    }
  }

}
