package M1_16_Javier_Molina_Garcia;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[] saludo = {'h', 'o', 'l', 'a'};
		ArrayCharSequenceTokio myCharArray = new ArrayCharSequenceTokio(saludo);
		System.out.println("Longitud: " + myCharArray.length());
        System.out.println("Carácter en [2]: " + myCharArray.charAt(2));
        CharSequenceTokio sub = myCharArray.subSequence(1, 4);
        System.out.println("Subsecuencia (1, 4): " + sub.toString());
        System.out.println("toString completo: " + myCharArray.toString());
        
        System.out.println(".........................................");
        
        BackwardsStringCharSequenceTokio myString = new BackwardsStringCharSequenceTokio("Hola mundo");
        System.out.println("Longitud: " + myString.length());
        System.out.println("Carácter en [8]: " + myString.charAt(8));
        CharSequenceTokio sub2 = myString.subSequence(2, 9);
        System.out.println("Subsecuencia (2, 9): " + sub2.toString());
        CharSequenceTokio sub3 = myString.subSequence(10, 10);
        System.out.println("Subsecuencia (10, 10): " + sub3.toString());
        System.out.println("toString completo: " + myString.toString());
	}
}
