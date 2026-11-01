import java.util.*;

class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    void display() {
        System.out.println(id + ". " + name + " - ₹" + price);
    }
}

public class ShoppingCart {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Product> products = new ArrayList<>();
    static ArrayList<Product> cart = new ArrayList<>();

    public static void main(String[] args) {

        // Products
        products.add(new Product(1, "T-Shirt", 499));
        products.add(new Product(2, "Jeans", 999));
        products.add(new Product(3, "Shoes", 1499));
        products.add(new Product(4, "Watch", 799));

        int choice;

        do {
            System.out.println("\n===== SHOPPING CART =====");
            System.out.println("1. View Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Remove Product");
            System.out.println("5. Checkout");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    viewProducts();
                    break;

                case 2:
                    addToCart();
                    break;

                case 3:
                    viewCart();
                    break;

                case 4:
                    removeFromCart();
                    break;

                case 5:
                    checkout();
                    break;

                case 6:
                    System.out.println("Thank you for shopping!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);
    }

    static void viewProducts() {
        System.out.println("\n--- AVAILABLE PRODUCTS ---");

        for (Product p : products) {
            p.display();
        }
    }

    static void addToCart() {

        viewProducts();

        System.out.print("Enter product ID: ");
        int id = sc.nextInt();

        for (Product p : products) {

            if (p.id == id) {
                cart.add(p);
                System.out.println(p.name + " added to cart!");
                return;
            }
        }

        System.out.println("Product not found!");
    }

    static void viewCart() {

        if (cart.isEmpty()) {
            System.out.println("\nCart is empty!");
            return;
        }

        double total = 0;

        System.out.println("\n--- YOUR CART ---");

        for (Product p : cart) {
            System.out.println(p.name + " - ₹" + p.price);
            total += p.price;
        }

        System.out.println("----------------------");
        System.out.println("Total: ₹" + total);
    }

    static void removeFromCart() {

        if (cart.isEmpty()) {
            System.out.println("Cart is empty!");
            return;
        }

        viewCart();

        System.out.print("Enter product ID to remove: ");
        int id = sc.nextInt();

        for (Product p : cart) {

            if (p.id == id) {
                cart.remove(p);
                System.out.println(p.name + " removed from cart!");
                return;
            }
        }

        System.out.println("Product not found in cart!");
    }

    static void checkout() {

        if (cart.isEmpty()) {
            System.out.println("Cart is empty!");
            return;
        }

        sc.nextLine();

        System.out.println("\n===== CHECKOUT =====");

        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        System.out.print("Enter delivery address: ");
        String address = sc.nextLine();

        double total = 0;

        for (Product p : cart) {
            total += p.price;
        }

        System.out.println("\n===== ORDER CONFIRMATION =====");
        System.out.println("Customer : " + name);
        System.out.println("Phone    : " + phone);
        System.out.println("Address  : " + address);
        System.out.println("Total    : ₹" + total);
        System.out.println("Payment  : Cash on Delivery");
        System.out.println("Status   : Order Placed");

        cart.clear();

        System.out.println("\nThank you! Your order has been placed.");
    }
}
