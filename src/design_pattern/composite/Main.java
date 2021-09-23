package design_pattern.composite;

public class Main {
    public static void main(String[] args) {
        DeviceComposite composite = new DeviceComposite();
        composite.addComponent(new DeviceLeaf(5));
        composite.addComponent(new DeviceLeaf(10));
        composite.addComponent(new DeviceLeaf(15));

        System.out.println(composite.getPrice());
    }
}
