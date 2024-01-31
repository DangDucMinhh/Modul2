    package manager;

    import io.ProductIOBinary;
    import io.ProductIOBinary;
    import model.Product;
    import validate.ValidateProduct;

    import java.util.ArrayList;
    import java.util.Comparator;
    import java.util.List;
    import java.util.Scanner;

    public class ManageProduct {
        List<Product> products = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        public void add(Product p) {
            products.add(p);
        }

        public void read() {
            products = ProductIOBinary.read();
        }

        public void write() {
            ProductIOBinary.write(products);
        }


    public Product create() {
        int id = ValidateProduct.id(products);
        String name = ValidateProduct.name(products);
        double price = ValidateProduct.price();
        int quantity = ValidateProduct.quantity();
        System.out.println("Nhập mô tả sản phẩm");
        String content = scanner.nextLine();
        return new Product(id, name, price, quantity, content);
    }

    public void edit() {
        try {
            System.out.println("Nhập mã sản phẩm muốn sửa");
            int id = Integer.parseInt(scanner.nextLine());
            int index = findIndexById(id);


            if (index != -1) {
                System.out.println("Nhập thông tin mới:");
                products.set(index, create());
                System.out.println("Cập nhật thành công!");
            } else {
                System.out.println("Không tìm được sản phẩm với mã sản phẩm trên.");

                System.out.println("Nhấn Enter để quay về menu chính...");
                scanner.nextLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void delete() {
        try {
            System.out.println("Nhập mã sản phẩm muốn xóa");
            int id = Integer.parseInt(scanner.nextLine());
            int index = findIndexById(id);

            if (index == -1) {
                System.out.println("Không tìm được sản phẩm với mã sản phẩm trên.");
                return;
            }

            System.out.println("Bạn có chắc chắn muốn xóa sản phẩm này? (Nhập 'Y' để xác nhận)");
            String confirmation = scanner.nextLine();

            if (confirmation.equalsIgnoreCase("Y")) {
                products.remove(index);
                System.out.println("Xóa sản phẩm thành công!");
            } else {
                System.out.println("Hủy xóa sản phẩm.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void display() {
        System.out.println("ID, Name, Price, Quantity, Content");
        for (Product p : products) {
            System.out.println(p);
        }
    }

    public int findIndexById(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }


    public Product findProductMax() {
        if (products.size() > 0) {
            Product max = products.get(0);
            for (Product p : products) {
                if (p.getPrice() > max.getPrice()) {
                    max = p;
                }
            }
            return max;

        } else {
            return null;
        }
    }

    public void sortProduct() {
        System.out.println("Chọn cách sắp xếp:");
        System.out.println("1. Giá tăng dần");
        System.out.println("2. Giá giảm dần");
        System.out.println("3. Quay về menu chính");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                bubbleSortByPriceAscending();
                break;
            case 2:
                bubbleSortByPriceDescending();
                break;
            case 3:
                // Quay về menu chính
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
    }

    private void bubbleSortByPriceAscending() {
        int n = products.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (products.get(j).getPrice() > products.get(j + 1).getPrice()) {
                    Product temp = products.get(j);
                    products.set(j, products.get(j + 1));
                    products.set(j + 1, temp);
                }
            }
        }
        display();
    }

    private void bubbleSortByPriceDescending() {
        int n = products.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (products.get(j).getPrice() < products.get(j + 1).getPrice()) {
                    Product temp = products.get(j);
                    products.set(j, products.get(j + 1));
                    products.set(j + 1, temp);
                }
            }
        }
        display();
    }
}