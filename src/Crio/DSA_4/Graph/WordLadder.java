package Crio.DSA_4.Graph;
import java.util.*;

class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.length() != endWord.length()) return 0;
        if(beginWord.equals(endWord)) return 1;

        HashSet<String> wordsSet = new HashSet<>(wordList);
        if(!wordsSet.contains(endWord)) return 0;

        Queue<WordObj> qFirst = new LinkedList<>();
        Queue<WordObj> qSecond = new LinkedList<>();
        HashSet<String> visitedFirst = new HashSet<>();
        HashSet<String> visitedSecond = new HashSet<>();
        qFirst.offer(new WordObj(beginWord,1));
        qSecond.offer(new WordObj(endWord,1));
        visitedFirst.add(beginWord);
        visitedSecond.add(endWord);

        while (!qFirst.isEmpty() && !qSecond.isEmpty()){
            int sizeFirst = qFirst.size();
            for(int i = 0; i < sizeFirst; i++){
                WordObj firstBFSobj = qFirst.poll();
                if(visitedSecond.contains(firstBFSobj.word)) return firstBFSobj.freq*2 - 1;

                for(int j = 0; j < beginWord.length(); j++){
                    char[] wordArray = firstBFSobj.word.toCharArray();
                    for(char k = 'a'; k <= 'z'; k++){
                        wordArray[j] = k;
                        String newWord = new String(wordArray);
                        if(wordsSet.contains(newWord) && !visitedFirst.contains(newWord)){
                            qFirst.offer(new WordObj(newWord, firstBFSobj.freq + 1));
                            visitedFirst.add(newWord);
                        }
                    }
                }
            }
            int sizeSecond = qSecond.size();
            for(int i = 0; i < sizeSecond; i++){
                WordObj secondBFSobj = qSecond.poll();
                if(visitedFirst.contains(secondBFSobj.word)) return secondBFSobj.freq*2 ;

                for(int j = 0; j < endWord.length(); j++){
                    char[] wordArray = secondBFSobj.word.toCharArray();
                    for(char k = 'a'; k <= 'z'; k++){
                        wordArray[j] = k;
                        String newWord = new String(wordArray);
                        if(wordsSet.contains(newWord) && !visitedSecond.contains(newWord)){
                            qSecond.offer(new WordObj(newWord, secondBFSobj.freq + 1));
                            visitedSecond.add(newWord);
                        }
                    }
                }
            }
        }
        return 0;
    }

    static class WordObj {
        int freq; String word;
        private WordObj(String word,int freq){
            this.freq = freq;
            this.word = word;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String beginWord = scanner.nextLine();
        String endWord = scanner.nextLine();

        int n = scanner.nextInt();
        List<String> wordList = new ArrayList<String>();

        for (int i = 0; i < n; ++i) {
            String word = scanner.next();
            wordList.add(word);
        }
        scanner.close();
        int result = new WordLadder().ladderLength(beginWord, endWord, wordList);
        System.out.println(result);
    }
}

/*
        //From Single BFS
        HashSet<String> wordsSet = new HashSet<>(wordList);
        if(!wordsSet.contains(endWord)) return 0;

        Queue<WordObj> qFirst = new LinkedList<>();
        int ans = 0;
        qFirst.offer(new WordObj(beginWord,1));


        while (!qFirst.isEmpty()){
            WordObj temp = qFirst.poll();
            ans = Math.max(0,temp.freq*2+1);
            StringBuilder s = new StringBuilder(temp.word);

            for (int i = 0; i < beginWord.length(); i++) {
                for (char j = 'a'; j <= 'z'; j++) {
                    if(wordsSet.contains((s.replace(i,i+1, String.valueOf(j))).toString())) {
                        wordsSet.remove(s.toString());
                        qFirst.offer(new WordObj(s.toString(),temp.freq+1));
                    }
                }
                if(s.toString().equals(endWord)) break;
                s = new StringBuilder(temp.word);
            }
        }

        return ans;
 */