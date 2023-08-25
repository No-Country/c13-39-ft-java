package com.nicoz.NZWanderlust.controller;

import com.nicoz.NZWanderlust.Entity.Bookmark;
import com.nicoz.NZWanderlust.NewBookmarkRequest;
import com.nicoz.NZWanderlust.Service.BookmarkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookmarkController {
    private final BookmarkService bookmarkService;

    public BookmarkController(BookmarkService bookmarkService){
        this.bookmarkService = bookmarkService;
    }

    @GetMapping("/bookmarks")
    public List<Bookmark> getBookmarks(){
        return bookmarkService.getBookmarks();
    }


    @PostMapping("/bookmarks")
    public void addBookmarks(@RequestBody NewBookmarkRequest request){
        bookmarkService.addBookmark(request);
    }

    @PutMapping("/bookmarks/{bookmarksId}")
    public ResponseEntity<Bookmark> updateBookmark(@PathVariable("bookmarksId") Long id,
                                               @RequestBody Bookmark userDetails){
        return bookmarkService.updateBookmark(id, userDetails);
    }

    @DeleteMapping("/bookmark/{bookmarkId}")
    public void deleteBookmark(@PathVariable("bookmarkId") Long id){
        bookmarkService.deleteBookmark(id);
    }
}
