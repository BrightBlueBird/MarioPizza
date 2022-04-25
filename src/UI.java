import java.time.LocalDateTime;
import java.util.Scanner;

public class UI {

  private Scanner input = new Scanner(System.in);
  private int options;

  private menukort menucard = new menukort();
  private OrderList orderList = new OrderList();
  private LocalDateTime time;


  public void intro() {

    Pizza Vesuvio = new Pizza("Vesuvio", 57, 1);
    Pizza Amerikaner = new Pizza("Amerikaner", 53, 2);
    Pizza Caccitore = new Pizza("Caccitore", 101, 3);
    Pizza Carbona = new Pizza("Carbona", 70, 4);
    Pizza Dennis = new Pizza("Dennis", 40, 5);
    Pizza Bertil = new Pizza ("Bertil", 57, 6);
    Pizza Silvia = new Pizza ("Silvia", 61, 7);
    Pizza Victoria = new Pizza ("Victoria", 61, 8);
    Pizza Toronfo = new Pizza ("Torofo", 61, 9);
    Pizza Capricciosa = new Pizza ("Capricciosa", 61, 10);
    Pizza Hawaii = new Pizza ("Hawaii", 61, 11);
    Pizza LeBlissola = new Pizza ("Le Blissola", 61, 12);
    Pizza Venezia = new Pizza ("Venezia", 61, 13);
    Pizza Mafia = new Pizza ("Mafia", 61, 14);
    Pizza Calzone = new Pizza ("Calzone", 61, 15);
    Pizza Kylling = new Pizza ("Kylling pizza", 61, 16);
    Pizza Salami = new Pizza ("Salami Pizza", 61, 17);
    Pizza Tun = new Pizza ("Tun Pizza", 61, 18);
    Pizza Pepperoni = new Pizza ("pepperoni Pizza", 61, 20);
    Pizza mamaRosa = new Pizza ("Mama Rosa", 61, 21);
    Pizza Venedig = new Pizza ("Venedig", 61, 22);
    Pizza Italiana = new Pizza ("Italiana", 61, 23);
    Pizza Florinta = new Pizza ("Florinta", 61, 24);
    Pizza potato = new Pizza ("Potato", 61, 25);
    Pizza Sara = new Pizza ("Sara Pizza", 61, 26);
    Pizza MamaMia = new Pizza ("Mama Mia", 61, 27);
    Pizza MarcoPolo = new Pizza ("Marco Polo", 61, 28);
    Pizza Pesot = new Pizza ("Pesot", 61, 29);
    Pizza Azteca = new Pizza ("Azteca", 61, 30);



    menukort menucard = new menukort();
    menucard.addpizza(Vesuvio);
    menucard.addpizza(Amerikaner);
    menucard.addpizza(Caccitore);
    menucard.addpizza(Carbona);
    menucard.addpizza(Dennis);
    menucard.addpizza(Bertil);
    menucard.addpizza(Silvia);
    menucard.addpizza(Victoria);
    menucard.addpizza(Toronfo);
    menucard.addpizza(Capricciosa);
    menucard.addpizza(Hawaii);
    menucard.addpizza(LeBlissola);
    menucard.addpizza(Venezia);
    menucard.addpizza(Mafia);
    menucard.addpizza(Calzone);
    menucard.addpizza(Kylling);
    menucard.addpizza(Salami);
    menucard.addpizza(Tun);
    menucard.addpizza(Pepperoni);
    menucard.addpizza(mamaRosa);
    menucard.addpizza(Venedig);
    menucard.addpizza(Italiana);
    menucard.addpizza(Florinta);
    menucard.addpizza(potato);
    menucard.addpizza(Sara);
    menucard.addpizza(MamaMia);
    menucard.addpizza(MarcoPolo);
    menucard.addpizza(Pesot);
    menucard.addpizza(Azteca);



    boolean isRunning = true;
    while (isRunning) {
      System.out.println("""
           Welcome to Marios Pizza Program
           you have the following  options:
           
           press 1 to see the menu card 
           press 2 to see the order list 
           press 3 to add pizza to list
           press 4 to edit order list 
           press 5 for payment    
           Press 6 to terminate program
          """);
      options = input.nextInt();

      switch (options) {
        case 1 -> {
          System.out.println("menu card");
          System.out.println(menucard.printmenucard());
        }
        case 2 -> {

          System.out.println(orderList.printOrderList());
        }
        case 3 -> {
          boolean anotherOrder = true;
          String newOrder;

          while (anotherOrder) {
            Payment payment = new Payment();
            int totalCost = 0;
            String orderName;
            System.out.println("What is the name of the customer?");
            input.nextLine(); //Scannerbug
            orderName = input.nextLine();
            System.out.println("Is the customer in house(1) or by phone(2)?");
            input.nextLine();
            int answer = input.nextInt();
            switch(answer) {
              case 1 -> {
                System.out.println("Does the customer want to pay immediately");
                input.nextLine(); //Scannerbug
                String immediately = input.nextLine();
                switch (immediately) {
                  case "yes" -> {
                    Order order = new Order(orderName, true);
                  }
                  case "no" -> {
                    Order order = new Order(orderName, false);
                  }
                }
              }
              case 2 -> {
                Order order = new Order(orderName, false, time);
              }
            }
            Order order = new Order(orderName, false);
            System.out.println("How many pizzas would you like to order?");
            // input order
            //How many pizzas
            //Input
            int orderAmount;
            orderAmount = input.nextInt();
            for (int i = 0; i < orderAmount; i++) {
              System.out.println(menucard.printmenucard());
              int pizzaNumber;
              System.out.println("choose pizza number");
              pizzaNumber = input.nextInt();
              Pizza check;
              check = menucard.checkMenuCard(pizzaNumber);
              if (check != null) {
                order.addPizzaToOrder(check);
                System.out.println("How many " + check.getName() + "'s");
                int pizzaTypeAmount;
                pizzaTypeAmount = input.nextInt();
                check.setAmount(pizzaTypeAmount);
                orderAmount = orderAmount - check.getAmount();
                totalCost = totalCost + payment.totalCost(order.getOrder());
              } else {
                System.out.println("Please pick a valid pizza");
                orderAmount = ++orderAmount;
              }
            }
            System.out.println("Your total cost is " + totalCost + "kr.");
            System.out.println("Will the customer pay immediately?");

            orderList.addOrderToOrderList(order);
            System.out.println("Do you want to add another order");
            input.nextLine(); //Scannerbug
            newOrder = input.nextLine();
            if (newOrder.equalsIgnoreCase("no")) {
              anotherOrder = false;
            }
          }
        }
        case 4 -> {
          System.out.println("Which order do you want to remove");
          String customerName;
          input.nextLine(); // Scannerbug
          customerName = input.nextLine();
          Order check;
          check = orderList.checkOrderExistence(customerName);
          if(check != null) {
            if(!check.getHasPayed()) {
              System.out.println("""
                  The customer hasn't payed yet. Please make sure the customer has payed,
                  before removing the order.""");
            }
            orderList.removeOrderFromOrderList(check);
            System.out.println(customerName + "'s order was removed");
          } else {
            System.out.println("Please write valid customer name");
          }
        }
        case 5 -> {
          System.out.println("Which order has been payed?");
          String customerName;
          input.nextLine(); // Scannerbug
          customerName = input.nextLine();
          Order check;
          check = orderList.checkOrderExistence(customerName);
          if(check != null) {
            if(!check.getHasPayed()) {
               check.setHasPayed(true);
            } else{
              System.out.println("Order has already been payed.");
            }
          } else{
            System.out.println("Error, order was not found.");
          }
        }
        case 6 -> {
          System.out.println("Program shuts down, goodbye!");
          isRunning = false;
        }
      }
    }
  }
}

