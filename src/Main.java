import manager.ManageProduct;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

                Scanner scanner = new Scanner(System.in);
                ManageProduct manageProduct = new ManageProduct();
                while (true) {
                    System.out.println("Menu Quản Lý Sản Phẩm");
                    System.out.println("1. Xem danh sách");
                    System.out.println("2. Thêm mới");
                    System.out.println("3. Cập nhật");
                    System.out.println("4. Xóa ");
                    System.out.println("5. Sắp xếp");
                    System.out.println("6. Tìm sản phẩm có giá đắt nhât");
                    System.out.println("7. Đọc từ file");
                    System.out.println("8. Ghi vào file");
                    System.out.println("9. Thoát");
                    int choice = 0;
                    while (true) {
                        try {
                            System.out.println("Nhập lựa chọn của bạn");
                            choice = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (Exception e) {

                        }
                    }

                    switch (choice){
                        case 1:
                            manageProduct.display();
                            break;
                        case 2:
                            manageProduct.add(manageProduct.create());
                            break;
                        case 3:
                            manageProduct.edit();
                            break;
                        case 4:
                            manageProduct.delete();
                            break;
                        case 5:
                            manageProduct.sortProduct();
                            break;
                        case 6:
                            System.out.println("Sản phẩm đắt nhất:");
                            System.out.println(manageProduct.findProductMax());
                            break;
                        case 7:
                            manageProduct.read();
                            break;
                        case 8:
                            manageProduct.write();
                            break;
                        case 9:
                            return;
                    }

                }

            }
        }

