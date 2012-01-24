package org.inftel.pasos.util;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.inftel.pasos.entity.Persona;
import org.inftel.pasos.entity.Usuario;

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
    public static Usuario formToBeanUser(HttpServletRequest req) {

        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        Usuario usuario = new Usuario();
        Persona persona = new Persona();
        usuario.setIdPersona(persona);

        if (isMultipart) {
            // Patrón factoría para manejar ficheros procedentes de formularios
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            try {
                // Sólo cojo la primera imagen
                List<FileItem> items = upload.parseRequest(req);
                for (FileItem item : items) {
                    if (item.isFormField()) {
                        usuario = actualizaUsuario(usuario, item);
                    } else {
                        InputStream is = item.getInputStream();
                        long sizeLong = item.getSize();
                        int size;

                        if (sizeLong < Integer.MAX_VALUE) {
                            size = (int) sizeLong;
                            byte[] buffer = new byte[size];
                            is.read(buffer);
                            usuario.setFoto(buffer);
                        }
                    }
                }

            } catch (FileUploadException ex) {
                Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            } catch (IOException ex) {
                Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }

        return usuario;
    }

    private static Usuario actualizaUsuario(Usuario usuario, FileItem campo) {
        String fieldname = campo.getFieldName();

        try {
            if (fieldname.equals("imei")) {
                usuario.setImei(new BigInteger(campo.getString()));
            } else if (fieldname.equals("nombre")) {
                usuario.getIdPersona().setNombre(campo.getString());
            } else if (fieldname.equals("apellido1")) {
                usuario.getIdPersona().setApellido1(campo.getString());
            } else if (fieldname.equals("apellido2")) {
                usuario.getIdPersona().setApellido2(campo.getString());
            } else if (fieldname.equals("direccion")) {
                usuario.getIdPersona().setDireccion(campo.getString());
            } else if (fieldname.equals("localidad")) {
                usuario.getIdPersona().setLocalidad(campo.getString());
            } else if (fieldname.equals("provincia")) {
                usuario.getIdPersona().setProvincia(campo.getString());
            } else if (fieldname.equals("codPostal")) {
                usuario.getIdPersona().setCodpostal(new BigInteger(campo.getString()));
            } else if (fieldname.equals("telefono")) {
                usuario.getIdPersona().setTelefono(new BigInteger(campo.getString()));
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        return usuario;
    }
}
