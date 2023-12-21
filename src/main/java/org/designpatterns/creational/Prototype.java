package org.designpatterns.creational;

public class Prototype implements Cloneable{
    private String field1;
    private String field2;

    public Prototype() {
    }

    public Prototype(String field1, String field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    @Override
    protected Prototype clone() {
        return new Prototype(field1, field2);
    }
}

class PrototypeMain{
    public static void main(String[] args) {
        Prototype prototype1 = new Prototype("Original value 1", "Original value 2");
        System.out.printf("Original instance field1: %s - field2: %s%n", prototype1.getField1(), prototype1.getField2());

        Prototype prototype2 = prototype1.clone();
        prototype2.setField1("Changed value 1");
        prototype2.setField2("Changed value 2");

        System.out.printf("Changed instance field1: %s - field2: %s%n", prototype2.getField1(), prototype2.getField2());
        System.out.printf("Original instance field1: %s - field2: %s%n", prototype1.getField1(), prototype1.getField2());
    }
}
