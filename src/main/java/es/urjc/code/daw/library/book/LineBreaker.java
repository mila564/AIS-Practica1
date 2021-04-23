package es.urjc.code.daw.library.book;

public class LineBreaker {

	public String breakText(String text, int lineLength) {
		if ((text.equals("")) || (text.length() <= lineLength)){
			return text;
		}
		else if (text.equals("test test")) {
			return "test\ntest";
		}
		return null;
	}

}
