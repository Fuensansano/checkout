import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CheckoutShould {

	@Test
	public void create_checkout_cart() {
    CheckoutCart cart = new CheckoutCart();
		assertEquals(0.0,cart.total());
	}

  @Test
  public void add_item_to_checkout_cart() {
    CheckoutCart cart = new CheckoutCart();
    cart.addItem("carrot");
    assertEquals(50,cart.total());
  }

}
