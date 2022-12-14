package com.expertorion.spring.basics.springin5steps;

public abstract class Coffee {
    public abstract double cost();
}

class DarkRoast extends Coffee{

    public double cost(){
        System.out.println("Plain DarkRoast Coffee Cost Rs 100/- ");
        return 100;
    }
}

class MochaDecorator extends Coffee{
    DarkRoast darkRoast;  // MochaDecorator wraps the DarkRoast Coffee

    public MochaDecorator(DarkRoast darkRoast) {
        this.darkRoast = darkRoast;
    }

    public double cost(){
        System.out.println("Condiment Mocha added , hence cost increased by Rs 20/- ");
        return (darkRoast.cost()+20);
    }
}

class WhipDecorator extends Coffee{
    MochaDecorator mochaDecorator ;  // WhipDecorator wraps the MochaDecorator Object
    public WhipDecorator(MochaDecorator mochaDecorator) {
        this.mochaDecorator = mochaDecorator;
    }

    public double cost(){
        System.out.println("Condiment Whip added, hence cost increased by Rs 10/- ");
        return (mochaDecorator.cost()+10);
    }
}

class customer {
    public static void main(String[] str) {
        Coffee coffee=new WhipDecorator(new MochaDecorator(new DarkRoast()));
        System.out.println("Your Coffee cost is "+coffee.cost());
    }
}


