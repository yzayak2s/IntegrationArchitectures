package de.hbrs.ia.model.exception;

public class ContainerException extends Exception {

    private Integer id;

    public ContainerException(String string) {
        super(string);
    }

    @Override
    public void printStackTrace() {
        if (this.id != null) {
            System.out.println("The person-object with the ID " + this.id + " is already taken!");
        } else {
            System.out.println(this.getMessage());
        }
    }

    public void addID(Integer id) {
        this.id = id;
    }
}
