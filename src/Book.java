public class Book extends Product {
    String authorFullName;

    @Override
    public String toString() {
        return "Book{" +
                "authorFullName='" + authorFullName + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
