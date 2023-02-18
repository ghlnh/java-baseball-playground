package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    //내가 쓴 정답1
    @Test
    void testCase1(String number) {
        String[] answer = number.split(",");
        assertThat(answer).contains("1","2");
        assertThat(answer).containsExactly("1");
    }

   //다른 사람의 정답1
    @Test
    void split() {
        //given
        String str1 = "1,2";
        String str2 = "1";

        //when
        String[] strArray1 = str1.split(",");
        String[] strArray2 = str2.split(",");

        //then
        assertThat(strArray1).contains("1", "2");
        assertThat(strArray1).containsExactly("1", "2");

        assertThat(strArray2).contains("1");
        assertThat(strArray2).containsExactly("1");
    }

   //내가 쓴 정답2
    @Test
    void testCase2() {
        String answer = "(1,2)".substring(1,4);
        assertThat(answer).isEqualTo("1,2");
    }
    //다른 사람이 쓴 정답2
    @Test
    void substring() {
        //given
        String str = "(1,2)";

        //when
        String strSubString = str.substring(1,4);

        //then
        assertThat(strSubString).isEqualTo("1,2");
    }

    //내가 쓴 정답3
    @Test
    void testCase3(){
        assertThatThrownBy(() -> {
            char answer = "abc".charAt(3);
            assertThat(answer).isEqualTo('c');
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("index out of range: 3");

    }
    //다른 사람이 쓴 정답3
    @Test
    @DisplayName("charAt test")
    void charAt() {
        //given
        String str = "abc";
        int index = 2;

        //when
        char c = str.charAt(index);

        //then
        assertThat(c).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt에서 assertThatThrownBy를 사용하여 Exception 처리")
    void charAtException() {

        String str = "abc";
        int index = 21;

        assertThatThrownBy(() -> {
            char c = str.charAt(index);
            assertThat(c).isEqualTo('c');
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("%d", index);
    }

    @Test
    @DisplayName("charAt에서 assertThatExceptionOfType 사용하여 Exception 처리")
    void charAtException2() {

        String str = "abc";
        int index = 21;

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    char c = str.charAt(index);
                    assertThat(c).isEqualTo('c');
                }).withMessageContaining("%d", index);
    }

}

