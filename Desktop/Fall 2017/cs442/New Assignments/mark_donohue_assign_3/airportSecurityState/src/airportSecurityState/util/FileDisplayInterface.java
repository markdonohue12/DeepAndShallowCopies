package airportSecurityState.driver;

import java.io.BufferedWriter;

public interface FileDisplayInterface {
	public void writeToFile(String outfile, String result, BufferedWriter outWriter);
}