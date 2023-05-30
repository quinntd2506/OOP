package aimsproject;

public class Aims {
    public static void main(String[] args){

        //Create a new cart
        Cart anOrder = new Cart();

        //Create new dvd objects and add them to cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King" , "Animation" , "Roger Allers",87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars" , "Science Fiction" , "George Lucas",87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin" , "Animation", 18.995f);
        anOrder.addDigitalVideoDisc(dvd3);

        anOrder.removeDigitalVideoDisc(dvd1);

        //Print total cost of the items in the cart
        System.out.println("Total Cost is:");
        System.out.println(anOrder.getTotalCost());

       
    }
}
