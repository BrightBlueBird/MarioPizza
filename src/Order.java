import java.util.ArrayList;

public class Order {
  private Pizza pizza;
  private ArrayList<Pizza> order = new ArrayList<>();
  private String time;
  private String name;

  Order(String name) {
    this.name = name;
  }

  public void addPizzaToOrder(Pizza pizza) {
    if (pizza != null) {
      order.add(pizza);
    }
  }

  public ArrayList<Pizza> getOrder() {
    return order;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public String getPizzaName() {
    return pizza.getName();
  }

  public int getPizzaAmount() {
    return pizza.getAmount();
  }

  public String getTime() {
    return time;
  }

  public String getOrderName() {
    return name;
  }

  @Override
  public String toString() {
    return order +
        ", time='" + time + '\'' +
        ", name='" + name + '\'' +
        '}';
  }
}

