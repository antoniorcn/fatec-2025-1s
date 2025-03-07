package edu.curso;
public class TesteString {
    public static void main(String[] args) {
        String a = "joao";
        String b = "joao";
        String c = b + "";
        System.out.printf("A: (%s)%n", a);
        System.out.printf("B: (%s)%n", b);
        System.out.printf("C: (%s)%n", c);
        if (a == b) { 
            System.out.println("A e B - São Iguais");
        } else { 
            System.out.println("A e B - São Diferentes");
        }
        if (a == c) { 
            System.out.println("A e C - São Iguais");
        } else { 
            System.out.println("A e C - São Diferentes");
        }
    }
}
