package ukr.clamor1s.ticketBooker.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ukr.clamor1s.ticketBooker.models.Film;

public class FilmDao implements Dao<Film> {

	private final JdbcTemplate jdbcTemplete;
	
	@Autowired
	public FilmDao(JdbcTemplate jdbcTemplate) {
		
		this.jdbcTemplete = jdbcTemplate;
	}
	
	@Override
	public Optional<Film> get(long id) {
		
		return Optional.ofNullable(jdbcTemplete.query("SELECT * FROM Films WHERE id=?;", new FilmMapper(), new Object[] {id})
				.stream().findAny().orElse(null));
	}

	@Override
	public List<Film> getAll() {
		
		return jdbcTemplete.query("SELECT * FROM Films ORDER BY id;", new FilmMapper());
	}

	@Override
	public void save(Film film) {
		
		if (film == null) return;
		
		Optional<Integer> newId = jdbcTemplete.query("SELECT id + 1 AS id FROM Films A WHERE NOT EXISTS(SELECT id FROM Films B WHERE B.id = A.id + 1) ORDER BY id;",
				new RowMapper<Integer>() {
			
			@Override
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				return Integer.valueOf(rs.getInt("id"));
			}
		}).stream().findFirst();
		
		if (newId == null) return;
		if (newId.isEmpty()) return;
		
		film.setId((long)newId.get());
		
		jdbcTemplete.update("INSERT INTO Films(id, name, genre, duration) VALUES(?, ?, ?, ?);", 
				film.getId(), film.getName(), film.getGenre(), film.getDuration());
	}

	@Override
	public void update(Film film) {
		
		if (film == null) return;
		
		if (film.getName() == null) {
			String oldName = jdbcTemplete.query("SELECT name AS name FROM Films WHERE id=?;", new RowMapper<String>() {

				@Override
				public String mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					return rs.getString("name");
				}
				
				
			}, new Object[] { film.getId() }).stream().findFirst().orElse(null);
			
			film.setName(oldName);
		}
		
		if (film.getGenre() == null) {
			String oldGenre = jdbcTemplete.query("SELECT genre AS genre FROM Films WHERE id=?;", new RowMapper<String>() {

				@Override
				public String mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					return rs.getString("genre");
				}
				
				
			}, new Object[] { film.getId() }).stream().findFirst().orElse(null);
			
			film.setGenre(oldGenre);
		}
		
		if (film.getDuration() == 0) {
			Integer oldDuration = jdbcTemplete.query("SELECT duration AS duration FROM Films WHERE id=?;", new RowMapper<Integer>() {

				@Override
				public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					return rs.getInt("duration");
				}
				
				
			}, new Object[] { film.getId() }).stream().findFirst().orElse(null);
			
			film.setDuration((int)oldDuration);
		}
		
		
		jdbcTemplete.update("UPDATE Films SET name=?, genre=?, duration=? WHERE id=?;",
				film.getName(), film.getGenre(), film.getDuration(), film.getId());
	}

	@Override
	public void delete(long id) {
		
		jdbcTemplete.update("DELETE FROM Films WHERE id=?;", id);
	}

	
}
