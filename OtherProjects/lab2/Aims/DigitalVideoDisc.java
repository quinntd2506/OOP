package aimsproject;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    DigitalVideoDisc(String title) {
        this.title = title; //Using ‘this’ keyword to refer current class instance variables
    }

    DigitalVideoDisc(String category, String title, float cost) {
        this(title); //Using this() to invoke current class constructor
        this.category = category;
        this.cost = cost;
    }

    DigitalVideoDisc(String director, String category, String title, float cost) {
        this(title, category, cost);
        this.category = director;
    }

    DigitalVideoDisc(String title, String category, String diretor, int length, float cost) {
        this(diretor, category, title, cost);
        this.length = length;
    }

    public String getTitle() {
        return this.title;
    }

    public String getCategory() {
        return this.category;
    }

    public String getDirector() {
        return this.director;
    }

    public int getLength() {
        return this.length;
    }

    public float getCost() {
        return this.cost;
    }

}