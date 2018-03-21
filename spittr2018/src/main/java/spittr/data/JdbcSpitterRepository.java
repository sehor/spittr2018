package spittr.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import spittr.data.jopo.Spitter;

@Repository
public class JdbcSpitterRepository implements SpitterRepository {
	
	private JdbcOperations jdbc;

	@Autowired
	public JdbcSpitterRepository(JdbcOperations jdbc) {
		this.jdbc = jdbc;
	}
	
	

	@Override
	public Spitter findSpitterByUsername(String username) {
		// TODO Auto-generated method stub
		return jdbc.queryForObject("select * from Spitter where username=?", new SpitterRowMap(), username);
	}

	@Override
	public List<Spitter> findSpitters() {
		// TODO Auto-generated method stub
		return jdbc.query("select * from spitter", new SpitterRowMap());
	}

	@Override
	
	public void save(Spitter spitter){
		
		System.out.println("准备存入数据库：   "+ spitter.getUsername());
		
		
		jdbc.update("insert into Spitter"
				+ " (username,password,first_name,last_name,email)"
				+ " values(?,?,?,?,?)",
				spitter.getUsername(),
				spitter.getPassword(),
				spitter.getFirstName(),
				spitter.getLastName(),
				spitter.getEmail()
				
				);
	}
	
	
	private static class SpitterRowMap implements RowMapper<Spitter> {

		@Override
		public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			return new Spitter(rs.getLong("id"), rs.getString("username"), rs.getString("password"),
					rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"));
		}

	}

}
