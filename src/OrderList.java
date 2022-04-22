import java.util.ArrayList;

public class OrderList {
  private ArrayList<Order> orderlist = new ArrayList<>();

  public void addOrderToOrderList(Order newOrder) {
    orderlist.add(newOrder);
  }

}
