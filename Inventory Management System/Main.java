// Design an inventory management system for a warehouse where products are stored on racks and shelves. Each product is uniquely identified by a product ID and has attributes such as name, quantity, and price. Utilize a combination of arrays and pointers to efficiently manage the inventory. The system should allow for the addition of new products, updating of product quantities, and calculation of the total value of the inventory. Pointers should be employed to establish relationships between related products or track product movements within the warehouse.


import java.util.*;

class Node {
    int id;
    String name;
    int quantity;
    int price;
    Node next;
    Node prev;
    
    Node(int id, String name, int quantity, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.next = null;
        this.prev = null;
    }
}

class Inventory {
    Scanner sc = new Scanner(System.in);

    Node head;
    Inventory() {
        head = null;
    }

    void Search() {
        System.out.println("Enter the name of prduct : ");
        String pname = sc.next();
        Node current = head;
        while (!current.name.equals(pname) && current != null ) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Product not found.");
        } else {
            System.out.println("{ " + current.id + " " + current.name + " " + current.price + " " + current.quantity + " }");
        }
    }

    void Update() {
        System.out.println("Enter the ID of prduct : ");
        int pid = sc.nextInt();

        Node current = head;
        while (current != null && current.id != pid) {
            current = current.next;
        }

        if(current == null) {
            System.out.println("Product not found.");
            return;
        }

        System.out.println("Enter values to update");

        System.out.println("Enter the Name : ");
        current.name = sc.next();
        System.out.println("Enter the Quantity : ");
        current.quantity = sc.nextInt();
        System.out.println("Enter the Price : ");
        current.price = sc.nextInt();

        System.out.println("Product is updated.");
    }

    void Delete() {
        System.out.println("Enter the ID of prduct : ");
        int pid = sc.nextInt();
        Node current = head;

        while (current != null && current.id != pid) {
            current = current.next;
        }

        if(current == null) {
            System.out.println("Product not found.");
            return;
        }

        if (current == head) {
            head = current.next;
            if (head != null) {
                head.prev = null;
            }
        } else {
            if (current.prev != null) {
                current.prev.next = current.next;
            }
            if (current.next != null) {
                current.next.prev = current.prev;
            }
        }

        System.out.println("Product deleted.");
    }

    void Display() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        } 

        Node current = head;
        while (current != null) {
            System.out.println("{ " + current.id + " " + current.name + " " + current.price + " " + current.quantity + " }");
            current = current.next;
        }
    }

    void Add() {
        System.out.println("Enter the ID : ");
        int id = sc.nextInt();
        System.out.println("Enter the Name : ");
        String name = sc.next();
        System.out.println("Enter the Quantity : ");
        int quantity = sc.nextInt();
        System.out.println("Enter the Price : ");
        int price = sc.nextInt();

        Node newNode = new Node(id, name, quantity, price);
        if (head == null) {
            head = newNode;
            return;
        }

        head.prev = newNode;
        newNode.next = head;
        head = head.prev;
    }

    void menu() {
        System.out.println("1. Add Product ");
        System.out.println("2. Display Products ");
        System.out.println("3. Delete Products ");
        System.out.println("4. Update products ");
        System.out.println("5. Search product ");
        System.out.println("6. Exit program ");
    }
}



public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("*************************************************************************************************************");
        System.out.println("--  Inventory Management  --");
        Inventory obj = new Inventory();
        while (true) {
            obj.menu();
            System.out.println("Enter the choice : ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    obj.Add();
                    break;

                case 2:
                    obj.Display();
                    break;

                case 3:
                    obj.Delete();
                    break;

                case 4:
                    obj.Update();
                    break;

                case 5:
                    obj.Search();
                    break;

                case 6:
                    System.out.println("Exit.....");
                    System.out.println("*************************************************************************************************************");
                    return;
                
                default:
                    System.out.println("Enter valid choice.");
                    break;
            }
        }
    }
}