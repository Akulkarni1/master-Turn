class Link
{
    public long dData;
    public Link next;
    public Link(long dd)
    { dData = dd; }
    public void displayLink()
    { System.out.print(dData + " "); }
}
class LinkList
{
    private Link first;
    public LinkList() { first = null;
    }
    public boolean isEmpty()
    { return (first==null); }
    public void insertFirst(long dd)
    {
        Link newLink = new Link(dd);
        newLink.next = first;
        first = newLink;
    }
    public long deleteFirst() {
        Link temp = first;
        first = first.next;
        return temp.dData;
    }
    public void displayList()
    {
        Link current = first;
        while(current != null)
        {
            current.displayLink();
            current = current.next;
        }
        System.out.println(" ");
    }
}
class LinkStack
{
    private LinkList theList;
    public LinkStack()
    {
        theList = new LinkList();
    }
    public void push(long j)
    {
        theList.insertFirst(j);
    }
    public long pop()
    {
        return theList.deleteFirst();
    }
    public boolean isEmpty()
    {
        return ( theList.isEmpty() );
    }
    public void displayStack()
    {
        System.out.print("Stack (top-->bottom): ");
        theList.displayList();
    }
}

class QueueList
{
    private Link first;
    private Link last;
    public QueueList(){
        first = null;
        last = null;
    }
    public boolean isEmpty() { return first==null; }
    public void insertLast(long dd) {
        Link newLink = new Link(dd);
        if( isEmpty() )
            first = newLink;
        else
            last.next = newLink;
        last = newLink;
    }
    public long deleteFirst() {
        long temp = first.dData;
        if(first.next == null)
            last = null;
        first = first.next;
        return temp;
    }
    public void displayList()
    {
        Link current = first; // start at beginning
        while(current != null) // until end of list,
        {
            current.displayLink(); // print data
            current = current.next; // move to next link
        }
        System.out.println(" ");
    }
}
class LinkQueue {
    private QueueList theList;

    public LinkQueue() // constructor
    {
        theList = new QueueList();
    }

    public boolean isEmpty() // true if queue is empty
    {
        return theList.isEmpty();
    }

    public void insert(long j) // insert, rear of queue
    {
        theList.insertLast(j);
    }

    public long remove() // remove, front of queue
    {
        return theList.deleteFirst();
    }

    public void displayQueue() {
        System.out.print("Queue (front-->rear): ");
        theList.displayList();
    }
}

public class LinkStackAppl {


    public static void main(String[] args)
    {
        LinkStack theStack = new LinkStack();

        theStack.push(20);
        theStack.push(40);
        theStack.displayStack();
        theStack.push(60);
        theStack.push(80);
        theStack.displayStack();
        theStack.pop();
        theStack.pop();
        theStack.displayStack();
    }
}