package eu.senla.task7;

import eu.senla.task7.dao.RobotDao;

public class Main {

    private static final int ROBOT_NUMBER = 9;

    public static void main(String[] args) {

        RobotDao robotDao = new RobotDao();

        for (int i = 0; i < ROBOT_NUMBER; i++) {
            robotDao.addRobo(robotDao.createRobo());
        }

    }
}
