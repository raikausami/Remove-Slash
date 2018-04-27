import java.awt.datatransfer.StringSelection;
class Slash{


    public static void main(String[] args){
        Glaphic g = new Glaphic;
        String str=rem_slash(g.inputText);
        setClipboard(str);
    }


   static void setClipboardString(String str) {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Clipboard clip = kit.getSystemClipboard();
		StringSelection ss = new StringSelection(str);
		clip.setContents(ss, ss);
	}


    static String rem_slash(String line)(
        line.replace("\r\n"," ");
        line.replace("\n"," ");
        return line;
    }
}

