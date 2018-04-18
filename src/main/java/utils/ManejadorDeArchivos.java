package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ManejadorDeArchivos {
	public String leerArchivoJson(String filePath) {
		try {
			StringBuilder builder = new StringBuilder();
			for(String lineaLeida : Files.readAllLines(Paths.get(filePath))) {
				builder.append(lineaLeida);
			}
			return builder.toString();
		} catch (IOException e) {
			//throw new ParserException("Error leyendo el archivo: " + filePath);
		}
		return filePath;
	}

}
