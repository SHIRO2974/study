package chapter16.practice.service;

import chapter16.practice.entite.Category;
import chapter16.practice.entite.Item;

import java.util.List;

public interface Manageable {

    List<Item> searchByCategory (Category category);
}
