import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;


public class Order {
  private ArrayList<Pizza> order = new ArrayList<>();
  final private String name;
  private boolean hasPayed;
  private LocalDateTime time;
  private String formattedTime;


  Order(String name, boolean hasPayed) {
    this.name = name;
    this.hasPayed = hasPayed;
    time = LocalDateTime.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");
    formattedTime = time.format(myFormatObj);
  }

  public void addPizzaToOrder(Pizza pizza) {
    if (pizza != null) {
      order.add(pizza);
    }
  }

  public void addAmountOfTime(int hours, int minutes) {
    LocalDateTime otherTime = time.plus(hours, ChronoUnit.HOURS);
    LocalDateTime otherOtherTime = otherTime.plus(minutes, ChronoUnit.MINUTES);
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");
    formattedTime = otherOtherTime.format(myFormatObj);
  }


  public ArrayList<Pizza> getOrder() {
    return order;
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

  @Override
  public String toString() {
    return order +
        ", time='" + formattedTime + '\'' +
        ", name='" + name + '\'' +
        '}';
  }
}

