package me.guillaume.recruitment.gossip;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Gossips {

    private LinkedList<Person> list = new LinkedList<>();
    private Map<String, Person> gossipMap;

    public Gossips(String... people) {

        gossipMap = new HashMap<>();
        for (String person : people) {
            String[] splits = person.split(" ");
            String title = splits[0];
            String name = splits[1];
            switch (title) {
                case "Mr":
                    gossipMap.put(name, new Mister(this, name));
                    break;
                case "Dr":
                    gossipMap.put(name, new Doctor(this, name));
                    break;
                case "Pr":
                    gossipMap.put(name, new Professor(this, name));
                    break;
                case "Agent":
                    gossipMap.put(name, new Agent(this, name));
                    break;
                case "Lady":
                    gossipMap.put(name, new Lady(this, name));
                    break;
                case "Sir":
                    gossipMap.put(name, new Sir(this, name));
                    break;
                default:
                    break;
            }
        }

    }

    public Map<String, Person> getGossipMap() {
        return gossipMap;
    }

    public Person from(String from) {
        Person person = gossipMap.get(from);
        list.add(person);
        return person;
    }

    public Gossip say(String message) {
        return new Gossip(this, message);
    }

    public void spread() {
        list.removeFirst().spread();
    }

    public String ask(String name) {
        return this.gossipMap.get(name).getMessage();
    }

}
