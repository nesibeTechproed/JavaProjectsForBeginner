package repeat.MiniBookStore;
//2-product işlemleri için standart
public interface ProductService {
    void processMenu();
    void listProduct();
    void  addProduct();
    void deleteProduct();
    void filterProducts(String filter);
}
