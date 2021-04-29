package es.urjc.code.daw.library.book;

public class LineBreaker {

	public static String breakText(String text, int lineLength, int acc) {
		text= text.trim().replaceAll("\s{2,}", " ");
		if (text.length() <= lineLength){
			return text;
		}
		else if (text.charAt(lineLength) == ' ') {
			return text.substring(0, lineLength) + '\n'+ 
					breakText(text.substring(lineLength+1, text.length()), acc, acc);
		}
		else if (lineLength == 0) {
			return text.substring(0, acc-1) + "-" + "\n" + breakText(text.substring(acc-1, text.length()), acc, acc);
		}
		else{
			return breakText(text, lineLength-1, acc);
		}
	}

}
