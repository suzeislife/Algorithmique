package s09;

<<<<<<< HEAD
public class TriCorrect {

  public boolean isSortingResultCorrect(int[] givenInput,
      int[] observedOutput) {
    boolean checkOk = true;
    // Test s'il y a le même nombre d'élément sur les deux tableaux
    if (givenInput.length != observedOutput.length)
      checkOk = false;
    // Vérifie que chaque élément est bien dans l'ordre
    for (int i = 0; i < observedOutput.length - 1; i++) {
      if (observedOutput[i] > observedOutput[i + 1]) {
        checkOk = false;
      }
    }
    // Vérifie qu'aucun élément n'a été changer
    boolean[] checkElement = new boolean[observedOutput.length];
    for (int i = 0; i < givenInput.length; i++) {
      for (int j = 0; j < observedOutput.length; j++) {
         if(givenInput[i] == observedOutput[j] && checkElement[j] == false){
           checkElement[j] = true;
           break;
         }
      }
    }
    for (int i = 0; i < checkElement.length; i++) {
      if(checkElement[i] == false){
        checkOk = false;
      }
    }
    return checkOk;
  }

  public static void main(String[] args) {

    TriCorrect test = new TriCorrect();

    int[] tableau1 = { 4,4, 9, 2 };
    int[] tableauResult = { 2,2,4,9};

    System.out.println(test.isSortingResultCorrect(tableau1, tableauResult));
=======

import s07.Quicksort;

public class TriCorrect {

  public boolean isSortingResultCorrect(int[] givenInput,
      int[] observedOutput) {
    boolean checkOk = true;
    // Test s'il y a le même nombre d'élément sur les deux tableaux
    if (givenInput.length != observedOutput.length)
      checkOk = false;
    // Vérifie que chaque élément est bien dans l'ordre
    for (int i = 0; i < observedOutput.length - 1; i++) {
      if (observedOutput[i] > observedOutput[i + 1]) {
        checkOk = false;
      }
    }
    // Vérifie qu'aucun élément n'a été changer
    boolean[] checkElement = new boolean[observedOutput.length];
    for (int i = 0; i < givenInput.length; i++) {
      for (int j = 0; j < observedOutput.length; j++) {
         if(givenInput[i] == observedOutput[j] && checkElement[j] == false){
           checkElement[j] = true;
           break;
         }
      }
    }
    for (int i = 0; i < checkElement.length; i++) {
      if(checkElement[i] == false){
        checkOk = false;
      }
    }
    return checkOk;
  }

  public static void main(String[] args) {
    TriCorrect triCorrect = new TriCorrect();
    int[] tableau = { 4,4, 9, 2 };
    int[] tableauResult = { 4,4,9,2};
    BuggySorting.sort00(tableauResult);
    System.out.println("Sort0: "+triCorrect.isSortingResultCorrect(tableau, tableauResult));
    int[] tableauResult2 = { 4,4,9,2};
    BuggySorting.sort01(tableauResult2);
    System.out.println("Sort1: "+triCorrect.isSortingResultCorrect(tableau, tableauResult2));
    int[] tableauResult3 = { 4,4,9,2};
    BuggySorting.sort02(tableauResult3);
    System.out.println("Sort2: "+triCorrect.isSortingResultCorrect(tableau, tableauResult3));
    int[] tableauResult4 = { 4,4,9,2};
    BuggySorting.sort03(tableauResult4);
    System.out.println("Sort3: "+triCorrect.isSortingResultCorrect(tableau, tableauResult4));
    int[] tableauResult5 = { 4,4,9,2};
    BuggySorting.sort04(tableauResult5);
    System.out.println("Sort4: "+triCorrect.isSortingResultCorrect(tableau, tableauResult5));
    int[] tableauResult6 = { 4,4,9,2};
    BuggySorting.sort05(tableauResult6);
    System.out.println("Sort5: "+triCorrect.isSortingResultCorrect(tableau, tableauResult6));
    int[] tableauResult7 = { 4,4,9,2};
    BuggySorting.sort06(tableauResult7);
    System.out.println("Sort6: "+triCorrect.isSortingResultCorrect(tableau, tableauResult7));
    int[] tableauResult8 = { 4,4,9,2};
    BuggySorting.sort07(tableauResult8);
    System.out.println("Sort7: "+triCorrect.isSortingResultCorrect(tableau, tableauResult8));
    int[] tableauResult9 = { 4,4,9,2};
    BuggySorting.sort08(tableauResult9);
    System.out.println("Sort8: "+triCorrect.isSortingResultCorrect(tableau, tableauResult9));
    int[] tableauResult10 = { 4,4,9,2};
    BuggySorting.sort08(tableauResult10);
    System.out.println("Sort9: "+triCorrect.isSortingResultCorrect(tableau, tableauResult10));
    
    
    int[] tableauResult11 = { 4,4,9,2};
    Quicksort.quickSort(tableauResult11);
    System.out.println("Quicksort: "+triCorrect.isSortingResultCorrect(tableau, tableauResult11));
>>>>>>> branch 'master' of https://github.com/suzeislife/Algorithmique.git
  }

}
