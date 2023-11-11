package vmath;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Mat4Test {

    @Test
    void givenNoArgs_whenMat4Created_thenMatrixIsIdentity() {
        Mat4 m = new Mat4();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    assertEquals(m.get(i, j), 1.0f);
                } else {
                    assertEquals(m.get(i, j), 0.0f);
                }
            }
        }
    }

    @Test
    void givenIndices_whenGetCalled_thenReturnCorrectValue() {
        //TODO
    }

    @Test
    void givenInvalidIndices_whenGetCalled_thenThrowIndexOutOfBoundsException() {
        Mat4 m = new Mat4();

        assertThrows(IndexOutOfBoundsException.class, () -> m.get(-1, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> m.get(4, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> m.get(0, -1));
        assertThrows(IndexOutOfBoundsException.class, () -> m.get(0, 4));
    }

    @Test
    void givenTwoMatrices_whenMultiplied_thenResultIsCorrect() {
        Mat4 m1 = new Mat4();
        Mat4 m2 = new Mat4();

        Mat4 expectedResult = new Mat4();
        Mat4 actualResult = m1.mul(m2);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                assertEquals(expectedResult.get(i, j), actualResult.get(i, j));
            }
        }
    }
}