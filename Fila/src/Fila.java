public class Fila {


    private Node first;
    private Node last;
    private int lenght;

    public class Node{
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    Fila(int value){
        Node newNome = new Node(value);
        first = newNome;
        last = newNome;
        lenght++;
    }

    public void getFirst(){
        if(first != null){
            System.out.println("First " + first.value);
        }else{
            System.out.println("A lista esta vazia");
        }
    }


    public void getLast(){
        if(last != null){
            System.out.println("First " + last.value);
        }else{
            System.out.println("A lista esta vazia");
        }
    }

    public void getLenght(){
        System.out.println("Tamanho: " + lenght);
    }

    public void print(){
        System.out.println("###########################");
        Node temp = first;
        while(temp!=null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void enqueue(int value){
        Node newNode = new Node(value);
        if(lenght ==0){
            first = newNode;
            last = newNode;
        }else{
            last.next = newNode;
            last = newNode;
        }
        lenght++;
    }

    public Node dequeue(){
        if(lenght == 0) return null;
        Node temp = first;
        if(lenght ==1){
            first = null ;
            last = null;
        }else{
            first = first.next;
            temp.next = null;
        }
        lenght--;
        return temp;
    }

    public static void main(String[] args) {
        Fila fila = new Fila(1);
        fila.print();
        fila.getFirst();
        fila.enqueue(2);
        fila.enqueue(4);
        fila.print();
        fila.getFirst();
        fila.getLast();
        System.out.println(fila.dequeue().value);
        System.out.println(fila.dequeue().value);
        System.out.println(fila.dequeue().value);
    }




}
