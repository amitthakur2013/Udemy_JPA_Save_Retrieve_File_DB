package com.amit.save_retrieve_file.repos;

import org.springframework.data.repository.CrudRepository;

import com.amit.save_retrieve_file.entity.Image;

public interface ImageRepository extends CrudRepository<Image, Long> {

}
