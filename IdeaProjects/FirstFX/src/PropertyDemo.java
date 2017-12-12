import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PropertyDemo
{
    private StringProperty firstName = new SimpleStringProperty(this, "firstName", "");

    //Return StringProperty the object
    public StringProperty firstNameProperty() {
        return firstName;
    }

    //Return the value stored in variable firstName
    public String getFirstName() {
        return firstName.get();
    }

    //Set the value in variable firstName
    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }
}
