package com.hust.ofornet.service;

import java.util.List;

import com.hust.ofornet.pojo.Category;
import com.hust.ofornet.pojo.Job;

public interface JobService {
	
	void add(Job p);
    void delete(int id);
    void update(Job p);

    Job get(int id);
    
    List listByCategory(int cid);
    List listByCompany(int coid);
    
    List<Job> list();
    List<Job> list(int id);
    
    void fill(List<Category> cs);

    void fill(Category c);

    void fillByRow(List<Category> cs);
    
    public List<Job> search(String keyword);

}
