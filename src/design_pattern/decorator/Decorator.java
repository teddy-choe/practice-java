package design_pattern.decorator;

public class Decorator implements VisualComponent {
    VisualComponent component;

    public Decorator(VisualComponent component) {
        this.component = component;
    }

    @Override
    public void draw() {
        component.draw();
    }
}
