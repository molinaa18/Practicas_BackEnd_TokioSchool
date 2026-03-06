package M1_16_Javier_Molina_Garcia;

public class BackwardsStringCharSequenceTokio implements CharSequenceTokio{

	String ogString;
	String ogStringInvertido = "";

	public BackwardsStringCharSequenceTokio (String ogString) {
		this.ogString = ogString;
		for (int i = ogString.length() - 1; i >= 0; i--) {
			ogStringInvertido = ogStringInvertido + ogString.charAt(i);
		}
	}
	
	@Override
	public int length() {
		return ogStringInvertido.length();
	}

	@Override
	public char charAt(int indice) {
		return ogStringInvertido.charAt(indice);
	}

	@Override
	public CharSequenceTokio subSequence(int inicio, int fin) {
		
		if (inicio < 0) return null;
		if (inicio > fin) return null;
		if (fin > ogStringInvertido.length()) return null;
		if (inicio == fin) {
	        return new ArrayCharSequenceTokio(new char[0]);
		}
		int nuevoLength = fin - inicio;
		char[] nuevoArray = new char[nuevoLength];
	    for (int i = 0; i < nuevoLength; i++) {
	        nuevoArray[i] = ogStringInvertido.charAt(inicio + i);
	    }
	    return new ArrayCharSequenceTokio(nuevoArray);
		
	}
	
	@Override
	public String toString() {
		return new String (ogStringInvertido);
	}

}
