class Solution {
    record Pair(String word, int level) {}
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Deque<Pair> q = new ArrayDeque<>();
        Set<String> set = new HashSet<>(wordList);
        q.offer(new Pair(beginWord, 1));
        set.remove(beginWord);

        while (!q.isEmpty()) {
            Pair p = q.poll();

            if (endWord.equals(p.word))
                return p.level;

            StringBuilder sb = new StringBuilder(p.word);

            for (int i = 0; i < p.word.length(); i++) {
                char original = sb.charAt(i);

                for (char c = 'a'; c <= 'z'; c++) {
                    sb.setCharAt(i, c);
                    String newWord = sb.toString();
                    if (set.contains(newWord)) {
                        set.remove(newWord);
                        q.offer(new Pair(newWord, p.level + 1));
                    }
                }

                sb.setCharAt(i, original);
            }
        }

        return 0;
    }
}
