import java.util.HashMap;
import java.util.Map;

class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class VendingMachine {
    private Map<Integer, Product> products;
    private double currentBalance;

    public VendingMachine() {
        products = new HashMap<>();
        currentBalance = 0.0;
    }

    public void addProduct(int code, String name, double price) {
        products.put(code, new Product(name, price));
    }

    public void insertCoin(double coinValue) {
        if (coinValue == 0.05 || coinValue == 0.10 || coinValue == 0.20 ||
            coinValue == 0.50 || coinValue == 1.0 || coinValue == 2.0) {
            currentBalance += coinValue;
        }
    }

    public boolean makePurchase(int code) {
        if (products.containsKey(code)) {
            Product product = products.get(code);
            if (currentBalance >= product.price) {
                currentBalance -= product.price;
                return true;
            }
        }
        return false;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.addProduct(1, "Coca Cola", 1.0);
        vendingMachine.addProduct(2, "Redbull", 1.25);
        vendingMachine.addProduct(3, "Water", 0.5);
        vendingMachine.addProduct(4, "Orange Juice", 1.95);

        vendingMachine.insertCoin(2.0);  // Insert 2.0 coin
        vendingMachine.insertCoin(1.0);  // Insert 1.0 coin
        boolean purchaseSuccessful = vendingMachine.makePurchase(2);  // Attempt to purchase Redbull (code 2)
        double remainingBalance = vendingMachine.getCurrentBalance();  // Get remaining balance
        
        System.out.println("Purchase successful: " + purchaseSuccessful);
        System.out.println("Remaining balance: " + remainingBalance);
    }
}
