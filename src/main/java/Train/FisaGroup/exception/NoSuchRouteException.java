package Train.FisaGroup.exception;

public class NoSuchRouteException extends Exception {
 static final long serialVersionUID = 1L;

	@Override
    public String getMessage(){
        return "NO SUCH ROUTE";
    }
}