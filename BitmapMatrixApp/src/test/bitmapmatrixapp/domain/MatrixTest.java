package bitmapmatrixapp.domain;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MatrixTest {

    private Matrix matrix;

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        matrix = new Matrix(15, 15, 100);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void canCreateMatrixTest() {
        Assert.assertEquals(15, matrix.width);
        Assert.assertEquals(15, matrix.height);
        Assert.assertEquals(100, matrix.elementQtd);
    }

    @Test
    public void populateWithRandomValuesAllValuesGeneratedTest() {
        matrix.populateWithRandomValues();
        for (int i = 0; i < matrix.width; i++) {
            for (int j = 0; j < matrix.height; j++) {
                Assert.assertNotNull(matrix.values[i][j]);
            }
        }
    }

    @Test
    public void populateWithRandomValuesAllValuesIntegerTest() {
        matrix.populateWithRandomValues();
        for (int i = 0; i < matrix.width; i++) {
            for (int j = 0; j < matrix.height; j++) {
                Assert.assertTrue(matrix.values[i][j] >= 0 && matrix.values[i][j] < matrix.elementQtd);
            }
        }
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void name() {
        matrix.populateWithRandomValues();
        int expectException = matrix.values[matrix.width + 1][matrix.height + 1];
        Assert.fail("Assigning value [" + expectException + "] to expectException should raise an ArrayIndexOutOfBoundsException.");
    }

    @Test
    public void calculateElementCountAllElementsSameNumberTest() {
        int n = 0;
        for (int i = 0; i < matrix.width; i++) {
            for (int j = 0; j < matrix.height; j++) {
                matrix.values[i][j] = n++;
            }
        }
        matrix.calculateElementCount();
        for (int i = 0; i < matrix.width * matrix.height; i++)
            Assert.assertSame(1, matrix.elementCountMap.get(i));
    }

    @Test
    public void calculateElementCountAllSameElementTest() {
        for (int i = 0; i < matrix.width; i++) {
            for (int j = 0; j < matrix.height; j++) {
                matrix.values[i][j] = 1;
            }
        }
        matrix.calculateElementCount();
        Assert.assertEquals(1, matrix.elementCountMap.size());
        Assert.assertEquals(Integer.valueOf(matrix.width * matrix.height), matrix.elementCountMap.get(1));
    }

    @Test
    public void printMatrixTest() {
        generateDummyMatrix();
        matrix.printMatrix();

        Assert.assertEquals("Matrix" + System.lineSeparator() +
                "0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 " + System.lineSeparator() +
                "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 " + System.lineSeparator() +
                "2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 " + System.lineSeparator() +
                "3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 " + System.lineSeparator() +
                "4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 " + System.lineSeparator() +
                "5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 " + System.lineSeparator() +
                "6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 " + System.lineSeparator() +
                "7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 " + System.lineSeparator() +
                "8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 " + System.lineSeparator() +
                "9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 " + System.lineSeparator() +
                "10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 " + System.lineSeparator() +
                "11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 " + System.lineSeparator() +
                "12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 " + System.lineSeparator() +
                "13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 " + System.lineSeparator() +
                "14 15 16 17 18 19 20 21 22 23 24 25 26 27 28",
                outputStreamCaptor.toString().trim());
    }

    @Test
    public void printElementCountTest() {
        generateDummyMatrix();
        matrix.calculateElementCount();
        matrix.printElementCount();

        Assert.assertEquals("Element:Quantity" + System.lineSeparator() +
                        "0:1" + System.lineSeparator() +
                        "1:2" + System.lineSeparator() +
                        "2:3" + System.lineSeparator() +
                        "3:4" + System.lineSeparator() +
                        "4:5" + System.lineSeparator() +
                        "5:6" + System.lineSeparator() +
                        "6:7" + System.lineSeparator() +
                        "7:8" + System.lineSeparator() +
                        "8:9" + System.lineSeparator() +
                        "9:10" + System.lineSeparator() +
                        "10:11" + System.lineSeparator() +
                        "11:12" + System.lineSeparator() +
                        "12:13" + System.lineSeparator() +
                        "13:14" + System.lineSeparator() +
                        "14:15" + System.lineSeparator() +
                        "15:14" + System.lineSeparator() +
                        "16:13" + System.lineSeparator() +
                        "17:12" + System.lineSeparator() +
                        "18:11" + System.lineSeparator() +
                        "19:10" + System.lineSeparator() +
                        "20:9" + System.lineSeparator() +
                        "21:8" + System.lineSeparator() +
                        "22:7" + System.lineSeparator() +
                        "23:6" + System.lineSeparator() +
                        "24:5" + System.lineSeparator() +
                        "25:4" + System.lineSeparator() +
                        "26:3" + System.lineSeparator() +
                        "27:2" + System.lineSeparator() +
                        "28:1" + System.lineSeparator() +
                        "29:0" + System.lineSeparator() +
                        "30:0" + System.lineSeparator() +
                        "31:0" + System.lineSeparator() +
                        "32:0" + System.lineSeparator() +
                        "33:0" + System.lineSeparator() +
                        "34:0" + System.lineSeparator() +
                        "35:0" + System.lineSeparator() +
                        "36:0" + System.lineSeparator() +
                        "37:0" + System.lineSeparator() +
                        "38:0" + System.lineSeparator() +
                        "39:0" + System.lineSeparator() +
                        "40:0" + System.lineSeparator() +
                        "41:0" + System.lineSeparator() +
                        "42:0" + System.lineSeparator() +
                        "43:0" + System.lineSeparator() +
                        "44:0" + System.lineSeparator() +
                        "45:0" + System.lineSeparator() +
                        "46:0" + System.lineSeparator() +
                        "47:0" + System.lineSeparator() +
                        "48:0" + System.lineSeparator() +
                        "49:0" + System.lineSeparator() +
                        "50:0" + System.lineSeparator() +
                        "51:0" + System.lineSeparator() +
                        "52:0" + System.lineSeparator() +
                        "53:0" + System.lineSeparator() +
                        "54:0" + System.lineSeparator() +
                        "55:0" + System.lineSeparator() +
                        "56:0" + System.lineSeparator() +
                        "57:0" + System.lineSeparator() +
                        "58:0" + System.lineSeparator() +
                        "59:0" + System.lineSeparator() +
                        "60:0" + System.lineSeparator() +
                        "61:0" + System.lineSeparator() +
                        "62:0" + System.lineSeparator() +
                        "63:0" + System.lineSeparator() +
                        "64:0" + System.lineSeparator() +
                        "65:0" + System.lineSeparator() +
                        "66:0" + System.lineSeparator() +
                        "67:0" + System.lineSeparator() +
                        "68:0" + System.lineSeparator() +
                        "69:0" + System.lineSeparator() +
                        "70:0" + System.lineSeparator() +
                        "71:0" + System.lineSeparator() +
                        "72:0" + System.lineSeparator() +
                        "73:0" + System.lineSeparator() +
                        "74:0" + System.lineSeparator() +
                        "75:0" + System.lineSeparator() +
                        "76:0" + System.lineSeparator() +
                        "77:0" + System.lineSeparator() +
                        "78:0" + System.lineSeparator() +
                        "79:0" + System.lineSeparator() +
                        "80:0" + System.lineSeparator() +
                        "81:0" + System.lineSeparator() +
                        "82:0" + System.lineSeparator() +
                        "83:0" + System.lineSeparator() +
                        "84:0" + System.lineSeparator() +
                        "85:0" + System.lineSeparator() +
                        "86:0" + System.lineSeparator() +
                        "87:0" + System.lineSeparator() +
                        "88:0" + System.lineSeparator() +
                        "89:0" + System.lineSeparator() +
                        "90:0" + System.lineSeparator() +
                        "91:0" + System.lineSeparator() +
                        "92:0" + System.lineSeparator() +
                        "93:0" + System.lineSeparator() +
                        "94:0" + System.lineSeparator() +
                        "95:0" + System.lineSeparator() +
                        "96:0" + System.lineSeparator() +
                        "97:0" + System.lineSeparator() +
                        "98:0" + System.lineSeparator() +
                        "99:0",
                outputStreamCaptor.toString().trim());
    }

    private void generateDummyMatrix() {
        for (int i = 0; i < matrix.width; i++) {
            for (int j = 0; j < matrix.height; j++) {
                matrix.values[i][j] = i + j;
            }
        }
    }

    @After
    public void tearDown() {
        System.setOut(standardOut);
    }
}
