package com.app.hw21;

public class BinarySearchTree {
    Node root;

    // Конструктор
    BinarySearchTree() {
        root = null;
    }

    // Метод для додавання вузла у BST
    void insert(int key) {
        root = insertRec(root, key);
    }

    // Рекурсивна допоміжна функція для вставки ключа у BST
    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    // Метод для видалення вузла у BST
    void delete(int key) {
        root = deleteRec(root, key);
    }

    // Рекурсивна допоміжна функція для видалення вузла з ключем key з BST
    Node deleteRec(Node root, int key) {
        if (root == null) {
            return null;
        }

        // Знаходимо вузол, що потрібно видалити
        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        } else {
            // Вузол з однією або без нащадків
            if (root.left == null) {
                return deleteRec(root.right, key);
            } else if (root.right == null) {
                return deleteRec(root.left, key);
            }

            // Вузол з двома нащадками: вузол з мінімальним ключем правого піддерева
            root.key = minValue(root.right);

            // Видаляємо вузол з мінімальним ключем правого піддерева
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    // Метод для знаходження мінімального ключа у піддереві з коренем в даному вузлі
    int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    // Метод для пошуку вузла з ключем key у BST
    Node search(Node root, int key) {
        // Вузол не знайдено або ключ співпадає з ключем кореня
        if (root == null || root.key == key) {
            return root;
        }

        // Ключ менший, ніж ключ кореня - шукаємо у лівому піддереві
        if (root.key > key) return search(root.left, key);

        // Ключ більший, ніж ключ кореня - шукаємо у правому піддереві
        return search(root.right, key);
    }

    // Метод для виведення вузлів у BST в порядку зростання ключів
    void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.key + " ");
            inOrderTraversal(root.right);
        }
    }

    // Метод для визначення висоти BST
    int getHeight() {
        return height(root);
    }

    // Рекурсивний метод для знаходження висоти BST
    int height(Node root) {
        if (root == null) return 0;

        else {
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            // Обираємо більшу висоту піддерева та додаємо 1 для кореня
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // Додавання вузлів у BST
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Вузли у дереві в порядку зростання ключів:");
        tree.inOrderTraversal(tree.root);
        System.out.println("\n");

        // Пошук та видалення вузла з ключем 20
        System.out.println("Видалення вузла з ключем 20:");
        tree.delete(20);
        System.out.println("Вузли у дереві після видалення:");
        tree.inOrderTraversal(tree.root);
        System.out.println("\n");

        // Пошук вузла з ключем 60
        System.out.println("Пошук вузла з ключем 60:");
        Node result = tree.search(tree.root, 60);
        if (result != null) System.out.println("Знайдено вузол з ключем 60");
        else System.out.println("Вузол з ключем 60 не знайдено");

        // Визначення висоти BST
        System.out.println("Висота дерева: " + tree.getHeight());
    }
}
