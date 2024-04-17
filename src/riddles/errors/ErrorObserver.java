package riddles.errors;

public interface ErrorObserver {
    public void error(Class c, Exception e, String message);
}
