import java.util.ArrayList;

public class Payment {
  private int price;
  public int totalCost (ArrayList<Pizza> currentOrder) {
    for (int i = 0; i < currentOrder.size(); i++) {
      price = currentOrder.get(i).getPrice() * currentOrder.get(i).getAmount();
    }
    return price;
  }
}
