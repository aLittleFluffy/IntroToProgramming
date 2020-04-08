package eTestHW6;

public class LinkedList {
    private int listCount;
    private Node head;

    public LinkedList() {
        head = new Node();
        listCount = 0;
    }

    public void add(int value){
        if(listCount==0){
            head.setData(value);
            listCount++;
        } else {

            Node currentNode = head;
            for (int i = 1; i < listCount; i++) {
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(new Node(value));
            listCount++;
        }
    }

    public void insert(int position, int value){
        if(position<listCount) {

            Node currentNode = head;
            for (int i = 0; i < position; i++) {
                currentNode = currentNode.getNextNode();
            }
            int preChangeDataVal = currentNode.getData();
            currentNode.setData(value);

            for (int i = position + 1; i < listCount; i++) {
                currentNode = currentNode.getNextNode();
                int changeVal = preChangeDataVal;
                preChangeDataVal = currentNode.getData();
                currentNode.setData(changeVal);
            }
            add(preChangeDataVal);
        }

    }
    public int get(int position){
        if(position<listCount){

            Node currentNode = head;
            for (int i = 0; i < position; i++) {
                currentNode = currentNode.getNextNode();
            }
            return currentNode.getData();
        } else {
            return 0;
        }
    }

    public void remove(int position){
        if(position<listCount){
            Node currentNode = head;
            for (int i = 0; i < position-1; i++) {
                currentNode = currentNode.getNextNode();
            }
            for (int i = position-1; i < listCount-1; i++) {
                currentNode.setData(currentNode.getNextNode().getData());
                currentNode = currentNode.getNextNode();
            }
            listCount--;
        }

    }
    public int size(){
        return listCount;
    }
}
