package ru.job4j.array;

public class EndsWith {
    public static boolean endsWith(char[] word, char[] post) {
        boolean result = true;
        for(int index = 0; index < post.length; index++){
            int word_index = word.length-index-1;
            int post_index = post.length-index-1;
            if(word[word_index]!=post[post_index]){
                result = false;
                break;
            }
        }
        return result;
    }
}