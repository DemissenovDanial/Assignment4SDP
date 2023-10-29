import java.util.ArrayList;
import java.util.List;

interface Subject {
    void registerClient(Client client);
    void removeClient(Client client);
    void notifyClient(String newDish);
}

interface Client {
    void update(String newDish);
}

class Restaurant implements Subject {
    private List<Client> clients;
    private String newDish;

    public Restaurant() {
        clients = new ArrayList<>();
    }

    @Override
    public void registerClient(Client client) {
        clients.add(client);
    }

    @Override
    public void removeClient(Client client) {
        clients.remove(client);
    }

    @Override
    public void notifyClient(String newDish) {
        for (Client client : clients) {
            client.update(newDish);
        }
    }

    public void addNewDish(String dishName) {
        this.newDish = dishName;
        notifyClient(dishName);
    }
}

class Customer implements Client {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void update(String newDish) {
        System.out.println("Hello, " + name + "! New dish added to the menu: " + newDish);
    }
}

public class Assignment4 {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();

        Customer customer1 = new Customer("Yatoro");
        Customer customer2 = new Customer("Collapse");
        Customer customer3 = new Customer("Ame");

        restaurant.registerClient(customer1);
        restaurant.registerClient(customer2);
        restaurant.registerClient(customer3);

        restaurant.addNewDish("Pizza Margarita");
    }
}
