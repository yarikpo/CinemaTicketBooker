package ukr.clamor1s.ticketBooker.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ukr.clamor1s.ticketBooker.models.Film;

public class FilmMapper implements RowMapper<Film> {

	@Override
	public Film mapRow(ResultSet resultSet, int rowNum) throws SQLException{
		
		Film film = new Film();
		
		try {
			film.setId(resultSet.getInt("id"));
			film.setName(resultSet.getString("name"));
			film.setGenre(resultSet.getString("genre"));
			film.setDuration(resultSet.getInt("duration"));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return film;
	}
	
}
