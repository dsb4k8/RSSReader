import java.io.*;
import java.net.*;

public class Reader {
	
	public static void main(String[] args){
		System.out.println(readRSS("http://rss.cnn.com/rss/cnn_world.rss"));
	}
	
	
	public static String readRSS(String urlAddress){
		try {
			URL rssUrl = new URL(urlAddress);
			BufferedReader in = new BufferedReader(new InputStreamReader(rssUrl.openStream()));
			String sourceCode = "";
			String line;
			while((line = in.readLine()) != null) {
				if (line.contains("<title>")) {
					int firstPos = line.indexOf("<title>");
					String temp = line.substring(firstPos);
					temp = temp.replace("<title>", "");
					int lastPos = temp.indexOf("</title>");
					temp = temp.substring(0, lastPos);
					sourceCode += temp + "\n";
					
				}			
			
			}
			//end stream
			in.close();
			return sourceCode;
			}
		//if validation fails
		catch (MalformedURLException ue) {
				String MalformedUrl = "Malformed Url";
				return MalformedUrl;
		}
		catch (IOException ioe) {
			String IOE = "Something went wring with reading the contents of URL :\\";
			return IOE;
		}
	}

}
