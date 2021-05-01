package es.urjc.code.daw.library.book;

public class LineBreaker {
	
	public static String breakLine(String text, int lineLength) {
		if (lineLength < 2) {
			throw new RuntimeException("El tamaño de línea no puede ser inferior a 2");
		}
		return breakLineAux(text,lineLength, lineLength);
	}
	
	public static String breakLineAux(String text, int lineLength, int acc) {
		text= text.trim().replaceAll("\\s{2,}", " ");
		if (text.length() <= lineLength){
			return text;
		}
		else if (text.charAt(lineLength) == ' ') {
			return text.substring(0, lineLength) + '\n'+ 
					breakLineAux(text.substring(lineLength+1, text.length()), acc, acc);
		}
		else if (lineLength == 0) {
			return text.substring(0, acc-1) + "-" + "\n" + breakLineAux(text.substring(acc-1, text.length()), acc, acc);
		}
		else{
			return breakLineAux(text, lineLength-1, acc);
		}
	}
}
