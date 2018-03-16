package spittr.data;

import java.util.List;

public interface SpittleRepository {

	
	List<Spittle> findSpittles(Long max,int count);
}
