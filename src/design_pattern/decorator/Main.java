package design_pattern.decorator;

public class Main {
    public static void main(String[] args) {
        VisualComponent textView = new TextView();
        VisualComponent scrollDecorator = new ScrollDecorator(textView);

        scrollDecorator.draw();

        System.out.println();

        VisualComponent textScrollBorderDecorator = new ScrollDecorator(new BorderDecorator(new TextView()));

        textScrollBorderDecorator.draw();
    }
}
