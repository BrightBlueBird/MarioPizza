import java.util.Scanner;

public class UI {

  Scanner input = new Scanner(System.in);
  int options;

  menukort menucard = new menukort();


  public void intro() {

    Pizza hawai = new Pizza("hawai", 100, 1);
    Pizza kebab = new Pizza("kebab pizza", 99, 2);
    Pizza skinke = new Pizza("skinke pizza", 101, 3);
    Pizza vegetar = new Pizza("grøntpis pizza", 5000, 4);
    Pizza aids = new Pizza("aids pizza", 40, 5);

    menukort menucard = new menukort();
    menucard.addpizza(hawai);
    menucard.addpizza(kebab);
    menucard.addpizza(skinke);
    menucard.addpizza(vegetar);
    menucard.addpizza(aids);


    System.out.println("""
         welcome to mario´s pizza we are more than pleased that you chose our store
         you have the following  options:
         press 1 to see the menu card 
         press 2 to see the order list 
         press 3 to add pizza to list
         press 4 to edit order list 
         press 5 for payment    
        """);
    options = input.nextInt();

    switch (options) {
      case 1 -> {
        System.out.println("menu card");
        System.out.println(menucard.printmenucard());
      }
      case 2 -> {
        System.out.println("See order list");
      }
      case 3 -> {
        Order order = new Order();
        boolean isRunning = true;
        String newOrder;

        while (isRunning) {
          System.out.println("How many pizzas would you like to order?");
          // input order
          //How many pizzas
          //Input
          int orderAmount;
          orderAmount = input.nextInt();
          for (int i = 0; i < orderAmount; i++) {
            System.out.println("choose pizza number");
            int pizzaNumber = 2;
            Pizza check;
            check = menucard.checkMenuCard(pizzaNumber);

            if (check != null) {
              order.addPizzaToOrder(check);
            } else {
              System.out.println("Please pick a valid pizza");
            }
            System.out.println("How many" + check.getName() + "s");
            hawai.setAmount(3);
            orderAmount = orderAmount - hawai.getAmount();
          }
          System.out.println("Do you want to add another order");
          input.nextLine();
          newOrder = input.nextLine();
          if (newOrder.equalsIgnoreCase("no")) {
            isRunning = false;
          }
        }
      }
      case 4 -> {
        System.out.println("edit order list");
      }
      case 5 -> {
        System.out.println("payment");
      }

    }
  }
}
