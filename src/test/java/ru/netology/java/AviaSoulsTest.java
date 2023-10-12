package ru.netology.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {

    Ticket ticket1 = new Ticket("Москва", "Новосибирск", 10_000, 3, 9);
    Ticket ticket2 = new Ticket("Семфирополь", "Санкт-Петербург", 20_500, 17, 22);
    Ticket ticket3 = new Ticket("Санкт-Петербург", "Париж", 16_635, 12, 14);
    Ticket ticket4 = new Ticket("Новoсибирск", "Москва", 10_000, 15, 19);
    Ticket ticket5 = new Ticket("Новoсибирск", "Москва", 5_220, 4, 10);
    Ticket ticket6 = new Ticket("Новoсибирск", "Москва", 35_600, 6, 9);

    AviaSouls manager = new AviaSouls();

    @BeforeEach
    public void shouldAdd() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
    }

    @Test
    public void shouldComparePriseIfMore() {
        System.out.println(ticket1.compareTo(ticket5));

        int expected = 1;
        int actual = ticket1.compareTo(ticket5);

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void shouldComparePriseIfLess() {
        System.out.println(ticket1.compareTo(ticket2));

        int expected = -1;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void shouldComparePriseIfEqual() {
        System.out.println(ticket1.compareTo(ticket4));

        int expected = 0;
        int actual = ticket1.compareTo(ticket4);

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void shouldSortByPriceMinToMax() {
        Ticket[] expected = {ticket5, ticket4, ticket6};
        Ticket[] actual = manager.search("Новoсибирск", "Москва");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindInOne() {
        Ticket[] expected = {ticket2};
        Ticket[] actual = manager.search("Семфирополь", "Санкт-Петербург");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNothingFound() {
        Ticket[] expected = {};
        Ticket[] actual = manager.search("Санкт-Петербург", "Кемерово");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortByFlightTime() {
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket6, ticket4, ticket5};
        Ticket[] actual = manager.searchAndSortBy("Новoсибирск", "Москва", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
