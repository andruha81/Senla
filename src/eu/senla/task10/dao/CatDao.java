package eu.senla.task10.dao;

import eu.senla.task10.api.dao.ICatDao;
import eu.senla.task10.api.exceptions.AgeOutOfBoundException;
import eu.senla.task10.api.exceptions.BlankNameException;
import eu.senla.task10.api.exceptions.NoSuchIndexException;
import eu.senla.task10.api.exceptions.NullNameException;
import eu.senla.task10.entity.Cat;

import java.util.ArrayList;
import java.util.List;

public class CatDao implements ICatDao {

    private final List<Cat> cats = new ArrayList<>();

    public void addCat(String name, int age) {
        try {
            checkAge(age);
        } catch (AgeOutOfBoundException exception) {
            age = Cat.DEFAULT_AGE;
            System.out.printf("Age should be from 0 to 20. Setting default age %s%n", age);
        }

        try {
            checkName(name);
        } catch (NullNameException exception) {
            name = Cat.DEFAULT_NAME;
            System.out.printf("Name shouldn't be null. Setting default name %s%n", name);
        } catch (BlankNameException exception) {
            name = Cat.DEFAULT_NAME;
            System.out.printf("Name shouldn't be blank. Setting default name %s%n", name);
        } finally {
            cats.add(new Cat(name, age));
            System.out.printf("Add new cat with name %s, age %s%n", name, age);
        }

    }

    public Cat getCat(int index) throws NoSuchIndexException {
        checkIndex(index);
        return cats.get(index);
    }

    private void checkAge(int age) throws AgeOutOfBoundException {
        if (age < 0 || age > 20) {
            throw new AgeOutOfBoundException();
        }
    }

    private void checkName(String name) throws NullNameException, BlankNameException {
        if (name == null) {
            throw new NullNameException();
        }

        if (name.trim().length() == 0) {
            throw new BlankNameException();
        }
    }

    private void checkIndex(int index) throws NoSuchIndexException {
        if (index < 0 || index >= cats.size()) {
            throw new NoSuchIndexException();
        }
    }

}
