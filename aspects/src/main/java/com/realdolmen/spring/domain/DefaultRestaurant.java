package com.realdolmen.spring.domain;

/**
 * Created by stannisbaratheon on 30/08/16.
 */
public class DefaultRestaurant implements Restaurant {

    @Override
    public void serveMeal(Visitor visitor) {
        System.out.println();
        System.out.println("*****************************************");
        System.out.format("Serving a nice meal to '%s'%n", visitor.getName());
        System.out.println("*****************************************");
        System.out.println(
                "                               .-'''''-.\n" +
                        "                               |'-----'|\n" +
                        "                               |-.....-|\n" +
                        "                               |       |\n" +
                        "                               |       |\n" +
                        "              _,._             |       |\n" +
                        "         __.o`   o`\"-.         |       |\n" +
                        "      .-O o `\"-.o   O )_,._    |       |\n" +
                        "     ( o   O  o )--.-\"`O   o\"-.`'-----'`\n" +
                        "      '--------'  (   o  O    o)  \n" +
                        "                   `----------`"
        );
        System.out.println("*****************************************");
        System.out.println();
    }
}
