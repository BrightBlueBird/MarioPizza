public class test{

  public void go(){
    System.out.println("this is your order");
    menukort menukort = new menukort();
    Pizza hawai = new Pizza("hawai",100,1);
    menukort.addpizza(hawai);
    menukort.printmenucard();
    System.out.println(menukort.printmenucard());
  }



  public static void main(String[] args) {
    test g = new test();
    g.go();

    UI p = new UI();
    p.intro();



  }
}
