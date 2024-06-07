public class Stacks {

    private Node top;
    private int height;

    public Stacks(int value){
        Node newNode = new Node(value);
        top = newNode;
        height = 1;

    }


    public class Node {
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }
    }

    public void getTop(){
        if(top == null){
            System.out.println("Pilha vazia");
        }
        System.out.println(" Topo: "+ top.value);
    }

    public void getHeight(){
        System.out.println("Altura da pilha: " + height);
    }

    public void print(){
        Node temp = top;
        System.out.println("###################");
        while(temp !=null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
    //inserir
    public void push(int value){
        Node newNode = new Node(value);
        if(height == 0){
            top = newNode;
        }else{
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    public Node pop(){
        Node temp = top;
        if(height==0){
            System.out.println("Pilha vazia");
            return null;
        }else{
            top = top.next;
            temp.next = null;
            height--;
        }
        return temp;
    }

    public static void main(String[] args) {
        Stacks p1 = new Stacks(1);
        p1.print();
        p1.getTop();
        p1.getHeight();
        p1.push(4);
        p1.push(10);
        p1.push(4150);
        p1.print();
        p1.getHeight();
        p1.pop();
        p1.print();
        p1.getHeight();

    }


}
