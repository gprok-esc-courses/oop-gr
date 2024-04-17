package riddles.errors;

public class ErrorMail implements ErrorObserver {
    @Override
    public void error(Class c, Exception e, String message) {
        System.out.println(c.getSimpleName() + ", " + e.getMessage());
    }
}
