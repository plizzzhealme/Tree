package main;

import tree.Tree;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        boolean workFlag = true;

        while (workFlag) {
            printMenu(tree);
            Scanner in = new Scanner(System.in);
            int option = in.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Введите значение");
                    tree.add(in.nextInt());
                    break;
                case 2:
                    printLessElements(tree);
                    break;
                case 3:
                    workFlag = false;
                    break;
                default:
                    System.out.println("Нет такого пункта меню");
            }
        }
    }

    private static void printLessElements(Tree tree) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите значение");
        int elemToCompare = in.nextInt();
        List<Integer> result = tree.searchLessElements(elemToCompare);
        System.out.printf("Количество элементов меньше %d: %d ", elemToCompare, result.size());
        System.out.println(result);
    }

    private static void printMenu(Tree tree) {
        tree.print();
        System.out.println("1. Добавить элемент");
        System.out.println("2. Вывести элементы меньше указанного");
        System.out.println("3. Кончить");
    }
}