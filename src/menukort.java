import java.util.ArrayList;

public class menukort {
 private ArrayList<Pizza> menucard = new ArrayList<>();

public void addpizza(Pizza pizza){

  menucard.add(pizza);
}
public ArrayList<Pizza> printmenucard(){
  return menucard;
}
public Pizza checkMenuCard(int menuNumber) {
  for (int i = 0; i < menucard.size(); i++) {
    Pizza check = menucard.get(i);
    if (menuNumber == check.getMenuNumber()) {
      return check;
    }
  }
  return null;
}
  }

