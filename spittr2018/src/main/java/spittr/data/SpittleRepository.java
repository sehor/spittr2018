package spittr.data;

import java.util.List;

import spittr.data.jopo.Spittle;

public interface SpittleRepository {

	
	List<Spittle> findSpittles(Long max,int count);
	void save(Spittle spittle);
}
