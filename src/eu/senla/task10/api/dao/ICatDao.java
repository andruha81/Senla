package eu.senla.task10.api.dao;

import eu.senla.task10.api.exceptions.NoSuchIndexException;
import eu.senla.task10.entity.Cat;

public interface ICatDao {
    void addCat(String name, int age);

    Cat getCat(int index) throws NoSuchIndexException;
}
