package design_pattern.decorator;

public class TextView implements VisualComponent {
    @Override
    public void draw() {
        System.out.println("draw Text");
    }
}
