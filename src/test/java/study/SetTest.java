package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // Test Case 구현
    //내가 쓴 정답1
    @Test
    void size() {
        int size = numbers.size();
        assertThat(size).isEqualTo(3);
    }

    //내가 쓴 정답2
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void contains(int ints) {
        assertTrue(numbers.contains(ints));
    }

    //내가 쓴 정답3
    @ParameterizedTest
    @CsvSource(value = {"true:false", "4:false", "5:false"}, delimiter = ':')
    void contain2(int value, boolean expected) {
       boolean actualValue = numbers.contains(value);
       assertEquals(expected, actualValue);
    }


    //다른사람이 쓴 정답3
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("메소드 결과값이 다른 경우 테스트")
    void csvSourceTest(int input, boolean excepted) {
        boolean result = numbers.contains(input);
        assertThat(result).isEqualTo(excepted);
    }
}
