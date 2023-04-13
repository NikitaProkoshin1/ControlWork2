import global.MyFileWriter;

import model.Toy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static global.Vars.allToys;
import static global.Vars.winsToys;

public class Main {

    public static void main(String[] args) {
        //Сначала создаем произвольные игрушки
        Toy cat = new Toy(1, "Кошка", 10, 20);
        Toy dog = new Toy(2, "Собака", 3, 5);
        Toy bird = new Toy(3, "Птица", 4, 10);
        Toy fish = new Toy(4, "Рыбка", 10, 30);
        Toy spiderman = new Toy(5, "Человек-паук", 6, 20);
        Toy superman = new Toy(6, "Супермен", 5, 8);


        addToListWithNewWeight(cat, 5);
        addToListWithNewWeight(dog, 10);
        addToListWithNewWeight(bird, 21);
        addToListWithNewWeight(fish, 7);
        addToListWithNewWeight(spiderman, 45);
        addToListWithNewWeight(superman, 67);


        System.out.println("все игрушки: ");
        showNewList(allToys);


        List<Toy> addedWinners = selectToyByMinWeight(allToys, 50);
        winsToys.addAll(addedWinners);


        System.out.println("Возможный выигрыш: ");
        showNewList(winsToys);

        Toy givedWinner = selectRandomToy(winsToys);

        winsToys.remove(givedWinner);


        System.out.println("Ваш выигрыш: " + givedWinner.info());

        MyFileWriter.writeToy(givedWinner);

    }

    private static List<Toy> selectToyByMinWeight(ArrayList<Toy> allToys, int minWeight) {
        List<Toy> result = new ArrayList<>();
        for (Toy currentToy : allToys) {
            if (currentToy.getWeight() <= minWeight) {
                result.add(currentToy);
            }
        }
        return result;
    }

    private static Toy selectRandomToy(ArrayList<Toy> winsToys) {
        Random rand = new Random();
        int winnerElement = rand.nextInt(winsToys.size());
        return winsToys.get(winnerElement);
    }

    private static void addToListWithNewWeight(Toy newToy, int newWeight) {
        newToy.setWeight(newWeight);
        allToys.add(newToy);
    }

    private static void showNewList(ArrayList<Toy> myList) {
        int winListSize = myList.size();
        for (int i = 0; i < winListSize; i++) {
            System.out.print("Игрушка [" + i + "]: " + myList.get(i).getName() + ", ");
        }
        System.out.println("");
    }
}