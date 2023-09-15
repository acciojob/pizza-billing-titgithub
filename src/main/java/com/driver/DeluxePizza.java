package com.driver;

public class Main {
    public static void main(String[] args) {
        Pizza pizza1 = new Pizza("Veg", false);
        pizza1.addExtraCheese();
        pizza1.addExtraToppings();
        pizza1.addPaperBag();
        System.out.println(pizza1.generateBill());

        DeluxePizza pizza2 = new DeluxePizza("Non-veg", false);
        pizza2.addExtraCheese();
        pizza2.addExtraToppings();
        System.out.println(pizza2.generateBill());
    }
}

// Pizza.java
public class Pizza {
    protected int basePrice;
    protected boolean extraCheese;
    protected boolean extraToppings;
    protected boolean paperBag;
    protected int totalPrice;

    public Pizza(String type, boolean isDeluxe) {
        if (type.equals("Veg")) {
            basePrice = 300;
        } else if (type.equals("Non-veg")) {
            basePrice = 400;
        }

        if (!isDeluxe) {
            extraCheese = false;
            extraToppings = false;
        }

        paperBag = false;
        totalPrice = basePrice;
    }

    public void addExtraCheese() {
        if (!extraCheese) {
            extraCheese = true;
            totalPrice += 80;
        }
    }

    public void addExtraToppings() {
        if (!extraToppings) {
            extraToppings = true;
            if (basePrice == 300) {
                totalPrice += 70;
            } else if (basePrice == 400) {
                totalPrice += 120;
            }
        }
    }

    public void addPaperBag() {
        if (!paperBag) {
            paperBag = true;
            totalPrice += 20;
        }
    }

    public String generateBill() {
        StringBuilder bill = new StringBuilder();
        bill.append("Base Price Of The Pizza: ").append(basePrice).append("\n");
        if (extraCheese) {
            bill.append("Extra Cheese Added: 80\n");
        }
        if (extraToppings) {
            if (basePrice == 300) {
                bill.append("Extra Toppings Added: 70\n");
            } else if (basePrice == 400) {
                bill.append("Extra Toppings Added: 120\n");
            }
        }
        if (paperBag) {
            bill.append("Paperbag Added: 20\n");
        }
        bill.append("Total Price: ").append(totalPrice).append("\n");

        return bill.toString();
    }
}

// DeluxePizza.java
public class DeluxePizza extends Pizza {
    public DeluxePizza(String type, boolean isDeluxe) {
        super(type, true);
    }
}