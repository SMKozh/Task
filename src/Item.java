public class Item {
    private final Colors color;
    private final Shape shape;
    private final int weight;
    private boolean onLight;

    public Item(Colors color, Shape shape, int weight, boolean onLight) {
        this.color = color;
        this.shape = shape;
        this.weight = weight;
        this.onLight = onLight;
    }

    public Colors getColor() {
        return color;
    }

    public Shape getShape() {
        return shape;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isOnLight() {
        return onLight;
    }

    public void setOnLight(boolean onLight) {
        this.onLight = onLight;
    }

    @Override
    public String toString() {
        return "Item{" + "color=" + color + ", shape=" + shape + ", weight=" + weight + ", onLight=" + onLight + '}';
    }
}
