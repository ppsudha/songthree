/*
 * You can use the following import statements
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 */

// Write your code here
package com.example.song.service;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import com.example.song.repository.SongJpaRepository;
import com.example.song.repository.SongRepository;
import com.example.song.model.Song;

@Service
public class SongJpaService implements SongRepository {
 @Autowired
  private SongJpaRepository songJpaRepository;

     @Override
    public void deleteSong(int songId) {
        try {

      songJpaRepository.deleteById(songId);
    } 
    catch (Exception e) {

      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    }
    @Override
    public Song updateSong(int songId, Song playlist) {
         try {
      Song newSong =songJpaRepository.findById(songId).get();
      if (playlist.getSongName() != null) {
        newSong.setSongName(playlist.getSongName());
      }
      if (playlist.getLyricist() != null) {
        newSong.setLyricist(playlist.getLyricist());
      }
      if (playlist.getSinger() != null) {
        newSong.setSinger(playlist.getSinger());
      }
      if (playlist.getMusicDirector() != null) {
        newSong.setMusicDirector(playlist.getMusicDirector());
      }
      songJpaRepository.save(newSong);

      return newSong;

    } 
    catch(Exception e){

      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    }
 @Override
    public Song addSong(Song playlist) {
        songJpaRepository.save(playlist);
          return playlist;

    }
@Override
    public Song getSongById(int songId) {
        try{

      Song playlist = songJpaRepository.findById(songId).get();
      return playlist;
    }
    catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    }

    @Override
    public ArrayList<Song> getSongs() {
         List<Song> songList = songJpaRepository.findAll();
    ArrayList<Song> songs = new ArrayList<>(songList);
    return songs;

    }

}
