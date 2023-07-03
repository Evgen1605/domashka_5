package org.example;

import java.util.*;

public class PhoneBook {
    private Map<String, Set<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void addContact(String name, String phone) {
        if (phoneBook.containsKey(name)) {
            Set<String> phones = phoneBook.get(name);
            phones.add(phone);
        } else {
            Set<String> phones = new HashSet<>();
            phones.add(phone);
            phoneBook.put(name, phones);
        }
    }

    public void removeContact(String name) {
        phoneBook.remove(name);
    }

    public void printPhoneBook() {
        List<Map.Entry<String, Set<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
        sortedEntries.sort((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()));

        for (Map.Entry<String, Set<String>> entry : sortedEntries) {
            String name = entry.getKey();
            Set<String> phones = entry.getValue();
            System.out.println(name + ": " + phones);
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addContact("John", "1234567890");
        phoneBook.addContact("John", "9876543210");
        phoneBook.addContact("Alice", "1111111111");
        phoneBook.addContact("Bob", "2222222222");
        phoneBook.addContact("Alice", "3333333333");

        phoneBook.printPhoneBook();
    }
}
