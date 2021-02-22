package eu.senla.task7.entity;

public class Robo {

    private int sn;
    private BodyType body;
    private HeadType head;

    public Robo(int sn, BodyType body, HeadType head) {
        this.sn = sn;
        this.body = body;
        this.head = head;
    }

    @Override
    public String toString() {
        return String.format("Robot SN:%s, body %s, head %s %n", this.sn, this.body, this.head);
    }
}
