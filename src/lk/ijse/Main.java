package lk.ijse;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        User user = new User("Alice", 30);

        // Serialization
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("user.ser"))) {
            out.writeObject(user);
            System.out.println("User has been serialized: " + user);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialization
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("user.ser"))) {
            User deserializedUser = (User) in.readObject();
            System.out.println("User has been deserialized: " + deserializedUser);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
