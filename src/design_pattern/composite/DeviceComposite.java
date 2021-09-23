package design_pattern.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DeviceComposite implements DeviceComponent{
    private List<DeviceComponent> components;

    public DeviceComposite() {
        this.components = new ArrayList<>();
    }

    public void addComponent(DeviceComponent component) {
        this.components.add(component);
    }

    public void removeComponent(DeviceComponent component) {
        this.components.remove(component);
    }

    @Override
    public int getPrice() {
        Iterator<DeviceComponent> iterator = components.iterator();
        int sum = 0;

        while (iterator.hasNext()) {
            sum += iterator.next().getPrice();
        }

        return sum;
    }
}
