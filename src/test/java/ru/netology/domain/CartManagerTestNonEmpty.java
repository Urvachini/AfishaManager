package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.CartManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CartManagerTestNonEmpty {



    @Test
    public void shouldGetTopTen() {

        //arrange
        CartManager manager = new CartManager();
        MovieItem first = new MovieItem(1, 1, "first", 1, 1);
        MovieItem second = new MovieItem(2, 1, "second", 1, 1);
        MovieItem third = new MovieItem(3, 1, "third", 1, 1);
        MovieItem fourth = new MovieItem(4, 1, "fourth", 1, 1);
        MovieItem fifth = new MovieItem(5, 1, "fifth", 1, 1);
        MovieItem sixth = new MovieItem(6, 1, "sixth", 1, 1);
        MovieItem seventh = new MovieItem(7, 1, "seventh", 1, 1);
        MovieItem eighth = new MovieItem(8, 1, "eighth", 1, 1);
        MovieItem ninth = new MovieItem(9, 1, "ninth", 1, 1);
        MovieItem tenth = new MovieItem(10, 1, "tenth", 1, 1);
        MovieItem eleventh = new MovieItem(11, 1, "eleventh", 1, 1);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);

        //act

        MovieItem[] actual = manager.getTop(10);
        MovieItem[] expected = new MovieItem[]{eleventh};//, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};

        //assert

        assertArrayEquals(expected, actual);


    }

    @Test
    void shouldRemoveIfExists() {
        CartManager manager = new CartManager();
        int idToRemove = 1;
        MovieItem first = new MovieItem(1, 1, "first", 1, 1);
        MovieItem second = new MovieItem(2, 1, "second", 1, 1);
        MovieItem third = new MovieItem(3, 1, "third", 1, 1);
        manager.add(first);
        manager.add(second);
        manager.add(third);

        manager.removeById(idToRemove);

        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{third, second};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotRemoveIfNotExists() {
        CartManager manager = new CartManager();
        int idToRemove = 4;
        MovieItem first = new MovieItem(1, 1, "first", 1, 1);
        MovieItem second = new MovieItem(2, 1, "second", 1, 1);
        MovieItem third = new MovieItem(3, 1, "third", 1, 1);
        manager.add(first);
        manager.add(second);
        manager.add(third);

        manager.removeById(idToRemove);

        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{third, second, first};

        assertArrayEquals(expected, actual);
    }
}
