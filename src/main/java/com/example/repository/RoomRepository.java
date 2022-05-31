package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entities.Room;

public interface RoomRepository extends JpaRepository<Room,Long>{

	
	@Query("FROM Room WHERE service_id = ?1")
	List<Room> findAllByService(Long id);
	
	
}
