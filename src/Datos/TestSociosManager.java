package Datos;

import java.util.ArrayList;
import java.util.List;

import Negocio.Socio;

public class TestSociosManager implements SociosManager {
	
	private ArrayList<Socio> sociosBackingList = new ArrayList<Socio>();
	
	public TestSociosManager() {
		sociosBackingList.add(new Socio(0, "COCA-COLA", "AV. CABILDO 123", "4557-7788",
				"coca@coca-cola.com"));
		sociosBackingList.add(new Socio(1, "GOOGLE", "AV. BELGRANO 456", "4557-7711",
				"google@gmail.com"));
	}

	@Override
	public List<Socio> getAllSocios() {
		List<Socio> result = new ArrayList<Socio>();
		// Copiamos cada uno de los socios para simular traída de DB.
		for (Socio currentSocio : sociosBackingList) {
			result.add(new Socio(
				currentSocio.getIdSocio(),
				currentSocio.getNombre(),
				currentSocio.getDomicilio(),
				currentSocio.getTelefono(),
				currentSocio.getMail()
			));
		}
		return result;
	}

	@Override
	public void addSocio(Socio newSocio) {
		newSocio.setIdSocio(getMaxId() + 1);
		sociosBackingList.add(new Socio(
				newSocio.getIdSocio(),
				newSocio.getNombre(),
				newSocio.getDomicilio(),
				newSocio.getTelefono(),
				newSocio.getMail()
			));
	}
	
	private int getMaxId() {
		int maxId = 0;
		for(Socio currentSocio: sociosBackingList)
			if(currentSocio.getIdSocio() > maxId)
				maxId = currentSocio.getIdSocio();
		return maxId;
	}

	@Override
	public void editSocio(int idSocio, Socio modifiedSocio) throws Exception {
		if(idSocio != modifiedSocio.getIdSocio())
			throw new Exception();
		Socio s = null;
		for (Socio currentSocio : sociosBackingList)
			if (currentSocio.getIdSocio() == idSocio) {
				s = currentSocio;
				break;
			}
		s.setNombre(modifiedSocio.getNombre());
		s.setDomicilio(modifiedSocio.getDomicilio());
		s.setTelefono(modifiedSocio.getTelefono());
		s.setMail(modifiedSocio.getMail());
	}

	@Override
	public void deleteSocio(int idSocio) {
		Socio s = null;
		for (Socio currentSocio : sociosBackingList)
			if (currentSocio.getIdSocio() == idSocio) {
				s = currentSocio;
				break;
			}
		sociosBackingList.remove(s);
	}

}