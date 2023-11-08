public class Electronics extends Product{
    String brand;
    String color;
    boolean isNew;
    int memory;

    @Override
    public String toString() {
        return "Electronics{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", isNew=" + isNew +
                ", memory=" + memory +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", createdAt=" + createdAt +
                '}';
    }
}
