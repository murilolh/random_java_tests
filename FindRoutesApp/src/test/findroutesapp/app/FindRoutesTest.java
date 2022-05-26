package findroutesapp.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FindRoutesTest {
    @Test
    @DisplayName("five city acronyms")
    public void fiveCityAcronyms() {
        assertEquals("MNL, TAG, CEB, TAC, BOR",
                FindRoutes.findRoutes(new ArrayList<ArrayList<String>>(Arrays.asList(
                        new ArrayList<String>(Arrays.asList("MNL", "TAG")),
                        new ArrayList<String>(Arrays.asList("CEB", "TAC")),
                        new ArrayList<String>(Arrays.asList("TAG", "CEB")),
                        new ArrayList<String>(Arrays.asList("TAC", "BOR"))))
                )
        );
    }

    @Test
    @DisplayName("six full city names")
    public void sixFullCityNames() {
        assertEquals("Halifax, Montreal, Toronto, Chicago, Winnipeg, Seattle",
                FindRoutes.findRoutes(
                        new ArrayList<ArrayList<String>>(Arrays.asList(
                                new ArrayList<String>(Arrays.asList("Chicago", "Winnipeg")),
                                new ArrayList<String>(Arrays.asList("Halifax", "Montreal")),
                                new ArrayList<String>(Arrays.asList("Montreal", "Toronto")),
                                new ArrayList<String>(Arrays.asList("Toronto", "Chicago")),
                                new ArrayList<String>(Arrays.asList("Winnipeg", "Seattle"))))
                )
        );
    }

    @Test
    @DisplayName("two full city names")
    public void twoFullCityNames() {
        assertEquals("Halifax, Montreal",
                FindRoutes.findRoutes(
                        new ArrayList<ArrayList<String>>(List.of(
                                new ArrayList<String>(Arrays.asList("Halifax", "Montreal"))))
                )
        );
    }

    @Test
    @DisplayName("three full city names, random order")
    public void threeFullCityNames() {
        assertEquals("Halifax, Montreal, Toronto",
                FindRoutes.findRoutes(
                        new ArrayList<>(List.of(
                                new ArrayList<>(Arrays.asList("Montreal", "Toronto")),
                                new ArrayList<>(Arrays.asList("Halifax", "Montreal"))))
                )
        );
    }

    @Test
    @DisplayName("six full city names circular")
    public void sixFullCityNamesCircular() {

        assertThrows(RuntimeException.class, () -> {
            FindRoutes.findRoutes(
                    new ArrayList<>(Arrays.asList(
                            new ArrayList<>(Arrays.asList("Chicago", "Winnipeg")),
                            new ArrayList<>(Arrays.asList("Halifax", "Montreal")),
                            new ArrayList<>(Arrays.asList("Montreal", "Toronto")),
                            new ArrayList<>(Arrays.asList("Toronto", "Chicago")),
                            new ArrayList<>(Arrays.asList("Seattle", "Halifax")),
                            new ArrayList<>(Arrays.asList("Winnipeg", "Seattle"))))
            );
        });
    }

    @Test
    @DisplayName("seven full city names multiple origins")
    public void sevenFullCityNamesMultipleOrigins() {

        assertThrows(RuntimeException.class, () -> {
            FindRoutes.findRoutes(
                    new ArrayList<>(Arrays.asList(
                            new ArrayList<>(Arrays.asList("Chicago", "Winnipeg")),
                            new ArrayList<>(Arrays.asList("Halifax", "Montreal")),
                            new ArrayList<>(Arrays.asList("Montreal", "Toronto")),
                            new ArrayList<>(Arrays.asList("Toronto", "Chicago")),
                            new ArrayList<>(Arrays.asList("London", "Montreal")),
                            new ArrayList<>(Arrays.asList("Winnipeg", "Seattle"))))
            );
        });
    }
}

