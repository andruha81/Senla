package eu.senla.task10.dao;

import eu.senla.task10.api.dao.ICatDao;
import eu.senla.task10.api.exceptions.AgeOutOfBoundException;
import eu.senla.task10.api.exceptions.NoSuchIndexException;
import eu.senla.task10.api.exceptions.NullNameException;
import eu.senla.task10.entity.Cat;

import java.util.ArrayList;
import java.util.List;

public class CatDao implements ICatDao {

    private final List<Cat> cats = new ArrayList<>();

    public void addCat(String name, int age) {
        try {
            checkParameters(name, age);
        } catch (AgeOutOfBoundException exception) {
            age = Cat.DEFAULT_AGE;
            System.out.printf("Age should be from 0 to 20. Setting default age %s", age);
        } catch (NullNameException exception) {
            name = Cat.DEFAULT_NAME;
            System.out.printf("Name shouldn't be null or blank. Setting default name %s", name);
        } finally {
            cats.add(new Cat(name, age));
        }
    }

    public Cat getCat(int index) throws NoSuchIndexException{
        checkIndex(index);
        return cats.get(index);
    }

    private void checkParameters(String name, int age){
        if (age < 0 || age > 20) {
            throw new AgeOutOfBoundException();
        }

        if (name == null || name.trim().length() == 0) {
            throw new NullNameException();
        }
    }

    private void checkIndex(int index) throws NoSuchIndexException{
        if (index < 0 || index >= cats.size()) {
            throw new NoSuchIndexException();
        }
    }
}
