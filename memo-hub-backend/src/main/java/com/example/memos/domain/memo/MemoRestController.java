package com.example.memos.domain.memo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemoRestController {
	@Autowired
	private MemoService service;
	
	@GetMapping("/memos/all")
	public List<Memo> findAll(){
		return service.getMemos();
	}
	
	@GetMapping("/memos/{id}")
	public Memo findMemo(@PathVariable("id") String id){
		return service.getMemo(id);
	}
	
	@PostMapping("/memos")
	public Memo saveMemo(@RequestBody Memo memo) {
		return service.save(memo);
	}
	
	@DeleteMapping("/memos/{id}")
	public void deleteMemo(@PathVariable("id") String id) {
		service.delete(id);
	}
	
	@PutMapping("/memos/{id}")
	public Memo updateMemo(@PathVariable("id") String id, @RequestBody Memo memo) {
		//TODO get memo from database by id and replace populated fields from representation
		return service.save(memo);
	}	
}
