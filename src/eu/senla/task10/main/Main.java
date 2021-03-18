package eu.senla.task10.main;

import eu.senla.task10.api.exceptions.NoSuchIndexException;
import eu.senla.task10.dao.CatDao;

public class Main{

    public static void main(String[] args) throws NoSuchIndexException {

        CatDao catDao = new CatDao();

        catDao.addCat("Murka", 10);
        catDao.addCat(null, 2);
        catDao.addCat("Barsik", -5);
        catDao.addCat("  ", 15);
        catDao.addCat("Konfetka", 8);

        System.out.printf("Cat from index 2: %s%n", catDao.getCat(2));
        System.out.printf("Cat from index 5: %s%n", catDao.getCat(5));
    }
}
