package BE.MyRoute.route.exception;

public class RouteNotExistException extends RuntimeException{
    public RouteNotExistException() {
        super("Route Is Not Exist");
    }
}
