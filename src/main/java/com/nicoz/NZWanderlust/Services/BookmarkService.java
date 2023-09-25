package com.nicoz.NZWanderlust.Services;

import com.nicoz.NZWanderlust.Entities.Bookmark;
import com.nicoz.NZWanderlust.NewBookmarkRequest;
import com.nicoz.NZWanderlust.Repositories.BookmarkRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookmarkService {
    private final BookmarkRepository bookmarkRepository;

    public BookmarkService(BookmarkRepository bookmarkRepository){
        this.bookmarkRepository = bookmarkRepository;
    }


    public List<Bookmark> getBookmarks(){
        return bookmarkRepository.findAll();
    }


    public void addBookmark(NewBookmarkRequest bookmarkRequest){
        Bookmark bookmark = new Bookmark();
        bookmark.setUserId(bookmarkRequest.getUserId());
        bookmark.setPostId(bookmarkRequest.getPostId());
        bookmarkRepository.save(bookmark);
    }

    public ResponseEntity<Bookmark> updateBookmark(Long id, Bookmark bookmarkDetails){
        Optional<Bookmark> optionalBookmark = bookmarkRepository.findById(id);
        if (!optionalBookmark.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Bookmark bookmark = optionalBookmark.get();
        bookmark.setUserId(bookmarkDetails.getUserId());
        bookmark.setPostId(bookmarkDetails.getPostId());
        Bookmark updatedBookmark = bookmarkRepository.save(bookmark);
        return new ResponseEntity<>(updatedBookmark, HttpStatus.OK);
    }

    public void deleteBookmark(Long id){
        bookmarkRepository.deleteById(id);
    }
}
