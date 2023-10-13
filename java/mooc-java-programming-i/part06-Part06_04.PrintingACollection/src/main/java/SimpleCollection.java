
import java.util.ArrayList;

public class SimpleCollection {

    private String name;
    private ArrayList<String> elements;

    public SimpleCollection(String name) {
        this.name = name;
        this.elements = new ArrayList<>();
    }

    public void add(String element) {
        this.elements.add(element);
    }

    public ArrayList<String> getElements() {
        return this.elements;
    }

    public String toString() {
        if (this.elements.size() == 0)
            return "The collection " + name + " is empty.";
        String printString = "The collection " + name + " has "
                + (elements.size() > 1 ? elements.size() + " elements:" : "1 element:");

        for (String element : elements)
            printString += "\n" + element;

        return printString;
    }

}
