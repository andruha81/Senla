package eu.senla.task10.main;

import eu.senla.task10.api.exceptions.NoSuchIndexException;
import eu.senla.task10.dao.CatDao;

public class Main{

    public static void main(String[] args) throws NoSuchIndexException {

        CatDao catDao = new CatDao();

        catDao.addCat("Murka", 10);

        System.out.println(catDao.getCat(0));
    }
}
