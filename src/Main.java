import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Item> input = new ArrayList<>();
        input.add(new Item(Colors.GREEN, Shape.CIRCLE, 1, true));
        input.add(new Item(Colors.GREEN, Shape.CIRCLE, 3, false));
        input.add(new Item(Colors.GREEN, Shape.CIRCLE, 2, true));
        input.add(new Item(Colors.GREEN, Shape.CIRCLE, 4, false));

        input.add(new Item(Colors.BLUE, Shape.CIRCLE, 1, false));
        input.add(new Item(Colors.BLUE, Shape.CIRCLE, 1, false));
        input.add(new Item(Colors.BLUE, Shape.CIRCLE, 3, true));
        input.add(new Item(Colors.BLUE, Shape.CIRCLE, 2, false));
        input.add(new Item(Colors.BLUE, Shape.CIRCLE, 4, true));
        input.add(new Item(Colors.BLUE, Shape.CIRCLE, 5, true));

        input.add(new Item(Colors.GREEN, Shape.RECTANGLE, 1, false));
        input.add(new Item(Colors.GREEN, Shape.RECTANGLE, 3, true));
        input.add(new Item(Colors.GREEN, Shape.RECTANGLE, 1, false));
        input.add(new Item(Colors.GREEN, Shape.RECTANGLE, 1, false));
        input.add(new Item(Colors.GREEN, Shape.RECTANGLE, 2, true));

        input.add(new Item(Colors.YELLOW, Shape.RECTANGLE, 1, true));
        input.add(new Item(Colors.YELLOW, Shape.RECTANGLE, 3, false));
        input.add(new Item(Colors.YELLOW, Shape.RECTANGLE, 1, true));
        input.add(new Item(Colors.YELLOW, Shape.RECTANGLE, 3, false));
        input.add(new Item(Colors.YELLOW, Shape.RECTANGLE, 2, false));

        input.forEach(System.out::println);

        Map<String, TreeSet<Item>> output = sortInputDataInBuckets(input);
        System.out.println("\nOutput data\n");
        int i = 1;
        for (Map.Entry<String, TreeSet<Item>> entry : output.entrySet()) {
            System.out.println("Bucket = " + i++);
            entry.getValue().forEach(System.out::println);
            System.out.println();
        }
    }

    private static Map<String, TreeSet<Item>> sortInputDataInBuckets(List<Item> inputItems) {
        Map<String, TreeSet<Item>> output = new LinkedHashMap<>();
        for (Item inputItem : inputItems) {
            Set<Item> items = output.computeIfAbsent(getKey(inputItem), k -> new TreeSet<>(Comparator.comparingInt(Item::getWeight)));
            if (inputItem.isOnLight()) {
                for (Item item : items) {
                    if (item.isOnLight() && item.getWeight() < inputItem.getWeight()) {
                        item.setOnLight(false);
                        break;
                    } else if (item.isOnLight() && item.getWeight() > inputItem.getWeight()) {
                        inputItem.setOnLight(false);
                        break;
                    }
                }
            }
            items.add(inputItem);
        }
        return output;
    }

    private static String getKey(Item item) {
        return item.getShape() + " " + item.getColor();
    }
}
