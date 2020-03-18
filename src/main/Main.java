package main;

import tree.Tree;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        int[] testSet = {8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15};
        Arrays.stream(testSet).forEach(tree::add);
        boolean workFlag = true;

        while (workFlag) {
            printMenu(tree);
            int option = new Scanner(System.in).nextInt();

            switch (option) {
                case 1:
                    addElement(tree);
                    break;
                case 2:
                    printLessElements(tree);
                    break;
                case 3:
                    tree.printTreeView();
                    break;
                case 4:
                    workFlag = false;
                    break;
                default:
                    System.out.println("Нет такого пункта меню");
            }
        }
    }

    private static void addElement(Tree tree) {
        System.out.println("Введите значение");
        tree.add(new Scanner(System.in).nextInt());
    }

    private static void printLessElements(Tree tree) {
        System.out.println("Введите значение");
        int elemToCompare = new Scanner(System.in).nextInt();
        List<Integer> result = tree.searchLessElements(elemToCompare);
        System.out.printf("Количество элементов меньше %d: %d. Список: ", elemToCompare, result.size());
        System.out.println(result);
    }

    private static void printMenu(Tree tree) {
        tree.printElements();
        System.out.println("1. Добавить элемент");
        System.out.println("2. Вывести элементы меньше указанного");
        System.out.println("3. Вывести в виде дерева");
        System.out.println("4. Кончить");
    }
}