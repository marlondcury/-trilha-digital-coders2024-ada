/*
Principais Operações:

1. Adicionar Item:
a) No início (prepend)
b) No fim (append)
c) Em uma determinada posição (insert)

2. Ler item:
a) No início (getHead)
b) No fim ( getTail)
c) De uma determinada posição (get)

3. Remover item:
a) No início ( removeFirst)
b) No fim ( removeLast)
c) Em uma determinada posição (delete)

4. Imprimir item

5. Operações adicionais:
a) Tamanho atual (getLength)
b) Verificar se estar vazia ( isEmpty)
c) Esvaziar lista (makeEmpty)

6. Criar lista
a) Criar construtor
b) Criar nó
c) recuperar cabeça, calda, tamanho
 */

public class ListaEncadeada {

    private Node head;
    private Node tail;
    private int length;

    public ListaEncadeada(String data) {
        length = 1;
        Node newNode = new Node(data);
        head = newNode;
        tail = newNode;

    }

    class Node{
        String data;
        Node next;

        Node(String data){
            this.data = data;
        }
    }


    public void getTail(){
        if(this.tail ==null){
            System.out.println("Lista vazia");
        }
        else{
            System.out.println("Cabeça: " + tail.data);
        }
    }


    public void getHead(){
        if(this.head ==null){
            System.out.println("Lista vazia");
        }
        else{
            System.out.println("Cabeça: " + head.data);
        }
    }


    public void getLength(){
        System.out.println("Tamanho da lista: " + this.length);
    }

    public void makeEmpty(){
        this.tail = null;
        this.head = null;
        length = 0;
    }

    public void print(){
        Node temp = this.head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("###########################################");

    }

    public void append(String data){
        Node newNode = new Node(data);
        if(length ==0){
            this.head = newNode;
            this.tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast(){
        if(length == 0) return  null;
        Node pre = head;
        Node temp = null;
        while(pre.next != tail){
            pre = pre.next;
        }
        temp = tail;
        tail = pre;
        tail.next = null;

        length--;
        if(length==0){
            head = null;
            tail = null;
        }
        return  temp;
    }

    public void preprend(String data){
        Node newNode = new Node(data);
        if( length == 0){
            head = newNode;
            tail = newNode;
        }else{
            newNode.next = head;
            head = newNode;
            length++;
        }
    }

    public Node removeFirst(){
        if(length == 0) return  null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if(length ==0){
            head = null;
            tail = null;
        }
        return temp;
    }

    public Node get(int index){
        if(index < 0 || index >=length) return  null;
        Node temp = head;
        for(int i = 0; i < index; i ++){
            if(index == i){
                temp = temp.next;
            }
        }
        return  temp;
    }

    public boolean insert(int index, String data){
        if(index < 0 || index > length) return  false;
        if(index == 0) {
            preprend(data);
            return true;
        }
        if(index==length){
            append(data);
            return true;
        }

        Node newNode = new Node(data);
        Node temp = get(index-1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public boolean set(int index, String data){
        Node temp = get(index);
        if(temp != null){
            temp.data = data;
            return true;
        }
        return false;
    }


    public Node remove(int index){
        if(index < 0 || index > length) return  null;
        if(index == 0) return removeFirst();
        if(index == (length-1)) return removeLast();

        Node prev = get(index-1);
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;

        return temp;




    }


    public static void main(String[] args) {
        ListaEncadeada list = new ListaEncadeada("Elemento 1");
        list.getTail();
        list.getLength();
        list.getHead();
        list.print();
        list.append("Elemento 2");
        list.append("Elemento 3");
        list.print();
        list.getHead();
        list.getTail();
        list.removeLast();
        list.print();
        System.out.println();
        list.preprend("Elemento 0");
        list.print();
        list.removeFirst();
        list.print();
        System.out.println(list.get(1).data);
        list.insert(2, "Elemento 3");
        list.print();
        list.set(2, "Elemento 0");
        list.print();
        list.remove(1);
        list.print();
    }


}
