package ejer08;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MiObjectOutputStream extends ObjectOutputStream {

	protected MiObjectOutputStream(OutputStream arg0) throws IOException, SecurityException {
		super(arg0);
	}

	// Sobrescritura del método
	protected void writeStreamHeader() throws IOException {
	}

}
