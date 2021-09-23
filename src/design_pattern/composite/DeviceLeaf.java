package design_pattern.composite;

public class DeviceLeaf implements DeviceComponent {
    private int price;

    public DeviceLeaf(int price) {
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
