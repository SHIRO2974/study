package chapter16.practice.entite;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Item {
    private String id;
    private String name;

    public abstract void display();
}
