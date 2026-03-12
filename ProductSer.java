package Mini_project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductSer {
    private List<Product> products = new ArrayList<>();
    public void them(Product product) throws InvalidProductException {
        for (Product p : products){
            if (p.getId() == product.getId()){
                throw new InvalidProductException("id tồn tại");
            }
            products.add(product);
        }
    }
    public void hienThi(){
        System.out.println("ID | Tên | Gía | Số lượng | Danh mục");
        products.forEach(p -> System.out.println(p.getId() + " | " +
                p.getName() + " | " +
                p.getPrice() + " | " +
                p.getQuantity() + " | " +
                p.getCategory())
        );
    }
    public void xoa(){
        products.removeIf(p -> p.getQuantity() == 0);
        System.out.println("xóa thành công");
    }
    public static void main(String[] args) {
        ProductSer ser = new ProductSer();
        Scanner sc = new Scanner(System.in);
        int chocie = sc.nextInt();
        try {
            System.out.println("\n===== PRODUCT MANAGEMENT SYSTEM =====\n");
            System.out.println("1. Thêm sản phẩm mới");
            System.out.println("2. Hiển thị sản danh sách sản phẩm");
            System.out.println("3. Cập nhật số lượng theo id");
            System.out.println("4. Xóa sản phẩm đã hêt hàng");
            System.out.println("5. Thoát chương trình");
            System.out.print("Nhập lựa chọn của bạn: ");
            chocie = Integer.parseInt(sc.nextLine());
            switch (chocie){
                case 1:
                    System.out.println("Nhập id: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nhập tên: ");
                    String name = sc.nextLine();
                    System.out.println("Nhập giá: ");
                    double price = sc.nextDouble();
                    System.out.println("Nhập số lượng: ");
                    int quantity = sc.nextInt();
                    System.out.println("Nhập danh mục: ");
                    String category = sc.nextLine();
                    Product p = new Product(id, name, price,quantity, category);
                    ser.them(p);
                    break;
                case 2:
                    ser.hienThi();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
            }
        }catch (InvalidProductException e){
            System.out.println("lỗi");
        }
    }
}
