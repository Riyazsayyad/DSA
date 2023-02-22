package Crio.DSA_5.AdvanceDSA;
import java.util.*;

public class ReplaceWords {
    // Implement Your Solution Here

    public static String replaceWords(ArrayList<String>dict, String sentence){
        String[] words = sentence.split(" ");
        String result = "";
        Trie obj = new Trie();
        for(String s : dict) obj.insert(s);
        for (int i = 0; i < words.length; i++) {
            words[i] = obj.findRootWord(words[i]);
        }
        for (String S : words){
            result = result.concat(S.concat(" "));
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String>dict = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            dict.add(sc.next());
        }
        String sentence = sc.nextLine();
        sentence = sc.nextLine();
        String ans = replaceWords(dict,sentence);
        System.out.print(ans);
        sc.close();
    }

}

class TrieNode{
    boolean isEndOfWord;
    TrieNode[] children;

    public TrieNode(){
        isEndOfWord = false;
        children = new TrieNode[26];
    }
}

class Trie{
    private TrieNode root;
    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    public String findRootWord(String word){
        TrieNode current = root;
        for (int i = 0;i < word.length();i++){
            if(current.children[word.charAt(i)-'a'] == null) return word;
            if(current.children[word.charAt(i)-'a'].isEndOfWord) return word.substring(0,i+1);
            current = current.children[word.charAt(i)-'a'];
        }
        return word;
    }
}
/*
class TrieNode {
    boolean isEndOfWord;
    TrieNode[] children;

    public TrieNode() {
        isEndOfWord = false;
        children = new TrieNode[26]; // 26 children for English alphabet
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return current.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return true;
    }
 */