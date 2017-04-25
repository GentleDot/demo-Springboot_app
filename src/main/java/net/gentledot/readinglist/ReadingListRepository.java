package net.gentledot.readinglist;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Sang on 2017-04-25.
 */
public interface ReadingListRepository extends JpaRepository<Book, Long> {
    List<Book> findByReader(Reader reader);
}
