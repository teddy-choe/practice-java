package design_pattern.decorator;

public class ScrollDecorator extends Decorator {
    public ScrollDecorator(VisualComponent component) {
        super(component);
    }

    @Override
    public void draw() {
        super.draw();
        System.out.println("draw Scroll");
    }
}
