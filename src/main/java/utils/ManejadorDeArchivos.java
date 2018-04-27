package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ManejadorDeArchivos {
	/**
	 * Lee todo el contenido de un archivo de texto.
	 * @param filePath El path donde se encuentra el archivo.
	 * @return El contenido del archivo.
	 */
	public String leerArchivo(String filePath) {
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
