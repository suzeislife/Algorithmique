package s09;

public class TriCorrect {

  public boolean isSortingResultCorrect(int[] givenInput,
      int[] observedOutput) {
    boolean checkOk = true;
    // Test s'il y a le m�me nombre d'�l�ment sur les deux tableaux
    if (givenInput.length != observedOutput.length)
      checkOk = false;
    // V�rifie que chaque �l�ment est bien dans l'ordre
    for (int i = 0; i < observedOutput.length - 1; i++) {
      if (observedOutput[i] > observedOutput[i + 1]) {
        checkOk = false;
      }
    }
    // V�rifie qu'aucun �l�ment n'a �t� changer
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
  }

}
