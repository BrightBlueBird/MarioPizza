public class Pizza {
  final private String name;
  final private int price;
  final private int menuNumber;
  private int amount;



  Pizza(String name, int price, int menuNumber){
    this.name = name;
    this.price = price;
    this.menuNumber = menuNumber;
  }

  public int getPrice() {
    return price;
  }

  public int getMenuNumber() {
    return menuNumber;
  }

  public String getName() {
    return name;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public int getAmount() {
    return amount;
  }


  @Override
  public String toString() {
    return "\n" + "nr.: " + menuNumber + " " + name + " Price: " + price + "\n";
  }

}
