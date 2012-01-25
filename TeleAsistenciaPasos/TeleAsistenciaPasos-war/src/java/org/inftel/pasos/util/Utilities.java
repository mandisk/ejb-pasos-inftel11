package org.inftel.pasos.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Métodos estáticos susceptibles de ser usados por varias clases.
 * @author Juan Manuel Rodríguez González
 */
public class Utilities {

    /**
     * Método estático para transformar la imagen que llega a través de un
     * formulario en un array de bytes.
     * @param req Objeto Request usado por el servlet donde llegan todos los
     * datos del formulario.
     * @return byte Array de bytes que contiene
     */
    public static byte[] formToBeanImage(HttpServletRequest req) {

        boolean isMultipart = ServletFileUpload.isMultipartContent(req);

        if (isMultipart) {
            // Patrón factoría para manejar ficheros procedentes de formularios
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            try {
                // Sólo cojo la primera imagen
                FileItem item = (FileItem) upload.parseRequest(req).get(0);
                InputStream is = item.getInputStream();
                long sizeLong = item.getSize();
                int size;

                if (sizeLong < Integer.MAX_VALUE) {
                    size = (int) sizeLong;
                    byte[] buffer = new byte[size];
                    is.read(buffer);
                    return buffer;
                }

                // En caso de que la imagen sea demasiado grande no la recojo
                return null;
            } catch (FileUploadException ex) {
                Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            } catch (IOException ex) {
                Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }

        return null;
    }
}
