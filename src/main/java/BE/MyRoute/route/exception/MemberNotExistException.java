package BE.MyRoute.route.exception;

public class MemberNotExistException extends RuntimeException{
    public MemberNotExistException() {
        super("Member Is Not Exist");
    }
}
