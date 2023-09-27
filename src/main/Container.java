package main;

/**
 * Класс "Container" представляет собой контейнер для хранения элементов типа T в виде связанного списка.
 *
 * @param <T> Тип данных, хранимых в контейнере.
 */
public class Container<T> {
    private Node<T> head;
    private int size;

    /**
     * Конструктор класса Container. Создает пустой контейнер.
     */
    public Container() {
        head = null;
        size = 0;
    }

    /**
     * Получить количество элементов в контейнере.
     *
     * @return Количество элементов в контейнере.
     */
    public int size() {
        return size;
    }

    /**
     * Получить значение элемента по указанной позиции в контейнере.
     *
     * @param pos Позиция элемента в контейнере.
     * @return Значение элемента или `null`, если позиция некорректна.
     */
    public T GetValue(int pos) {
        if(pos < 0 || pos >= size) {
            System.out.println("Wrong position. The element cannot be obtained.");
            return null;
        }
        Node<T> cur = head;
        for (int i = 0; i < pos; ++i)
            cur = cur.GetNext();
        return cur.GetData();
    }

    /**
     * Добавить элемент в конец контейнера.
     *
     * @param val Значение элемента, которое нужно добавить.
     */
    public void Add(T val) {
        Node<T> nNode = new Node<>(val);
        if(head == null)
            head = nNode;
        else {
            Node<T> cur = head;
            while(cur.GetNext() != null)
                cur = cur.GetNext();
            cur.SetNext(nNode);
        }
        ++size;
    }

    /**
     * Добавить элемент в контейнер по указанной позиции.
     *
     * @param val Значение элемента, которое нужно добавить.
     * @param pos Позиция, на которую нужно добавить элемент.
     */
    public void AddByPosition(T val, int pos){
        if (pos < 0 || pos > size) {
            System.out.println("Wrong position. The element cannot be added.");
            return;
        }

        Node<T> newNode = new Node<>(val);
        if (pos == 0) {
            newNode.SetNext(head);
            head = newNode;
        } else {
            Node<T> cur = head;
            int curPosition = 0;

            while (curPosition < pos - 1) {
                cur = cur.GetNext();
                curPosition++;
            }

            newNode.SetNext(cur.GetNext());
            cur.SetNext(newNode);
        }
        size++;
    }

    /**
     * Удалить все элементы с указанным значением из контейнера.
     *
     * @param val Значение элемента, которое нужно удалить.
     */
    public void RemoveByValue(T val) {
        if (size == 0) {
            System.out.println("The container is empty. Deletion failed.");
        } else {
            int oldSize = size;
            while (head.GetData().equals(val) && head != null) {
                head = head.GetNext();
                size--;
            }
            Node<T> cur = head;
            while (cur.GetNext() != null && cur != null) {
                if (cur.GetNext().GetData().equals(val)) {
                    cur.SetNext(cur.GetNext().GetNext());
                    size--;
                } else
                    cur = cur.GetNext();
            }
            if (size == oldSize)
                System.out.println("The value not found in the container. Deletion failed.");
        }
    }

    /**
     * Удалить элемент из контейнера по указанной позиции.
     *
     * @param pos Позиция элемента, который нужно удалить.
     * @return Значение удаленного элемента или `null`, если позиция некорректна.
     */
    public T RemoveByPosition(int pos) {
        if (size == 0) {
            System.out.println("The container is empty. Deletion failed.");
            return null;
        }

        if (pos < 0 || pos >= size) {
            System.out.println("Wrong position. Deletion failed.");
            return null;
        }

        T removedValue;
        if (pos == 0) {
            removedValue = head.GetData();
            head = head.GetNext();
            size--;
            return removedValue;
        }

        Node<T> cur = head;
        int curPosition = 0;
        while (cur != null && curPosition < pos - 1) {
            cur = cur.GetNext();
            curPosition++;
        }

        if (cur != null && cur.GetNext() != null) {
            removedValue = cur.GetNext().GetData();
            cur.SetNext(cur.GetNext().GetNext());
            size--;
            return removedValue;
        }
        return null;
    }

    /**
     * Удалить все элементы из контейнера, делая его пустым.
     */
    public void RemoveAll() {
        while(head != null)
            RemoveByPosition(0);
    }

    /**
     * Вывести все элементы контейнера в консоль.
     */
    public void PrintList() {
        if(size == 0) {
            System.out.println("The container is empty.");
            return;
        }

        Node<T> cur = head;
        while(cur != null) {
            System.out.print(cur.GetData() + " ");
            cur = cur.GetNext();
        }
        System.out.println();
    }
}
