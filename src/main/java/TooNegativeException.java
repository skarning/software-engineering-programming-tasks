public class TooNegativeException extends RuntimeException {
    private int id;

    public TooNegativeException(int id) {
        this.id = id;
    }

    public String toString() {
        return "TooNegativeException[" + id + "]" ;
    }
}
