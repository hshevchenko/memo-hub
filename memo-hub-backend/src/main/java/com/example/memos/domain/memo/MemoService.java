package com.example.memos.domain.memo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemoService {
	@Autowired
	private MemoRepository repository;
	
	/**
	 * Get all
	 * @return
	 */
	public List<Memo> getMemos(){
		return repository.findAll();
	}
	
	/**
	 * Save memo
	 * @param memo
	 * @return
	 */
	public Memo save(Memo memo) {
		return repository.save(memo);
	}
	
	/**
	 * Get memo by id
	 * @param memoId
	 * @return
	 */
	public Memo getMemo(String memoId) {
		return repository.findById(memoId).get();
	}
	
	/**
	 * 
	 * @param memo
	 */
	public void delete(Memo memo) {
		repository.delete(memo);
	}	
	
	/**
	 * 
	 * @param memo
	 */
	public void delete(String id) {
		repository.deleteById(id);
	}
}
