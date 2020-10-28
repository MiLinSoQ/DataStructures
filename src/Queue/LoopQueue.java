public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
//    private int size;

    public LoopQueue(int capacity) {
        this.data = (E[]) new Object[capacity + 1];
        this.front = 0;
        this.tail = 0;
//        this.size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getSize() {

        if (this.tail >= this.front) {
            return this.tail - this.front;
        } else {
            return this.data.length - this.front + this.tail;
        }
//        return this.size;
    }

    public int getCapacity() {
        return this.data.length - 1;
    }

    public boolean isEmpty() {
        return this.front == this.tail;
    }

    public void enqueue(E e) {

        if (((this.tail + 1) % this.data.length) == this.front) {
            resize(2 * getCapacity());
        }

        this.data[this.tail] = e;
        this.tail = (this.tail + 1) % this.data.length;
//        this.size++;
    }


    public E dequeue() {
        if (isEmpty()) throw new IllegalArgumentException("Dequeue failed, data is empty.");

        E ret = data[this.front];
        data[this.front] = null;
        this.front = (this.front + 1) % this.data.length;

//        this.size--;
        if (this.getSize() <= getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    public E getFirst() {
        if (isEmpty()) throw new IllegalArgumentException("Dequeue failed, data is empty.");
        return this.data[this.front];
    }

    private void resize(int newCapacity) {
        if (newCapacity < 0) throw new IllegalArgumentException("Resize failed, capacity is illegal.");

        E[] newData = (E[]) new Object[newCapacity + 1];

        for (int i = 0; i < this.getSize(); i++) {
            newData[i] = this.data[(i + this.front) % this.data.length];
        }

        this.data = newData;
		
		this.tail = getSize();
        this.front = 0;
        
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Loop Queue: size: [ %d ], capacity: [ %d ]\n", getSize(), getCapacity()));
        res.append("Front [ ");

        for (int i = 0; i < getSize(); i++) {
            res.append(data[(i + this.front) % getCapacity()]);
            if ((i + this.front) % getCapacity() != this.tail - 1) res.append(", ");
        }

        res.append(" ] Tail");
        return res.toString();
    }
}
