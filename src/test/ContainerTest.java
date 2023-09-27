package test;

import main.Container;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {
    private Container<Integer> list;

    @BeforeEach
    public void setUp(){
        list = new Container<>();
    }

    @org.junit.jupiter.api.Test
    public void testSizeEmptyContainer(){
        assertEquals(0, list.size());
    }

    @org.junit.jupiter.api.Test
    public void testSizeAfterAddingElements(){
        list.Add(1);
        list.Add(2);
        list.Add(3);

        assertEquals(3, list.size());
    }

    @org.junit.jupiter.api.Test
    public void testSizeAfterRemovingElements(){
        list.Add(1);
        list.Add(2);
        list.Add(3);

        list.RemoveByPosition(0);
        list.RemoveByValue(2);

        assertEquals(1, list.size());
    }

    @org.junit.jupiter.api.Test
    void testGetValueFromEmptyContainer(){
        assertNull(list.GetValue(0));
    }

    @org.junit.jupiter.api.Test
    void testGetValueWithValidPosition(){
        list.Add(1);
        list.Add(2);
        list.Add(3);

        assertEquals(1, list.GetValue(0));
        assertEquals(2, list.GetValue(1));
        assertEquals(3, list.GetValue(2));
    }

    @org.junit.jupiter.api.Test
    void testGetValueWithInvalidPosition(){
        list.Add(1);
        list.Add(2);
        list.Add(3);

        assertNull(list.GetValue(-1));
        assertNull(list.GetValue(3));
    }

    @org.junit.jupiter.api.Test
    void testAddToEmptyContainer() {
        list.Add(1);
        assertEquals(1, list.size());
        assertEquals(1, list.GetValue(0));
    }

    @org.junit.jupiter.api.Test
    void testAddToNonEmptyContainer() {
        list.Add(1);
        list.Add(2);
        assertEquals(2, list.size());

        list.Add(3);
        assertEquals(3, list.size());
        assertEquals(3, list.GetValue(2));
    }

    @org.junit.jupiter.api.Test
    void addByPositionToEmptyContainer() {
        list.AddByPosition(1, 0);
        assertEquals(1, list.size());
        assertEquals(1, list.GetValue(0));
    }

    @org.junit.jupiter.api.Test
    void addByPositionToNonEmptyContainer() {
        list.Add(1);
        list.Add(2);
        list.AddByPosition(3, 1);

        assertEquals(3, list.size());
        assertEquals(3, list.GetValue(1));

        assertEquals(1, list.GetValue(0));
        assertEquals(2, list.GetValue(2));
    }

    @org.junit.jupiter.api.Test
    void addByPositionWithInvalidPosition(){
        list.AddByPosition(1, -1);
        assertEquals(0, list.size());
    }

    @org.junit.jupiter.api.Test
    void removeByValueFromEmptyContainer() {
        list.RemoveByValue(1);
        assertEquals(0, list.size());
    }

    @org.junit.jupiter.api.Test
    void removeByValueNonExistentElement() {
        list.Add(1);
        list.Add(2);
        list.Add(3);
        list.RemoveByValue(4);
        assertEquals(3, list.size());
    }

    @org.junit.jupiter.api.Test
    void removeByValueExistentElement() {
        list.Add(1);
        list.Add(2);
        list.Add(3);
        list.Add(1);
        list.Add(4);

        list.RemoveByValue(1);
        assertEquals(3, list.size());
        assertEquals(2, list.GetValue(0));
        assertEquals(3, list.GetValue(1));
        assertEquals(4, list.GetValue(2));
    }

    @org.junit.jupiter.api.Test
    void removeByPositionFromEmptyContainer() {
        assertNull(list.RemoveByPosition(0));
        assertEquals(0, list.size());
    }

    @org.junit.jupiter.api.Test
    void removeByPositionValidPosition(){
        list.Add(1);
        list.Add(2);
        list.Add(3);

        assertEquals(2, list.RemoveByPosition(1));
        assertEquals(2, list.size());
        assertEquals(1, list.GetValue(0));
        assertEquals(3, list.GetValue(1));
    }

    @org.junit.jupiter.api.Test
    void removeByPositionInvalidPosition(){
        list.Add(1);
        list.Add(2);
        list.Add(3);

        assertNull(list.RemoveByPosition(-1));
        assertEquals(3, list.size());
        assertEquals(1, list.GetValue(0));
        assertEquals(2, list.GetValue(1));
        assertEquals(3, list.GetValue(2));

        assertNull(list.RemoveByPosition(3));
        assertEquals(3, list.size());
        assertEquals(1, list.GetValue(0));
        assertEquals(2, list.GetValue(1));
        assertEquals(3, list.GetValue(2));
    }

    @org.junit.jupiter.api.Test
    void testRemoveAll(){
        list.Add(1);
        list.Add(2);

        list.RemoveAll();
        assertEquals(0, list.size());
    }
}