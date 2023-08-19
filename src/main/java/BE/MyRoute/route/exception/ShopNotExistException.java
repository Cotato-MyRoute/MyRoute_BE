package BE.MyRoute.route.exception;

public class ShopNotExistException extends RuntimeException{
    public ShopNotExistException() {
        super("Shop Is Not Exist");
    }
}
