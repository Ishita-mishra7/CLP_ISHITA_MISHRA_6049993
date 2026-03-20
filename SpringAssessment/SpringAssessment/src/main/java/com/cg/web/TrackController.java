package com.cg.web;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Track;
import com.cg.repo.TrackRepository;

@RestController
public class TrackController {
 
	@Autowired
	private TrackRepository trackRepository;
	
	 @PostMapping("tracks")
	public ResponseEntity<String> addTrack(@RequestBody Track track){
		trackRepository.save(track);
		return ResponseEntity.ok("track added successfully");
		
	}
	
	  @GetMapping("tracks")
	public ResponseEntity<List<Track>> getTracks() {
		List<Track> list=trackRepository.findAll();
		return ResponseEntity.ok(list);
		
	}
	@GetMapping("tracks/title/{title}")
	public ResponseEntity<List<Track>> getTracksByTitle(@PathVariable String title) {
		List<Track> t=trackRepository.findByTitle(title);
		return  ResponseEntity.ok(t);
		
	}
	 @GetMapping("tracks/{id}")
	 public ResponseEntity<Object> getTrack(@PathVariable Long id) {
	        Optional<Track> track = trackRepository.findById(id);

	        if (track.isPresent()) {
	            return ResponseEntity.ok(track.get());
	        } else {
	            return ResponseEntity.status(404).body("Track not found");
	        }
	    }

  
}