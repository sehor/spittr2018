package spittr.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import spittr.data.jopo.Spittle;

@Repository
public class JdbcSpittleRepository implements SpittleRepository {

	private JdbcOperations JdbcTemplate;

	@Autowired
	public JdbcSpittleRepository(JdbcOperations jdbcTemplate) {

		this.JdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Spittle> findSpittles(Long max, int count) {
		// TODO Auto-generated method stub
		
		return JdbcTemplate.query("select message,id,created_at,longitude,latitude from Spittle", new SpittleRowMap());

	}

	@Override
	public void save(Spittle spittle) {
		// TODO Auto-generated method stub

		JdbcTemplate.update("insert into Spittle (message,created_at,longitude,latitude)" + " values(?,?,?,?)",
				spittle.getMessage(), spittle.getTime(), spittle.getLongitude(), spittle.getLatitude());
	}

	private static class SpittleRowMap implements RowMapper<Spittle> {

		@Override
		public Spittle mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			return new Spittle(rs.getLong("id"), rs.getString("message"), rs.getDate("created_at"),
					rs.getDouble("longitude"), rs.getDouble("latitude"));
		}

	}

}
