# Sereialization And Deserialization

##  Introduction

Serialization and Deserialization are processes used to convert an object into a byte
stream and vice versa. This is essential for persisting objects, sending objects over a
network, or deep cloning.

![1_8zJ4G6UTsAyqwpmbLyI5fg](https://github.com/user-attachments/assets/db68e93c-5051-4f81-a525-47d5ed0ac59c)

## Benefits
1. **Persistence**: Serialize objects to store them on disk, allowing them to be retrieved and used later.
2. **Communication**: Serialize objects to send them over a network between different Java applications.
3. **Cloning**: Deep clone objects by serializing and then deserializing them.
4. **Caching**: Store serialized objects in a cache for quick access.

## Mechanism
- **Serialization**: Converts an object into a byte stream.
  - Implement `Serializable` interface.
  - Use `ObjectOutputStream` to write the object to a byte stream.
- **Deserialization**: Converts a byte stream back into an object.
  - Use `ObjectInputStream` to read the object from the byte stream.

## Example Scenario
Consider a scenario where we need to save the state of a `User` object to a file and retrieve it later.

## Example Code Snippet

```java
import java.io.*;

// Define the User class
class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;

    // Constructor
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and toString method
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + "}";
    }
}

public class SerializationExample {
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
```

##  Explanation of above code  and GitHub Repository Link


### Explanation
1. **User Class**: Implements `Serializable` interface, indicating it can be serialized.
2. **Serialization**: The `user` object is written to a file named `user.ser` using `ObjectOutputStream`.
3. **Deserialization**: The `user` object is read back from the file using `ObjectInputStream`.

### GitHub Repository
You can find the complete code  in the following GitHub repository:
[Serialization and Deserialization Example](https://github.com/pavithraniperera/Serialization-and-Deserialization)

## References
- Baeldung, (n.d.). Java Serialization Basics. Baeldung. Available at: <https://www.baeldung.com/java-serialization> [Accessed 17 July 2024].
- GeeksforGeeks, (n.d.). Serialization and Deserialization in Java with Example. GeeksforGeeks. Available at: <https://www.geeksforgeeks.org/serialization-in-java/> [Accessed 17 July 2024].
- Tutorialspoint, (n.d.). Java Serialization. Tutorialspoint. Available at: <https://www.tutorialspoint.com/java/java_serialization.htm> [Accessed 17 July 2024].

