package me.guillaume.recruitment.gossip;

public class Doctor extends Person {

    private int index = 0;

    public Doctor(Gossips gossips, String name) {
        super(gossips, name);
    }

    @Override
    public void addMessage(String message) {
        if (this.message.equals("")) {
            this.message = message;
        } else {
            this.message += ", " + message;
        }
    }

    @Override
    public void spread() {
        if (this.next != null) {
            String[] splits = this.message.split(", ");
            if (splits.length > index) {
                this.next.addMessage(splits[index]);
                this.index++;
            }
        }
    }
}
