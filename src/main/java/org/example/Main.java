package org.example;

import java.util.Arrays;

public class Main {
    static int carriagePosition;
    static int[] tape;
    static int next;

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {

        tape = new int[]{0, 0, 0, 0, 0, 1, 1, 1, 1, 0};
        carriagePosition = 1;
        next = 1;

        System.out.println("Початковий стан стрічки:");
        printTape();

        while (next>0) {
            switch (next) {
                // місце для запису набору команд для машини Поста
                case 1 -> {goRight(); next = 2;}
                case 2 -> questionMark(1,3);
                case 3 -> {goLeft(); next = 4;}
                case 4 -> {drawMark(); next = 5;}
                case 5 -> stop();
            }
        }

    }



    private void stop() {
        next = -1;
        System.out.println("Рузультат роботи:");
        printTape();
    }
    private void printTape(){
        System.out.println(Arrays.toString(tape));
    }
    private void drawMark() {
        tape[carriagePosition] = 1;
    }
    private void eraseMark(int index) {
        tape[carriagePosition] = 0;
    }
    private void goLeft() {
        carriagePosition--;
    }
    private void goRight() {
        carriagePosition++;
    }
    private void questionMark(int number1, int number2) {
        if (tape[carriagePosition] == 0) {
            next = number1;
        } else {
            next = number2;
        }
    }

}