package eu.senla.task7.dao;

import eu.senla.task7.api.IRoboDao;
import eu.senla.task7.entity.Robo;
import eu.senla.task7.utils.RoboFactory;

import java.util.ArrayList;
import java.util.List;

public class RobotDao implements IRoboDao {

    private List<Robo> robots = new ArrayList<>();

    @Override
    public void addRobo(Robo robo) {
        robots.add(robo);
    }

    @Override
    public Robo createRobo() {
        Robo robo = new Robo(robots.size() + 1, RoboFactory.createBody(), RoboFactory.createHead());
        System.out.printf("Created robot: %s %n", robo.toString());
        return robo;
    }
}
