import java.util.*;

class Product{
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
    
    public String toString()
    {
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
    
   public static void main(String args[])
   {
     List<Product> products = new ArrayList<>();
    Product product1 = new Product(12, "cream", 2, "milk", "Use according to Sunlight", 2, "LocalKing", "Sun Pharma", "cosmetic");
      products.add(product1);
    Product product2 = new Product(89, "binaon", 2, "milk", "Use according to Sunlight", 2, "LocalKing", "Sun Pharma", "cosmetic");
    products.add(product2);
    Product product3 = new Product(2, "cream", 2, "milk", "Use according to Sunlight", 2, "LocalKing", "Sun Pharma", "cosmetic");
    products.add(product3);
    Product product4 = new Product(86, "dsamm", 2, "milk", "Use according to Sunlight", 2, "LocalKing", "Sun Pharma", "cosmetic");
    products.add(product4);
    Product product5 = new Product(10, "fsream", 2, "milk", "Use according to Sunlight", 2, "LocalKing", "Sun Pharma", "cosmetic");
    products.add(product5);

    
    // Sorting Based on price 

    System.out.println("\n Shorting based on price \n");
    Collections.sort(products, (p1,p2)-> Double.compare(p1.getPrice(), p2.getPrice()));
    for(Product product:products)
    {
        System.out.println(" "+product);
    }
       
    //Sorting Based on Name
      System.out.println("\n Sorting based on Name \n");
    Collections.sort(products, (p1,p2)-> p1.getName().compareToIgnoreCase(p2.getName()));
    for(Product product:products)
    {
        System.out.println( " "+product+" ");
    }

       //Sorting Based on Category
      System.out.println("\n Sorting based on Category \n");
    Collections.sort(products, (p1,p2)-> p1.getCategory().compareToIgnoreCase(p2.getCategory()));
    for(Product product:products)
    {
        System.out.println(" "+product+ " ");
    }
    
   //Implementing Searching Facility
    // Search Resuls based on Name
    Scanner sc = new Scanner(System.in);
    System.out.println("\n Enter the name of product to search \n");
    String searchItem = sc.next();
     List<Product> searchResult = new ArrayList<>();
     for (Product p : products) {
        if (p.getName().equalsIgnoreCase(searchItem)) {
            searchResult.add(p);
        }
     }
     System.out.println("Result based on name search");
     for (Product product : searchResult) {
        System.out.println(product +"\n");
     }

     //Search Results based on Category...

    System.out.println("\n Enter the Category of product to search \n");
    String searchItem2 = sc.next();
     List<Product> searchResult2 = new ArrayList<>();
     for (Product p : products) {
        if (p.getCategory().equalsIgnoreCase(searchItem2)) {
            searchResult.add(p);
        }
     }
     System.out.println("Result based on Category search");
     for (Product product : searchResult2) {
        System.out.println(product +"\n");
     }

      //Search Results based on ingredient
    System.out.println("\n Enter the ingredient of product to search \n");
    String searchItem3 = sc.next();
     List<Product> searchResult3 = new ArrayList<>();
     for (Product p : products) {
        if (p.getCategory().equalsIgnoreCase(searchItem3)) {
            searchResult.add(p);
        }
     }
     System.out.println("\n Result based on Ingredient search \n");
     for (Product product : searchResult2) {
        System.out.println(product +"\n");
     }
     for(int i=0;i<products.size();i++)
     {
        for(int j=i+1;j<products.size();j++)
        {
            if (products.get(i).equals(products.get(j))) {
                products.remove(j);
            }
        }
     }
   }
}