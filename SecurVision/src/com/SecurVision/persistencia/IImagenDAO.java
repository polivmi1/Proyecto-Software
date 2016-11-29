package com.SecurVision.persistencia;

import com.SecurVision.persistenciaDTO.ImagenDTO;
import com.SecurVision.exceptions.*;

public interface IImagenDAO {

	public void subirImagen(ImagenDTO p)throws DAOExcepcion;
}
