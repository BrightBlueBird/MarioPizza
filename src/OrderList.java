import java.util.ArrayList;

public class OrderList {
  private ArrayList<Order> orderlist = new ArrayList<>();


  public void addOrderToOrderList(Order newOrder) {
    orderlist.add(newOrder);
  }

  public void removeOrderFromOrderList(Order oldOrder) {
    orderlist.remove(oldOrder);
  }

  public ArrayList<Order> printOrderList() {
    return orderlist;
  }

  public Order checkOrderExistence(String customerName) {
    for (int i = 0; i < orderlist.size(); i++) {
      Order check = orderlist.get(i);
      if (check.getOrderName().equalsIgnoreCase(customerName)) {
        return check;
      }
    }
    return null;
  }


  @Override
  public String toString() {
    return "OrderList{" +
        "orderlist=" + orderlist +
        '}';
  }
}
