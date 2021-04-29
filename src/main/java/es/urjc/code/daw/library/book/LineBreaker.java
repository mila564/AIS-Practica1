package es.urjc.code.daw.library.book;

public class LineBreaker {

	public String breakText(String text, int lineLength) {
		text= text.trim().replaceAll("\s{2,}", " ");
		if (text.length() <= lineLength){
			return text;
		}
		else if (text.charAt(lineLength) == ' ') {
			return text.substring(0, lineLength) + '\n'+ 
					breakText(text.substring(lineLength+1, text.length()), lineLength);
		}
		else{
			return breakText(text, lineLength-1);
		}
	}

}
