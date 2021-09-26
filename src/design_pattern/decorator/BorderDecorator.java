package design_pattern.decorator;

public class BorderDecorator extends Decorator {
    public BorderDecorator(VisualComponent component) {
        super(component);
    }

    @Override
    public void draw() {
        super.draw();
        System.out.println("draw Border");
    }
}
