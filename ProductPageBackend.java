import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Product {
    private double price;
    private String name;
    private int quantity;
    private String ingredient;
    private String description;
    private double rating;
    private String manufacturer;
    private String brand;
    private String category;

    public Product(double price, String name, int quantity, String ingredient, String description, double rating,
                   String manufacturer, String brand, String category) {
        this.price = price;
        this.name = name;
        this.quantity = quantity;
        this.ingredient = ingredient;
        this.description = description;
        this.rating = rating;
        this.manufacturer = manufacturer;
        this.brand = brand;
        this.category = category;
    }

    // Getters and Setters
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", ingredient='" + ingredient + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", manufacturer='" + manufacturer + '\'' +
                ", brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

public class ProductPageBackend {
    private List<Product> products;

    public ProductPageBackend() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void sortProductsByPrice() {
        Collections.sort(products, Comparator.comparingDouble(Product::getPrice));
    }

    public void sortProductsByName() {
        Collections.sort(products, Comparator.comparing(Product::getName));
    }

    public void sortProductsByCategory() {
        Collections.sort(products, Comparator.comparing(Product::getCategory));
    }

    public List<Product> searchProductsByName(String searchTerm) {
        String lowerCaseSearchTerm = searchTerm.toLowerCase();
        return products.stream()
                .filter(product -> product.getName().toLowerCase().contains(lowerCaseSearchTerm))
                .collect(Collectors.toList());
    }

    public List<Product> searchProductsByCategory(String searchTerm) {
        String lowerCaseSearchTerm = searchTerm.toLowerCase();
        return products.stream()
                .filter(product -> product.getCategory().toLowerCase().contains(lowerCaseSearchTerm))
                .collect(Collectors.toList());
    }

    public List<Product> searchProductsByIngredient(String searchTerm) {
        String lowerCaseSearchTerm = searchTerm.toLowerCase();
        return products.stream()
                .filter(product -> product.getIngredient().toLowerCase().contains(lowerCaseSearchTerm))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        ProductPageBackend backend = new ProductPageBackend();

        // Create sample products
        Product product1 = new Product(9.99, "Product 1", 10, "Ingredient A", "Description 1", 4.5,
                "Manufacturer A", "Brand A", "Category A");
        Product product2 = new Product(19.99, "Product 2", 5, "Ingredient B", "Description 2", 3.8,
                "Manufacturer B", "Brand B", "Category B");
        Product product3 = new Product(14.99, "Product 3", 8, "Ingredient A", "Description 3", 4.2,
                "Manufacturer A", "Brand C", "Category A");
        Product product4 = new Product(24.99, "Product 4", 3, "Ingredient C", "Description 4", 4.0,
                "Manufacturer B", "Brand D", "Category C");
        Product product5 = new Product(12.99, "Product 5", 12, "Ingredient D", "Description 5", 4.7,
                "Manufacturer C", "Brand A", "Category D");

        backend.addProduct(product1);
        backend.addProduct(product2);
        backend.addProduct(product3);
        backend.addProduct(product4);
        backend.addProduct(product5);

        // Test sorting functionality
        System.out.println("Sorted products by price:");
        backend.sortProductsByPrice();
        backend.products.forEach(System.out::println);

        System.out.println("\nSorted products by name:");
        backend.sortProductsByName();
        backend.products.forEach(System.out::println);

        System.out.println("\nSorted products by category:");
        backend.sortProductsByCategory();
        backend.products.forEach(System.out::println);

        // Test searching functionality
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter the search term (name, category, or ingredient): ");
        String searchTerm = scanner.nextLine();

        System.out.println("\nSearch results for term: " + searchTerm);
        List<Product> searchResults = backend.searchProductsByName(searchTerm);
        searchResults.forEach(System.out::println);
        searchResults = backend.searchProductsByCategory(searchTerm);
        searchResults.forEach(System.out::println);
        searchResults = backend.searchProductsByIngredient(searchTerm);
        searchResults.forEach(System.out::println);
    }
}