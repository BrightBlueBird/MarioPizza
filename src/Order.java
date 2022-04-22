import java.util.ArrayList;

public class Order {
  private ArrayList<Pizza> order = new ArrayList<>();
  private String time;

  public void addPizzaToOrder(Pizza pizza){
    if(pizza != null){
    order.add(pizza);
    }
  }

  public void setTime(String time) {
    this.time = time;
  }

  public String getTime() {
    return time;
  }
}
