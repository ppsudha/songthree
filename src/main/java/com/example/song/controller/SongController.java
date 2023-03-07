/*
 * 
 * You can use the following import statements
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 *
 */

// Write your code here
package com.example.song.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.song.service.SongJpaService;
import com.example.song.model.Song;
import java.util.*;

@RestController
public class SongController {   
@Autowired
   public SongJpaService songService;
    @GetMapping("/songs")
    public ArrayList<Song> getSongs() {
        return songService.getSongs();
    }
    @GetMapping("/songs/{songId}")
    public Song getSongById(@PathVariable("songId") int songId) {
        return songService.getSongById(songId);
    }
    @PostMapping("/songs")
    public Song addSong(@RequestBody Song playlist) {
        return songService.addSong(playlist);
    }
    @PutMapping("/songs/{songId}")
    public Song updateSong(@PathVariable("songId") int songId, @RequestBody Song playlist) {
        return songService.updateSong(songId, playlist);
    }
    @DeleteMapping("/songs/{songId}")
    public void deleteSong(@PathVariable("songId") int songId) {
        songService.deleteSong(songId);
    }
}