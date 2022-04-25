import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Order {
  private Pizza pizza;
  private ArrayList<Pizza> order = new ArrayList<>();
  final private String name;
  private boolean hasPayed;
  private LocalDateTime time;
  private String formattedTime;

  Order(String name, boolean hasPayed) {
    this.name = name;
    this.hasPayed = hasPayed;
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");
    this.formattedTime = LocalDateTime.now().format(myFormatObj);
  }

  Order(String name, boolean hasPayed, LocalDateTime time) {
    this.name = name;
    this.hasPayed = hasPayed;
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");
    this.formattedTime = time.format(myFormatObj);
  }

  public void addPizzaToOrder(Pizza pizza) {
    if (pizza != null) {
      order.add(pizza);
    }
  }

  public void timeFormatter() {
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");
    this.formattedTime = time.format(myFormatObj);
  }

  public ArrayList<Pizza> getOrder() {
    return order;
  }

  public String getPizzaName() {
    return pizza.getName();
  }

  public int getPizzaAmount() {
    return pizza.getAmount();
  }

  public String getOrderName() {
    return name;
  }

  public void setHasPayed(boolean hasPayed) {
    this.hasPayed = hasPayed;
  }

  public boolean getHasPayed() {
    return hasPayed;
  }

  public void setTimeStamp(String formattedTime) {

    this.formattedTime = formattedTime;
  }

  @Override
  public String toString() {
    return order +
        ", time='" + formattedTime + '\'' +
        ", name='" + name + '\'' +
        '}';
  }
}

