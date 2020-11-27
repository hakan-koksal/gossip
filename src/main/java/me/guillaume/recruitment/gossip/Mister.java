package me.guillaume.recruitment.gossip;

public class Mister extends Person {

    public Mister(Gossips gossips, String name) {
        super(gossips, name);
    }

    @Override
    public void addMessage(String message) {
        this.message = message;
    }

    @Override
    public void spread() {
        if (!this.message.isEmpty()) {
            this.next.addMessage(this.message);
        }
        this.message = this.newMessage;
    }
}
