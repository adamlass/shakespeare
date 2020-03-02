package sorting;

/**
 * TrieSort
 */
public class TrieSort extends Sorter<String> {

    @Override
    public String[] sort(String[] arr) {
        Trie trie = new Trie();

        for (int i = 0; i < arr.length; i++) {
            trie.insert(arr[i], i);
        }

        trie.traverse(arr);
        return trie.getResult();
    }

}