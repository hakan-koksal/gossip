package me.guillaume.recruitment.gossip;

public class Gossip {

    private Gossips gossips;
    private String message;

    public Gossip(Gossips gossips, String message) {
        this.gossips = gossips;
        this.message = message;
    }

    public void to(String name) {
        Person person = this.gossips.getGossipMap().get(name);
        person.setMessage(this.message);
    }
}
