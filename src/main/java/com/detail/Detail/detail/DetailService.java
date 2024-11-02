package com.detail.Detail.detail;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailService {
	
	@Autowired
	private DetailRepository repository;
	
	public List<DetailEntity> getAllDetails(){
		return repository.findAll();
	}
	
	public void saveDetails(DetailEntity detail) {
		repository.save(detail);
	}
	
	public void updateDetail(Long id, DetailEntity detail) {
		DetailEntity existingDetail = repository.findById(id).orElseThrow();
		existingDetail.setActivity(detail.getActivity());
		repository.save(existingDetail);
	}


}
