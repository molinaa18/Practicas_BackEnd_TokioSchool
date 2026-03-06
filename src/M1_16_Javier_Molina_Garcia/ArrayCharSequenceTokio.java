package M1_16_Javier_Molina_Garcia;

public class ArrayCharSequenceTokio implements CharSequenceTokio {
	
	char[] arrayDeChars;
	
	public ArrayCharSequenceTokio (char[] arrayDeChars) {
		this.arrayDeChars = arrayDeChars;
	}
	
	@Override
	public int length() {
		return arrayDeChars.length;
	}
	
	@Override
	public char charAt(int indice) {
	    if (indice < 0 || indice >= arrayDeChars.length) {
	        return 0;
	    }
	    return arrayDeChars[indice];
	}
	
	@Override
	public CharSequenceTokio subSequence(int inicio, int fin) {
	    if (inicio < 0) return null;
	    if (fin < 0) return null;
	    if (inicio > fin) return null;
	    if (inicio > arrayDeChars.length) return null;
	    if (fin > arrayDeChars.length) return null;
	    if (inicio == fin) {
	        return new ArrayCharSequenceTokio(new char[0]);
	    }
	    int nuevoLength = fin - inicio;
	    char[] nuevoArray = new char[nuevoLength];
	    for (int i = 0; i < nuevoLength; i++) {
	        nuevoArray[i] = arrayDeChars[inicio + i];
	    }
	    return new ArrayCharSequenceTokio(nuevoArray);
	}
	
	@Override
	public String toString() {
		return new String (arrayDeChars);
	}
	
}
