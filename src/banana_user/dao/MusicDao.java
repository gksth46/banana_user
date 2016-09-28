package banana_user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
<<<<<<< HEAD
import java.time.LocalDate;
import java.util.ArrayList;
=======
import java.util.ArrayList;
import java.util.ResourceBundle.Control;
>>>>>>> refs/remotes/origin/master

import banana_user.controller.Controllers;
import banana_user.domain.Music;
import banana_user.repository.LoginRepository;

public class MusicDao {

	public MusicDao() {
<<<<<<< HEAD

=======
>>>>>>> refs/remotes/origin/master
	}

	//음원 목록
	public ArrayList<Music> musicSelectAll() {

		ArrayList<Music> musicList = new ArrayList<Music>();
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = Controllers.getProgramController().getConnection().createStatement();
			String sql = "select musicNumber, title, singer, lyrics from music order by playingCount desc";
			rs = stmt.executeQuery(sql);

			while(rs.next()) {
				Music music = new Music();
				music.setMusicNumber(rs.getInt("musicNumber"));
				music.setTitle(rs.getString("title"));
				music.setSinger(rs.getString("singer"));
				music.setLyrics(rs.getString("lyrics"));
				musicList.add(music);
<<<<<<< HEAD
			}
		} catch (SQLException e){

		} finally {

			if(stmt != null) {
				try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(rs != null) {
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
=======
			}	
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			} if(stmt != null) {
				try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
>>>>>>> refs/remotes/origin/master
			}
		}

		return musicList;
<<<<<<< HEAD
=======


>>>>>>> refs/remotes/origin/master
	}

	public Music selectOneMusic(int musicNumber){

		Music selectedMusic = null;

		Statement stmt = null;
		ResultSet rs = null;

		//선택번호가 0이면 노래를 안들을 것임
		if(musicNumber==0){

			selectedMusic = new Music();
			selectedMusic.setMusicNumber(0);
			return selectedMusic;
		}

		String sql = "select * from Music where musicNumber = " + musicNumber;

		try {

			stmt = Controllers.getProgramController().getConnection().createStatement();
			rs = stmt.executeQuery(sql);

			if(rs.next()){

				selectedMusic = new Music();
				selectedMusic.setMusicNumber(rs.getInt(1));
				selectedMusic.setTitle(rs.getString(2));
				selectedMusic.setSinger(rs.getString(3));
				selectedMusic.setLyrics(rs.getString(4));
				selectedMusic.setEmotionNumber(rs.getInt(5));
				selectedMusic.setPlayingCount(rs.getInt(6));

			} else {
				selectedMusic = new Music();
				selectedMusic.setMusicNumber(-1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
<<<<<<< HEAD
			if(rs != null) {
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			} if(stmt != null) {
				try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}

		return selectedMusic;
	}

	public int playMusic(Music selectedMusic){

		int success = 0;
		//0:비로그인상태  1:이용권구매안하거나 기간만료 2:이용권 유
		int userNumber=0;
		Statement stmt = null;
		ResultSet rs = null;
		String endDate = null;
		
		//재생하면 재생카운트 증가
		try {
			
			String sql = "update Music set PlayingCount = " + (selectedMusic.getPlayingCount() + 1)
								+" where musicNumber = " + selectedMusic.getMusicNumber();
			stmt = Controllers.getProgramController().getConnection().createStatement();
			
			stmt.executeUpdate(sql);
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		if(LoginRepository.getLogin().getLoginId() == null){

			return success;

		} else {

			try {
				String sql = "select userNumber from banana_user where userId = '"
						+LoginRepository.getLogin().getLoginId()+"'";
				stmt = Controllers.getProgramController().getConnection().createStatement();

				rs = stmt.executeQuery(sql);
				if(rs.next()){
					userNumber = rs.getInt(1);
				}

			} catch (SQLException e) {

				e.printStackTrace();

			}  finally {
				if(rs != null) {
					try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
				} if(stmt != null) {
					try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
				}
=======

			if(stmt != null) {
				try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
>>>>>>> refs/remotes/origin/master
			}
		}

		try {
			String sql = "select max(endDate) from purchaseTicket where userNumber = " + userNumber;
			stmt = Controllers.getProgramController().getConnection().createStatement();

			rs = stmt.executeQuery(sql);

			if(rs.next()) {

				endDate = rs.getString(1);

				if(rs.getString(1) == null){

					success = 1;

				}  else	{

					LocalDate end = LocalDate.parse(endDate);
					LocalDate currentDate = LocalDate.now();

					if(end.isAfter(currentDate)){

						success = 2;
					}
				}
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

<<<<<<< HEAD
		return success;
=======
		return selectedMusic;
>>>>>>> refs/remotes/origin/master
	}

}
