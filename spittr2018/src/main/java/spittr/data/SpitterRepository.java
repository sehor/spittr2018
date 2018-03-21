package spittr.data;

import java.util.List;

import spittr.data.jopo.Spitter;

public interface SpitterRepository {
	
	Spitter findSpitterByUsername(String username);
	List<Spitter> findSpitters();
	void save(Spitter spitter);

}
