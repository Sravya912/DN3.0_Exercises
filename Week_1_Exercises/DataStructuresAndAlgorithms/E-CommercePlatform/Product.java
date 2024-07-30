package ecp;

class Product {
    private String productId;
    private String productName;
    private String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    // Getters
    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }
}

class Search {
    public static Product linearSearch(Product[] products, String productName) {
        if (productName == null) {
            return null;
        }
        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String productName, int left, int right) {
        if (productName == null) {
            return null;
        }
        if (left <= right) {
            int mid = left + (right - left) / 2;
            String midProductName = products[mid].getProductName();
            
            if (midProductName.equals(productName)) {
                return products[mid];
            }
            if (midProductName.compareTo(productName) > 0) {
                return binarySearch(products, productName, left, mid - 1);
            } else {
                return binarySearch(products, productName, mid + 1, right);
            }
        }
        return null;
    }
}
