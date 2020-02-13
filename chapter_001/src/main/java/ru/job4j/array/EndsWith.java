package ru.job4j.array;

public class EndsWith {
    public static boolean endsWith(char[] word, char[] post) {
        boolean result = true;
        for (int index = 0; index < post.length; index++) {
            int wordIndex = word.length - index - 1;
            int postIndex = post.length - index - 1;
            if (word[wordIndex] != post[postIndex]) {
                result = false;
                break;
            }
        }
        return result;
    }
}