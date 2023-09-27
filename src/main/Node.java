package main;

/**
 * Класс "Node" представляет собой элемент связанного списка, содержащий данные типа T.
 *
 * @param <T> Тип данных, хранимых в узле.
 */
public class Node<T> {
    private T data;         // Данные, хранимые в узле
    private Node<T> next;   // Ссылка на следующий узел в списке

    /**
     * Конструктор класса Node.
     *
     * @param data Данные, которые будут храниться в узле.
     */
    public Node(T data)
    {
        this.data = data;
        this.next = null;
    }

    /**
     * Получить данные, хранящиеся в узле.
     *
     * @return Данные из узла.
     */
    public T GetData()
    {
        return data;
    }

    /**
     * Получить ссылку на следующий узел в списке.
     *
     * @return Ссылка на следующий узел.
     */
    public Node<T> GetNext()
    {
        return next;
    }

    /**
     * Установить ссылку на следующий узел в списке.
     *
     * @param next Ссылка на следующий узел.
     */
    public void SetNext(Node<T> next)
    {
        this.next = next;
    }
}
