package me.guillaume.recruitment.gossip;

public abstract class Person {

    protected String name;
    protected Person next;
    protected String message = "";
    protected String newMessage = "";
    protected Gossips gossips;

    public Person(Gossips gossips, String name) {
        this.gossips = gossips;
        this.name = name;
    }

    public Gossips to(String to) {
        this.next = this.gossips.getGossipMap().get(to);
        return this.gossips;
    }

    public abstract void addMessage(String message);

    public abstract void spread();

    public String getMessage() {
        return message;
    }

    public String getName() {
        return this.name;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
