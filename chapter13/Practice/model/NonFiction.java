package chapter13.Practice.model;

public class NonFiction extends Book{

    private String field;

    public NonFiction(int id, String title, String author, String field) {
        super(id, title, author);
        this.field = field;
    }

    public String getField() {
        return field;
    }

    @Override
    public String toString() {
        return super.toString() + ", Field: " + field;
    }
}
