import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void displayInitialOptions() {
        System.out.println("""
                1. Регистрация
                2. Вход
                3. Выход""");
    }

    public static void displayLoggedOptions() {
        System.out.println("""
                0. Выйти
                1. Добавить новый продукт
                2. Получить все продукты
                3. Получить все книги
                4. Получить все электроники""");
    }

    public static boolean isEmailAlreadyTaken(ArrayList<User> users, String email) {
        for (User user : users) {
            if (user.email.equals(email)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<>();
        User currentUser = null;
        boolean exit = false;
        boolean isLoggedIn = false;
        while (!exit) {
            displayInitialOptions();
            if (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                scanner.nextLine();
                switch (num) {
                    case 1:
                        User user = new User();
                        System.out.print("Введите ваше имя: ");
                        user.firstName = scanner.nextLine();
                        System.out.print("Введите вашу фамилию: ");
                        user.lastName = scanner.nextLine();
                        while (true) {
                            System.out.print("Введите ваш email: ");
                            String email = scanner.nextLine();
                            if (isEmailAlreadyTaken(users, email)) {
                                System.out.println("Такой email уже существует!");
                            } else {
                                user.email = email;
                                break;
                            }
                        }
                        System.out.print("Введите пароль для вашего email: ");
                        user.password = scanner.nextLine();
                        users.add(user);
                        System.out.println("Вы успешно зарегистрировались!");
                        break;
                    case 2:
                        while (currentUser == null) {
                            System.out.print("Напишите email: ");
                            String email = scanner.nextLine();
                            System.out.print("Напишите пароль: ");
                            String password = scanner.nextLine();
                            for (User u : users) {
                                if (u.email.equals(email) && u.password.equals(password)) {
                                    currentUser = u;
                                    break;
                                }
                            }
                            if (currentUser != null) {
                                System.out.println("Вы успешно вошли! ~ Добро пожаловать! ");
                                System.out.println("Профиль: " + currentUser.firstName + " " + currentUser.lastName);
                                System.out.println("email: " + currentUser.email);
                                System.out.println();
                                isLoggedIn = true;
                            } else {
                                System.out.println("Неправильный email или пароль.");
                            }
                        }
                        break;
                    case 3:
                        exit = true;
                        System.out.println("Вы успешно вышли!");
                        break;
                    default:
                        System.out.println("Введите правильную цифру!");
                        break;
                }

            } else {
                System.out.println("Вы не ввели значение, введите еще раз!");
                scanner.nextLine();
            }
            if (isLoggedIn) {
                ArrayList<Product> products = new ArrayList<>();
                while (isLoggedIn) {
                    displayLoggedOptions();
                    if (scanner.hasNextInt()) {
                        int num = scanner.nextInt();
                        switch (num) {
                            case 0:
                                currentUser = null;
                                isLoggedIn = false;
                                System.out.println("Вы успешно вышли!");
                                break;
                            case 1:
                                System.out.println("Выберите категорию: (1) Электроника  или (2) Книга ");
                                scanner.nextLine();
                                if (scanner.hasNextInt()) {
                                    int categoryChoice = scanner.nextInt();
                                    scanner.nextLine();
                                    if (categoryChoice == 1) {
                                        System.out.print("Напишите название продукта: ");
                                        Electronics product = new Electronics();
                                        product.name = scanner.nextLine();
                                        System.out.print("Напишите бренд: ");
                                        product.brand = scanner.nextLine();
                                        System.out.print("Укажите цвет продукта: ");
                                        product.color = scanner.nextLine();
                                        while (true) {
                                            System.out.print("Новый ли это продукт? (true or false): ");

                                            if (scanner.hasNextBoolean()) {
                                                product.isNew = scanner.nextBoolean();
                                                scanner.nextLine();
                                                break;
                                            } else {
                                                System.out.println("Введите boolean!");
                                                scanner.nextLine();
                                            }
                                        }
                                        System.out.print("Количество памяти: ");
                                        product.memory = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.print("Напишите описание: ");
                                        product.description = scanner.nextLine();
                                        while (true) {
                                            System.out.print("Укажите цену продукта: ");
                                            if (scanner.hasNextDouble()) {
                                                product.price = BigDecimal.valueOf(scanner.nextDouble());
                                                scanner.nextLine();
                                                break;
                                            } else {
                                                System.out.println("Введите число!");
                                                scanner.nextLine();
                                            }
                                        }
                                        System.out.print("Укажите дату выпуска продукта: ");
                                        product.createdAt = scanner.nextLine();
                                        products.add(product);
                                        System.out.println("Электроника успешно добавлена!");
                                        System.out.println();
                                    } else if (categoryChoice == 2) {
                                        System.out.print("Напишите название продукта: ");
                                        Book product = new Book();
                                        product.name = scanner.nextLine();
                                        System.out.print("Напишите описание: ");
                                        product.description = scanner.nextLine();
                                        while (true) {
                                            System.out.print("Укажите цену продукта: ");
                                            if (scanner.hasNextDouble()) {
                                                product.price = BigDecimal.valueOf(scanner.nextDouble());
                                                scanner.nextLine();
                                                break;
                                            } else {
                                                System.out.println("Введите число!");
                                                scanner.nextLine();
                                            }
                                        }
                                        System.out.print("Укажите дату выпуска продукта: ");
                                        product.createdAt = scanner.nextLine();
                                        System.out.print("Укажите полное имя автора: ");
                                        product.authorFullName = scanner.nextLine();
                                        products.add(product);
                                        System.out.println("Книга успешно добавлена!");
                                        System.out.println();
                                    } else {
                                        System.out.println("Выбрана неверная категория.");
                                    }
                                } else {
                                    System.out.println("Введите числовое значение!");
                                    scanner.nextLine();
                                }
                                if (scanner.hasNextLine()) {
                                    String category = scanner.nextLine();
                                    if (category.equalsIgnoreCase("электроника")) {
                                        System.out.print("Напишите название продукта: ");
                                        Electronics product = new Electronics();
                                        product.name = scanner.nextLine();
                                        System.out.print("Напишите бренд: ");
                                        product.brand = scanner.nextLine();
                                        System.out.print("Укажите цвет продукта: ");
                                        product.color = scanner.nextLine();
                                        while (true) {
                                            System.out.print("Новый ли это продукт? (true or false): ");

                                            if (scanner.hasNextBoolean()) {
                                                product.isNew = scanner.nextBoolean();
                                                scanner.nextLine();
                                                break;
                                            } else {
                                                System.out.println("Введите boolean!");
                                                scanner.nextLine();
                                            }
                                        }
                                        System.out.print("Количество памяти: ");
                                        product.memory = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.print("Напишите описание: ");
                                        product.description = scanner.nextLine();
                                        while (true) {
                                            System.out.print("Укажите цену продукта: ");
                                            if (scanner.hasNextDouble()) {
                                                product.price = BigDecimal.valueOf(scanner.nextDouble());
                                                scanner.nextLine();
                                                break;
                                            } else {
                                                System.out.println("Введите число!");
                                                scanner.nextLine();
                                            }
                                        }
                                        System.out.print("Укажите дату выпуска продукта: ");
                                        product.createdAt = scanner.nextLine();
                                        products.add(product);
                                        System.out.println("Электроника успешно добавлена!");
                                        System.out.println();
                                    }
                                    if (category.equalsIgnoreCase("книга")) {
                                        System.out.print("Напишите название продукта: ");
                                        Book product = new Book();
                                        product.name = scanner.nextLine();
                                        System.out.print("Напишите описание: ");
                                        product.description = scanner.nextLine();
                                        while (true) {
                                            System.out.print("Укажите цену продукта: ");
                                            if (scanner.hasNextDouble()) {
                                                product.price = BigDecimal.valueOf(scanner.nextDouble());
                                                scanner.nextLine();
                                                break;
                                            } else {
                                                System.out.println("Введите число!");
                                                scanner.nextLine();
                                            }
                                        }
                                        System.out.print("Укажите дату выпуска продукта: ");
                                        product.createdAt = scanner.nextLine();
                                        System.out.print("Укажите полное имя автора: ");
                                        product.authorFullName = scanner.nextLine();
                                        products.add(product);
                                        System.out.println("Книга успешно добавлена!");
                                        System.out.println();
                                    }
                                } else {
                                    System.out.println("Введите строку!");
                                }
                                break;
                            case 2:
                                if (products.isEmpty()) {
                                    System.out.println("Продуктов не найдено.");
                                } else {
                                    System.out.println("Все продукты:");
                                    for (Product p : products) {
                                        System.out.println(p);
                                    }
                                }
                                break;
                            case 3:
                                ArrayList<Book> books = new ArrayList<>();
                                for (Product p : products) {
                                    if (p instanceof Book) {
                                        books.add((Book) p);
                                    }
                                }
                                if (books.isEmpty()) {
                                    System.out.println("Книг не найдено.");
                                } else {
                                    System.out.println("Все книги:");
                                    for (Book b : books) {
                                        System.out.println(b);
                                    }
                                }
                                break;
                            case 4:
                                ArrayList<Electronics> electronics = new ArrayList<>();
                                for (Product p : products) {
                                    if (p instanceof Electronics) {
                                        electronics.add((Electronics) p);
                                    }
                                }
                                if (electronics.isEmpty()) {
                                    System.out.println("Электроники не найдено.");
                                } else {
                                    System.out.println("Все электроники:");
                                    for (Electronics e : electronics) {
                                        System.out.println(e);
                                    }
                                }
                                break;
                            default:
                                System.out.println("Введите правильное число!");
                                break;
                        }
                    } else {
                        System.out.println("Введите правильное число!");
                        scanner.nextLine();
                    }
                }
            }
        }
    }
}