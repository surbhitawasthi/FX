public class TableProductClass
{
    private String name;
    private int price;
    private int quantity;

    public TableProductClass()
    {
        name="";
        price=0;
        quantity=0;
    }

    public TableProductClass(String name, int price, int quantity)
    {
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {

        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
