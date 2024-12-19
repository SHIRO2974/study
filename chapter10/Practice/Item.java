package chapter10.Practice;

abstract public class   Item {

    private String id;
    private String name;

    public Item(String id, String name) {

        this.id = id;
        this.name = name;
    }
    public  String getName() {
        return name;
    }
    public String getId() {
        return id;
    }

    public  abstract void display();
}
