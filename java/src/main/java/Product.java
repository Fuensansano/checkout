public class Product {
  private String name;
  private Double price;

  public Product(String name, Double price) {
    this.name = name;
    this.price = price;
  }

  public String name() {
    return name;
  }

  public Double price() {
    return price;
  }
}
