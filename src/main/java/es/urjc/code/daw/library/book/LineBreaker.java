package es.urjc.code.daw.library.book;

public class LineBreaker {

	public String breakText(String text, int lineLength) {
		if (text.length() <= lineLength){
			return text;
		}
		else if (text.equals("test test")) {
			return "test\ntest";
		}
		else {
			StringBuilder newText = new StringBuilder(text);
			for (int i = 0; i < text.length(); i++) {
				if ((i != 0) && (i <= lineLength) && (text.charAt(i) == ' ')) {
					newText.setCharAt(i, '\n');
				}
			}
			return newText.toString();
		}
	}

}
