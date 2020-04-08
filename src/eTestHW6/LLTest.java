package eTestHW6;

public class LLTest {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for (int i = 1; i <=5; i++) {
            linkedList.add(i);
        }
        System.out.println("Print all");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }
        linkedList.insert(3, 10);
        System.out.println("\nPrint all after insert");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }
        linkedList.remove(linkedList.size()-1);
        System.out.println("\nPrint all after remove");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }
    }
}
