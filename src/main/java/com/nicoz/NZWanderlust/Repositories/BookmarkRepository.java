package com.nicoz.NZWanderlust.Repositories;

import com.nicoz.NZWanderlust.Entities.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
}
