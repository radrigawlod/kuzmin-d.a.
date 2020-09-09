// Кузьмин Д, ИБ-119
// Билет 16
// На вход поступают текстовый файл, строка и число n
// Вывести все слова из строки длиннее числа n, содержащиеся в файле

public class BST<String extends Comparable<String>, Integer> {
    private class Node
    {
        private String key;
        private int val;
        private Node left, right;
        private int N;
        public Node(String key, int val, int N)
        {
            this.key=key;
            this.val=val;
            this.N=N;
        }
    }

    private Node root;

    public int size()
    {
        return size(root);
    }

    public int size(Node x)
    {
        if (x==null) return 0;
        else return x.N;
    }

    public int get (String key)
    {
        return get(root, key);
        // this.root, key
    }

    public int get (Node x, String key)
    {
        if (x==null) return -1;
        int compare = key.compareTo(x.key);
        if (compare<0) return get(x.left, key);
        else if (compare>0) return get(x.right, key);
        else return x.val;
    }

    public void put (String key, int val)
    {
        root = put(root, key, val);
    }

    public Node put (Node x, String key, int val)
    {
        if (x==null) return new Node(key, val, 1);
        int compare = key.compareTo(x.key);
        if (compare<0) x.left = put(x.left, key, val);
        else if (compare>0) x.right = put(x.right, key, val);
        else x.val=val;
        x.N = size(x.left)+size(x.right)+1;
        return x;
    }
}